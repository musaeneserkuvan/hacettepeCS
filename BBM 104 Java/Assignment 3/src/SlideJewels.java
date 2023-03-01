import java.util.Objects;

public interface SlideJewels {

    default void Slide(GameGrid[][] array)  {

        for (int t = 0; t < 10; t++) {
            for (int i = 2; i < 12; i++) {

                for (int j = 2; j < 12; j++) {

                    if (!Objects.equals(array[i][j].getSymbol(), " ") && Objects.equals(array[i + 1][j].getSymbol(), " ")) {

                        array[i][j].setRow(i + 1);
                        array[i + 1][j].setRow(i);

                        GameGrid[] clone1 = array[i].clone();
                        GameGrid[] clone2 = array[i + 1].clone();

                        array[i][j] = clone2[j];
                        array[i + 1][j] = clone1[j];

                    }

                }
            }

        }

    }
}
