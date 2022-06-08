import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Chapter7 {
    /**
     * Здесь будет описание :)
     * @param graph
     * @param startNode
     * @param endNode
     */
    public static void findingTheShortestPath(HashMap<String, HashMap<String, Double>> graph, String startNode, String endNode) {
        Set<String> processedNodes = new HashSet<>();
        HashMap<String, Double> costs = createCosts(graph, startNode);
        HashMap<String, String> parents = createParents(graph, startNode);
        String node = findLowerCostNode(costs, processedNodes);
        while (node != null) {
            double cost = costs.get(node);
            HashMap<String, Double> neighbors = graph.get(node);
            for (String neighbor : neighbors.keySet()) {
                double newCost = cost + neighbors.get(neighbor);
                if (costs.get(neighbor) > newCost) {
                    costs.put(neighbor, newCost);
                    parents.put(neighbor, node);
                }
            }
            processedNodes.add(node);
            node = findLowerCostNode(costs, processedNodes);
        }
        System.out.println("Costs: " + costs);
        System.out.println("Parents: " + parents);
        System.out.println(costs.get(endNode));
    }

    private static HashMap<String, Double> createCosts(HashMap<String, HashMap<String, Double>> graph, String startNode) {
        HashMap<String, Double> newCosts = new HashMap<>();
        double inf = Double.POSITIVE_INFINITY;
        Set<String> keys = graph.keySet();
        Set<String> startNodeKeys = graph.get(startNode).keySet();

        for (String key : keys) {
            if (startNodeKeys.contains(key)) {
                Double weight = graph.get(startNode).get(key);
                newCosts.put(key, weight);
            } else {
                newCosts.put(key, inf);
            }
        }
        newCosts.remove(startNode);
        return newCosts;
    }

    private static HashMap<String, String> createParents(HashMap<String, HashMap<String, Double>> graph, String startNode) {
        HashMap<String, String> newParents = new HashMap<>();
        for (String parent : graph.keySet()) {
            if (graph.get(startNode).containsKey(parent)) {
                newParents.put(parent, startNode);
            } else {
                newParents.put(parent, null);
            }
        }
        newParents.remove(startNode);
        return newParents;
    }

    private static String findLowerCostNode(HashMap<String, Double> costs, Set<String> processedNodes) {
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
