package it.unibo.es3;

public interface Logics {

    public boolean[] init();

    /**
     * Update the animation state to the next step
     */
    public boolean[] update();

    public boolean toQuit();

}
