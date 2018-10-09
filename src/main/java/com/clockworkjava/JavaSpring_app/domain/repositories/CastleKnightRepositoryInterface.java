package com.clockworkjava.JavaSpring_app.domain.repositories;

import com.clockworkjava.JavaSpring_app.domain.Knight;
import jdk.jshell.spi.ExecutionControl;

import java.util.Collection;
import java.util.Optional;

public interface CastleKnightRepositoryInterface {
    void createKnights(String name, int age);

    Collection<Knight> getAllKnights();

    Optional<Knight> getKnight(String name);

    void removeKnight(int id);

    void saveKnight(Knight knight);

    void build();

    Knight getKnightById(int id);

    void updateKnight(int id, Knight knight);
}
