import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Muwanguzi Keith Jonathan
 *  Sorting and Removing duplicates using java
 **/

public class Question_Five {
    // Merge Sort implementation for sorting the list - Runs on O(n log n)
    public static List<Integer> mergeSort(List<Integer> numbers) {
        if (numbers.size() <= 1) {
            return numbers;
        }

        int mid = numbers.size() / 2;
        List<Integer> left = mergeSort(new ArrayList<>(numbers.subList(0, mid)));
        List<Integer> right = mergeSort(new ArrayList<>(numbers.subList(mid, numbers.size())));

        return merge(left, right);
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) <= right.get(rightIndex)) {
                result.add(left.get(leftIndex++));
            } else {
                result.add(right.get(rightIndex++));
            }
        }

        result.addAll(left.subList(leftIndex, left.size()));
        result.addAll(right.subList(rightIndex, right.size()));

        return result;
    }

    // Method to remove duplicates from a sorted list
    public static List<Integer> removeDuplicates(List<Integer> nums) {
        if (nums.isEmpty()) {
            return nums;
        }

        List<Integer> result = new ArrayList<>();
        result.add(nums.get(0));

        for (int i = 1; i < nums.size(); i++) {
            if (!nums.get(i).equals(nums.get(i - 1))) {
                result.add(nums.get(i));
            }
        }

        return result;
    }

    // Main method to sort and remove duplicates
    public static List<Integer> sortAndRemoveDuplicates(List<Integer> numbers) {
        //Sort the list using mergeSort - O(n log n) average case
        List<Integer> sorted = mergeSort(numbers);

        // Remove duplicates - O(n)
        return removeDuplicates(sorted);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(5, 2, 8, 2, 1, 9, 5, 3, 1));
        System.out.println("Original list: " + numbers);

        List<Integer> sortedUnique = sortAndRemoveDuplicates(numbers);
        System.out.println("Sorted list without duplicates: " + sortedUnique);
    }


    /** BONUS
     * To optimize memory usage when dealing with extremely large datasets when sorting
     * and removing duplicates, I'd consider the following strategies:
     *
     * 1. I would Use Primitive Arrays: Instead of using List<Integer>, I'd use an int[] array.
     *    This reduces the overhead associated with object wrappers.
     * 2. Implement an in-place sorting algorithm (like QuickSort) instead of using merge sort,
     *    which requires additional space for the left and right lists.
     *
     * I have implemented this in code below
     */

    // Optimized method to sort and remove duplicates using primitive array and QuickSort
    public static int[] optimizedSortAndRemoveDuplicates(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }

        // Sort the array using QuickSort
        quickSort(numbers, 0, numbers.length - 1);

        // Remove duplicates in-place
        int uniqueCount = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[i - 1]) {
                numbers[uniqueCount++] = numbers[i];
            }
        }

        // Create a new array with only unique elements
        return Arrays.copyOf(numbers, uniqueCount);
    }

    // QuickSort implementation
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
