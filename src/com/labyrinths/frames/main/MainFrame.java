package com.labyrinths.frames.main;

import com.labyrinths.frames.labyrinth.LabyrinthFrame;
import com.labyrinths.labyrinth.Labyrinth;
import com.labyrinths.solvers.DijkstraSolver;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class MainFrame {

  public MainFrame() {

    randomButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        Random random = new Random();
        int width;
        int height;
        if (lock) {
          int size = random.nextInt(64) + 1;
          width = size;
          height = size;
        } else {
          width = random.nextInt(64) + 1;
          height = random.nextInt(64) + 1;
        }
        widthSlider.setValue(width);
        heightSlider.setValue(height);
        seedInput.setText(String.valueOf(Math.abs(random.nextLong())));
      }
    });

    randomSeedButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        Random random = new Random();
        seedInput.setText(String.valueOf(Math.abs(random.nextLong())));
      }
    });

    generateButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        int width = widthSlider.getValue();
        int height = heightSlider.getValue();
        long seed = Long.parseLong(seedInput.getText());

        var labyrinth = new Labyrinth(width, height, seed);
        new LabyrinthFrame(labyrinth, new DijkstraSolver());
      }
    });

    lockCheckBox.addItemListener(e -> {
      if (e.getStateChange() == ItemEvent.SELECTED) {
        lock = true;
        heightSlider.setValue(widthSlider.getValue());
      } else {
        lock = false;
      }
    });

    widthSlider.addChangeListener(e -> {
      if (lock) {
        heightSlider.setValue(widthSlider.getValue());
      }
    });

    heightSlider.addChangeListener(e -> {
      if (lock) {
        widthSlider.setValue(heightSlider.getValue());
      }
    });
  }

  public JPanel getContentPanel() {
    return contentPanel;
  }

  private boolean lock;
  private JPanel contentPanel;
  private JTextField seedInput;
  private JButton randomButton;
  private JButton generateButton;
  private JSlider widthSlider;
  private JSlider heightSlider;
  private JButton randomSeedButton;
  private JCheckBox lockCheckBox;
}
