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

      ArrayList<Point> visitedNeighbors = new ArrayList<>(4);
      if (y > 0) {
        Point point = new Point(x, y -1);
        if (nodes[y - 1][x] == null) {
          if (!cells.contains(point)) {
            cells.add(point);
          }
        } else {
          visitedNeighbors.add(point);
        }
      }

      if (x > 0) {
        Point point = new Point(x - 1, y);
        if (nodes[y][x - 1] == null) {
          if (!cells.contains(point)) {
            cells.add(point);
          }
        } else {
          visitedNeighbors.add(point);
        }
      }

      if (y < height - 1) {
        Point point = new Point(x, y + 1);
        if (nodes[y + 1][x] == null) {
          if (!cells.contains(point)) {
            cells.add(point);
          }
        } else {
          visitedNeighbors.add(point);
        }
      }

      if (x < width - 1) {
        Point point = new Point(x + 1, y);
        if (nodes[y][x + 1] == null) {
          if (!cells.contains(point)) {
            cells.add(point);
          }
        } else {
          visitedNeighbors.add(point);
        }
      }

      if (!visitedNeighbors.isEmpty()) {
        Point neighborLocation = visitedNeighbors.remove(random.nextInt(visitedNeighbors.size()));
        int neighborY = neighborLocation.y;
        int neighborX = neighborLocation.x;
        Node neighbor = nodes[neighborY][neighborX];

        if (y > neighborY) {
          node.setUp(neighbor);
        } else if (y < neighborY) {
          node.setDown(neighbor);
        } else if (x < neighborX) {
          node.setRight(neighbor);
        } else if (x > neighborX) {
          node.setLeft(neighbor);
        }
      }
    }

    this.entrance = nodes[0][random.nextInt(width)];
    this.exit = nodes[height - 1][random.nextInt(width)];
  }

  private final int width;
  private final int height;
  private final Node entrance;
  private final Node exit;
  private final Node[][] nodes;

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public Node getEntrance() {
    return entrance;
  }

  public Node getExit() {
    return exit;
  }

  public Node[][] getNodes() {
    return nodes;
  }
}
