package com.clockworkjava.JavaSpring_app.domain.repositories;

import com.clockworkjava.JavaSpring_app.domain.Quest;
import com.clockworkjava.JavaSpring_app.utils.Ids;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
@Scope("singleton")
public class QuestsRepository {

    Random random =  new Random();
//    List<Quest> quests = new ArrayList<>();
    Map<Integer, Quest> quests = new HashMap<>();

    public void addQuest(String desc) {
        int key = Ids.getNewId(this.quests.keySet());
        Quest quest = new Quest(key, desc);
        this.quests.put(key, quest);
    }

    public List<Quest> getQuests() { return new ArrayList<>(this.quests.values()); }
    public void deleteQuest (Quest quest) {
        this.quests.remove(quest.getId());
    }

    @Scheduled(fixedDelayString = "${questCreationDelay:50000}")
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

    public void update(Quest quest) {
        this.quests.put(quest.getId(), quest);
    }

    public Quest getQuest(int id) {
        return this.quests.get(id);
    }

    @Override
    public String toString() {
        return "QuestsRepository{" +
                "quests=" + quests +
                '}';
    }
}
