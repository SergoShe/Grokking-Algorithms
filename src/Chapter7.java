import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Chapter7 {
    /**
     * Здесь будет описание :)
     */
    public static String findingTheShortestPath(HashMap<String, HashMap<String, Double>> graph, String startNode, String endNode) {
        Set<String> processedNodes = new HashSet<>();
        double inf = Double.POSITIVE_INFINITY;
        HashMap<String, Double> costs = new HashMap<>(graph.get(startNode));
        HashMap<String, String> parents = createParents(graph, startNode);
        String node = findLowerCostNode(costs, processedNodes);
        while (node != null) {
            double cost = costs.get(node);
            HashMap<String, Double> neighbors = graph.get(node);
            for (String neighbor : neighbors.keySet()) {
                double newCost = cost + neighbors.get(neighbor);
                costs.putIfAbsent(neighbor, inf);
                if (costs.get(neighbor) > newCost) {
                    costs.put(neighbor, newCost);
                    parents.put(neighbor, node);
                }
            }
            processedNodes.add(node);
            node = findLowerCostNode(costs, processedNodes);
        }
        String theShortestPath = "";
        String parent = parents.get(endNode);
        while (parent != null) {
            theShortestPath = parent + " - " + theShortestPath;
            parent = parents.get(parent);
        }
        theShortestPath = "The Shortest Path: " + theShortestPath + endNode + " : " + costs.get(endNode);
        return theShortestPath;
    }

    public static HashMap<String, String> createParents(HashMap<String, HashMap<String, Double>> graph, String startNode) {
        HashMap<String, String> newParents = new HashMap<>();
        for (String parent : graph.keySet()) {
            if (graph.get(startNode).containsKey(parent)) {
                newParents.put(parent, startNode);
            } else {
                newParents.put(parent, null);
            }
        }
        return newParents;
    }

    public static String findLowerCostNode(HashMap<String, Double> costs, Set<String> processedNodes) {
        double lowestCost = Double.POSITIVE_INFINITY;
        String lowestCostNode = null;
        for (String node : costs.keySet()) {
            double cost = costs.get(node);
            if (cost < lowestCost && !processedNodes.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }

}
