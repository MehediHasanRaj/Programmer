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


    @GetMapping( "/allprogrammer")
    public ModelAndView allprogrammer(){
        ModelAndView mv = new ModelAndView("allProgrammer.html");
        List<Programmer> p = new ArrayList<Programmer>();
        p.add(new Programmer(101,"raj","c++"));
        p.add(new Programmer(102,"shuvo","Java"));
        p.add(new Programmer(103,"shahria","Python"));
        mv.addObject("programmers",p);
        return mv;
    }


//              CRUD operation methods
//-------------------------------------------
    @PostMapping("/addProgrammer") // Create/insert data to database
    public String addProgrammer(@ModelAttribute Programmer programmer){
        pr.save(programmer);
        return "redirect:/home";
    }

    @PostMapping("/findById") // get data from database
    public String findById(@RequestParam int pId, Model model){
        Programmer p = pr.getOne(pId);
        model.addAttribute("programmer", p);
        return "programmerInfo.html";

    }


    @GetMapping ("/deleteProgrammer") // delete data from database
    public String deleteProgrammer(@RequestParam int pId, Model model){
        pr.deleteById(pId);
        return "redirect:/home";

    }

    @PostMapping("/updateProgrammer") // update data to database
    public String updateProgrammer(@ModelAttribute Programmer programmer){
        Programmer p = pr.getOne(programmer.getpId());
        p.setpName(programmer.getpName());
        p.setpLan(programmer.getpLan());
        pr.save(p);
        return "ProgrammerInfo.html";
    }

    // custom query method

    @PostMapping("/findByLan") // get data from database
    public String findByLan(@RequestParam String pLan, Model model){
        List<Programmer> p = pr.findBypLan(pLan);
        model.addAttribute("programmers", p);
        return "allprogrammer.html";

    }





}
