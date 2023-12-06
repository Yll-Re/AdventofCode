import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2part1 {


    static String filepath = "src/Input";

    public static void main(String[] args) {


        int sum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                boolean meetsConditions = true;
                String[] parts = line.split(": ");
                System.out.println(line);

                String gameNumber = parts[0].trim().split(" ")[1];

                String[] colorCounts = parts[1].trim().split(";");


                for (String counts : colorCounts) {
                    String[] colors = counts.split(",");
                    for (String color : colors) {
                        String[] countParts = color.trim().split("\\s");
                        int quantity = Integer.parseInt(countParts[0]);
                        String colorName = countParts[1];

                        if(("red".equals(colorName) && quantity > 12) || ("blue".equals(colorName) && quantity > 14) || ("green".equals(colorName) && quantity > 13)) {
                            meetsConditions = false;
                            break;
                        }
                    }
                }
                if (meetsConditions) {
                    System.out.println("THIS GAME WORKS");
                    sum = sum + Integer.parseInt(gameNumber);
                }
            }
        }   catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final number is: "+ sum);
    }
}