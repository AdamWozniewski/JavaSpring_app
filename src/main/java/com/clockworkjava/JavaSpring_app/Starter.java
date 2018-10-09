package com.clockworkjava.JavaSpring_app;

import com.clockworkjava.JavaSpring_app.domain.repositories.CastleKnightRepository;
import com.clockworkjava.JavaSpring_app.domain.repositories.CastleKnightRepositoryInterface;
import com.clockworkjava.JavaSpring_app.domain.repositories.QuestsRepository;
import com.clockworkjava.JavaSpring_app.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    CastleKnightRepositoryInterface castleKnightRepository;

    @Autowired
    QuestsRepository questsRepository;

    @Autowired
    QuestService questService;

    @Override
    public void run(String... args) throws Exception {

//        this.questsRepository.createRandomQuest();
        this.questsRepository.createRandomQuest();
        this.questsRepository.createRandomQuest();

//        this.questService.assignRandomQuest("lancelot");
        this.questService.assignRandomQuest("percival");

//        System.out.println(this.castleKnightRepository.toString());
    }


}
