package mitest;

/**
 * Programa principal MiTeSt
 * @license GPL v3
 * @author Esteban De La Fuente Rubio, esteban@delaf.cl
 * @date 2011-02-23
 */
public class Main {

    public static void main(String[] args) {

        // variables
        String titulo = "MiTeSt v1.0";
        int ancho = 415;
        int alto = 370;

        // crear frame principal
        MainFrame f = new MainFrame(titulo, ancho, alto);
        f.setVisible(true);
    }

}
