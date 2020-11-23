package com.vladcom.capitalism.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class indexController {
    @GetMapping("/Cap")
    public String indexPage(Model model){
        model.addAttribute("tak", "ДОБРОПОЖАЛОВАТЬ");
        return "index";
    }

    @PostMapping("/Cap")
    public String capitalCalc(@RequestParam String capital, Model model){
        if(capital.equals("")){
            capital = "0";
        }
        String verdict = "ВВЕДИ СВОЙ КАПИТАЛ ДРУЖОК!";
        int cap = Integer.parseInt(capital);
        if(cap <= 1000 && cap > 0){
            verdict = "ТЫ НАШ! ПРОЛЕТАРИАТ!";
        }
        else if(cap > 1000 & cap < 50000){
            verdict = "РАСКУЛАЧИТЬ";
        }
        else if(cap == 0){
            verdict = "ИДИ РАБОТАЙ! ТУНЕЯДЕЦ!";
        }
        else if(cap > 50000){
            verdict = "РАССТРЕЛЯТЬ!!1";
        }
        model.addAttribute("tak", verdict);
        return "index";
    }

    @GetMapping("/second")
    public String secondPage(){
        return "second";
    }
}

