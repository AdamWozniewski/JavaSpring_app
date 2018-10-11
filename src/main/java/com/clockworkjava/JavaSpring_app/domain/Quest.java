package com.clockworkjava.JavaSpring_app.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
//@Table(name = "Zadania") // zmiana nazwy tabeli
public class Quest {

    @Column(name = "opis") // zmiana nazwy kolumby
    private String desc;
    private int reward = 100;

//    @Transient // pomijanie tej wartosci w bazie
    private int length = 30;

    private boolean started = false;
    private boolean finished = false;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Quest() { }

    private LocalDateTime startDate;
    public Quest(String desc) {
//        this.id = id;
        this.desc = desc;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public boolean isStarted() {
        return started;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return this.desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setStarted(boolean started) {
        if (started == true) {
            this.startDate = LocalDateTime.now();
        }
        this.started = started;
    }
    public boolean isFinished() {
        if (this.finished) {
            return this.finished;
        } else {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime localDateTime = this.startDate.plusSeconds(this.length);
            boolean isAfter = now.isAfter(localDateTime);
            if (isAfter) {
                this.finished = true;
            }
            return isAfter;
        }
    }

}
