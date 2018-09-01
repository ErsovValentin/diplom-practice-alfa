package com.cooking.controller;

import com.cooking.model.Storage;
import com.cooking.model.addition.StorageActivity;
import com.cooking.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping("/storages")
    public String listOfStorages(Model model, ModelAndView modelAndView)
    {
        model.addAttribute("listOfStorages", storageService.getAllStorages());
        model.addAttribute("storage",new Storage());
        modelAndView.addObject("storageActivity",StorageActivity.values());

        return "/storageAdmin/storages";
    }

    @RequestMapping(value = "storages/addStorage", method = RequestMethod.POST)
    public String addStorage(@ModelAttribute("storage")Storage storage)
    {
        if(storage.getId() == 0)
        {
            storageService.addStorage(storage);
        }
        else
        {
            storageService.updateStorage(storage);
        }

        return "redirect:/storages";
    }

    @RequestMapping("/updateStorage/{id}")
    public String updateStorage(@PathVariable("id") int storageId, Model model)
    {
        model.addAttribute("listOfStorages",storageService.getAllStorages());
        model.addAttribute("storage", storageService.getStorageById(storageId));

        return "/storageAdmin/storages";
    }

    @RequestMapping("/deleteStorage/{id}")
    public String deleteStorage(@PathVariable("id") int storageId)
    {
        storageService.deleteStorage(storageService.getStorageById(storageId));

        return "redirect:/storages";
    }
}
