/**
 * TemperatureConverter class converts temperatures between Celsius and Fahrenheit.
 * It handles input validation and provides error messages for invalid temperatures.
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class TemperatureConverter {

	// ANSI color codes to make the output and error messages stand out
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String GREEN_BRIGHT = "\033[0;92m";

	// Absolute zero temperatures in Celsius and Fahrenheit
	public static final double ABSOLUTE_ZERO_CELSIUS = -273.15;
	public static final double ABSOLUTE_ZERO_FAHRENHEIT = -459.67;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(ANSI_CYAN + "\n~~~~~~~~ WELCOME TO THE TEMPERATURE CONVERTER ~~~~~~~~\n" + ANSI_RESET);

		// Display menu options and handle user input
        while (true) {

			try {

				System.out.println("1. Convert Celsius to Fahrenheit");
				System.out.println("2. Convert Fahrenheit to Celsius");
				System.out.println("3. Quit");
				System.out.print("Enter your choice: ");
		        int choice = scanner.nextInt();

		        if (choice == 1) {

					// Convert temperature from Celsius to Fahrenheit
		            while (true) {

		                System.out.print("\nEnter the temperature in Celsius: ");
		                double tempInCelsius = scanner.nextDouble();

		                if (tempInCelsius <= ABSOLUTE_ZERO_CELSIUS) {

		                     System.out.println(ANSI_RED + "Temperature cannot be below absolute zero (-273.15 °C). Please enter a valid temperature." + ANSI_RESET);

		                } else {

		                     double tempInFahrenheit = (tempInCelsius * 9 / 5) + 32;

		                     System.out.format(ANSI_GREEN + "\nThe temperature in Fahrenheit is " + GREEN_BRIGHT + "%.2f" + ANSI_GREEN  + " °F\n\n" + ANSI_RESET, tempInFahrenheit);

		                     break;

		                }

		            }

		        } else if (choice == 2) {

					// Convert temperature from Fahrenheit to Celsius
		            while (true) {

		                System.out.print("\nEnter the temperature in Fahrenheit: ");
		                double tempInFahrenheit = scanner.nextDouble();

		                if (tempInFahrenheit <= ABSOLUTE_ZERO_FAHRENHEIT) {

		                     System.out.println(ANSI_RED + "Temperature cannot be below absolute zero (-459.67 °F). Please enter a valid temperature." + ANSI_RESET);

		                } else {

		                     double tempInCelsius = (tempInFahrenheit - 32) * 5 / 9;

		                     System.out.format(ANSI_GREEN + "\nThe temperature in Celsius is " + GREEN_BRIGHT + "%.2f" + ANSI_GREEN  + " °C\n\n" + ANSI_RESET, tempInCelsius);

		                     break;

		                }

		            }

		        } else if (choice == 3) {

					System.out.println(ANSI_CYAN + "\n~~~~~~~~~~~~~~~~~~~~~~~~ BYE! ~~~~~~~~~~~~~~~~~~~~~~~~\n" + ANSI_RESET);

		            break;

		        } else {

		            System.out.println(ANSI_RED + "Please enter a valid choice\n" + ANSI_RESET);

		        }

			} catch (InputMismatchException e) {

				// Clear the invalid input
				scanner.next();
				System.out.println(ANSI_RED + "Invalid input. Please enter a number.\n" + ANSI_RESET);

			}

		}

        scanner.close();

    }

}
