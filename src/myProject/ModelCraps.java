package myProject;

public class ModelCraps {
    private Dado dado1, dado2;

    private int tiro, punto, estado;
    private String estadoToString;
    private int[] caras;

    /*Constructor*/
    public ModelCraps(){
        dado1 = new  Dado();
        dado2 = new Dado();
        caras = new int[2];
    }

    /*metodos*/
    /*Determina el valor del tiro*/
    public void calcularTiro() {
       caras[0]=dado1.getCara();
       caras[0]=dado2.getCara();
    }
}
