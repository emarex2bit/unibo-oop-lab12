package it.unibo.es3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI for the game.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final List<JButton> cells = new ArrayList<>();
    private final Logics logics;

    /**
     * Constructor.
     *
     * @param width the size of the grid
     */
    public GUI(final int width) {
        logics = new LogicsImpl(width, width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Il frame usa BorderLayout di default → OK
        final JPanel grid = new JPanel(new GridLayout(width, width));
        this.getContentPane().add(grid, java.awt.BorderLayout.CENTER);

        // Crea i bottoni della grid
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                final var pos = new Pair<>(j, i);
                final JButton button = new JButton(pos.toString());
                this.cells.add(button);
                grid.add(button);
            }
        }

        // Bottone NEXT STEP separato
        final JButton nextStepButton = new JButton(">");
        nextStepButton.addActionListener(e -> {
            boolean[] flags = logics.update();
            updateUI(flags);
            if (logics.toQuit()) {
                dispose();
            }
        });

        // Lo aggiungo *sotto*, non nella grid
        this.getContentPane().add(nextStepButton, java.awt.BorderLayout.SOUTH);

        updateUI(logics.init());

        pack();
        this.setVisible(true);
    }

    private void updateUI(boolean[] flags) {
        for (int i = 0; i < cells.size(); i++) {
            cells.get(i).setText(flags[i] ? "*" : "");
        }
    }
}
