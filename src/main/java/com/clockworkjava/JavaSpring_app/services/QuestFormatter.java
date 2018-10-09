package com.clockworkjava.JavaSpring_app.services;

import com.clockworkjava.JavaSpring_app.domain.Quest;
import com.clockworkjava.JavaSpring_app.domain.repositories.QuestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;


@Service
public class QuestFormatter implements Formatter<Quest> {

    @Autowired
    QuestsRepository questsRepository;

    @Override
    public Quest parse(String s, Locale locale) throws ParseException {
        Integer id = Integer.parseInt(s);

        return this.questsRepository.getQuest(id);
    }

    @Override
    public String print(Quest quest, Locale locale) {
        return quest.toString();
    }
}
