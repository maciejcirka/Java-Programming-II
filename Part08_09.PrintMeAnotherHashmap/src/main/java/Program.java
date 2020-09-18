
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        HashMap<String, Book> hashmap = new HashMap<>();
        hashmap.put("sense", new Book("Sense and Sensibility", 1811, "..."));
        hashmap.put("prejudice", new Book("Pride and prejudice", 1813, "...."));

        printValues(hashmap);
        System.out.println("---");
        printValueIfNameContains(hashmap, "prejud");
    }

    public static void printValues(HashMap<String, Book> hashmap) {
        for (String book : hashmap.keySet()) {
            System.out.println(hashmap.get(book));
        }
    }

    public static void printValueIfNameContains(HashMap<String, Book> hashmap, String text) {
        for (String book : hashmap.keySet()) {
            if (hashmap.get(book).getName().toLowerCase().contains(text.toLowerCase())) {
                System.out.println(hashmap.get(book));
            }
        }

    }
}
