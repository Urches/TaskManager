package com.project.controller;

import com.project.dictionary.service.DictionaryService;
import com.project.dictionary.model.Phrase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService service;

    @RequestMapping(value = "/phrase", method = RequestMethod.POST, headers = {"content-type=application/json"})
    @ResponseBody
    public Model addPhrase(@RequestBody Phrase phrase){
        service.addPhrase(phrase);
        System.out.println("Hello!");
        return "/phrase post";
    }

    @RequestMapping(value = "/phrase/{id}", method = RequestMethod.GET)
    public String getPhrase(@PathVariable String id){
        return "/phrase get";
    }
}
