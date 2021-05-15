package Practico3.ImagenTransformada;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Practico3.Imagenes.Modelo;

public class Imagenes extends Transformacion {
    private BufferedImage imagen = null;
    private int color;
    private JFileChooser chooser = new JFileChooser();
    private boolean aprobacion;

    public Imagenes(Modelo mdl) {
        modeloBase = mdl;
    }

    @Override
    public void hacer() {
        try {
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Tipo de archivo imagen", "jpg", "png", "gif");
            chooser.setDialogTitle("Escoge una imagen...");
            chooser.setFileFilter(filtro);
            int validarArchivo = chooser.showOpenDialog(null);
            if (validarArchivo == JFileChooser.APPROVE_OPTION) {
                imagen = ImageIO.read(chooser.getSelectedFile());
                if (imagen.getWidth() == 600 && imagen.getHeight() == 400)
                    aprobacion = true;
                else
                    JOptionPane.showMessageDialog(null, "Debe tener un ancho de 600 y un alto de 400");
            }

            if (aprobacion) {
                int ancho1 = modeloBase.getAncho();
                int alto1 = modeloBase.getAlto();
                for (int i = 0; i < ancho1; i++) {
                    for (int j = 0; j < alto1; j++) {
                        color = imagen.getRGB(i, j);
                        modeloBase.setPixel(color, i, j);
                    }
                }
                modeloBase.cambioOk();
                aprobacion = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
