package it.unibo.es2;

public interface Logics {
    /**
     * True if the flag is turned on
     * 
     * @return
     */
    boolean updateFlag(int x, int y);

    /**
     * True if it is time to quit (i.e., all flags in a coloumn or row turned on).
     *
     * @return whether it is time to quit
     */
    boolean toQuit();
}
