package com.example.programmer.controller;

import com.example.programmer.model.Programmer;
import com.example.programmer.repository.ProgrammerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    ProgrammerRepo pr;
    @ModelAttribute
    public void welcome(Model m){
        m.addAttribute("msg", "welcome to spring boot");
    }
    @GetMapping("/home")
    public String homepage(){
        return "home.html";
    }
    @PostMapping("/addProgrammer")
    public String addProgrammer(@ModelAttribute Programmer programmer){
//        ModelAndView mv = new ModelAndView("programmerInfo.html");
            pr.save(programmer);
          return "programmerInfo.html";
//        return mv;
    }

    @GetMapping("/allprogrammer")
    public ModelAndView allprogrammer(){
        ModelAndView mv = new ModelAndView("allProgrammer.html");
        List<Programmer> p = new ArrayList<Programmer>();
        p.add(new Programmer(101,"raj","c++"));
        p.add(new Programmer(102,"shuvo","Java"));
        p.add(new Programmer(103,"shahria","Python"));
        mv.addObject("programmers",p);
        return mv;
    }
}
