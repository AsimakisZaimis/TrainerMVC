
package com.asimakis.trainermvc.controllers;

import com.asimakis.trainermvc.entities.Trainer;
import com.asimakis.trainermvc.services.ITrainer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class TrainerController {
    private String listurl = "list";
    private String editurl = "edit";
    private String deleteurl = "delete";
    private String updateurl = "update";
    
    @Autowired
    ITrainer trainerService;
    
    @Autowired
    MessageSource messageSource;
    
    // index
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listAllTrainers(ModelMap view, @RequestParam(required = false) String msg) {
        List<Trainer> trainers  = trainerService.findAllTrainers();
        view.addAttribute("trainers", trainers);
        view.addAttribute("editurl", editurl);
        view.addAttribute("deleteurl", deleteurl);
        view.addAttribute("msg", msg);
        return("trainerslist");
    }
    
    // get form for new trainer
    @RequestMapping("/new")
    public String newTrainer(ModelMap view) {
        Trainer trainer = new Trainer();
        view.addAttribute("trainer", trainer);
        view.addAttribute("listurl", listurl);
        return("newtrainer");
    }
    
    // post form for new trainer
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveTrainer(ModelMap view, Trainer trainer) {
        if(trainerService.save(trainer)) {
            view.addAttribute("msg", new String("Added Successfully!"));
        }
        else {
            view.addAttribute("msg", new String("Couldn't add!"));
        }
        view.addAttribute("listurl", listurl);
        return("redirect:/list");
    }
    
    // delete for an existing trainer
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTrainer(ModelMap view, @PathVariable int id) {
        if(trainerService.delete(id)) {
            view.addAttribute("msg", new String("Deleted Successfully!"));
        } else {
            view.addAttribute("msg", new String("Not Deleted!"));
        }
        return("redirect:/list");
    }
    
    // show edit / update for an existing trainer
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editStudent(ModelMap view, @PathVariable int id) {
        Trainer trainer = trainerService.findById(id);
        view.addAttribute("trainer", trainer);
        view.addAttribute("updateurl", updateurl);
        return("edittrainer");
    }
    
    // store edit / update for an existing trainer
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateStudent(ModelMap view, Trainer trainer) {
        trainerService.update(trainer);
        view.addAttribute("msg", new String("Updated Successfully!!"));
        return("redirect:/list");
    }
   
}