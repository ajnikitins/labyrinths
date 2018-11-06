package com.labyrinths.solvers;

import com.labyrinths.labyrinth.Labyrinth;
import com.labyrinths.labyrinth.Node;
import com.labyrinths.utilities.LabyrinthUtility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DijkstraSolver extends Solver {

  @Override
  public void solveLabyrinth(Labyrinth labyrinth) {
    unvisitedNodes = new ArrayList<>(labyrinth.getWidth() * labyrinth.getHeight());
    Map<Node, Integer> distanceMap = new HashMap<>(labyrinth.getWidth() * labyrinth.getHeight());
    Map<Node, Node> previousMap = new HashMap<>(labyrinth.getWidth() * labyrinth.getHeight());

    for (Node[] row : labyrinth.getNodes()) {
      for (Node node : row) {
        distanceMap.put(node, Integer.MAX_VALUE);
        previousMap.put(node, null);
        unvisitedNodes.add(node);
      }
    }
    distanceMap.put(labyrinth.getEntrance(), 0);
    path = new Stack<>();

    while (!unvisitedNodes.isEmpty()) {
      Node u = LabyrinthUtility.findSmallestKey(distanceMap, unvisitedNodes);

      unvisitedNodes.remove(u);
      if (u.equals(labyrinth.getExit())) {
        if (previousMap.get(u) != null || u.equals(labyrinth.getEntrance())) {
          while (u != null) {
            path.push(u);
            u = previousMap.get(u);
          }
        }
        setSolved(true);
        return;
      }

      for (Node v : u.getNeighbors()) {
        if (unvisitedNodes.contains(v)) {
          int alt = distanceMap.get(u) + 1;
          if (alt < distanceMap.get(v)) {
            distanceMap.put(v, alt);
            previousMap.put(v, u);
          }
        }
      }
    }
  }
}
