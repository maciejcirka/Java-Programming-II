
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        
        System.out.println("Input numbers, type \"end\" to stop.");
        
        while (true) {
            
            String input = scanner.nextLine();
            
            if (input.equals("end"))
                break;
            
            list.add(input);
            
            
            
            
            

    }
    }
    
    public static List<Integer> positive(List<Integer> numbers) {
        return numbers.stream()
        .filter(value -> value >= 0)
        .collect(Collectors.toCollection(ArrayList:: new));
        
    } 

}
