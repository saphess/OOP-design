package ru.netology.homework8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestRadio {

    @ParameterizedTest
    @CsvSource({
            "7, 8",
            "8, 9",
            "9, 0",
            "10, 1", //по последним есть сомнения. не сказано, что пользователь может задать текущее значение выше 9,
            //а потом уже менять. по сути, эти два теста - не логичны, тк текущая станция не может быть
            //десятой или далее, но, это граничные значения и я должна их проверить...
            //немного запуталась, прошу прокомментировать это :(
            "11, 1",
            "0, 1",
            "-1, 1",
            "-2, 1"
    })
    public void shouldLimitValueNextRadioStation(int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(currentStation);

        radio.nextRadioStation();

        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 1",
            "1, 0",
            "0, 9",
            "-1, 9",
            "-2, 9",
            "8, 7",
            "9, 8",
            "10, 9",
            "11, 9"
    })
    public void shouldLimitValuePrevRadioStation(int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(currentStation);

        radio.prevRadioStation();

        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({
            "98, 99",
            "99, 100",
            "100, 100",
            "101, 100",
            "102, 100",
            "2, 3",
            "1, 2",
            "0, 1",
            "-1, 1",
            "-2, 1"
    })
    public void shouldLimitValueIncreaseVolume(int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);

        radio.increaseVolume();

        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "98, 97",
            "99, 98",
            "100, 99",
            "101, 99",
            "102, 99",
            "2, 1",
            "1, 0",
            "0, 0",
            "-1, 0",
            "-2, 0"
    })
    public void shouldLimitValueDecreaseVolume(int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);

        radio.decreaseVolume();

        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }
}
