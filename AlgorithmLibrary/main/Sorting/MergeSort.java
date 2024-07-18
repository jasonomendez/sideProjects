public class MergeSort { 

    private int[] array;

    public MergeSort(int[] array) {  
        this.array = array;
    }  

    public void merge(int[] array, int l, int m, int r) {
        int n1 = m - l + 1;  
        int n2 = r - m; 

        int[] left = new int[n1]; 
        int[] right = new int[n2]; 

        for (int i = 0; i < n1; ++i)
            left[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            right[j] = array[m + 1 + j];

        int i = 0, j = 0;
        int k = l; 
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                array[k] = left[i];  
                i++;
            } else {
                array[k] = right[j];   
                j++;            
            } 
            k++; 
        }
        
        while (i < n1) {
            array[k] = left[i]; 
            i++; 
            k++;
        } 

        while (j < n2) {
            array[k] = right[j]; 
            j++; 
            k++;
        }
    }

    public void sort(int[] array, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2; 
            sort(array, l, m); 
            sort(array, m + 1, r); 
            merge(array, l, m, r);
        }
    }

    public long sortAndMeasureTime() {
        long startTime = System.nanoTime();
        sort(array, 0, array.length - 1);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    @Override
    public String toString() {  
        StringBuilder result = new StringBuilder("Sorted array: "); 
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]).append(" ");
        }
        return result.toString().trim();
    }

    public String complexity() {
        return "Time complexity: O(n log n), Space complexity: O(n)"; 
    } 

    public static void main(String[] args) {
        int[] array = {11, 23, 3, 5, 17, 18, 12, 15, 21};
        MergeSort ms = new MergeSort(array); 
        long timeTaken = ms.sortAndMeasureTime();
        System.out.println(ms.toString()); 
        System.out.println("Time taken: " + timeTaken + " ns");
        System.out.println(ms.complexity());
    }
}