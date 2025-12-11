package it.unibo.es2;

public class LogicsImpl implements Logics{

    private boolean[] flags;
    private int w;
    private int h;

    public LogicsImpl(int size) {
        flags = new boolean[size * size];
        w = h = size;
    }

    @Override
    public boolean updateFlag(int x, int y) {
        int index = y * w + x;
        flags[index] = !flags[index];
        return flags[index];
    }

    @Override
    public boolean toQuit() {
        boolean ret = false;
        for (int i = 0; i < flags.length; i += w) {
            for (int j = i; j < i + 4; j++) {
                ret = flags[j];
                if(!flags[j]) {
                    break;
                }
            }
            if(ret) {
                return true;
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = i; j < flags.length; j += w) {
                ret = flags[j];
                if(!flags[j]) {
                    break;
                }
            }
            if(ret) {
                return true;
            }
        }

        return false;
    }
    
}
