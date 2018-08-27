package app;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by yanildamartinez on 8/26/18.
 */
@RunWith(SpringRunner.class)
public class ConnectedComponentTest {

/*

    @Test
    public void findConnectedComponentsTest() {

        Map<String, Integer> map = ConnectedComponent.findConnectedComponents(ProcessFile.populateGraph());
        assert (map.containsKey("Boston"));
        assert (map.get("Boston") == map.get("Newark"));

    }

    @Test
    public void populateGraphTest() {

        Graph graph = ProcessFile.populateGraph();

        assert (graph.hasNode("Boston"));
        assert (graph.adj.containsKey("Newark"));

    }


    @Test
    public void isConnectedTest() {

      Map<String, Integer> components = new HashMap<String, Integer>();
        components.put("Boston",1);
        components.put("Newark",2);
        components.put("New York",1);

        assert(components.get("Boston")==components.get("New York"));


    }
*/
}
