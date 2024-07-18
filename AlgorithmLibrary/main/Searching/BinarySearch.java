public class BinarySearch {

    // Method to perform binary search
    public int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            // Check if the target is present at middle
            if (array[middle] == target) {
                return middle;
            }

            // If target is greater, ignore the left half
            if (array[middle] < target) {
                left = middle + 1;
            }
            // If target is smaller, ignore the right half
            else {
                right = middle - 1;
            }
        }

        // Target is not present in the array
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] array = {2, 3, 4, 10, 40};
        int target = 10;

        int result = bs.binarySearch(array, target);

        if (result == -1) {
            System.out.println("Element not present in array");
        } else {
            System.out.println("Element found at index: " + result);
        }

        // Additional tests
        target = 3;
        result = bs.binarySearch(array, target);
        System.out.println("Searching for 3, found at index: " + result);

        target = 5;
        result = bs.binarySearch(array, target);
        System.out.println("Searching for 5, found at index: " + result);
    }
}
