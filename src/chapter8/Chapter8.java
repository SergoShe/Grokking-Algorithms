package chapter8;

import java.util.*;

public class Chapter8 {

    /**
     * Метод findStations принимает множество statesNeeded, в котором указаны требуемые штаты для покрытия, и
     * хеш-таблицу stations, в котором указаны станции и те штаты, которые они покрывают.
     * В самом методе инициализируется множество finalStation - итоговый набор станций,
     * которые будут выбраны из stations.
     * Пока statesNeeded не будет пустой, внутри цикла while происходит перебор станций для поиска лучших станций.
     * Для начала создаются переменные bestStation, куда будет записываться лучшая станция при переборе станций, а также
     * statesCovered - множество штатов, которые входят в текущую станцию и не входящих в текущее покрытие.
     * Внутри цикла for создается множество covered, куда по очереди будут записываться значения station. Далее
     * путем пересечения множеств в covered остаются штаты, которые входят в покрытие текущей станцией.
     * Если размер множества covered больше, чем statesCovered, то в bestStation записывается текущий ключ station, а в
     * statesCovered - значение covered.
     * После перебора станций, текущая лучшая станция добавляется в finalStations, а из statesNeeded удаляются элементы,
     * которые остались в statesCovered.
     * Метод возвращает множество finalStations.
     */

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