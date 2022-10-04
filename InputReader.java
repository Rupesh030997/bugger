import java.util.Scanner;
import java.util.HashSet;

public class InputReader {
    private Scanner input;

    public InputReader() {
        input = new Scanner(System.in);
    }

    public HashSet<String> getInput() {
        System.out.println("===>");
        String inputLine = input.nextLine().trim().toLowerCase();

        String wordArray[] = inputLine.split(" ");
        HashSet<String> words = new HashSet<String>();

        for (String word : wordArray) {
            words.add(word);
        }
        return words;
    }
}