package com.clockworkjava.JavaSpring_app.domain.repositories;

import com.clockworkjava.JavaSpring_app.domain.Knight;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CastleKnightRepository implements CastleKnightRepositoryInterface {

    Map<String, Knight> knights = new HashMap<>();

    public CastleKnightRepository() {}

    @Override
    public void createKnights(String name, int age) {
        this.knights.put(name, new Knight(name, age));
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return this.knights.values();
    }

    @Override
    public Knight getKnight(String name) {
        return this.knights.get(name);
    }

    @Override
    public void removeKnight(String name) {
        this.knights.remove(name);
    }

    @Override
    @PostConstruct
    public void build() {
        this.createKnights("lancelot", 29);
        this.createKnights("percival", 25);
    }

    @Override
    public String toString() {
        return "CastleKnightRepository{" +
                ", knights=" + knights +
                '}';
    }
}

