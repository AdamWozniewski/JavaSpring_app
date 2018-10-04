package com.clockworkjava.JavaSpring_app.services;


import com.clockworkjava.JavaSpring_app.domain.Knight;
import com.clockworkjava.JavaSpring_app.domain.repositories.CastleKnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KnightService {

    @Autowired
    CastleKnightRepository castleKnightRepository;
    public List<Knight> getAllKnights() { // pobieranie rycerzy
        return new ArrayList<>(this.castleKnightRepository.getAllKnights());
    }

    public void saveKnight(Knight knight) {
        this.castleKnightRepository.saveKnight(knight);
    }

    public Knight getKnightService(Integer id) {
        return this.castleKnightRepository.getKnightById(id);
    }
}
