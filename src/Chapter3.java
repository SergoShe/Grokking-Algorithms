public class Chapter3 {

    /*
    Место под реализацию задачи поиска ключа в коробке двумя методами - через while и рекурсию
     */

    /** Метод countdown принимает число, с которого будет идти отсчет.
     * Вначале идет печать текущего значения, а затем проверка, число больше нуля или нет.
     * Если условие выполняется, то вызывается метод countdown со значением меньше текущего на
     * единицу (рекурсивный случай).
     * Если нет, то ничего не просиходит и метод завершает работу (базовый случай).
     */
    public static void countdown(int i) {
        System.out.println(i);
        if (i > 0) countdown(i - 1);
    }

    public static void greet(String name) {
        System.out.println("hello, " + name + "!");
        greet2(name);
        System.out.println("getting ready to say bye...");
        bye();
    }

    public static void greet2(String name) {
        System.out.println("how are you, " + name + "?");
    }

    public static void bye() {
        System.out.println("ok bye!");
    }

    /**
     * Метод fact принимает число x и высчитывает факториал этого числа.
     * Если число равно 1, то метод возвращает значение 1 (базовый случай).
     * Иначе метод возвращает произведение текущего числа x и метода fact со значением меньше текущего на
     * единицу, т.е. x-1 (рекурсивный метод). Прежде чем вернуть это произведение, происходит вызов метода fact(x-1).
     */
    public static int fact(int x) {
        if (x == 1)
            return 1;
        else
            return x * fact(x - 1);
    }
}
