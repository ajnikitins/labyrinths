package com.labyrinths.solvers;

import com.labyrinths.labyrinth.Labyrinth;
import com.labyrinths.labyrinth.Node;
import java.util.List;
import java.util.Stack;

public abstract class Solver {
  private boolean solved;
  List<Node> unvisitedNodes;
  Stack<Node> path;

  public boolean getSolved() {
    return solved;
  }

  public List<Node> getUnvisitedNodes() {
    return unvisitedNodes;
  }

  public Stack<Node> getPath() {
    return path;
  }

  void setSolved(boolean solved) {
    this.solved = solved;
  }

  public abstract void solveLabyrinth(Labyrinth labyrinth);
}
