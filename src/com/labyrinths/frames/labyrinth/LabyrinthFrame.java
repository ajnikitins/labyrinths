package com.labyrinths.frames.labyrinth;

import com.labyrinths.labyrinth.Labyrinth;
import com.labyrinths.solvers.Solver;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class LabyrinthFrame {
  public LabyrinthFrame(String title, Labyrinth labyrinth, Solver solver) throws HeadlessException {
    JFrame frame = new JFrame(title);
    frame.setContentPane(new LabyrinthPanel(labyrinth, solver).getContentPane());
    frame.pack();
    frame.setVisible(true);
    frame.setResizable(false);
  }
}
