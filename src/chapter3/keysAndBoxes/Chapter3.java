package chapter3.keysAndBoxes;

import java.util.LinkedList;
import java.util.Queue;

public class Chapter3 {

    /**
     * Метод lookForItem_1 принимает объект класса Box, с которого начинается поиск предмета и строку itemName -
     * предмет, который нужно найти.
     * В методе создается очередь pile, куда будут добавляться объекты для поиска предмета.
     * Внутри цикла while происходит просмотр каждого предмета, пока очередь не будет пустой. Из очереди берется предмет
     * и происходит проверка. Если предмет оказался объектом класса Box, то его содержимое добавляется в очередь.
     * Иначе, если предмет оказался искомым предметом itemName, то выводится соответствующее сообщение и возврат предмета.
     * Если же после просмотра всей очереди, предмет не нашелся, то цикл завершается, т.к. очередь пуста, происходит
     * вывод сообщения, что предмет не найден и возврат null.
     */

    public static Material lookForItem_1(Box box, String itemName) {
        Queue<Material> pile = new LinkedList<>(box.getItems());
        while (!pile.isEmpty()) {
            Material item = pile.poll();
            if (item.getClass() == Box.class) {
                pile.addAll(((Box) item).getItems());
            } else if (item.getName().equals(itemName)) {
                System.out.println("found the " + itemName + "!");
                return item;
            }
        }
        System.out.println(itemName + " is not found");
        return null;
    }

    /**
     * Метод lookForItem_2 принимает объект класса Box box, с которого начинается поиск предмета и строку itemName -
     * предмет, который нужно найти.
     * В самом методе происходит перебор содержимого box. Если предмет является объектом класса Box, то вызывается
     * метод lookForItem_2, куда передается сам объект и искомый предмет itemName. Результат метода записывается в
     * переменную itemFound. Если itemFound не null, то основной метод возвращает найденный элемент itemFound и завершает поиск.
     * Иначе, если предмет оказался искомым предметом itemName, то выводится соответствующее сообщение и возвращается
     * предмет.
     * Если после перебора всех элементов предмет не был найден, то метод возвращает null и означает, что
     * itemName не был найден.
     */

    public static Material lookForItem_2(Box box, String itemName) {
        for (Material item : box.getItems()) {
            if (item.getClass() == Box.class) {
                Material itemFound = lookForItem_2((Box) item, itemName);
                if (itemFound!=null) {
                    return itemFound;
                }
            } else if (item.getName().equals(itemName)) {
                System.out.println("found the " + itemName + "!");
                return item;
            }
        }
        return null;
    }
}