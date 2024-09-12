package ru.netology.homework8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestRadio {

    @ParameterizedTest
    @CsvSource({
            "9, 9",
            "10, 10",
            "11, 11",
            "1, 1",
            "0, 10",
            "-1, 10"
    })
    public void shouldSetSizeRadioStation(int sizeRadioStation, int expected){
        Radio radio = new Radio(sizeRadioStation);

        int actual = radio.getSizeRadioStation();
        Assertions.assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({
            "8, 6, 7",
            "8, 7, 0",
            "8, 0, 1",
            "8, 1, 2",
            "9, 6, 7",
            "9, 7, 8",
            "9, 8, 0"
    })
    public void shouldLimitValueNextRadioStation(int sizeStation, int currentStation, int expected){
        Radio radio = new Radio(sizeStation);
        radio.setCurrentRadioStation(currentStation);

        radio.nextRadioStation();

        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "8, 2, 1",
            "8, 1, 0",
            "8, 0, 7",
            "8, 7, 6",
            "9, 1, 0",
            "9, 0, 8",
            "9, 8, 7"
    })
    public void shouldLimitValuePrevRadioStation(int sizeStation, int currentStation, int expected){
        Radio radio = new Radio(sizeStation);
        radio.setCurrentRadioStation(currentStation);

        radio.prevRadioStation();

        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "7, 8",
            "8, 9",
            "9, 0",
            "10, 1",
            "11, 1",
            "0, 1",
            "-1, 1",
            "-2, 1"
    })
    public void shouldLimitValueNextRadioStationIfByDefault(int currentStation, int expected) {
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
    public void shouldLimitValuePrevRadioStationIfByDefault(int currentStation, int expected) {
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
