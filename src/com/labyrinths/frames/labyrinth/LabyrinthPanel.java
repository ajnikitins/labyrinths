package com.labyrinths.frames.labyrinth;

import com.labyrinths.labyrinth.Labyrinth;
import com.labyrinths.labyrinth.Node;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

public class LabyrinthPanel extends JPanel {

  public LabyrinthPanel(Labyrinth labyrinth) {
    this.labyrinth = labyrinth;
  }

  private final Labyrinth labyrinth;

  @Override
  public void paint(Graphics g) {
//    g.drawRect(0, 0, labyrinth.getWidth() * LabyrinthFrame.SIZE_PER_PIXEL, labyrinth.getHeight() * LabyrinthFrame.SIZE_PER_PIXEL);
    Node[][] nodes = labyrinth.getNodes();

    for (int y = 0, h = labyrinth.getHeight(); y < h; y++) {
      for (int x = 0, w = labyrinth.getWidth(); x < w; x++) {
          Node node = nodes[y][x];
          Point startPoint = new Point(x * LabyrinthFrame.SIZE_PER_PIXEL, y * LabyrinthFrame.SIZE_PER_PIXEL);
          if (node.getUp() == null) {
            int endX = startPoint.x + LabyrinthFrame.SIZE_PER_PIXEL;
            g.drawLine(startPoint.x, startPoint.y, endX, startPoint.y);
          }

          if (node.getLeft() == null) {
            int endY = startPoint.y + LabyrinthFrame.SIZE_PER_PIXEL;
            g.drawLine(startPoint.x, startPoint.y, startPoint.x, endY);
          }
//        g.drawRect(x * LabyrinthFrame.SIZE_PER_PIXEL, y * LabyrinthFrame.SIZE_PER_PIXEL, LabyrinthFrame.SIZE_PER_PIXEL, LabyrinthFrame.SIZE_PER_PIXEL);
      }
    }
  }
}
