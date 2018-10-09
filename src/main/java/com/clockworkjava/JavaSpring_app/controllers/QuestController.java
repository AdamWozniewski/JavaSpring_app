package com.clockworkjava.JavaSpring_app.controllers;


import com.clockworkjava.JavaSpring_app.components.PlayerInformation;
import com.clockworkjava.JavaSpring_app.domain.Knight;
import com.clockworkjava.JavaSpring_app.domain.Quest;
import com.clockworkjava.JavaSpring_app.services.KnightService;
import com.clockworkjava.JavaSpring_app.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestController {

    @Autowired
    KnightService knightService;

    @Autowired
    PlayerInformation playerInformation;

    QuestService questService;

    @RequestMapping(value = "/missionForKnight")
    public String assignQuest(@RequestParam("id") Integer id, Model model) {
        Knight knight = knightService.getKnightService(id);
        List<Quest> notStarted = this.questService.getAllNotStartedQuests();
        model.addAttribute("knight", knight);
        model.addAttribute("quests", notStarted);
        return "missionForKnight";
    }

    @Autowired
    public void setQuestService(QuestService questService) {
        this.questService = questService;
    }

    @RequestMapping(value = "/assignMissionForKnight", method = RequestMethod.POST)
    public String assignQuest(Knight knight) {
        this.knightService.updateKnight(knight);
        Quest quest = knight.getQuest();
        this.questService.update(quest);
        return "redirect:/getKnights";
    }

    @RequestMapping(value = "/checkQuest")
    public String checkQuest() {
        List<Knight> allKnights = this.knightService.getAllKnights();
        allKnights.forEach(knight ->
            knight.getQuest().isFinished()
        );
        int currentGold = this.playerInformation.getGold();
        this.playerInformation.setGold(currentGold + this.knightService.collectRewards());
        this.knightService.collectRewards();
        return "redirect:/getKnights";
    }
}
