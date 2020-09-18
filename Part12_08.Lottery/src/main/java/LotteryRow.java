
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;
    private Random random;

    public LotteryRow() {
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public boolean containsNumber(int number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }

    public void randomizeNumbers() {
        this.random = new Random();
        this.numbers = new ArrayList<>();

        while (true) {
            if (numbers.size() == 7) {
                break;
            }

            int added = random.nextInt(40) + 1;
            if (containsNumber(added) == false) {
                numbers.add(added);
            }
        }

    }

    public boolean equals(Object other) {
        return false;
    }
}
