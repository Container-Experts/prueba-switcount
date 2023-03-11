package co.com.swiftcount;

import java.util.Scanner;

import co.com.swiftcount.util.Pair;


public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int numberAmount = sc.nextInt();
            int[] numbers = new int[numberAmount];

            for (int i=0; i<numberAmount; i++) {
                numbers[i] = sc.nextInt();
            }


            int queriesAmount = sc.nextInt();

            while (queriesAmount-- > 0) {
                int pivotNumber = sc.nextInt();
                System.out.println(String.format("Result for pivot %s: %s", pivotNumber, findNumberBelowAndAbove(numbers, pivotNumber)));
            }

        } catch (Exception ex) {
            System.err.println(String.format("Runtime error detected while performing operation: %s", ex.getLocalizedMessage()));
        }
    }

    private static Pair<String, String> findNumberBelowAndAbove(int[] numbers, int pivotNumber) {
        int leftIndex = -1;
        int rightIndex = -1;

        int i=0;
        int j=numbers.length-1;

        if (pivotNumber > numbers[i]) {
            while (i<numbers.length && leftIndex == -1) {
                if (numbers[i] == pivotNumber) {
                    leftIndex = i-1;
                } else if (i+1 >= numbers.length || numbers[i+1] > pivotNumber){
                    leftIndex = i;
                }

                i++;
            }
        }

        if (pivotNumber < numbers[j]) {
            while (j>=0 && rightIndex == -1) {
                if (numbers[j] == pivotNumber) {
                    rightIndex = j+1;
                } else if (j-1 < 0 || numbers[j-1] < pivotNumber) {
                    rightIndex = j;
                }

                j--;
            }
        }

        
        return new Pair<>(
            (leftIndex != -1) ? String.valueOf(numbers[leftIndex]): "X",
            (rightIndex != -1) ? String.valueOf(numbers[rightIndex]): "X"
        );

    }
    
}
