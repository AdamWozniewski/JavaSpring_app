package com.clockworkjava.JavaSpring_app;

import com.clockworkjava.JavaSpring_app.domain.Knight;
import com.clockworkjava.JavaSpring_app.domain.Quest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Knight lancelot = new Knight("Lancelot", 100, new Quest("ratuj siurze"));

        System.out.println(lancelot.toString());

        Knight percival = new Knight("Percival", 29, new Quest("Zasiukaj smoka"));
    }
}
