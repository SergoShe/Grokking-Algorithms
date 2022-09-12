import java.util.*;

public class Chapter6 {
    /**
     * Метод searchSeller принимает хэш-таблицу graph, в которой прописаны персоны и их друзья в массиве, и имя name -
     * имя, с кого начать поиск.
     * Внутри метода создается множество listOfSearched, куда будут занесены проверенные имена.
     * Также создается очередь searchQueue, куда будут заносится имена друзей персоны, если сама персона не окажется
     * искомым объектом.
     * Далее, пока очередь не будет пустой, внутри цикла while происходит перебор имен очереди searchedQueue.
     * В переменную person забираем первое из очереди имя. Если person не содержится в listOfSearched, то проверяется,
     * является ли person искомым с помощью метода personIsSeller:
     * - Если метод personIsSeller истинно, то вывод сообщения, что персона найдена и возврат из метода.
     * - Иначе добавляем в очередь список друзей персоны, если данная персона есть в graph, а также добавляем имя
     *   персоны в listOfSearched.
     * Если после проверки очереди искомый объект не найден, то выводится соответствующее сообщение.
     */
    public static void searchSeller(HashMap<String,String[]> graph, String name){
        HashSet<String> listOfSearched = new HashSet<>();
        listOfSearched.add(name);
        Queue<String> searchQueue = new LinkedList<>(Arrays.asList(graph.get(name)));
        while (!searchQueue.isEmpty()){
            String person = searchQueue.poll();
            if (!listOfSearched.contains(person)){
                if (personIsSeller(person)) {
                    System.out.println(person + " is mango seller!");
                    return;
                } else {
                    if (graph.containsKey(person)) {
                        searchQueue.addAll(Arrays.asList(graph.get(person)));
                    } else {
                        System.out.println(person + " not found");
                    }
                    listOfSearched.add(person);
                }
            }
        }
        System.out.println("Mango seller not found");
    }

    public static boolean personIsSeller(String person){
        if (person==null)
            return false;
        char lastLetterName = person.charAt(person.length()-1);
        return ('m'==lastLetterName);
    }
}
