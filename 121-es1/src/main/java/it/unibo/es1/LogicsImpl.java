package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private static final String ERROR_MESSAGE = "Unimplemented method";
    
    private List<BtnData> btns;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.btns = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.btns.add(new BtnData());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.btns.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> values() {
        return this.btns
            .stream()
            .map(x -> x.value)
            .toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        return this.btns
            .stream()
            .map(x -> x.enabled)
            .toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        return this.btns.get(elem).inc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        StringBuilder stringBuilder = new StringBuilder("|");

        this.btns.stream()
            .map(x -> x.value)
            .forEach( e -> 
                {
                    stringBuilder.append(e + "|");
                });

        return stringBuilder.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        Integer start = this.btns.get(0).value;
        return this.btns.stream()
            .allMatch(x -> x.value.equals(start));
    }


    private class BtnData
    {
        private boolean enabled = true;
        private Integer value = 0;

        public Integer inc() {
            return ++this.value;
        }
    }
}
