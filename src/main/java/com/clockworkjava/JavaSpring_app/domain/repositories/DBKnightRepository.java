package com.clockworkjava.JavaSpring_app.domain.repositories;

import com.clockworkjava.JavaSpring_app.domain.Knight;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;


@Repository
public class DBKnightRepository implements CastleKnightRepositoryInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createKnights(String name, int age) {
        Knight knight = new Knight(name, age);
        this.entityManager.persist(knight);
    }

    public Collection<Knight> getAllKnights() {
        return this.entityManager.createQuery("from Knight").getResultList();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        Knight name1 = this.entityManager
                .createQuery("from Knight k where k.name=:name", Knight.class)
                .setParameter("name", name)
                .getSingleResult();

        return Optional.ofNullable(name1);
    }

    @Transactional
    public void removeKnight(int id) {
        this.entityManager.remove(id);
    }

//    public void removeKnight(String name) {
//        System.out.println("używam bazy danych");
//    }

    @Transactional
    public void saveKnight(Knight knight) {
        this.entityManager.persist(knight);
    }

    public void build() {
        System.out.println("używam bazy danych");
    }


    public Knight getKnightById(int id) {
        return this.entityManager.find(Knight.class, id);
    }

    @Override
    @Transactional
    public void updateKnight(int id, Knight knight) {
        this.entityManager.merge(knight);
    }

}
