package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Imagen {
    public static final int anchoPermitido=1024;
    public static final int altoPermitido=720;
	private Color arreglo[][];
    private int ancho;
    private int alto;
    
	public Imagen(String archivo) {
        int anchoPermitido;
		arreglo = new Color[1024][720];
        cargarImagen(archivo);
    }
	
	public Imagen(){}
	
	public void cargarImagen(String archivo){
        BufferedImage bf=null;
        try {
            bf = ImageIO.read(new File(archivo));
        } catch (IOException ex) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (bf.getWidth()<anchoPermitido) {
            ancho=bf.getWidth();
        }else
            ancho=anchoPermitido;
        if (bf.getHeight()<altoPermitido) {
            alto=bf.getHeight();
        }else
            alto=altoPermitido;
        int cont=0;
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                cont++;
                arreglo[i][j]= new Color(bf.getRGB(j, i));
                //System.out.println(cont +":"+"RedGreenBlue:"+ bf.getRGB(j, i));
            }
        }
    }
	
    public static BufferedImage redimensionar(String archivo, double porcentaje ){
        
        BufferedImage bf = null;
        try {
            bf = ImageIO.read(new File(archivo));
        } catch (IOException ex) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        int ancho = bf.getWidth();
        int alto = bf.getHeight();
        int escalaAncho = (int)(porcentaje* ancho);
        int escalaAlto = (int)(porcentaje*alto);
        BufferedImage bufim = new BufferedImage(escalaAncho, escalaAlto, bf.getType());
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bf, 0,0, escalaAncho,escalaAlto, 0,0,ancho,alto, null);
        g.dispose();
        return bufim;
}
	
	public static ImageIcon redimension(BufferedImage A){
		ImageIcon icono = new ImageIcon(A.getScaledInstance(190, 190, Image.SCALE_SMOOTH));
		return icono;
	}
}
