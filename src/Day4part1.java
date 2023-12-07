import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day4part1 {

    static String filepath = "src/Input";



    public static void main(String[] args){

        int sum = 0;


        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;
            while ((line = br.readLine()) != null){
                int temp = 0;
                int tempSum = 0;
                System.out.println(line);
                String[] splitLine = line.split("\\|");
                String[] numberBefor = splitLine[0].trim().split("\\s+");
                String[] numberAfter = splitLine[1].trim().split("\\s+");

                int[] numberBeforeInt = convertInt(numberBefor);
                int[] numberAfterInt = convertInt(numberAfter);

                for (int i = 0; i<numberBeforeInt.length; i++){

                    for (int j = 0; j<numberAfterInt.length; j++){

                        if (numberBeforeInt[i]==numberAfterInt[j]){
                            System.out.println(numberBeforeInt[i] + "It was equal" + numberAfterInt[j]);

                            tempSum = (int) Math.pow(2,temp);
                            temp++;
                            System.out.println(sum + "Inside loop");
                        }
                    }
                }
                sum = sum + tempSum;
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sum);
    }

    private static int[] convertInt(String[] stringNumbers){
        int[] arrayNumbers = new int[stringNumbers.length];
        for (int i=0; i < stringNumbers.length; i++){
            try {
                arrayNumbers[i] = Integer.parseInt(stringNumbers[i]);
            } catch (NumberFormatException e) {

            }
        }
        return arrayNumbers;
    }
}
