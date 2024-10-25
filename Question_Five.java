import java.util.ArrayList;
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
}
