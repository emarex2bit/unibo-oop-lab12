package it.unibo.es3;

import java.util.ArrayList;
import java.util.Random;

public class LogicsImpl implements Logics {

    private int width;
    private int heigth;

    private boolean[] flags;

    public LogicsImpl(int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
        flags = new boolean[width * heigth];
    }

    @Override
    public boolean[] init() {
        Random rng = new Random();
        for (int i = 0; i < 3; i++) {
            int index = rng.nextInt(0, flags.length);
            flags[index] = true;
        }

        return flags;
    }

    @Override
    public boolean[] update() {

        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < flags.length; i++) {
            if (flags[i]) {
                indexes.add(i);
            }
        }

        for (Integer i : indexes) {
            for (int j = -1; j < 2; j++) {
                for (int k = -1; k < 2; k++) {
                    int index = i + j * width + k;
                    if (index >= 0 && index < flags.length) {
                        flags[index] = true;
                    }
                }
            }
        }

        return flags;
    }

    @Override
    public boolean toQuit() {
        for (int i = 0; i < flags.length; i++) {
            if (!flags[i]) {
                return false;
            }
        }
        return true;
    }

}
