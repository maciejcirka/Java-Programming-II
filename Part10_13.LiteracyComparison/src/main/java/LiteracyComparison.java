
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        
       List <Data> list = new ArrayList<>();
        
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(row -> row.split(","))
                    .map(data -> new Data(data[3], Integer.valueOf(data[4]), data[2].substring(0, data[2].length()-4).trim(), data[5]))
                    .forEach(data -> list.add(data));
                    
                 
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
  
        
        Collections.sort(list, (d1, d2) -> d1.getLiteracyPercent().compareTo(d2.getLiteracyPercent()));
        
        list.stream().forEach(data -> System.out.println(data));
        
        
        
        
        

    }
    
    
}
