package Projects.Project4;
/*************
 *Program name: IceCreamAnalysis
 *Program Description: A program to analyze Scoops Ahoy's ice cream flavors and displays average calories, cost, highest favourability,
 * least cost, best value, and 2 lowest calorie flavors along with a function at the end to check whether a flavor is present in the array.
 --------------------------------------------------------------------------------------------
 *Name: Sameer Ali
 *Version date: 03/25/2023
 *CMSC 255 901
 ***************/

import java.util.Scanner;
public class IceCreamAnalysis {
    public static double calcMean(double[] values) {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.length;
    }

    public static double findGreatest(double[] values) {
        double greatest = Double.MIN_VALUE;
        for (double value : values) {
            if (value > greatest) {
                greatest = value;
            }
        }
        return greatest;
    }

    public static double findSmallest(double[] values) {
        double smallest = Double.MAX_VALUE;
        for (double value : values) {
            if (value < smallest) {
                smallest = value;
            }
        }
        return smallest;
    }

    public static String findBestValue(String[] flavors, double[] favorability, double[] cost) {
        double[] valueRatings = new double[flavors.length];
        for (int i = 0; i < flavors.length; i++) {
            valueRatings[i] = favorability[i] * (5 - cost[i]);
        }
        int maxIndex = 0;
        for (int i = 1; i < valueRatings.length; i++) {
            if (valueRatings[i] > valueRatings[maxIndex]) {
                maxIndex = i;
            }
        }
        return flavors[maxIndex];
    }

    public static String[] findSmallestTwo(String[] flavors, double[] values) {
        int minIndex1 = 0;
        int minIndex2 = 1;
        if (values[minIndex2] < values[minIndex1]) {
            int temp = minIndex1;
            minIndex1 = minIndex2;
            minIndex2 = temp;
        }
        for (int i = 2; i < values.length; i++) {
            if (values[i] < values[minIndex1]) {
                minIndex2 = minIndex1;
                minIndex1 = i;
            } else if (values[i] < values[minIndex2]) {
                minIndex2 = i;
            }
        }
        return new String[]{flavors[minIndex1], flavors[minIndex2]};
    }

    public static boolean findFlavor(String[] flavors, String flavor) {
        for (String f : flavors) {
            if (flavor.equals(f)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] flavors = {"Vanilla", "Chocolate", "Mint Chocolate Chip", "Cookies N’ Cream", "Strawberry",
                "Cookie Dough", "Salted Caramel", "Moose Tracks"};
        double[] calories = {137.6, 143.5, 151.3, 162.8, 126.6, 168.4, 139.1, 158.2};
        double[] favorability = {0.78, 0.62, 0.59, 0.33, 0.45, 0.67, 0.72, 0.49};
        double[] cost = {1.98, 2.14, 2.23, 2.17, 2.09, 2.12, 2.07, 2.34};

        System.out.printf("The average calorie amount is: %.3f\n", calcMean(calories));
        System.out.printf("The average cost per gallon is: %.3f\n", calcMean(cost));
        System.out.printf("The highest favorability is: %.3f\n", findGreatest(favorability));
        System.out.printf("The least cost per gallon is: %.3f\n", findSmallest(cost));
        System.out.println("The best value is: " + findBestValue(flavors, favorability, cost));
        System.out.println("The least two flavors for calories are:");
        String[] smallestTwo = findSmallestTwo(flavors, calories);
        for (String flavor : smallestTwo) {
            System.out.println(flavor);
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a flavor: ");
        String flavor = input.nextLine();
        if (isFlavorInArray(flavor, flavors)) {
            System.out.println(flavor + " is a flavor in the array.");
        } else {
            System.out.println(flavor + " is not a flavor in the array.");
        }
    }

    public static boolean isFlavorInArray(String flavor, String[] array) {
        for (String element : array) {
            if (element.equalsIgnoreCase(flavor)) {
                return true;
            }
        }
        return false;
    }
}
