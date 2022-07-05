import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Thread;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.awt.Toolkit;

public class Doc {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path logFile = Path.of(
                "logfile");
        ArrayList<String> logs;
        ArrayList<String> givenTreatment = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Waiting for new Request");
            String logFileString = Files.readString(logFile);
            logs = new ArrayList<String>(Arrays.asList(logFileString.split(",")));
            // System.out.println(logs.size());
            for (String text : logs) {
                String arr[] = text.split(":");
                if (arr.length == 3 && Integer.parseInt(arr[2]) < 10 && !givenTreatment.contains(arr[0])) {
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println("\n\n");
                    System.out.println("__________________________________");
                    System.out.println("Emergency!!! Saline Value Low");
                    System.out.println("Patient name: " + arr[0]);
                    System.out.println("Patient bedno: " + arr[1]);
                    System.out.println("__________________________________");
                    System.out.println("\n\n");
                    System.out.println("Press 1 after giving treatment, 0 to exit");
                    if (sc.nextInt() == 1) {
                        givenTreatment.add(arr[0]);
                        continue;
                    } else {
                        System.exit(0);
                    }

                }

            }
            Thread.sleep(1000);
        }
    }
}