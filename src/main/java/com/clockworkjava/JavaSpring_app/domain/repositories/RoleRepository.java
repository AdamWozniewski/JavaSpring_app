package com.clockworkjava.JavaSpring_app.domain.repositories;

import com.clockworkjava.JavaSpring_app.utils.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class RoleRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void persistRole(Role role) {
        this.entityManager.persist(role);
    }
}
