package Practico2.ImagenesTransformadas;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Practico2.Imagenes.Modelo;

public class Imagenes extends Transformacion {
    private BufferedImage imagen1;
    private BufferedImage imagen2 = null;
    private Color color1;
    private Color color2;
    private final static Logger logger = LogManager.getLogger();
    private final JFileChooser chooser = new JFileChooser();
    private File archivo1;
    private File archivo2;
    private boolean aprobacion;

    public Imagenes(Modelo modelo) {
        modeloBase = modelo;
    }

    @Override
    public void hacer1() {
        try {
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Tipo de archivo imagen", "jpg", "png", "gif");
            chooser.setDialogTitle("Escoge una imagen...");
            chooser.setFileFilter(filtro);
            int validarArchivo = chooser.showOpenDialog(null);
            if (validarArchivo == JFileChooser.APPROVE_OPTION) {
                imagen1 = ImageIO.read(chooser.getSelectedFile());
                archivo1 = chooser.getSelectedFile();
                if (imagen1.getWidth() == 600 && imagen1.getHeight() == 400)
                    aprobacion = true;
                else
                    JOptionPane.showMessageDialog(null, "Debe tener un ancho de 600 y un alto de 400");
            }

            if (aprobacion) {
                int ancho1 = modeloBase.getAncho();
                int alto1 = modeloBase.getAlto();

                for (int i = 0; i < ancho1 - 400; i++) {
                    for (int j = 0; j < alto1; j++) {
                        color1 = new Color(imagen1.getRGB(i, j));
                        int red = color1.getRed() << 16;
                        int green = color1.getGreen() << 8;
                        int blue = color1.getBlue();
                        modeloBase.setPixel(red | green | blue, i, j);
                    }
                }

                for (int i = ancho1 - 400; i < ancho1 - 200; i++) {
                    for (int j = 0; j < alto1; j++) {
                        color1 = new Color(imagen1.getRGB(i,j));
                        int red = (color1.getRed() << 16) / 2;
                        int green = (color1.getGreen() << 8) / 2;
                        int blue = color1.getBlue() / 2;
                        int alpha = color1.getAlpha() & (255 | 16 | 255 << 8 | 255);
                        modeloBase.setPixel(red | green | blue, i, j);
                    }
                }

                for (int i = ancho1 - 200; i < ancho1; i++) {
                    for (int j = 0; j < alto1; j++) {
                        color1 = new Color(0);
                        modeloBase.setPixel(color1.getRGB(), i, j);
                    }
                }
                modeloBase.cambioOk();
                aprobacion = false;
                logger.info("En este metodo asignamos los colores que habra en cada pixel");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hacer2() {
        try {
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Tipo de archivo imagen", "jpg", "png", "gif");
            chooser.setDialogTitle("Escoge una imagen...");
            chooser.setFileFilter(filtro);
            int validarArchivo = chooser.showOpenDialog(null);
            if (validarArchivo == JFileChooser.APPROVE_OPTION) {
                imagen2 = ImageIO.read(chooser.getSelectedFile());
                archivo2 = chooser.getSelectedFile();
                if (imagen2.getWidth() == 600 && imagen2.getHeight() == 400)
                    aprobacion = true;
                else
                    JOptionPane.showMessageDialog(null, "Debe tener un ancho de 600 y un alto de 400");
            }

            int ancho2 = modeloBase.getAncho();
            int alto2 = modeloBase.getAlto();

            if (aprobacion) {
                for (int i = 0; i < ancho2 - 400; i++) {
                    for (int j = 0; j < alto2; j++) {
                        color2 = new Color(0);
                        modeloBase.setPixel(color2.getRGB(), i, j);
                    }
                }

                for (int i = ancho2 - 400; i < ancho2 - 200; i++) {
                    for (int j = 0; j < alto2; j++) {
                        color2 = new Color(imagen1.getRGB(i, j));
                        int red = color2.getRed() / 2;
                        int green = color2.getGreen() / 2;
                        int blue = color2.getBlue() / 2;
                        int alpha = color2.getAlpha() / 2;
                        modeloBase.setPixel(red | green | blue | alpha, i, j);
                    }
                }

                for (int i = ancho2 - 200; i < ancho2; i++) {
                    for (int j = 0; j < alto2; j++) {
                        color2 = new Color(imagen1.getRGB(i, j));
                        int red = color2.getRed();
                        int green = color2.getGreen();
                        int blue = color2.getBlue();
                        modeloBase.setPixel(red | green | blue, i, j);
                    }
                }
                modeloBase.cambioOk();
                aprobacion = false;
                logger.info("En este metodo asignamos los colores que habra en cada pixel");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void hacer3() {
        if (imagen1 != null && imagen2 != null) {
            try {
                imagen1 = ImageIO.read(archivo1);
                imagen2 = ImageIO.read(archivo2);
                int ancho1 = modeloBase.getAncho();
                int alto1 = modeloBase.getAlto();

                int ancho2 = modeloBase.getAncho();
                int alto2 = modeloBase.getAlto();

                for (int i = 0; i < ancho1 - 400; i++) {
                    for (int j = 0; j < alto1; j++) {
                        color1 = new Color(imagen1.getRGB(i, j));
                        int red = color1.getRed();
                        int green = color1.getGreen();
                        int blue = color1.getBlue();
                        modeloBase.setPixel(red | green | blue, i, j);
                    }
                }

                for (int i = ancho2 - 400; i < ancho2 - 200; i++) {
                    for (int j = 0; j < alto2; j++) {
                        color1 = new Color(imagen1.getRGB(i, j));
                        color2 = new Color(imagen2.getRGB(i, j));
                        int red = color1.getRed() / 2 + color2.getRed() / 2;
                        int green = color1.getGreen() / 2 + color2.getGreen() / 2;
                        int blue = color1.getBlue() / 2 + color2.getBlue() / 2;
                        int alpha = color1.getAlpha() + color2.getAlpha() / 2;
                        modeloBase.setPixel(red | green | blue | alpha, i, j);
                    }
                }

                for (int i = ancho2 - 200; i < ancho2; i++) {
                    for (int j = 0; j < alto2; j++) {
                        color2 = new Color(imagen2.getRGB(i, j));
                        int red = color2.getRed();
                        int green = color2.getGreen();
                        int blue = color2.getBlue();
                        modeloBase.setPixel(red | green | blue, i, j);
                    }
                }
                modeloBase.cambioOk();
                logger.info("En este metodo asignamos los colores que habra en cada pixel");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            JOptionPane.showMessageDialog(null, "Debe cargar 2 imagenes para obtener la imagen resultante");
    }
}

