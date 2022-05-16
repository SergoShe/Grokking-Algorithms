public class Chapter4 {

    public static int sum(int[] array) {
        return sum(array, 0, array.length - 1);
    }

    public static int sum(int[] array, int from, int to) {
        if (from == to)
            return array[from];
        else
            return array[from] + sum(array, from + 1, to);
    }

    public static int count(int[] array) {
        return count(array, 0, array.length);
    }

    public static int count(int[] array, int from, int to) {
        if (from == to)
            return 0;
        return 1 + count(array, from + 1, to);
    }

    public static int max(int[] array) {
        return max(array, 0, array.length - 1);
    }

    public static int max(int[] array, int from, int to) {
        if (to - from == 1)
            return (array[from] > array[to]) ? array[from] : array[to];
        int subMax = max(array, from + 1, to);
        return (array[from] > subMax) ? array[from] : subMax;
    }

    /**
     * Метод quickSort принимает массив array, и два индекса startIndex и endIndex, что позволяет
     * отсортировать массив на конкретном участке.
     * Вначале идет проверка индексов - это базовый случай. Если startIndex больше или равен endIndex -
     * - происходит возврат из метода.
     * В указатели lowPos и highPos записываются индексы начала и конца сортировки.
     * В pivot записывается значение опорного элемента, относительно которого происходит сортировка.
     * Далее пока значение lowPos меньше или равно highPos внутри цикла происходит сортировка значений относительно
     * опорного элемента pivot:
     * - Пока значение элемента array[lowPos] меньше опорного pivot, происходит увеличение указателя lowPos
     * - Затем пока значение элемента array[highPos] больше опорного pivot, происходит уменьшение указателя highPos
     * - После идет проверка - если указатель lowPos меньше или равен highPos, то при условии, что lowPos < highPos,
     * происходит обмен элементов массива по этим указателям, а затем lowPos увеличивается, а highPos уменьшается
     * на единицу.
     * По завершению цикла происходит рекурсивный случай, где в метод quickSort вначале передаются переменные
     * startIndex и highPos - это отрезок массива, расположенный слева от опорного элемента. И затем в метод передаются
     * переменные lowPos и endIndex - это отрезок массива, расположенный справа от опорного элемента.
     * Так происходит до тех пор, пока внутри рекурсивных методов переменные startIndex и highPos, а также
     * lowPos и endIndex не будут равны.
     */
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return;

        int lowPos = startIndex;
        int highPos = endIndex;
        int pivot = array[(endIndex + startIndex) / 2];
        do {
            while (array[lowPos] < pivot)
                lowPos++;
            while (array[highPos] > pivot)
                highPos--;
            if (lowPos <= highPos) {
                if (lowPos < highPos)
                    swap(array, lowPos, highPos);
                lowPos++;
                highPos--;
            }


        } while (lowPos <= highPos);
        quickSort(array, startIndex, highPos);
        quickSort(array, lowPos, endIndex);
    }

    private static void swap(int[] array, int startIndex, int endIndex) {
        int temp = array[startIndex];
        array[startIndex] = array[endIndex];
        array[endIndex] = temp;
    }

}
