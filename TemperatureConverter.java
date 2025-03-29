import java.util.Scanner;


public class TemperatureConverter {

    //we will make function for each conversion
    //1.conversion of celcius to others

    static void celsiusToOther(double c) {
        System.out.printf("Fahrenheit: %.2f°F%n", (c * 9/5) + 32);
        System.out.printf("Kelvin: %.2fK%n", c + 273.15);
    }

    //2.fahrenheit to others
    static void fahrenheitToOther(double f){
        System.out.printf("Celsius: %.2f°C%n", (f - 32)*5/9);
        System.out.printf("Kelvin: %.2fK%n", ((f - 32)*5/9) + 273.15);
    }

    //3. kelvin to other
    static void kelvinToOther(double k) {
        System.out.printf("Celsius: %.2f°C%n", k - 273.15);
        System.out.printf("Fahrenheit: %.2f°F%n", ((k - 273.15)*9/5) + 32);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("TEMPERATURE CONVERTER");
        System.out.println("1.Celsius to other");
        System.out.println("2.Fahrenheit to other");
        System.out.println("3.Kelvin to other");
        System.out.printf("Chose a conversion from(1-3): ");
        int choice = scanner.nextInt();

        //Take user input for the temperature
        System.out.println("Enter the Temperature");
        double temp = scanner.nextDouble();

        //performing conversion
        switch(choice) {
            case 1 -> celsiusToOther(temp);
            case 2 -> fahrenheitToOther(temp);
            case 3 -> kelvinToOther(temp);
            default -> System.out.println("Invalid choice!");
        }
        scanner.close();
    }
}
