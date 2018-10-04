package com.clockworkjava.JavaSpring_app.domain.repositories;

import com.clockworkjava.JavaSpring_app.domain.Knight;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class CastleKnightRepository implements CastleKnightRepositoryInterface {

    Map<Integer, Knight> knights = new HashMap<>();

    public CastleKnightRepository() {}

    @Override
    public void createKnights(String name, int age) {
        Knight knight = new Knight(name, age);
        knight.setId(this.getNewId());
        this.knights.put(knight.getId(), knight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return this.knights.values();
    }

    public int getNewId() {
        if (this.knights.isEmpty()) {
            return 0;
        }
        else {
            Integer integer = this.knights.keySet().stream().max(Integer::max).get();
            return integer + 1;
        }
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        Optional<Knight> knightOptional = this.knights
                .values()
                .stream()
                .filter(knight -> knight.getName().equals(name))
                .findAny();
        return knightOptional;
    }

    @Override
    public void removeKnight(int id) {
        this.knights.remove(id);
    }

    @Override
    @PostConstruct
    public void build() {
        this.createKnights("lancelot", 29);
        this.createKnights("percival", 25);
    }

    @Override
    public Knight getKnightById(int id) {
        return this.knights.get(id);
    }

    @Override
    public String toString() {
        return "CastleKnightRepository{" +
                ", knights=" + knights +
                '}';
    }

    @Override
    public void saveKnight(Knight knight) {
        this.knights.put(knight.getId(), knight);
    }
}

