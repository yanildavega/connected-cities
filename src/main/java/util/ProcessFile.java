package util;


import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import domain.Graph;
import domain.Node;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by yanildamartinez
 */
@Component
public class ProcessFile {

    static Graph graph = new Graph();


    @Value("${city.mapping.file}")
    private static String file= "city-dev.txt";

    public static ArrayList<String> readFile() {

        ArrayList<String> listCities = new ArrayList<>();
        try {
            Path path = Paths.get(ClassLoader.getSystemResource("city-dev.txt").toURI());

            StringBuilder data = new StringBuilder();
            Stream<String> lines = Files.lines(path);
            lines.forEach(line -> {
                //   System.out.println(line);
                data.append(line);
                listCities.add(line.toString());
            });
            lines.close();

            return listCities; //data.toString();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Graph populateGraph() {

        ArrayList<String> file = readFile();


        file.stream()
                .flatMap(x -> Arrays.stream(x.split(", ")))
                .forEach(s -> {

                    Node node = new Node(s);
                    graph.addNode(node);
                });

        file.stream().close();
        addEdges(file);

        return graph;
    }


    private static Graph addEdges(ArrayList<String> file) {

        file.stream()
                .flatMap(x -> Arrays.stream(x.split("\n")))
                .forEach(s -> {

                    String[] listStr = s.split(",");
                    String from = listStr[0].trim();
                    String to = listStr[1].trim();
                    graph.addEdge(from, to);
                });
        file.stream().close();

        return graph;

    }


    @PostConstruct
    public void init() {


        populateGraph();


    }

    public static Graph getGraph() {
        return graph;

    }

}





