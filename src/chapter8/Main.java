package chapter8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //Chapter8
        Set<String> statesNeeded = new HashSet<>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        HashMap<String, Set<String>> stations = new HashMap<>();
        stations.put("kone",new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("ktwo",new HashSet<>(Arrays.asList("wa","id","mt")));
        stations.put("kthree",new HashSet<>(Arrays.asList("or","nv","ca")));
        stations.put("kfour",new HashSet<>(Arrays.asList("nv","ut")));
        stations.put("kfive",new HashSet<>(Arrays.asList("ca","az")));
        System.out.println(Chapter8.findStations(statesNeeded,stations));
    }
}