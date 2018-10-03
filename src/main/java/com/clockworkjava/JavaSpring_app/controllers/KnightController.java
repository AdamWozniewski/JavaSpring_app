package com.clockworkjava.JavaSpring_app.controllers;

import com.clockworkjava.JavaSpring_app.domain.Knight;
import com.clockworkjava.JavaSpring_app.domain.repositories.CastleKnightRepository;
import com.clockworkjava.JavaSpring_app.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService knightService;

    @RequestMapping("/getKnights")
    public String getKnights(Model model) {
        List<Knight> allKnights = this.knightService.getAllKnights(); // serwis zwraca liste rycerzy
        model.addAttribute("knightsATR", allKnights); // przekazanie propsow do widoku
        return "knights";//nazwa template
    }
}
