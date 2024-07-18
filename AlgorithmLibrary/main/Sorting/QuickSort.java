public class QuickSort {
    private int[] array;   

    public QuickSort(int[] array){
        this.array = array; 
    }

    public int partition(int[] array, int low, int high){   
        int middle = low + (high - low) / 2;

        // Find the values at the low, middle, and high indices
        int mid = array[middle];   
        int first = array[low];  
        int last = array[high];  

        // Correct median-of-three calculation
        int pivotValue = Math.max(Math.min(first, mid), Math.min(Math.max(first, mid), last));  // Change: Correct median calculation
        int pivotIndex; 

        if (pivotValue == mid) {
            pivotIndex = middle;
        } else if (pivotValue == last) {
            pivotIndex = high;
        } else {
            pivotIndex = low;
        }

        // Move the pivot to the end for partitioning
        int temp = array[pivotIndex]; 
        array[pivotIndex] = array[high]; 
        array[high] = temp;  

        int pivot = array[high];
        int i = low - 1; 

        // Partition the array around the pivot
        for (int j = low; j < high; j++){
            if (array[j] < pivot){
                i++; 
                // Correct swap logic
                int temp2 = array[i]; 
                array[i] = array[j]; 
                array[j] = temp2; 
            }
        }

        // Move pivot to its correct position
        i++; 
        int temp3 = array[i];  // Change: Correct swapping logic here
        array[i] = array[high];  // Change: Use correct index for swapping
        array[high] = temp3;  // Change: Use correct index for swapping

        return i; // Return the index of the pivot
    }

    public void quickSort(int[] array, int low, int high){
        if (low < high){ // Ensure there are at least two elements to sort
            int pivot = partition(array, low, high);  
            quickSort(array, low, pivot - 1); // Recursively sort elements less than the pivot 
            quickSort(array, pivot + 1, high); // Recursively sort elements greater than the pivot 
        }
    }

    public long sortTimer(){
        long startTime = System.nanoTime(); 
        quickSort(array, 0, array.length - 1); 
        long endTime = System.nanoTime(); 
        return endTime - startTime; 
    }

    public String complexity(){
        return "Run-time complexity: Best case O(n log n), Worst case O(n^2) (already sorted), Average case O(n log n) (random)"; 
    }

    public static void main(String[] args) {
        int[] array = {1002, 36, 30, 20, 19, 8, 22, 73, 3, 4}; 
        QuickSort quickSort = new QuickSort(array);  
        quickSort.sortTimer();   
        System.out.print("Sorted array: ");
        for (int i : array){
            System.out.print(i + " "); 
        } 
        System.out.println("\n" + quickSort.complexity());
    } 
} 
