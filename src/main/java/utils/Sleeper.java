package utils;

import lombok.SneakyThrows;

public class Sleeper {
    @SneakyThrows
    public static void sleepInSec(int waitSec) {
        Thread.sleep(waitSec * 1000);
    }

    @SneakyThrows
    public static void sleepInMills(int waitInMillis) {
        Thread.sleep(waitInMillis);
    }
}
