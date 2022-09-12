import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        /*
        //Chapter1
        int[] myList1 = {1, 3, 5, 7, 9};
        System.out.println(Chapter1.binarySearch(myList1, 3));
        System.out.println(Chapter1.binarySearch(myList1, -1));

        //Chapter2
        int[] myList2 = {0, 1, 0, -1, 6, -48, 34, 1};
        //int[] myList2 = {-1, 0,1, -1, 0, -1, 0, 1};
        System.out.println(Arrays.toString(Chapter2.selectionSort(myList2)));
        */
        //Chapter3
        Item photo = new Item("photo");
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        Item item4 = new Item("item4");
        Box box3 = new Box("box3");
        Item doll = new Item("doll");
        Item notebook = new Item("notebook");
        Item key = new Item("key");
        Box box4 = new Box("box4", new HashSet<>(Arrays.asList(doll, notebook, key))); //key is here
        Item pen = new Item("pen");
        Item book = new Item("book");
        Item star = new Item("star");
        Item ball = new Item("ball");
        Box box5 = new Box("box5", new HashSet<>(Arrays.asList(pen, book, star, ball)));
        Box box2 = new Box("box2", new HashSet<>(Arrays.asList(box3, box4, item4, box5)));
        Box box1 = new Box("box1", new HashSet<>(Arrays.asList(item1, item2, box2, item3)));
        Box mainBox = new Box("mainBox", new HashSet<>(Arrays.asList(photo, box1)));
        String itemName = "key";

        long start = System.nanoTime();
        Material item_1 = Chapter3.lookForItem_1(mainBox, itemName);
        long finish = System.nanoTime();
        if (item_1!=null) {
            System.out.println(item_1.getName());
        }
        System.out.println(finish - start);

        start = System.nanoTime();
        Material item_2 = Chapter3.lookForItem_2(mainBox, itemName);
        if (item_2!=null) {
            System.out.println(item_2.getName());
        }
        finish = System.nanoTime();
        System.out.println(finish - start);
        /*
        Chapter3.countdown(5);
        Chapter3.greet("Maggie");
        System.out.println(Chapter3.fact(5));

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
    }
}
