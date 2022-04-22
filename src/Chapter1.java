public class Chapter1 {
    /** Метод binarySearch принимает отсортированный массив array и значение item, которое нужно найти.
     *  Берется центральное значение массива и проверяется, оно больше, меньше или равно искомого.
     *  Если больше, то нижняя граница low сдвигается. Если меньше, то сдвигается верхняя граница high.
     *  И так до тех пор, пока нижняя граница меньше или равна верхней.
     *  Если значение находится, то возвращается индекс элемента. Если нет, то -1.
     *  Сложность алгоритма - О (log n).
     */
    public static int binarySearch(int[] array, int item) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = array[mid];
            if (guess == item)
                return mid;
            else if (guess > item)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
