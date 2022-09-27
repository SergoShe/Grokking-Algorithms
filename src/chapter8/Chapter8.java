package chapter8;

import java.util.*;

public class Chapter8 {

    public static Set<String> findStations(Set<String> statesNeeded, HashMap<String, Set<String>> stations) {
        Set<String> finalStations = new HashSet<>();
        while (!statesNeeded.isEmpty()) {
            String bestStation = null;
            Set<String> statesCovered = new HashSet<>();
            for (Map.Entry<String, Set<String>> pair : stations.entrySet()) {
                Set<String> covered = new HashSet<>(pair.getValue());
                covered.retainAll(statesNeeded);
                if (covered.size() > statesCovered.size()) {
                    bestStation = pair.getKey();
                    statesCovered = covered;
                }
            }
            statesNeeded.removeAll(statesCovered);
            if (bestStation != null){
                finalStations.add(bestStation);
            }
        }
        return finalStations;
    }
}