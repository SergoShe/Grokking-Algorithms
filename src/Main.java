import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        /*
        //Chapter1
        int[] myList1 = {1, 3, 5, 7, 9};
        System.out.println(Chapter1.binarySearch(myList1, 3));
        System.out.println(Chapter1.binarySearch(myList1, -1));
        Chapter2
        //int[] myList2 = {0, 1, 0, -1, 6, -48, 34, 1};
        //int[] myList2 = {-1, 0,1, -1, 0, -1, 0, 1};
        //System.out.println(Arrays.toString(Chapter2.selectionSort(myList2)));

        //Chapter4

        int[] myList4 = new int[1000];
        Random rand = new Random();
        for (int i = 0; i < myList4.length; i++) {
            myList4[i] = rand.nextInt(10000);
        }

        System.out.println(Chapter4.sum(myList4));
        System.out.println(Chapter4.count(myList4));
        System.out.println(Chapter4.max(myList4));

        Chapter4.quickSort(myList4);
        */
        //Chapter6
        HashMap<String,String[]> graph = new HashMap<>();
        graph.put("you",new String[] {"alice","bob","claire"});
        graph.put("bob",new String[] {"anuj","peggi"});
        graph.put("alice",new String[] {"peggy"});
        graph.put("claire",new String[] {"thom","jonny"});
        graph.put("anuj",new String[] {});
        graph.put("peggy",new String[] {});
        graph.put("thom",new String[] {});
        graph.put("jonny",new String[] {});
        Chapter6.searchSeller(graph, "you");


    }
}
