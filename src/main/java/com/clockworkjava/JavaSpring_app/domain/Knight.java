package com.clockworkjava.JavaSpring_app.domain;

public class Knight {
    private String name;
    private int age;
    private Quest quest;

    public Knight(String name, int age, Quest quest) {
        this.name = name;
        this.age = age;
        this.quest = quest; // wstrzykiwanie przez konstrukotor
    }

    public void setQuest(Quest quest) { // wstrzykiwanie porzez metode
        this.quest = quest;
    }

    @Override
    public String toString() {
        return "Knight o danych: {" +
                "name='" + this.name + '\'' +
                ", age=" + this.age +
                ", quest=" + this.quest.toString() +
                '}';
    }
}
