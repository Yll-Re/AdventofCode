import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2part2 {


    static String filepath = "src/Input";

    public static void main(String[] args) {


        int sum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                boolean meetsConditions = true;
                String[] parts = line.split(": ");
                System.out.println(line);
                String[] gamePart = parts[1].trim().split(";");

                int colorPower = 0;

                int maxRed = 0;
                int maxGreen = 0;
                int maxBlue = 0;

                for (String colorGame : gamePart){




                    String[] everyColor = colorGame.split(", ");

                    for (String ColorAndNumber : everyColor){
                        System.out.println(ColorAndNumber);
                        String[] ColorNumber = ColorAndNumber.trim().split(" ");
                        if (ColorAndNumber.contains("red") && (maxRed < Integer.parseInt(ColorNumber[0]))){
                            maxRed = Integer.parseInt(ColorNumber[0]);

                        } else if (ColorAndNumber.contains("blue") && (maxBlue < Integer.parseInt(ColorNumber[0]))) {
                            maxBlue = Integer.parseInt(ColorNumber[0]);
                        }
                        else if (ColorAndNumber.contains("green") && (maxGreen < Integer.parseInt(ColorNumber[0]))) {
                            maxGreen = Integer.parseInt(ColorNumber[0]);
                        }

                    }
                    System.out.println(maxRed + " " + maxBlue + " " + maxGreen);
                    colorPower = maxRed * maxGreen * maxBlue;
                    System.out.println(colorPower);
                }

                sum = sum + colorPower;


            }
        }   catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final number is: " + sum);
    }
}