package com.clockworkjava.JavaSpring_app.domain.repositories;

import com.clockworkjava.JavaSpring_app.domain.Knight;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public class DBKnightRepository implements CastleKnightRepositoryInterface {

    public void createKnights(String name, int age) {
        System.out.println("używam bazy danych");
    }

    public Collection<Knight> getAllKnights() {
        System.out.println("używam bazy danych");
        return null;
    }

    @Override
    public Knight getKnight(String name) {
        System.out.println("używam bazy danych");
        return null;
    }

    public void removeKnight(String name) {
        System.out.println("używam bazy danych");
    }

    public void build() {
        System.out.println("używam bazy danych");
    }

}
