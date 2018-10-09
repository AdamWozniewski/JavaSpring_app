package com.clockworkjava.JavaSpring_app.utils;

import java.util.Set;

public class Ids {
    public static int getNewId(Set<Integer> keysSoFar) {
        if (keysSoFar.isEmpty()) {
            return 0;
        } else {
            Integer integer = keysSoFar.stream().min(Integer::max).get();
            return integer + 1;
        }
    }
}
