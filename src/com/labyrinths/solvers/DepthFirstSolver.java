package com.labyrinths.solvers;

import com.labyrinths.labyrinth.Labyrinth;
import com.labyrinths.labyrinth.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DepthFirstSolver extends Solver {

  @Override
  public void solveLabyrinth(Labyrinth labyrinth) {
    unvisitedNodes = new ArrayList<>(labyrinth.getWidth() * labyrinth.getHeight());
    Map<Node, Node> previousMap = new HashMap<>(labyrinth.getWidth() * labyrinth.getHeight());
    Stack<Node> stack = new Stack<>();

    for (Node[] row : labyrinth.getNodes()) {
      for (Node node : row) {
        previousMap.put(node, null);
        unvisitedNodes.add(node);
      }
    }

    stack.push(labyrinth.getEntrance());

    while (!stack.isEmpty()) {
      Node u = stack.pop();

      if (u.equals(labyrinth.getExit())) {
        doExit(u, labyrinth, previousMap);
        return;
      }

      if (unvisitedNodes.contains(u)) {
        unvisitedNodes.remove(u);
        for (Node v : u.getNeighbors()) {
          if (unvisitedNodes.contains(v)) {
            stack.push(v);
            previousMap.put(v, u);
          }
        }
      }
    }
  }
}
