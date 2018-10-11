package com.clockworkjava.JavaSpring_app.domain.repositories;

import com.clockworkjava.JavaSpring_app.domain.Quest;
import com.clockworkjava.JavaSpring_app.utils.Ids;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Repository
@Scope("singleton")
public class QuestsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    Random random =  new Random();
//    Map<Integer, Quest> quests = new HashMap<>();

    @Transactional
    public void addQuest(String desc) { // zamiana na funkcje z bazą danych
//        int key = Ids.getNewId(this.quests.keySet());
        Quest quest = new Quest(desc);
//        this.quests.put(key, quest);
        this.entityManager.persist(quest);
    }

    public List<Quest> getQuests() {
        return this.entityManager.createQuery("from Quest", Quest.class).getResultList();
//        return new ArrayList<>(this.quests.values());
    }
    @Transactional
    public void deleteQuest (Quest quest) {
//        this.quests.remove(quest.getId());
        this.entityManager.remove(quest);
    }

    @Scheduled(fixedDelayString = "${questCreationDelay:50000}")
    @Transactional
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
    }

    @PostConstruct
    public void init() {
    }

    @Transactional
    public void update(Quest quest) {
//        this.quests.put(quest.getId(), quest);
        this.entityManager.merge(quest);
    }


    public Quest getQuest(int id) {
//        return this.quests.get(id);
        return this.entityManager.find(Quest.class, id);
    }
}
