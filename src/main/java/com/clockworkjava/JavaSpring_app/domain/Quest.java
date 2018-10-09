package com.clockworkjava.JavaSpring_app.domain;

import java.time.LocalDateTime;

public class Quest {
    private String desc;
    private int reward = 100;
    private int length = 30;
    private boolean started = false;
    private boolean finished = false;

    private int id;
    private LocalDateTime startDate;
    public Quest(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isStarted() {
        return started;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
