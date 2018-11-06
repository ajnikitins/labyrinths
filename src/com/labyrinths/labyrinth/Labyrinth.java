package com.labyrinths.labyrinth;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Labyrinth {

  public Labyrinth(int width, int height, long seed) {
    this.width = width;
    this.height = height;
    Random random = new Random(seed);
    this.nodes = new Node[height][width];

    // Implementation of Prim's algorithm
    List<Point> cells = new ArrayList<>(width * height);

    int x = random.nextInt(width);
    int y = random.nextInt(height);

    cells.add(new Point(x, y));

    while (!cells.isEmpty()) {
      Point cell = cells.remove(random.nextInt(cells.size()));
      y = cell.y;
      x = cell.x;
      Node node = new Node(x, y);
      nodes[y][x] = node;

      ArrayList<Point> mazeNeighbors = new ArrayList<>(4);
      if (y > 0) {
        (nodes[y - 1][x] == null ? cells : mazeNeighbors).add(new Point(x, y - 1));
      }

      if (x > 0) {
        (nodes[y][x - 1] == null ? cells : mazeNeighbors).add(new Point(x-1, y));
      }

      if (y < height - 1) {
        (nodes[y+1][x] == null ? cells : mazeNeighbors).add(new Point(x, y + 1));
      }

      if (x < width - 1) {
        (nodes[y][x+1] == null ? cells : mazeNeighbors).add(new Point(x + 1, y));
      }

      if (!mazeNeighbors.isEmpty()) {
        Point neighborLocation = mazeNeighbors.remove(random.nextInt(mazeNeighbors.size()));
        int neighborY = neighborLocation.y;
        int neighborX = neighborLocation.x;
        Node neighbor = nodes[neighborY][neighborX];

        if (y > neighborY) {
          node.setDown(neighbor);
        } else if (y < neighborY) {
          node.setUp(neighbor);
        } else if (x < neighborX) {
          node.setRight(neighbor);
        } else if (x > neighborX) {
          node.setLeft(neighbor);
        }
      }
    }
  }

  private int width;
  private int height;
  private Node[][] nodes;

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public Node[][] getNodes() {
    return nodes;
  }
}
