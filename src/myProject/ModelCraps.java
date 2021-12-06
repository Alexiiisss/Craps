package myProject;

/**
 * MOdelCraps apply craps rules.
 * estado = 1 Natural winner.
 * estado = 2 Craps looser.
 * estado = 3 Establish Punto.
 * estado = 4 Punto winner.
 * estado = 5 Punto looser.
 * @author Alexis Lopez
 * @version V1.0.0 date 05/12/2021
 */
public class ModelCraps {
    private Dado dado1, dado2;
    private int tiro, punto, estado, flag;
    private String[] estadoToString;
    private int[] caras;

    /**
     * Class Constructor.
     */
    public ModelCraps(){
        dado1 = new  Dado();
        dado2 = new Dado();
        caras = new int[2];
        estadoToString  = new String[2];
        flag = 0;
    }

    /**
     * Establish the tiro value according to each dice
     */
    public void calcularTiro() {
       caras[0]=dado1.getCara();
       caras[1]=dado2.getCara();
       tiro = caras[0] + caras[1];
    }

    /**
     * Establish game state
     * estado = 1 Natural winner.
     * estado = 2 Craps looser.
     * estado = 3 Establish Punto.
     * estado = 4 Punto winner.
     * estado = 5 Punto looser.
     */
    public void determinarJuego() {
        if(flag == 0) {
            if(tiro == 7 || tiro == 11) {
                estado = 1;
            } else {
                if (tiro == 3 || tiro == 2 || tiro == 12) {
                    estado = 2;
                } else {
                    estado = 3;
                    punto = tiro;
                    flag = 1;
                }
            }
        } else {
            //Match point
            rondaPunto();
        }
    }

    /**
     * Establish game state according to estado attribute value.
     * estado = 4 Punto winner.
     * estado = 5 Punto looser.
     */
    private void rondaPunto() {
        if (tiro == punto) {
            estado = 4;
            flag = 0;
        } else {
            if (tiro == 7) {
                estado = 5;
                flag = 0;
            } else {
                estado = 6;
            }
        }
    }

    public int getTiro() {
        return tiro;
    }

    public int getPunto() {
        return punto;
    }

    /**
     * Establish message game state according to estado attribute value.
     * @return Message for the View class
     */
    public String[] getEstadoToString() {
        switch (estado) {
            case 1: estadoToString[0] = "Tiro de salida = " + tiro;
                    estadoToString[1] = "Sacaste natural, has ganado!";
                    break;
            case 2: estadoToString[0] = "Tiro de salida = " + tiro;
                    estadoToString[1] = "Sacaste craps, has perdido!";
                    break;
            case 3: estadoToString[0] = "Tiro de salida = " + tiro + "\nPunto " + punto;
                    estadoToString[1] = "Estableciste punto en " + punto + " Debes seguir lanzando!" +
                                        "\n pero si sacas 7 antes que " + punto + " perderás";
                    break;
            case 4: estadoToString[0] = "Tiro de salida = " + punto + "\nPunto " + punto + "\nValor del nuevo tiro es = " + tiro;
                    estadoToString[1] = "Volviste a sacar " + punto + ", has ganado!";
                    break;
            case 5: estadoToString[0] = "Tiro de salida = " + punto + "\nPunto " + punto + "\nValor del nuevo tiro es = " + tiro;
                    estadoToString[1] = "Sacaste 7 antes que " + punto + " has perdido!";
                    break;
            case 8: estadoToString[0] = "Tiro de salida = " + punto + "\nPunto " + punto + "\nValor del nuevo tiro es = " + tiro;
                    estadoToString[1] = "\nEstas en Punto y debes seguir lanzanddo! " +
                                        "\n pero si sacas 7 antes que " + punto + " perderas.";
                break;
        }
        return estadoToString;
    }

    public int[] getCaras() {
        return caras;
    }
}
