package com.clockworkjava.JavaSpring_app.services;

import com.clockworkjava.JavaSpring_app.domain.Quest;
import com.clockworkjava.JavaSpring_app.domain.repositories.CastleKnightRepository;
import com.clockworkjava.JavaSpring_app.domain.repositories.CastleKnightRepositoryInterface;
import com.clockworkjava.JavaSpring_app.domain.repositories.QuestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuestService {

    @Autowired
    CastleKnightRepositoryInterface castleKnightRepository;

    @Autowired
    QuestsRepository questsRepository;

    final static Random random = new Random();

    public void assignRandomQuest(String knightName) {
        List<Quest> allQuests = this.questsRepository.getQuests();
        Quest randomQuest = allQuests.get(random.nextInt(allQuests.size()));
        this.questsRepository.deleteQuest(randomQuest);
        this.castleKnightRepository.getKnight(knightName).ifPresent(knight -> knight.setQuest(randomQuest));
    }

    public List<Quest> getAllNotStartedQuests() {
        return this.questsRepository.getQuests().stream().filter(quest -> !quest.isStarted()).collect(Collectors.toList());
    }

    public void update(Quest quest) {
        this.questsRepository.update(quest);
    }

    public boolean isQuestComplieted(Quest quest) {
        return quest.isFinished();
    }
}
