package com.clockworkjava.JavaSpring_app.domain.repositories;

import com.clockworkjava.JavaSpring_app.domain.Knight;

import javax.annotation.PostConstruct;
import java.util.Collection;

public interface CastleKnightRepositoryInterface {
    void createKnights(String name, int age);

    Collection<Knight> getAllKnights();

    Knight getKnight(String name);

    void removeKnight(String name);

    void build();
}
