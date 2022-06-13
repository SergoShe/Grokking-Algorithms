import org.junit.Before;
import org.junit.Test;

import java.sql.Array;
import java.util.*;

import static org.junit.Assert.*;

public class Chapter7Test {
    HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
    String startNode = "B";

    @Before
    public void SetUp() {
        HashMap<String, Double> nodeStart = new HashMap<>();
        nodeStart.put("A", 5.0);
        nodeStart.put("B", 2.0);
        graph.put("start", nodeStart);
        HashMap<String, Double> nodeA = new HashMap<>();
        nodeA.put("C", 4.0);
        nodeA.put("D", 2.0);
        graph.put("A", nodeA);
        HashMap<String, Double> nodeB = new HashMap<>();
        nodeB.put("A", 8.0);
        nodeB.put("D", 7.0);
        graph.put("B", nodeB);
        HashMap<String, Double> nodeC = new HashMap<>();
        nodeC.put("end", 3.0);
        nodeC.put("D", 6.0);
        graph.put("C", nodeC);
        HashMap<String, Double> nodeD = new HashMap<>();
        nodeD.put("end", 1.0);
        graph.put("D", nodeD);
        HashMap<String, Double> nodeEnd = new HashMap<>();
        graph.put("end", nodeEnd);
    }

    @Test
    public void testFindingTheShortestPath() {
        String endNode = "end";
        String extended = "The Shortest Path: B - D - end : 8.0";
        String actual = Chapter7.findingTheShortestPath(graph, startNode, endNode);
        assertEquals(extended, actual);
    }

    @Test
    public void testCreateParents() {
        HashMap<String, String> parents = new HashMap<>();
        parents.put("start", null);
        parents.put("A", "B");
        parents.put("B", null);
        parents.put("C", null);
        parents.put("D", "B");
        parents.put("end", null);
        Set<Map.Entry<String, String>> extended = parents.entrySet();
        Set<Map.Entry<String, String>> actual = Chapter7.createParents(graph, startNode).entrySet();
        assertEquals(actual, extended);

    }

    @Test
    public void testFindLowerCostNode_1() {
        Set<String> processedNodes = new HashSet<>();
        HashMap<String, Double> costs = new HashMap<>(graph.get(startNode));
        String extended = "D";
        String actual = Chapter7.findLowerCostNode(costs, processedNodes);
        assertEquals(extended, actual);
    }

    @Test
    public void testFindLowerCostNode_2() {
        Set<String> processedNodes = new HashSet<>();
        processedNodes.add("D");
        HashMap<String, Double> costs = new HashMap<>(graph.get(startNode));
        String extended = "A";
        String actual = Chapter7.findLowerCostNode(costs, processedNodes);
        assertEquals(extended, actual);
    }
}