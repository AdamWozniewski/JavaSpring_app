package com.clockworkjava.JavaSpring_app;

import com.clockworkjava.JavaSpring_app.components.PlayerInformation;
import com.clockworkjava.JavaSpring_app.domain.repositories.CastleKnightRepository;
import com.clockworkjava.JavaSpring_app.domain.repositories.CastleKnightRepositoryInterface;
import com.clockworkjava.JavaSpring_app.domain.repositories.PlayerInformationRepository;
import com.clockworkjava.JavaSpring_app.domain.repositories.QuestsRepository;
import com.clockworkjava.JavaSpring_app.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
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

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

//        this.questsRepository.createRandomQuest();
        this.questsRepository.createRandomQuest();
        this.questsRepository.createRandomQuest();

//        this.questService.assignRandomQuest("lancelot");
        this.questService.assignRandomQuest("percival");

        this.playerInformationRepository.createPlayerInformation(new PlayerInformation());
    }


}
