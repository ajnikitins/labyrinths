package com.labyrinths.labyrinth;

import java.awt.Point;
import java.util.Objects;

public class Node {

  Node(int x, int y) {
    this.x = x;
    this.y = y;
  }

  private final int x;
  private final int y;
  private Node up;
  private Node right;
  private Node down;
  private Node left;

  public Point getPoint() {
    return new Point(x, y);
  }

  public Node getUp() {
    return up;
  }

  void setUp(Node up) {
    this.up = up;
    up.down = this;
  }

  void setRight(Node right) {
    this.right = right;
    right.left = this;
  }

  void setDown(Node down) {
    this.down = down;
    down.up = this;
  }

  public Node getLeft() {
    return left;
  }

  void setLeft(Node left) {
    this.left = left;
    left.right = this;
  }

  public Node[] getNeighbors() {
    return new Node[] { up, right, down, left };
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node node = (Node) o;
    return x == node.x &&
        y == node.y &&
        Objects.equals(up != null, node.up != null) &&
        Objects.equals(right != null, node.right != null) &&
        Objects.equals(down != null, node.down != null) &&
        Objects.equals(left != null, node.left != null);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y, up != null, right != null, down != null, left != null);
  }

  @Override
  public String toString() {
    return "Node{" +
        "x=" + x +
        ", y=" + y +
        ", up=" + (up != null) +
        ", right=" + (right != null) +
        ", down=" + (down != null) +
        ", left=" + (left != null) +
        '}';
  }
}
