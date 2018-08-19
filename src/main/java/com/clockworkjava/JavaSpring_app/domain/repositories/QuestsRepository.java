package com.clockworkjava.JavaSpring_app.domain.repositories;

import com.clockworkjava.JavaSpring_app.domain.Quest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
@Scope("singleton")
public class QuestsRepository {
    List<Quest> quests = new ArrayList<>();

    public void addQuest(String desc) {
        this.quests.add(new Quest(desc));
    }

    public List<Quest> getQuests() { return this.quests; }

    public void deleteQuest (Quest quest) {
        this.quests.remove(quest);
    }

    @PostConstruct
    public void init() {
        this.addQuest("Ratuj ksiezniczke !");
        this.addQuest("Weź udział w turnieju !");
    }

    @Override
    public String toString() {
        return "QuestsRepository{" +
                "quests=" + quests +
                '}';
    }
}
