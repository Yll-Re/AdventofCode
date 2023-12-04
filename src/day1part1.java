import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day1part1 {

    public static String repWordNumb(String input){
        Map<String, String> numberWordMap = new HashMap<>();
        numberWordMap.put("oneight", "18");
        numberWordMap.put("twone", "21");
        numberWordMap.put("eightwo", "82");
        numberWordMap.put("one", "1");
        numberWordMap.put("two", "2");
        numberWordMap.put("three", "3");
        numberWordMap.put("four", "4");
        numberWordMap.put("five", "5");
        numberWordMap.put("six", "6");
        numberWordMap.put("seven", "7");
        numberWordMap.put("eight", "8");
        numberWordMap.put("nine", "9");

        Pattern pattern = Pattern.compile("(oneight|twone|eightwo|one|two|three|four|five|six|seven|eight|nine)");

        Matcher matcher = pattern.matcher(input);

        StringBuilder replacedBuffer = new StringBuilder();
        while (matcher.find()) {
            String numberWord = matcher.group();
            String replacement = numberWordMap.get(numberWord);
            matcher.appendReplacement(replacedBuffer, ""); // Remove this line
            if (replacement != null) {
                replacedBuffer.append(replacement); // Append the replacement directly
            }
        }
        matcher.appendTail(replacedBuffer);

        return replacedBuffer.toString();

    }


    public static void main(String[] args) {
        int sum = 0;


        String filepath = "src/Input";

        try (BufferedReader br = new BufferedReader (new FileReader(filepath))){
            String line;
            while((line = br.readLine()) != null){
                line = repWordNumb(line);
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
