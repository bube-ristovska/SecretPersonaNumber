import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static String filterEpochMillis(long epochMillis) {
        String epochString = String.valueOf(epochMillis);
        long firstPart = epochMillis % 1000000;
        long lastPart = Long.parseLong(epochString.substring(epochString.length() - 6));
        long sum = (firstPart * lastPart) % 1000000;
        return String.format("%06d", sum);
    }

    public static String mapDateToThreeLetters() {
        String possibleCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        LocalDate date = LocalDate.now();
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear() % 100; // Using last two digits of the year

        Random random = new Random();

        StringBuilder mappedLetters = new StringBuilder();
        mappedLetters.append(possibleCharacters.charAt(Math.abs((day * random.nextInt(25)) % 26)));
        mappedLetters.append(possibleCharacters.charAt(Math.abs((month * random.nextInt(25)) % 26)));
        mappedLetters.append(possibleCharacters.charAt(Math.abs((year * random.nextInt(25)) % 26)));


        return mappedLetters.toString();
    }
    public static ArrayList<Character> toCharacterList(String s) {
        ArrayList<Character>  arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            arr.add(s.charAt(i));
        }
        return arr;
    }
    public static String generateSecretPersonalNumber(String randomNum, String randomString){
        ArrayList<Character> list = toCharacterList(randomNum + randomString);
        Collections.shuffle(list);
        StringBuilder shuffledLetters = new StringBuilder();
        for (Character c : list) {
            shuffledLetters.append(c);
        }

        return shuffledLetters.toString();
    }
    /** Uncomment the commented code for testing on 1800000 citizens */
    public static void main(String[] args) {
//        int i = 0;
//        ArrayList<String> testingRandomness = new ArrayList<>();
//        while(i != 1800000){
//            i++;
//
            long currentEpochMillis = System.currentTimeMillis();
            String randomNum = filterEpochMillis(currentEpochMillis);
            String randomString = mapDateToThreeLetters();
            System.out.println("Generated random number: " + randomNum);
            System.out.println("Generated random string: " + randomString);String PRN = generateSecretPersonalNumber(randomNum, randomString);

            System.out.println("RPN:" + PRN);
//
//            if(testingRandomness.contains(PRN)){
//                System.out.println("DUPLICATE");
//            } else {
//                testingRandomness.add(PRN);
//            }
//
//
//        }
//        System.out.println("DONE");
    }
}