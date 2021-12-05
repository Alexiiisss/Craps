package myProject;

import java.util.Random;

/**
 * Class Dado generate a ramdom value between 1 and 6
 * @author Alexis Lopez
 * @version v 1.0.0 date 5/12/2021
 */
public class Dado {
    private int cara;

    /**
     * Method that generate and random value to cara
     * @return number betweem (1, 6)
     */

    public int getCara() {
        /*Constructor de la clase Random*/
        Random aleatorio = new Random();
        cara = aleatorio.nextInt(6)+1;
        return cara;
    }
}
