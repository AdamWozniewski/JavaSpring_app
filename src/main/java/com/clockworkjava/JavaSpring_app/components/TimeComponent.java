package com.clockworkjava.JavaSpring_app.components;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // każde wywolanie buduje nowy komponent, odswieza go
public class TimeComponent {
    private LocalDateTime localDateTime = LocalDateTime.now();

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
