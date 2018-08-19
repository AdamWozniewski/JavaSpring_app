package com.clockworkjava.JavaSpring_app;

import com.clockworkjava.JavaSpring_app.domain.repositories.CastleKnightRepository;
import com.clockworkjava.JavaSpring_app.domain.repositories.QuestsRepository;
import com.clockworkjava.JavaSpring_app.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    CastleKnightRepository castleKnightRepository; // Zależnosc na klasę Castle, wstrzykiwanie zaleznosci, dzięki temu można go używać w starterze

    @Autowired
    QuestsRepository questsRepository;

    @Autowired
    QuestService questService;

    @Override
    public void run(String... args) throws Exception {

        this.questService.assignRandomQuest("lancelot");
        this.questService.assignRandomQuest("percival");

        System.out.println(this.castleKnightRepository.toString());

    }
}
