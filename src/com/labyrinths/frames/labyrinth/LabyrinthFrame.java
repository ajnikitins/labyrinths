package com.labyrinths.frames.labyrinth;

import com.labyrinths.labyrinth.Labyrinth;
import com.labyrinths.solvers.Solver;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class LabyrinthFrame extends JFrame {

  public LabyrinthFrame(Labyrinth labyrinth, Solver solver) throws HeadlessException {
    this.labyrinth = labyrinth;
    this.solver = solver;

    Dimension size = new Dimension((labyrinth.getWidth())  * SIZE_PER_PIXEL, labyrinth.getHeight() * SIZE_PER_PIXEL);
    setSize(size);
    setContentPane(new LabyrinthPanel(labyrinth));
    setVisible(true);
  }

  public static final int SIZE_PER_PIXEL = 20;
  private final Labyrinth labyrinth;
  private final Solver solver;

}
