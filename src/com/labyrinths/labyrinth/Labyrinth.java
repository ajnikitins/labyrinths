package com.labyrinths.labyrinth;

import java.awt.Dimension;

public class Labyrinth {

  Labyrinth(Dimension size) {
    this(size.width, size.height);
  }

  Labyrinth(int width, int height) {
    this.width = width;
    this.height = height;

    this.nodes = new Node[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        nodes[y][x] = new Node(x, y);

        if (x != 0) {
          nodes[y][x].setLeft(nodes[y][x-1]);
        }

        if (y != 0) {
          nodes[y][x].setUp(nodes[y-1][x]);
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

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public Dimension getSize() {
    return new Dimension(width, height);
  }

  public void setSize(Dimension d) {
    setSize(d.width, d.height);
  }

  public void setSize(int width, int height) {
    this.width = width;
    this.height = height;
  }
}
