package mitest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

/**
 *
 * @author delaf
 */
public class Preguntas {

    private Vector listado;
    public String nombre;
    private File archivo;
    private String ruta;

    public Preguntas (File archivo) {
        this.listado = new Vector();
        this.nombre = null;
        this.archivo = archivo;
        this.ruta = this.archivo.getAbsolutePath().replace(this.archivo.getName(), "");
        System.out.println(this.ruta);
        this.cargar();
    }

    private void cargar() {

        // variables
        BufferedReader in = null;
        String linea;
        boolean preguntaNueva;
        // variables que se iran reseteando
        String[] aux;
        int numero;
        String pregunta;
        String alternativa;
        String respuesta;
        String alt;
        boolean correcta;
        String explicacion;
        Vector preg = null;
        Vector respuestas = null;
        
        if(!archivo.exists()) System.exit(1);
        
        try {
            in = new BufferedReader(new FileReader(archivo));
        } catch (Exception e) {}

        try {

            while((linea = in.readLine()) != null) {

                // resetar variables
                aux = null;
                numero = 0;
                pregunta = null;
                alternativa = null;
                respuesta = null;
                correcta = false;
                explicacion = null;

                if(this.nombre==null && linea.startsWith("!:")) {
                    this.nombre = linea.replace("!:", "");
                }

                // no procesar si es una linea comentario
                if(!linea.startsWith("#") && !linea.isEmpty() && !linea.startsWith("!:")) {

                    // procesar linea
                    aux = linea.split(" ", 2); // dividir en 2 partes numero+pregunta o alternativa+respuesta
                    if(this.isInt(aux[0])) {
                        numero = Integer.parseInt(aux[0]);
                        pregunta = aux[1];
                    }
                    else if(aux[0].equals("(E)")) {
                        explicacion = aux[1];
                    }
                    else {
                        if(aux[0].startsWith("*")) correcta = true;
                        alternativa = aux[0].replace("*", "");
                        respuesta = aux[1];
                    }

                    if(numero!=0) preguntaNueva = true;
                    else preguntaNueva = false;

                    if(preguntaNueva) {
                        preg = new Vector();
                        preg.add(numero);
                        preg.add(pregunta);
                        respuestas = new Vector();
                    }

                    if(!preguntaNueva && explicacion==null) {
                        alt = alternativa+") "+respuesta;
                        preg.add(alt);
                        respuestas.add(correcta);
                    }

                    // si la linea es una explicacion cargarla y terminar vector
                    if(explicacion!=null) {
                        preg.add(respuestas); // respuesta en formato booleano
                        preg.add(explicacion); // agregar explicacion
                        preg.add(this.rutaImagen((Integer) preg.elementAt(0)));
                        this.listado.add(preg); // agregar pregunta al listado
                        preg = null; // reiniciar vector para la proxima pregunta
                        respuestas = null;
                    }

                } // fin del while que lee el archivo

            }
        } catch (Exception e) {}
        
    }

    private String rutaImagen(int numero) {
        String ubicacionImagen;
        File imagen;
        String extensiones[] = {"jpg", "jpeg", "png", "gif", "JPG", "JPEG", "PNG", "GIF"};
        for(int i=0; i<extensiones.length; i++) {
            ubicacionImagen = this.ruta+numero+"."+extensiones[i];
            //System.out.println("Buscando imagen: "+ubicacionImagen);
            imagen = new File(ubicacionImagen);
            if(imagen.exists()) return ubicacionImagen;
        }
        return null;
    }

    public int cantidad () {
        return this.listado.size();
    }

    public Vector pregunta (int n) {
        return (Vector) this.listado.elementAt(n-1);
    }

    public int nalt (int n) {
        int nalt;
        Vector pregunta = (Vector) this.listado.elementAt(n-1);
        nalt = pregunta.size() - 3;
        return nalt;
    }

    public void mostrar(int n) {
        // variables
        int tamanio, i;
        String[] alt;
        // obtener pregunta
        Vector preg = this.pregunta(n);
        // procesar pregunta y mostrarla
        tamanio = preg.size();
        System.out.println(preg.elementAt(0)+".- "+preg.elementAt(1));
        for(i=2; i<(tamanio-3); i++)
            System.out.println(preg.elementAt(i));
        System.out.println("Correcta: "+preg.elementAt(tamanio-3));
        System.out.println("Explicación: "+preg.elementAt(tamanio-2));
        System.out.println("Imagen: "+preg.elementAt(tamanio-1));
    }

    public void mostrar() {
        for(int i=1; i<=this.cantidad(); i++)
            this.mostrar(i);
    }

    private boolean isInt(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static void main (String[] args) {
        Preguntas preguntas = new Preguntas(new File("/home/delaf/preguntas.txt"));
        System.out.println(preguntas.nombre);
        System.out.println("Existen "+preguntas.cantidad()+" preguntas");
        preguntas.mostrar();
    }

}
