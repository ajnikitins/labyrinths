package com.labyrinths.frames.main;

import com.labyrinths.frames.labyrinth.LabyrinthFrame;
import com.labyrinths.labyrinth.Labyrinth;
import com.labyrinths.solvers.Solver;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

  public MainFrame() {
    randomButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        Random random = new Random();
        int size = random.nextInt(65);
        widthSlider.setValue(size);
        heightSlider.setValue(size);
        seedInput.setText(String.valueOf(Math.abs(random.nextLong())));
      }
    });
    generateButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        int width = widthSlider.getValue();
        int height = heightSlider.getValue();
        long seed = Long.parseLong(seedInput.getText());

        var labyrinth = new Labyrinth(width, height, seed);
        new LabyrinthFrame(labyrinth, new Solver());
      }
    });
  }

  public JPanel getContentPanel() {
    return contentPanel;
  }

  private JPanel contentPanel;
  private JTextField seedInput;
  private JButton randomButton;
  private JButton generateButton;
  private JSlider widthSlider;
  private JSlider heightSlider;
}
