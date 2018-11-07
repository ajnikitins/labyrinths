package com.labyrinths.solvers;

import com.labyrinths.labyrinth.Labyrinth;
import com.labyrinths.labyrinth.Node;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public abstract class Solver {
  private boolean solved;
  List<Node> unvisitedNodes;
  private Stack<Node> path;

  public boolean getSolved() {
    return solved;
  }

  public List<Node> getUnvisitedNodes() {
    return unvisitedNodes;
  }

  public Stack<Node> getPath() {
    return path;
  }

  public abstract void solveLabyrinth(Labyrinth labyrinth);

  void doExit(Node u, Labyrinth labyrinth, Map<Node, Node> previousMap) {
    path = new Stack<>();
    if (previousMap.get(u) != null || u.equals(labyrinth.getEntrance())) {
      while (u != null) {
        path.push(u);
        u = previousMap.get(u);
      }
    }
    solved = true;
  }
}
