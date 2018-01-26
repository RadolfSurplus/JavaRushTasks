package com.javarush.task.task27.task2712.ad;

import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> availableAdvertisement = storage.list();
        if (availableAdvertisement.isEmpty())
            throw new NoVideoAvailableException();

    }
}
