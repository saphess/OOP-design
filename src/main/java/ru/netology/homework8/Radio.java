package ru.netology.homework8;

public class Radio {
    private int sizeRadioStation = 10;

    private int currentRadioStation;
    private int currentVolume;

    public Radio() {

    }

    //можно ли считать конструктор методом сеттера?
    //плюсом есть такое условие
    //"Теперь объекты радио в своём поле будут хранить и количество станций, заданное при создании объекта радио."
    //значит ли это, что нам не нужен сеттер?
    public Radio(int sizeRadioStation) {
        if (sizeRadioStation <= 0) {
            return;
        }
        this.sizeRadioStation = sizeRadioStation;
    }

    public int getSizeRadioStation() {
        return sizeRadioStation;
    }

    public void setCurrentRadioStation(int newRadioStation) {
        if (newRadioStation < 0) {
            return;
        }
        if (newRadioStation > (sizeRadioStation - 1)) {
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
        if (getCurrentRadioStation() == (sizeRadioStation - 1)) {
            setCurrentRadioStation(0);
            return;
        }

        setCurrentRadioStation(getCurrentRadioStation() + 1);
    }

    public void prevRadioStation() {
        if (getCurrentRadioStation() == 0) {
            setCurrentRadioStation((sizeRadioStation - 1));
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
