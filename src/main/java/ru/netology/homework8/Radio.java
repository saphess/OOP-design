package ru.netology.homework8;

public class Radio {
    private int currentRadioStation;
    private int currentVolume;

    public void setCurrentRadioStation(int newRadioStation) {
        if (newRadioStation < 0) {
            return;
        }
        if (newRadioStation > 9) {
            return;
        }
        currentRadioStation = newRadioStation;
    }

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentVolume(int newVolume) {
        if (newVolume < 0) {
            currentVolume = 0;
            return;
        }
        if (newVolume > 100) {
            currentVolume = 100;
            return;
        }
        currentVolume = newVolume;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void nextRadioStation() {
        if (getCurrentRadioStation() == 9) {
            setCurrentRadioStation(0);
            return;
        }

        setCurrentRadioStation(getCurrentRadioStation() + 1);
    }

    public void prevRadioStation() {
        if (getCurrentRadioStation() == 0) {
            setCurrentRadioStation(9);
            return;
        }
        setCurrentRadioStation(getCurrentRadioStation() - 1);
    }

    public void increaseVolume() {
        if (getCurrentVolume() == 100) {
            return;
        }
        setCurrentVolume(getCurrentVolume() + 1);
    }

    public void decreaseVolume() {
        if (getCurrentVolume() == 0) {
            return;
        }
        setCurrentVolume(getCurrentVolume() - 1);
    }
}
