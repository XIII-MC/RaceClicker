package com.xiii.raceclicker.data;

// MADE BY DukeinPro

public class TempServerData {
    public int racePhase = 0;

    public boolean isWaitingBeforeClickPhase;
    public boolean isClickingPhase;
    public boolean isWaitingAfterClickPhase;
    public boolean isRacePhase;
    public int timeLeft;
    public double addSpeed = 0.02;


    public void changePhase() {
        isWaitingBeforeClickPhase = racePhase == 0;
        isClickingPhase = racePhase == 1;
        isWaitingAfterClickPhase = racePhase == 2;
        isRacePhase = racePhase == 3;
    }
}
