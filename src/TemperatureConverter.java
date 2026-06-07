import java.util.Scanner;

public class TemperatureConverter {

    public static double convertTemperature(double temperature, String unit) {
        if (unit.equalsIgnoreCase("C")) {
            return (temperature * 9.0 / 5.0) + 32.0;
        } else {
            return (temperature - 32.0) * 5.0 / 9.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Enter a temperature (or 'stop' to quit): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("stop")) {
                running = false;
            } else {
                boolean validNumber = true;
                double temp = 0.0;

                Scanner numCheck = new Scanner(input);
                if (numCheck.hasNextDouble()) {
                    temp = numCheck.nextDouble();
                } else {
                    validNumber = false;
                }
                numCheck.close();

                if (!validNumber) {
                    System.out.println("Invalid input: \"" + input + "\" is not a valid number. Please try again.");
                } else {
                    String unit = "";
                    boolean validUnit = false;

                    while (!validUnit) {
                        System.out.print("Enter unit (C or F): ");
                        unit = scanner.nextLine().trim();

                        if (unit.equalsIgnoreCase("C") || unit.equalsIgnoreCase("F")) {
                            validUnit = true;
                        } else {
                            System.out.println("Invalid unit: \"" + unit + "\" is not recognized. Please enter C or F.");
                        }
                    }

                    double result = convertTemperature(temp, unit);

                    if (unit.equalsIgnoreCase("C")) {
                        System.out.printf("%.2f\u00b0C is equal to %.2f\u00b0F%n", temp, result);
                    } else {
                        System.out.printf("%.2f\u00b0F is equal to %.2f\u00b0C%n", temp, result);
                    }
                }
            }
        }

        scanner.close();
    }
}
