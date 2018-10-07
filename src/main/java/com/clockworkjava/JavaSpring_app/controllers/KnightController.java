package com.clockworkjava.JavaSpring_app.controllers;

import com.clockworkjava.JavaSpring_app.components.TimeComponent;
import com.clockworkjava.JavaSpring_app.domain.Knight;
import com.clockworkjava.JavaSpring_app.components.PlayerInformation;
import com.clockworkjava.JavaSpring_app.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService knightService;

    @Autowired
    TimeComponent timeComponent;

    @Autowired
    PlayerInformation playerInformation;

    @RequestMapping("/getKnights")
    public String getKnights(Model model) {
        List<Knight> allKnights = this.knightService.getAllKnights(); // serwis zwraca liste rycerzy
        model.addAttribute("knightsATR", allKnights); // przekazanie propsow do widoku
        model.addAttribute("timeComponent", this.timeComponent);
        model.addAttribute("playerGold", this.playerInformation);
        return "knights";//nazwa template1
    }

    @RequestMapping(value = "/createdKnights", method = RequestMethod.POST)
    public String saveKnight(
            @Valid
            @ModelAttribute("objectKnight")
            Knight knight,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "knightForm";
        }
            this.knightService.saveKnight(knight);
            return "redirect:/getKnights";

    }

    @RequestMapping("/oneKnight")
    public String getKnight(@RequestParam("id") Integer id, Model model) {
       Knight knight = this.knightService.getKnightService(id);
       model.addAttribute("selectedKnight", knight);
       model.addAttribute("timeComponent", this.timeComponent);
       model.addAttribute("playerGold", this.playerInformation);
       return "oneKnight";
    }
    @RequestMapping(value = "/deleteKnight/{id}")
    public String deleteKnight(@PathVariable("id") Integer id, Model model) {
        this.knightService.deleteKnight(id);
        return "redirect:/getKnights";
    }

    @RequestMapping("/newKnight")
    public String newKnight(Model model) {
        model.addAttribute("objectKnight", new Knight());
        model.addAttribute("timeComponent", this.timeComponent);
        model.addAttribute("playerGold", this.playerInformation);
        return "knightForm";
    }
}
