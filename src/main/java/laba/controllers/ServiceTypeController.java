package laba.controllers;

import laba.exceptions.IncorrectCodeException;
import laba.exceptions.IncorrectNameException;
import laba.objects.ServiceType;
import laba.service.ServTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServiceTypeController {

    @Autowired
    ServTypeService servTypeService;

    @RequestMapping(value = "/service_types", method = RequestMethod.GET)
    public String serviceTypesList(Model model) {
        model.addAttribute("types", servTypeService.findAll());
        model.addAttribute("newtype", new ServiceType());
        return "lists/service_type_list";
    }

    @RequestMapping(value = "/service_types/add", method = RequestMethod.POST)
    public String addTypeService(@ModelAttribute("newtype") ServiceType serviceType) {
        try {
            servTypeService.add(serviceType);
        } catch (IncorrectCodeException e) {
            return "redirect:/errors/" + e.getMessage();
        } catch (IncorrectNameException e) {
            return "redirect:/errors/" + e.getMessage();
        }
        return "redirect:/service_types";
    }

    @RequestMapping(value = "/service_types/update/{typeServiceCode}", method = RequestMethod.GET)
    public String updateTypeService(Model model, @PathVariable("typeServiceCode") String typeServiceCode) {
        model.addAttribute("type", servTypeService.getByTypeServiceCode(typeServiceCode));
        model.addAttribute("update_type", new ServiceType());
        return "updates/service_type_update";
    }

    @RequestMapping(value = "/service_types/update_process", method = RequestMethod.POST)
    public String updatedProcessTypeService(@ModelAttribute("update_type") ServiceType serviceType) {
        try {
            servTypeService.update(serviceType);
        } catch (IncorrectNameException e) {
            return "redirect:/errors/" + e.getMessage();
        }
        return "redirect:/service_types";
    }

    @RequestMapping(value = "/service_types/delete/{typeServiceCode}", method = RequestMethod.GET)
    public String deleteTypeService(@PathVariable("typeServiceCode") String typeServiceCode) {
        servTypeService.delete(typeServiceCode);
        return "redirect:/service_types";
    }
}
