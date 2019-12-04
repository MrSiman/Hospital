package laba.controllers;

import laba.exceptions.IncorrectNumPassportException;
import laba.objects.Patient;
import laba.objects.PatientDTS;
import laba.service.DoctorsService;
import laba.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class PatientesController {
    @Autowired
    DoctorsService doctorsService;
    @Autowired
    PatientService patientService;

    @RequestMapping(value = "/patientes", method = RequestMethod.GET)
    public String patientesList(Model model) {
        model.addAttribute("patientes", patientService.findAll());
        model.addAttribute("doctors", doctorsService.findAll());
        return "lists/patientes_list";
    }

    @RequestMapping(value = "/patientes/add", method = RequestMethod.POST)
    public String addPatient(@RequestParam("numPassport")String numPassport,
                             @RequestParam("FIO")String FIO,
                             @RequestParam("doctorFIO")String doctorFIO,
                             @RequestParam("doB")String doB,
                             @RequestParam("recordingDate")String recordingDate,
                             @RequestParam("sex")boolean b_sex) {
        String sex;
        if (b_sex == true) {
            sex = "муж";
        } else {
            sex = "жен";
        }

        PatientDTS patientDTS = new PatientDTS(numPassport, FIO, doctorFIO, doB, recordingDate, sex);
        try {
            patientService.add(patientDTS);
        }
        catch (ParseException e) {
            return "redirect:/errors/Incorrect_date";
        }
        catch (IncorrectNumPassportException e) {
            return "redirect:/errors/" + e.getMessage();
        }
        return "redirect:/patientes";
    }

    @RequestMapping(value = "/patientes/delete/{numPassport}", method = RequestMethod.GET)
    public String deletePatient(@PathVariable("numPassport")String numPassport) {
        patientService.delete(numPassport);
        return "redirect:/patientes";
    }

    @RequestMapping(value = "/patientes/update/{numPassport}", method = RequestMethod.GET)
    public String updatePatient(Model model, @PathVariable("numPassport")String numPassport) {
        model.addAttribute("update_patient", patientService.getPatientByNumPassport(numPassport));
        model.addAttribute("doctors", doctorsService.findAll());
        return "updates/patientes_update";
    }

    @RequestMapping(value = "/patientes/updated", method = RequestMethod.POST)
    public String updatedProcessPatient(@RequestParam("numPassport")String numPassport,
                                        @RequestParam("FIO")String FIO,
                                        @RequestParam("doctorFIO")String doctorFIO,
                                        @RequestParam("doB")String doB,
                                        @RequestParam("recordingDate")String recordingDate,
                                        @RequestParam("sex")boolean b_sex) {
        String sex;
        if (b_sex == true) {
            sex = "муж";
        } else {
                sex = "жен";
            }
        PatientDTS patientDTS = new PatientDTS(numPassport, FIO, doctorFIO, doB, recordingDate, sex);
        try {
            patientService.add(patientDTS);
        }
        catch (ParseException e) {
            return "redirect:/errors/Incorrect_date";
        }
        catch (IncorrectNumPassportException e) {
            return "redirect:/errors/" + e.getMessage();
        }
        return "redirect:/patientes";
    }
}
