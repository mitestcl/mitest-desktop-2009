package mitest;

import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author delaf
 */
public class ImagenFrame extends JFrame {

    public ImagenFrame (String rutaImagen) {
        this.setTitle(rutaImagen);
        this.setLayout(new FlowLayout());
        Icon imgIcon = new ImageIcon (rutaImagen);
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(imgIcon);
        this.add(imgLabel);
        this.setVisible(true);
        this.pack();
    }

}
