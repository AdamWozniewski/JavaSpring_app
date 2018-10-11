package com.clockworkjava.JavaSpring_app.services;


import com.clockworkjava.JavaSpring_app.components.PlayerInformation;
import com.clockworkjava.JavaSpring_app.domain.Knight;
import com.clockworkjava.JavaSpring_app.domain.repositories.CastleKnightRepository;
import com.clockworkjava.JavaSpring_app.domain.repositories.PlayerInformationRepository;
import com.clockworkjava.JavaSpring_app.domain.repositories.QuestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class KnightService {

    @Autowired
    CastleKnightRepository castleKnightRepository;

    @Autowired
    QuestsRepository questsRepository;

    @Autowired
    PlayerInformationRepository playerInformation;
    public List<Knight> getAllKnights() { // pobieranie rycerzy
        return new ArrayList<>(this.castleKnightRepository.getAllKnights());
    }

    public void saveKnight(Knight knight) {
        this.castleKnightRepository.saveKnight(knight);
    }

    public Knight getKnightService(Integer id) {
        return this.castleKnightRepository.getKnightById(id);
    }

    public void deleteKnight(int id) {
        this.castleKnightRepository.removeKnight(id);
    }

    public void updateKnight(Knight knight) {
        this.castleKnightRepository.updateKnight(knight.getId(), knight);
    }

    public int collectRewards() {
        Predicate<Knight> knightPredicate = knight -> {
            if (knight.getQuest() != null) {
                return knight.getQuest().isFinished();
            } else {
                return false;
            }
        };
        int sum = this.castleKnightRepository.getAllKnights().stream().filter(knightPredicate)
                .mapToInt(knight -> knight.getQuest().getReward())
                .sum();
        this.castleKnightRepository.getAllKnights().stream().filter(knightPredicate).forEach(knight -> knight.setQuest(null));

        return sum;
    }

    @Transactional
    public void getMyGold() {
        List<Knight> allKnights = this.getAllKnights();
        allKnights.forEach(knight -> {
                if (knight.getQuest() != null) {
                    boolean finished = knight.getQuest().isFinished();
                    if (finished) {
                        this.questsRepository.update(knight.getQuest());
                    }
                }
            }
        );
        PlayerInformation local = this.playerInformation.getFirst();
        int currentGold = local.getGold();
        local.setGold(currentGold + this.collectRewards());

    }
}
