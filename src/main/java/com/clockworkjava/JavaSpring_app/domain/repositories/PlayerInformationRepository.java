package com.clockworkjava.JavaSpring_app.domain.repositories;

import com.clockworkjava.JavaSpring_app.components.PlayerInformation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class PlayerInformationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createPlayerInformation(PlayerInformation playerInformation){
//        PlayerInformation playerInformation1 = new PlayerInformation();
        this.entityManager.persist(playerInformation);

    }

    @Transactional
    public PlayerInformation getFirst() {
        return this.entityManager
                .createQuery("from PlayerInformation", PlayerInformation.class)
                .getResultList()
                .get(0);
    }
}
