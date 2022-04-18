public class Chapter1 {
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
