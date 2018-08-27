package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yanildamartinez
 */
public class Node {

    private String name;
    private final Set<Node> adjacentNodes;
    public boolean isVisited = false;

   public Node(String name) {
        this.name = name;
        this.adjacentNodes = new HashSet<>();

    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void addAdjacentNode(Node neighbor) {

        adjacentNodes.add(neighbor);
    }

    public void addAdjacentNodes(List<Node> adjacentNodes) {

        this.adjacentNodes.addAll(adjacentNodes);
    }

    public Set<Node> getAdjacentNodes() {

        return adjacentNodes;
    }

    public boolean hasAdjacentNode(Node node) {

      return   adjacentNodes.contains(node);

    }

}

