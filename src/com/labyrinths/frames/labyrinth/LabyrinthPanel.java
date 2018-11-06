package com.labyrinths.frames.labyrinth;

import com.labyrinths.labyrinth.Labyrinth;
import com.labyrinths.labyrinth.Node;
import com.labyrinths.solvers.Solver;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

class LabyrinthPanel {

  LabyrinthPanel(Labyrinth labyrinth, Solver solver) {
    this.labyrinth = labyrinth;
    this.solver = solver;
    this.contentPane = new JPanel() {
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintPanel(g);
      }
    };
    contentPane.setPreferredSize(new Dimension(
        labyrinth.getWidth() * NODE_SIZE + 1, labyrinth.getHeight() * NODE_SIZE + 1
    ));
    contentPane.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (!solver.getSolved()) {
          solver.solveLabyrinth(labyrinth);
          contentPane.repaint();
        }
      }
    });
  }

  private final JPanel contentPane;
  private static final int NODE_SIZE = 20;
  private final Labyrinth labyrinth;
  private final Solver solver;

  JPanel getContentPane() {
    return contentPane;
  }

  private void paintPanel(Graphics g) {
    g.drawRect(0, 0, labyrinth.getWidth() * NODE_SIZE, labyrinth.getHeight() * NODE_SIZE);
    Node[][] nodes = labyrinth.getNodes();

    g.setColor(Color.GREEN);
    Point entrance = labyrinth.getEntrance().getPoint();
    g.fillRect(entrance.x * NODE_SIZE, entrance.y * NODE_SIZE, NODE_SIZE, NODE_SIZE);

    g.setColor(Color.RED);
    Point exit = labyrinth.getExit().getPoint();
    g.fillRect(exit.x * NODE_SIZE, exit.y * NODE_SIZE, NODE_SIZE, NODE_SIZE);

    g.setColor(Color.BLACK);
    for (int y = 0, h = labyrinth.getHeight(); y < h; y++) {
      for (int x = 0, w = labyrinth.getWidth(); x < w; x++) {
          Node node = nodes[y][x];
          Point startPoint = new Point(x * NODE_SIZE, y * NODE_SIZE);

          if (solver.getSolved() && !(node.equals(labyrinth.getEntrance()) || node.equals(labyrinth.getExit()))) {
            if (solver.getPath().contains(node)) {
              g.setColor(new Color(255, 255, 0, 75));
              g.fillRect(x * NODE_SIZE, y * NODE_SIZE, NODE_SIZE, NODE_SIZE);
            } else if (!solver.getUnvisitedNodes().contains(node)) {
              g.setColor(new Color(0, 0, 255, 50));
              g.fillRect(x * NODE_SIZE, y * NODE_SIZE, NODE_SIZE, NODE_SIZE);
            }
          }
          g.setColor(Color.BLACK);

          if (node.getUp() == null) {
            int endX = startPoint.x + NODE_SIZE;
            g.drawLine(startPoint.x, startPoint.y , endX, startPoint.y );
          }

          if (node.getLeft() == null) {
            int endY = startPoint.y + NODE_SIZE;
            g.drawLine(startPoint.x , startPoint.y, startPoint.x , endY);
          }

      }
    }
  }
}
