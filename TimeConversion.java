import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class TimeConversion {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Get the source and target countries from the user
        System.out.print("Enter the source country: ");
        String sourceCountry = scanner.nextLine();

        System.out.print("Enter the target country: ");
        String targetCountry = scanner.nextLine();

        // Get the current time in the source country's time zone
        ZonedDateTime sourceDateTime = ZonedDateTime.now(ZoneId.of(sourceCountry));

        // Convert the source time to the target country's time zone
        ZonedDateTime targetDateTime = sourceDateTime.withZoneSameInstant(ZoneId.of(targetCountry));

        // Get the current time in the target country's time zone
        ZonedDateTime currentDateTime = ZonedDateTime.now(ZoneId.of(targetCountry));

        // Format the converted time and current time as strings in 12-hour format with AM/PM
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a", Locale.ENGLISH);
        String convertedTime = targetDateTime.format(formatter);
        String currentTime = currentDateTime.format(formatter);

        // Display the converted time and current time
        System.out.println("Source Country: " + sourceCountry);
        System.out.println("Target Country: " + targetCountry);
        System.out.println("Converted Time: " + convertedTime);
        System.out.println("Current Time in Target Country: " + currentTime);

        // Close the Scanner
        scanner.close();
    }
}
