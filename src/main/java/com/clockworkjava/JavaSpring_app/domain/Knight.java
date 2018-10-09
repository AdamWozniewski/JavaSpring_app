package com.clockworkjava.JavaSpring_app.domain;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Knight {

//    @Min(2)
//    @Max(40)
    @NotNull
    @Size(min = 2, max = 40, message = "Imie musi byc miedzy 2 a 40 znakow")
    private String name;

    @NotNull
    @Range(min = 18, max = 60, message = "musi miec min 18 a max 60 lat")
    private int age;

    private int id;
    private int level;
    private Quest quest;

    public Knight() {
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        this.level = 0;
    }

    public Quest getQuest() {
        return quest;
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
//        this.quest.setStarted(true);
        this.quest = quest;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
