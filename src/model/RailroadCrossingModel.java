package model;

import java.util.Timer;
import java.util.TimerTask;


public class RailroadCrossingModel {
    private enum State {WHITE, RED}
    private State state = State.WHITE;
    private boolean redToggle = false;  // Для мигания красного света
    private boolean whiteToggle = true;  // Для мигания бело-голубого света
    private int trainX = 0;  // Положение поезда
    private final int speed = 12;  // Скорость движения

    private Timer timer;

    public RailroadCrossingModel() {
        timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateState();
            }
        }, 0, 500); // Обновление каждые 500 мс
    }

    public int getTrainX() {
        return trainX;
    }

    public boolean isWhiteOn() {
        return state == State.WHITE && whiteToggle;
    }

    public boolean isRedLeftOn() {
        return state == State.RED && redToggle;
    }

    public boolean isRedRightOn() {
        return state == State.RED && !redToggle;
    }

    public void moveTrain() {
        trainX += speed;
        if (trainX > 800) trainX = -200;  // Цикл движения
    }

    private void updateState() {
        moveTrain();
        int trainNose = trainX + 200; // Перед поезда
        int trainEnd = trainX; // Конец поезда

        if (trainNose < 250) {
            state = State.WHITE;
        } else if (trainNose >= 250 && trainEnd <= 450) {
            state = State.RED;
        } else if (trainEnd > 450) {
            state = State.WHITE;
        }

        if (state == State.RED) {
            redToggle = !redToggle;
        } else if (state == State.WHITE) {
            whiteToggle = !whiteToggle;
        }
    }
}
