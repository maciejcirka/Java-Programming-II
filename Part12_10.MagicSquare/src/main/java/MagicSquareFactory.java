
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        int count = 1;
        int min = 0;
        int max = size - 1;
        int row = size / 2;
        int col = 0;

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                if (col < min) {
                    col = max;
                }
                if (row > max) {
                    row = min;
                }

                square.placeValue(row, col, count);
                count++;
                row++;
                col--;
            }

            col++;
            col++;
            row--;

        }

        return square;
    }

}
