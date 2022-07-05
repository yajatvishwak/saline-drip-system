import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Nurse {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Saline Drip Check");
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Path logFile = Path.of(
                "logfile");
        while (true) {
            System.out.println("1. Entering Patient Details");
            System.out.println("2. Exit");
            int ch = sc.nextInt();
            if (ch == 2) {
                break;
            }
            System.out.println("Patient Name:");
            String name = sc2.nextLine();
            System.out.println("Bed Number:");
            String bedno = sc2.nextLine();
            System.out.println("Saline Value:");
            String sv = sc2.nextLine();
            // write to a file
            Files.writeString(logFile, name + ":" + bedno + ":" + sv + ",", StandardOpenOption.APPEND);

        }
        sc.close();
        sc2.close();
    }
}
