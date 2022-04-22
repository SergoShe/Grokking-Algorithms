public class Chapter2 {
    /** Метод selectionSort принимает массив array и отсортировывает его по возрастанию.
     *  В переменную smallestIndex записывается индекс минимального элемента, найденный с помощью метода findSmallest,
     *  куда передается массив и индекс нижней границы. Затем производится перестановка элементов по индексу
     *  нижней границы и индексу минимального значения. После каждой итерации, нижняя граница сдвигается на единицу.
     *  Сложность алгоритма - O(n^2)
     */
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int smallestIndex = findSmallest(array, i);
            int temp = array[i];
            array[i] = array[smallestIndex];
            array[smallestIndex] = temp;
        }
        return array;
    }

    private static int findSmallest(int[] array, int minIndex) {
        int smallest = array[minIndex];
        int smallestIndex = minIndex;
        for (int i = minIndex; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}
