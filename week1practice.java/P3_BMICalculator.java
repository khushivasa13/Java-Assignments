import java.util.Scanner;

public class P3_BMICalculator {

    static double calculateBMI(double height, double weight) {
        return weight / (height * height);
    }

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("\nPerson\tHeight\tWeight\tBMI\tStatus");

        for (int i = 0; i < heights.length; i++) {
            double bmi = calculateBMI(heights[i], weights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s\n",
                    i + 1, heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int PEOPLE = 10;

        double[] heights = new double[PEOPLE];
        double[] weights = new double[PEOPLE];

        for (int i = 0; i < PEOPLE; i++) {
            System.out.print("Height of Person " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();

            System.out.print("Weight of Person " + (i + 1) + ": ");
            weights[i] = sc.nextDouble();
        }

        printWellnessReport(heights, weights);

        sc.close();
    }
}