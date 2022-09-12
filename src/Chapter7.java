import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Chapter7 {
    /**
     * Метод findingTheShortestPath принимает хэш-таблицу graph, которая содержит в себе информацию об узлах графа,
     * startNode - узел, с которого нужно начать поиск, endNode - узел, до которого ищем путь и кратчайшую стоимость.
     * Внутри метода создаются дополнительные таблицы costs, в котором хранятся стоимости до узлов, куда изначально
     * заносятся стоимости соседей startNode, и parents, где хранится информация о родителе узла.
     * Также создается множество processedNodes, куда будут записыватся узлы, которые были просмотрены, чтобы не
     * допустить повторного просмотра.
     * Далее происходит перебор узлов. В переменную node записывается узел с наименьшей стоимостью,
     * который определяется через метод findLowerCostNode. В переменную cost записывается стоимость узла node.
     * Затем в отдельную хэш-таблицу neighbors записываем соседей node с их стоимостями и перебираем соседей neighbor:
     * - В переменную newCost записываем сумму стоимости узла cost и стоимость узла соседа.
     * - Происходит создание записи о стоимости узла соседа с бесконечным значением, если ее нет в costs.
     * - Затем происходит проверка - если newCost меньше чем ранее записанная стоимость узла neighbor,
     *   то происходит запись/перезапись стоимости узла neighbor в costs и запись/перезапись родителя узла neighbor в
     *   parents.
     * После узел node заносится в множество processedNodes и определяется новый узел с меньшей стоимостью.
     * В конце формируется сообщение о кратчайшем пути, стоимости этого пути и возврат этого сообщения из самого метода.
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
        return createMessageTheShortestPath(parents,endNode,costs.get(endNode));
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

    public static String createMessageTheShortestPath(HashMap<String, String> parents, String endNode, double endCost){
        String theShortestPath = "";
        String parent = parents.get(endNode);
        while (parent != null) {
            theShortestPath = parent + " - " + theShortestPath;
            parent = parents.get(parent);
        }
        theShortestPath = "The Shortest Path: " + theShortestPath + endNode + " : " + endCost;
        return theShortestPath;

    }

}
