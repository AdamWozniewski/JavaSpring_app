package com.clockworkjava.JavaSpring_app.domain.repositories;

import com.clockworkjava.JavaSpring_app.domain.Quest;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
@Scope("singleton")
public class QuestsRepository {

    Random random =  new Random();
    List<Quest> quests = new ArrayList<>();

    public void addQuest(String desc) {
        this.quests.add(new Quest(desc));
    }

    public List<Quest> getQuests() { return this.quests; }

    public void deleteQuest (Quest quest) {
        this.quests.remove(quest);
    }

    @Scheduled(fixedDelayString = "${questCreationDelay:5000}")
    public void createRandomQuest() {
        List<String> desc = new ArrayList<>();

        desc.add("zadanie 1");
        desc.add("zadanie 2");
        desc.add("zadanie 3");
        desc.add("zadanie 4");
        desc.add("zadanie 5");
        desc.add("zadanie 6");
        desc.add("Ratuj ksiezniczke !");
        desc.add("Weź udział w turnieju !");

        String description = desc.get(this.random.nextInt(desc.size()));
        this.addQuest(description);
        System.out.println(" Utworzono zadanie:  " + description);
    }

    @PostConstruct
    public void init() {
    }

    @Override
    public String toString() {
        return "QuestsRepository{" +
                "quests=" + quests +
                '}';
    }
}
