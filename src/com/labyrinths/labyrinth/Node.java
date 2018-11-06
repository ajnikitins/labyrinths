package com.labyrinths.labyrinth;

import java.awt.Point;

public class Node {

  public Node(int x, int y) {
    this.x = x;
    this.y = y;
    this.id = 10*y + x;
  }

  public Node(Point location) {
    this(location.x, location.y);
  }

  private int id;
  private int x;
  private int y;
  private Node up;
  private Node right;
  private Node down;
  private Node left;

  public int getId() {
    return id;
  }

  public Point getPoint() {
    return new Point(x, y);
  }

  public Node getUp() {
    return up;
  }

  public void setUp(Node up) {
    this.up = up;
    up.down = this;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
    right.left = this;
  }

  public Node getDown() {
    return down;
  }

  public void setDown(Node down) {
    this.down = down;
    down.up = this;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
    left.right = this;
  }

  public Node[] getNeighborArray() {
    return new Node[] { up, right, down, left};
  }
}
