package laba.controllers;

import laba.exceptions.IncorrectFioException;
import laba.exceptions.IncorrectNumPassportException;
import laba.exceptions.IncorrectSalaryException;
import laba.objects.Doctor;
import laba.service.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DoctorsController {

    @Autowired
    DoctorsService doctorsService;

    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public String doctorsList(Model model) {
        model.addAttribute("doctors", doctorsService.findAll());
        return "lists/doctors_list";
    }

    @RequestMapping(value = "/doctors/add", method = RequestMethod.POST)
    public String addDoctor(@ModelAttribute("new_doctor")Doctor doctor) {
        try {
            doctorsService.add(doctor);
        } catch (IncorrectNumPassportException e) {
            return "redirect:/errors/" + e.getMessage();
        } catch (IncorrectFioException e) {
            return "redirect:/errors/" + e.getMessage();
        } catch (IncorrectSalaryException e) {
            return "redirect:/errors/" + e.getMessage();
        }
        return "redirect:/doctors";
    }

    @RequestMapping(value = "/doctors/update/{numPassport}", method = RequestMethod.GET)
    public String updateDoctor(@PathVariable("numPassport")String numPassport, Model model) {
        model.addAttribute("doctor", doctorsService.getDoctorByPassport(numPassport));
        model.addAttribute("updated_doctor", new Doctor());
        return "updates/doctor_update";
    }

    @RequestMapping(value = "/doctors/update_process", method = RequestMethod.POST)
    public String updatedProcessDoctor(@ModelAttribute("updated_doctor")Doctor doctor) {
        try {
            doctorsService.update(doctor);
        } catch (IncorrectFioException e) {
            return "redirect:/errors/" + e.getMessage();
        } catch (IncorrectSalaryException e) {
            return "redirect:/errors/" + e.getMessage();
        }
        return "redirect:/doctors";
    }

    @RequestMapping(value = "/doctors/delete/{numPassport}", method = RequestMethod.GET)
    public String deleteDoctor(@PathVariable("numPassport")String numPassport) {
        doctorsService.delete(numPassport);
        return "redirect:/doctors";
    }
}
