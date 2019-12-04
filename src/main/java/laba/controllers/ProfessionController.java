package laba.controllers;

import laba.exceptions.IncorrectCodeException;
import laba.exceptions.IncorrectNameException;
import laba.objects.Profession;
import laba.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfessionController {

    @Autowired
    ProfessionService professionService;

    @RequestMapping(value = "/profession", method = RequestMethod.GET)
    public String professionList(Model model) {
        model.addAttribute("professions", professionService.findAll());
        return "lists/professions_list";
    }

    @RequestMapping(value = "/profession/add", method = RequestMethod.POST)
    public String addProfession(@ModelAttribute("new_prof") Profession profession) {
        try {
            professionService.add(profession);
        } catch (IncorrectCodeException e) {
            return "redirect:/errors/" + e.getMessage();
        } catch (IncorrectNameException e) {
            return "redirect:/errors/" + e.getMessage();
        }
        return "redirect:/profession";
    }

    @RequestMapping(value = "/profession/delete/{code}", method = RequestMethod.GET)
    public String deleteProfession(@PathVariable("code") String code) {
        professionService.delete(code);
        return "redirect:/profession";
    }

    @RequestMapping(value = "/profession/update/{code}", method = RequestMethod.GET)
    public String updateProfession(Model model, @PathVariable("code") String code) {
        model.addAttribute("update_prof", professionService.getByCode(code));
        return "updates/profession_update";
    }

    @RequestMapping(value = "/profession/update_process", method = RequestMethod.POST)
    public String updatedProcessProfession(@ModelAttribute("update_prof") Profession profession) {
        try {
            professionService.update(profession);
        } catch (IncorrectNameException e) {
            return "redirect:/errors/" + e.getMessage();
        }
        return "redirect:/profession";
    }
}
