import java.util.Scanner;

public class TemperatureConverter {

    public static double convertTemperature(double value, String fromScale, String toScale) {
        fromScale = fromScale.toLowerCase();
        toScale = toScale.toLowerCase();

        double celsius;
        switch (fromScale) {
            case "celsius":
                celsius = value;
                break;
            case "fahrenheit":
                celsius = (value - 32) * 5 / 9;
                break;
            case "kelvin":
                celsius = value - 273.15;
                break;
            default:
                throw new IllegalArgumentException("Invalid fromScale. Use Celsius, Fahrenheit, or Kelvin.");
        }

        switch (toScale) {
            case "celsius":
                return celsius;
            case "fahrenheit":
                return (celsius * 9 / 5) + 32;
            case "kelvin":
                return celsius + 273.15;
            default:
                throw new IllegalArgumentException("Invalid toScale. Use Celsius, Fahrenheit, or Kelvin.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the temperature value: ");
        double value = scanner.nextDouble();

        System.out.print("Enter the scale to convert from (Celsius, Fahrenheit, Kelvin): ");
        String fromScale = scanner.next();

        System.out.print("Enter the scale to convert to (Celsius, Fahrenheit, Kelvin): ");
        String toScale = scanner.next();

        try {
            double result = convertTemperature(value, fromScale, toScale);
            System.out.printf("%.2f %s is %.2f %s%n",
                    value, capitalize(fromScale), result, capitalize(toScale));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    private static String capitalize(String str) {
        if (str == null || str.length() == 0)
            return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
