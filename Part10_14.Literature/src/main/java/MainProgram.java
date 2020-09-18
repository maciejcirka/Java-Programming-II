
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> shelf = new ArrayList<>();
        int i = 0;
      
        while (true) {
           
            System.out.println("Input the name of the book, empty stops:");
            String title = scanner.nextLine();
            
            if(title.isEmpty()) {
                break;
            }
            
            System.out.println("Input the age recommendation:");
            int age = Integer.valueOf(scanner.nextLine());
            
            
            shelf.add(new Book(title, age));
            i++;
            
        }
        
        System.out.println(i + " books in total.");
        
        Comparator<Book> comparator = Comparator.comparing(Book::getAge).thenComparing(Book::getTitle);
        
        Collections.sort(shelf, comparator);
        
        System.out.println("Books:");
        shelf.stream().forEach(book -> System.out.println(book));
       
    }

}
