package com.clockworkjava.JavaSpring_app.domain;

import java.util.Objects;

public class Knight {
    private String name;
    private int age;
    private Quest quest;

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knight knight = (Knight) o;
        return age == knight.age &&
                Objects.equals(name, knight.name) &&
                Objects.equals(quest, knight.quest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, quest);
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
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
