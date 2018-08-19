package com.clockworkjava.JavaSpring_app.domain.repositories;

import com.clockworkjava.JavaSpring_app.domain.Knight;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CastleKnightRepository {

    Map<String, Knight> knights = new HashMap<>();

    public CastleKnightRepository() {}

    public void createKnights(String name, int age) {
        knights.put(name, new Knight(name, age));
    }

    public Collection<Knight> getAllKnights () {
        return this.knights.values();
    }

    public Knight getKnight (String name) {
        return knights.get(name);
    }

    public void removeKnight (String name) {
        knights.remove(name);
    }

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

