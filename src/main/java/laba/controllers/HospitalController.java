package laba.controllers;

import laba.exceptions.IncorrectNumPassportException;
import laba.objects.*;
import laba.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
@Controller
public class HospitalController {

    @Autowired
    DoctorsService doctorsService;
    @Autowired
    PatientService patientService;
    @Autowired
    CompleteServService completeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(Model model) {
        model.addAttribute("doctors", doctorsService.findAll());
        System.out.println("-------------------------------------------------------------------------------------");;
        System.out.println(System.getProperty("user.dir"));
        System.out.println("-------------------------------------------------------------------------------------");
        return "start_page";
    }

    @RequestMapping(value = "add_new_patient", method = RequestMethod.POST)
    public String registerPatient(@RequestParam("num_passport")String num_passport,
                                  @RequestParam("FIO")String patientFIO,
                                  @RequestParam("doB")String doB,
                                  @RequestParam("recording_date")String recordingDate,
                                  @RequestParam("sex")boolean b_sex,
                                  @RequestParam("doctor_FIO")String doctorFIO) {
        String sex;
        if (b_sex == true) {
            sex = "муж";
        } else {
            sex = "жен";
        }
        try {
            PatientDTS patientDTS = new PatientDTS(num_passport, patientFIO, doctorFIO, doB, recordingDate, sex);
            patientService.add(patientDTS);
        } catch (ParseException e) {
            return "redirect:/errors/Incorrect_date";
        } catch (IncorrectNumPassportException e) {
            return "redirect:/errors/{" + e.getMessage() + "}";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/hospital", method = RequestMethod.GET)
    public String startHospital(Model model) {
        return "start_page_doctor";
    }

    @RequestMapping(value = "/tables", method = RequestMethod.GET)
    public String tables() {
        return "list_all_tables";
    }

    @RequestMapping(value = "/login_doctor", method = RequestMethod.GET)
    public String startLoginDoctor() {
        return "doctor/doctor_start_page";
    }

    @RequestMapping(value = "/login_doctor/current_patientes", method = RequestMethod.GET)
    public String getCurrectPatientes(Model model) {
        User doctor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("current_patientes", patientService.getPatientsByDoctorName(doctor.getName()));
        return "doctor/currect_patientes";
    }

    @RequestMapping(value = "/login_doctor/add/{numPassport}", method = RequestMethod.GET)
    public String addNewCompleteService(@PathVariable("numPassport") String numPassport, Model model) {
        model.addAttribute("patient", patientService.getPatientByNumPassport(numPassport));
        return "doctor/add_new_complete_service";
    }

   @RequestMapping(value = "/login_doctor/add/process", method = RequestMethod.POST)
    public String addNewCompleteServiceProcess(@RequestParam("id")int id,
                                               @RequestParam("patient_FIO")String patientFIO,
                                               @RequestParam("service_name")String serviceName,
                                               @RequestParam("date_complete")String dateComplete,
                                               @RequestParam("time_begin")String timeBegin,
                                               @RequestParam("time_end")String timeEnd,
                                               @RequestParam("cost")int cost) {
       User doctor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       try {
           CompleteServicesDTS completeServicesDTS = new CompleteServicesDTS(id, serviceName, doctor.getName(), patientFIO, dateComplete, timeBegin, timeEnd, cost);
           completeService.add(completeServicesDTS);
           patientService.deleteByPatientName(patientFIO);
       } catch (ParseException e) {
           return "redirect:/errors/Incorrect_date";
       }
       return "redirect:/login_doctor/compete_services";
   }

    @RequestMapping(value = "/login_doctor/compete_services", method = RequestMethod.GET)
    public String getCompleteServices(Model model) {
        User doctor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("complete_services", completeService.findByDoctorName(doctor.getName()));
        return "doctor/doctor_complete_service";
    }

    @RequestMapping(value = "/all_complete_services", method = RequestMethod.GET)
    public String getAllCompleteServices(Model model) {
        model.addAttribute("all_complete_services", completeService.findAll());
        return "all_complete_services";
    }

    @RequestMapping(value = "/all_complete_services/delete/{id}", method = RequestMethod.GET)
    public String deleteCompleteService(@PathVariable("id") int id) {
        completeService.delete(id);
        return "redirect:/all_complete_services";
    }
}
