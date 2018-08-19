package com.clockworkjava.JavaSpring_app.services;

import com.clockworkjava.JavaSpring_app.domain.Quest;
import com.clockworkjava.JavaSpring_app.domain.repositories.CastleKnightRepository;
import com.clockworkjava.JavaSpring_app.domain.repositories.QuestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestService {

    @Autowired
    CastleKnightRepository castleKnightRepository;

    @Autowired
    QuestsRepository questsRepository;

    final static Random random = new Random();

    public void assignRandomQuest(String knightName) {
        List<Quest> allQuests = this.questsRepository.getQuests();
        Quest randomQuest = allQuests.get(random.nextInt(allQuests.size()));
        this.questsRepository.deleteQuest(randomQuest);
        this.castleKnightRepository.getKnight(knightName).setQuest(randomQuest);
    }
}
