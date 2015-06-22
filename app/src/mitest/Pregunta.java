/*
 * Pregunta.java
 *
 * Created on 02-12-2009, 01:58:27 PM
 */

package mitest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JCheckBox;

/**
 *
 * @author delaf
 */
public class Pregunta extends javax.swing.JPanel {

    private int npregunta;
    private String pregunta;
    private Vector alternativas;
    private Vector alternativasCheckBox;
    private Vector correctas;
    private String explicacion;
    private String imagen;
    public float puntaje=0;
    public boolean revisadaFlag = false;

    /** Creates new form Pregunta */
    public Pregunta(Vector preg) {
        // inicializar componentes
        initComponents();
        // obtener pregunta y setear atributos clase
        int tamanio, i;
        tamanio = preg.size();
        this.npregunta = (Integer) preg.elementAt(0);
        this.pregunta = (String) preg.elementAt(1);
        this.alternativas = new Vector();
        for(i=2; i<(tamanio-3); i++) {
            this.alternativas.add(preg.elementAt(i));
        }
        this.correctas = (Vector) preg.elementAt(tamanio-3);
        this.explicacion = (String) preg.elementAt(tamanio-2);
        this.imagen = (String) preg.elementAt(tamanio-1);
        this.crearGraficos();
    }

    private void crearGraficos () {
        int i;
        this.preguntaLabel.setText(String.valueOf(npregunta)+".- "+pregunta);
        //this.altPanel.setLayout(new FlowLayout());
        this.altPanel.setLayout(new GridLayout(alternativas.size(),1));
        this.alternativasCheckBox = new Vector();
        for(i=0; i<this.alternativas.size(); i++) {
            JCheckBox alt = new JCheckBox();
            alt.setText((String) alternativas.elementAt(i));
            this.alternativasCheckBox.add(alt);
            this.altPanel.add(alt, BorderLayout.LINE_START);
        }
        this.explicacionTextArea.setText("");
        this.explicacionButton.setEnabled(false);
        if(this.imagen==null)
            this.imagenButton.setEnabled(false);
        seleccioneLabel.setText("Seleccione "+this.alternativasCorrectas()+" alternativa(s):");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        preguntaLabel = new javax.swing.JLabel();
        explicacionButton = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        explicacionTextArea = new javax.swing.JTextArea();
        altPanel = new javax.swing.JPanel();
        revisarButton = new javax.swing.JButton();
        limpiarButton = new javax.swing.JButton();
        imagenButton = new javax.swing.JButton();
        seleccioneLabel = new javax.swing.JLabel();

        preguntaLabel.setText("preguntaLabel");

        explicacionButton.setText("Explicación");
        explicacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                explicacionButtonActionPerformed(evt);
            }
        });

        explicacionTextArea.setColumns(20);
        explicacionTextArea.setRows(5);
        jScrollPane1.setViewportView(explicacionTextArea);

        altPanel.setLayout(null);

        revisarButton.setText("Revisar");
        revisarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revisarButtonActionPerformed(evt);
            }
        });

        limpiarButton.setText("Limpiar");
        limpiarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarButtonActionPerformed(evt);
            }
        });

        imagenButton.setText("Imágen");
        imagenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagenButtonActionPerformed(evt);
            }
        });

        seleccioneLabel.setText("seleccioneLabel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(altPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(preguntaLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(revisarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limpiarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(explicacionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagenButton, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                    .addComponent(seleccioneLabel, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(preguntaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(seleccioneLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(altPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(revisarButton)
                    .addComponent(limpiarButton)
                    .addComponent(explicacionButton)
                    .addComponent(imagenButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void explicacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_explicacionButtonActionPerformed
        if(this.explicacionButton.isSelected())
            this.explicacionTextArea.setText(this.explicacion);
        else
            this.explicacionTextArea.setText("");
    }//GEN-LAST:event_explicacionButtonActionPerformed

    private void revisarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revisarButtonActionPerformed
        this.revisar();
    }//GEN-LAST:event_revisarButtonActionPerformed

    public void revisar () {
        int i;
        int seleccionadas = 0;
        int ncorrectas = this.alternativasCorrectas();
        for(i=0; i<this.alternativasCheckBox.size(); i++) {
            JCheckBox alt = (JCheckBox) this.alternativasCheckBox.elementAt(i);
            boolean selected = alt.isSelected();
            boolean correcta = (Boolean) correctas.elementAt(i);
            //System.out.println(selected+":"+correcta);
            if(selected) {
                seleccionadas++;
                if(correcta) {
                    alt.setForeground(Color.GREEN);
                    if(seleccionadas<=ncorrectas) {
                        if(!revisadaFlag) this.puntaje += (float) 1/ncorrectas;
                        //System.out.println(this.puntaje);
                    }
                }
                if(!correcta) alt.setForeground(Color.RED);
            } else alt.setForeground(Color.BLACK);
        }
        revisadaFlag = true;
        this.explicacionButton.setEnabled(true);
    }

    private int alternativasCorrectas () {
        int ncorrectas = 0;
        for(int i=0; i<this.correctas.size(); i++)
            if((Boolean) correctas.elementAt(i)) ncorrectas++;
        return ncorrectas;
    }

    private void limpiarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarButtonActionPerformed
        int i;
        for(i=0; i<this.alternativasCheckBox.size(); i++) {
            JCheckBox alt = (JCheckBox) this.alternativasCheckBox.elementAt(i);
            alt.setSelected(false);
            alt.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_limpiarButtonActionPerformed

    private void imagenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagenButtonActionPerformed
        ImagenFrame img = new ImagenFrame(imagen);
    }//GEN-LAST:event_imagenButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel altPanel;
    private javax.swing.JToggleButton explicacionButton;
    private javax.swing.JTextArea explicacionTextArea;
    private javax.swing.JButton imagenButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiarButton;
    private javax.swing.JLabel preguntaLabel;
    private javax.swing.JButton revisarButton;
    private javax.swing.JLabel seleccioneLabel;
    // End of variables declaration//GEN-END:variables

}
