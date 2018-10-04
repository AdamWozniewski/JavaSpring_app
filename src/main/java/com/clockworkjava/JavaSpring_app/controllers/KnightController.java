package com.clockworkjava.JavaSpring_app.controllers;

import com.clockworkjava.JavaSpring_app.domain.Knight;
import com.clockworkjava.JavaSpring_app.domain.repositories.CastleKnightRepository;
import com.clockworkjava.JavaSpring_app.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/createdKnights", method = RequestMethod.POST)
    public String saveKnights(Knight knight) {
        this.knightService.saveKnight(knight);
        return "redirect:/getKnights";
    }

    @RequestMapping("/oneKnight")
    public String getKnight(@RequestParam("id") Integer id, Model model) {
       Knight knight = this.knightService.getKnightService(id);
       model.addAttribute("selectedKnight", knight);
       return "oneKnight";
    }


    @RequestMapping("/newKnight")
    public String newKnights(Model model) {
        model.addAttribute("objectKnight", new Knight());
        return "knightForm";
    }
}
