package service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import domain.Graph;
import domain.Node;
import org.springframework.stereotype.Service;
import util.ProcessFile;

/**
 * Created by yanildamartinez
 */
@Service
public class ConnectedComponent {


    private static Map<String, Integer> components = new HashMap<String, Integer>();
    private static int count = 0;

    public static void loadGraph() {

        Graph graph = ProcessFile.getGraph();

        findConnectedComponents(graph);

    }

    public static Map<String, Integer> findConnectedComponents(Graph graph) {

        for (Node key : graph.adj.values())

            if (!key.isVisited) {
                count++;
                dfs(key);
            }

        return components;

    }


    public boolean isConnected(String item1, String item2) {

        if(!components.containsKey(item1) || !components.containsKey(item2))
            return false;

        return components.get(item1) == components.get(item2);

    }


    private static void dfs(Node current) {
        current.isVisited = true;
        components.put(current.getName(), count);

        for (Node to : current.getAdjacentNodes()) {
            if (!to.isVisited)
                dfs(to);
        }
    }


    @PostConstruct
    public void init() {

        loadGraph();

    }
}
