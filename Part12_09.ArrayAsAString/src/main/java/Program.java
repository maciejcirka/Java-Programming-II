
public class Program {

    public static void main(String[] args) {
        int rows = 2;
        int cols = 3;
        int[][] matrix = new int[rows][cols];
        matrix[0][1] = 5;
        matrix[1][0] = 3;
        matrix[1][2] = 7;
        System.out.println(arrayAsString(matrix));
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder big = new StringBuilder();
        for (int row = 0; row < array.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int column = 0; column < array[row].length; column++) {
                int value = array[row][column];
                sb.append(value);
            }
            big.append(sb);
            big.append("\n");
        }
        
        return big.toString();

    }
}
