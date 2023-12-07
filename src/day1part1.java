import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class day1part1 {
    public static void main(String[] args) {
        int sum = 0;


        String filepath = "src/Input";

        try (BufferedReader br = new BufferedReader (new FileReader(filepath))){
            String line;
            while((line = br.readLine()) != null){
                int leftMost = -1;
                int rightMost = -1;
                System.out.println(line);
                for (int i = 0; i < line.length(); i++){

                    if (Character.isDigit(line.charAt(i))){
                        if (leftMost==-1){
                            leftMost = Character.getNumericValue(line.charAt(i));
                            rightMost = Character.getNumericValue(line.charAt(i));
                        }
                        else {
                            rightMost = Character.getNumericValue(line.charAt(i));
                        }
                    }

                }
                System.out.println("left and right most are: " + leftMost + rightMost);
                sum = sum + (leftMost*10) + rightMost;
                System.out.println("the sum so far is: " + sum);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
