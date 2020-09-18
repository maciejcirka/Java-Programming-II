import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Checker checker = new Checker();
        
        System.out.println("Tell me:");
        
        String word = scanner.nextLine();
        
        System.out.println(checker.timeOfDay(word));
        
        
    }
}
