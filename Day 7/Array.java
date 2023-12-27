public class Array {
    public static void main(String[] args) {

        // 1. Create an array of 5 integer values with the any elements: like [1, 12, 30, 22, 5].

        int[] arr = { 1, 12, 30, 22, 5 }; // creating array
        System.out.print("Array of integers : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); // print all values using for loop
        }

        // 2. Calculate and print the sum of all the values in the array.
        int sum = 0;
        for (int elem : arr) {
            sum = elem + sum; // calcualting sum of all values using for each loop
        }
        System.out.println("\nsum of integers in array : " + sum);

        // 3. Calculate and print the average (mean) of the values in the array.

        int avg = sum / arr.length; // average = sum/count
        System.out.println("Average of array : " + avg);

        // 4 . Find and print the maximum value among the elements in the array.

        int max = arr[0]; // initial value at index 0
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) { // if to check the maximum value
                max = arr[i];
            }
        }
        System.out.println("Maximum value in array : " + max);

        // 5. Find and print the minimum value among the elements in the array.

        int min = arr[0]; // initial value at index 0
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) { // if to check the minimum value
                min = arr[i];
            }
        }
        System.out.println("Minimum value in array : " + min);

    }
}
