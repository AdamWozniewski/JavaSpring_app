package com.clockworkjava.JavaSpring_app.config;

import com.clockworkjava.JavaSpring_app.domain.repositories.CastleKnightRepository;
import com.clockworkjava.JavaSpring_app.domain.repositories.CastleKnightRepositoryInterface;
import com.clockworkjava.JavaSpring_app.domain.repositories.DBKnightRepository;
import org.springframework.context.annotation.*;

@Configuration
public class MainConfig {

    @Bean(name = "inmemoryrepository")
    @Profile("dev")
    public CastleKnightRepositoryInterface createMemoryRepo() {
        CastleKnightRepositoryInterface repo = new CastleKnightRepository();
        return repo;
    }

//    @Bean(name = "dbrepository")
//    @Profile("prod")
//    public CastleKnightRepositoryInterface createDBRepo() {
//        CastleKnightRepositoryInterface repo = new DBKnightRepository();
//        return repo;
//    }
}
