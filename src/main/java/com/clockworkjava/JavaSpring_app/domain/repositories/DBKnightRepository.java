package com.clockworkjava.JavaSpring_app.domain.repositories;

import com.clockworkjava.JavaSpring_app.domain.Knight;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


@Repository
public class DBKnightRepository {

    public void createKnights(String name, int age) {
        System.out.println("używam bazy danych");
    }

    public Collection<Knight> getAllKnights() {
        System.out.println("używam bazy danych");
        return null;
    }


    public Optional<Knight> getKnight(String name) {
        System.out.println("używam bazy danych");
        return null;
    }


    public void removeKnight(int id) {

    }

    public void removeKnight(String name) {
        System.out.println("używam bazy danych");
    }


    public void saveKnight(Knight knight) {
    }

    public void build() {
        System.out.println("używam bazy danych");
    }


    public Knight getKnightById(int id) {
        return null;
    }

}
