package domain;

/**
 * Created by yanildamartinez on 8/23/18.
 */

import java.util.HashMap;


public class Graph {

    public HashMap<String, Node> adj;


    public Graph() {

        adj = new HashMap<String, Node>();

    }

    /*
    Add Node
     */
    public Node addNode(Node node) {

        adj.put(node.getName(), node);
        return node;

    }

    public Node addNode(String name) {

        Node node = new Node(name);
        adj.put(name, node);

        return node;


    }

    public void addEdge(Node v, Node w) {


        if (hasEdge(v, w))
            return;

        if ((v = getNode(v.getName())) == null)
            v = addNode(w);
        if ((w = getNode(w.getName())) == null)
            w = addNode(w);


        adj.get(v.getName()).addAdjacentNode(w);
        adj.get(w.getName()).addAdjacentNode(v);


    }

    public void addEdge(String v, String w) {

        if (hasEdge(getNode(v), getNode(w)))
            return;

        if ((v = getNode(v).getName()) == null)
            addNode(v);
        if ((w = getNode(w).getName()) == null)
            addNode(w);
        adj.get(v).addAdjacentNode(adj.get(w));
        adj.get(w).addAdjacentNode(adj.get(v));


    }

    public Node getNode(String name) {

        return adj.get(name);
    }


    public boolean hasEdge(Node from, Node to) {

        if (!hasNode(from.getName()) || !hasNode(to.getName()))
            return false;

        if (!getNode(from.getName()).hasAdjacentNode(to) || !getNode(to.getName()).hasAdjacentNode(from))
            return false;

        return false;
    }


    public boolean hasNode(String name) {

        return adj.containsKey(name);
    }



}
