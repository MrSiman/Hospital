package laba.controllers;

import laba.exceptions.IncorrectCodeException;
import laba.exceptions.IncorrectCostException;
import laba.exceptions.IncorrectNameException;
import laba.objects.Service;
import laba.service.ServService;
import laba.service.ServTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ServiceController {

    @Autowired
    ServTypeService servTypeService;
    @Autowired
    ServService servService;

    @RequestMapping(value = "/services" ,method = RequestMethod.GET)
    public String servicesList(Model model) {
        model.addAttribute("services", servService.findAll());
        model.addAttribute("type_services", servTypeService.findAll());
        return "lists/service_list";
    }

    @RequestMapping(value = "/services/add", method = RequestMethod.POST)
    public String addService(@ModelAttribute("new_service")Service service) {
        try {
            servService.add(service);
        } catch (IncorrectCodeException e) {
            return "redirect:/errors/" + e.getMessage();
        } catch (IncorrectNameException e) {
            return "redirect:/errors/" + e.getMessage();
        } catch (IncorrectCostException e) {
            return "redirect:/errors/" + e.getMessage();
        }
        return "redirect:/services";
    }

    @RequestMapping(value = "/services/update/{code}", method = RequestMethod.GET)
    public String updateService(@PathVariable("code") String code, Model model) {
        model.addAttribute("service", servService.getByCode(code));
        model.addAttribute("updated_service", new Service());
        model.addAttribute("type_services", servTypeService.findAll());
        return "updates/service_update";
    }

    @RequestMapping(value = "/services/update_process", method = RequestMethod.POST)
    public String updatedProcessService(@ModelAttribute("update_service") Service service) {
        try {
            servService.update(service);
        } catch (IncorrectNameException e) {
            return "redirect:/errors/" + e.getMessage();
        } catch (IncorrectCostException e) {
            return "redirect:/errors/" + e.getMessage();
        }
        return "redirect:/services";
    }

    @RequestMapping(value = "/services/delete/{code}", method = RequestMethod.GET)
    public String deleteService(@PathVariable("code") String code) {
        servService.delete(code);
        return "redirect:/services";
    }
}
