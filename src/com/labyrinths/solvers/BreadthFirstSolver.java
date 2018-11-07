package com.labyrinths.solvers;

import com.labyrinths.labyrinth.Labyrinth;
import com.labyrinths.labyrinth.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSolver extends Solver {
  @Override
  public void solveLabyrinth(Labyrinth labyrinth) {
    unvisitedNodes = new ArrayList<>(labyrinth.getWidth() * labyrinth.getHeight());
    Map<Node, Node> previousMap = new HashMap<>(labyrinth.getWidth() * labyrinth.getHeight());
    Queue<Node> queue = new LinkedList<>();

    for (Node[] row : labyrinth.getNodes()) {
      for (Node node : row) {
        previousMap.put(node, null);
        unvisitedNodes.add(node);
      }
    }

    queue.offer(labyrinth.getEntrance());
    unvisitedNodes.remove(labyrinth.getEntrance());

    while (!queue.isEmpty()) {
      Node u = queue.poll();

      if (u.equals(labyrinth.getExit())) {
        doExit(u, labyrinth, previousMap);
        return;
      }

      for (Node v : u.getNeighbors()) {
        if (unvisitedNodes.contains(v)) {
          queue.offer(v);
          unvisitedNodes.remove(v);
          previousMap.put(v, u);
        }
      }
    }
  }
}
