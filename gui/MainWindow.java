package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

import source.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class MainWindow {

	private JFrame frmProductorconsumidor;
	static JProgressBar progressBar = new JProgressBar();
	
	static JLabel lbl_semaforoProducor = new JLabel("SemaforoProductor");
	static JLabel lbl_SemaforoConsumidor = new JLabel("[SemaforoConsumidor]");
	static JLabel lblSemaforoBuffer = new JLabel("[Semaforo Buffer]");
	
	final static ImageIcon imgR = new ImageIcon("C:\\Users\\rober\\OneDrive\\Documents\\Eclipse\\Practica_9\\src\\imagenes\\semaforo_R.png");
	static Image img_R = imgR.getImage();
	
	
	static ImageIcon imgV = new ImageIcon("C:\\Users\\rober\\OneDrive\\Documents\\Eclipse\\Practica_9\\src\\imagenes\\semaforo_V.png");
	static Image img_V = imgV.getImage();
	
	
	static ImageIcon imgBR = new ImageIcon("C:\\Users\\rober\\OneDrive\\Documents\\Eclipse\\Practica_9\\src\\imagenes\\semaforo_R.png");
	static Image img_BR = imgR.getImage();

	//IMAGENES
	
	
			//ROJO
			ImageIcon ii = new ImageIcon("C:\\Users\\rober\\OneDrive\\Documents\\Eclipse\\Practica_9\\src\\imagenes\\semaforo_R.png");
			Image img = ii.getImage();
		
			
			//VERDE
			ImageIcon oo = new ImageIcon("C:\\Users\\rober\\OneDrive\\Documents\\Eclipse\\Practica_9\\src\\imagenes\\semaforo_V.png");
			Image imgv = oo.getImage();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmProductorconsumidor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		
		initialize();
	}
	
	public static void barra(int i){
		progressBar.setValue(i);;
	}
	
	public static void barra_menos(int i){
		progressBar.setValue(i);;
	}
	
	public static void semaforo_PR(){
		final Image RojoSPB				= img_R.getScaledInstance(lbl_semaforoProducor.getWidth(), lbl_semaforoProducor.getHeight(), Image.SCALE_SMOOTH);
		final ImageIcon Rojo_SPB		= new ImageIcon(RojoSPB);
		lbl_semaforoProducor.setIcon(Rojo_SPB);
	}
	
	public static void semaforo_CR(){
		final Image RojoSVC				= img_R.getScaledInstance(lbl_SemaforoConsumidor.getWidth(), lbl_SemaforoConsumidor.getHeight(), Image.SCALE_SMOOTH);
		final ImageIcon Rojo_SVC		= new ImageIcon(RojoSVC);
		lbl_SemaforoConsumidor.setIcon(Rojo_SVC);
	}
	
	public static void buffer_R(){
		final Image RojoB			= img_BR.getScaledInstance(lblSemaforoBuffer.getWidth(), lblSemaforoBuffer.getHeight(), Image.SCALE_SMOOTH);
		final ImageIcon Rojo_B		= new ImageIcon(RojoB);
		lblSemaforoBuffer.setIcon(Rojo_B);
	}
	
	public static void semaforo_CV(){
		final Image VerdeV			= img_V.getScaledInstance(lbl_SemaforoConsumidor.getWidth(), lbl_SemaforoConsumidor.getHeight(), Image.SCALE_SMOOTH);
		final ImageIcon Verde		= new ImageIcon(VerdeV);
		lbl_SemaforoConsumidor.setIcon(Verde);
	}
	
	public static void semaforo_PV(){
		final Image VerdeV			= img_V.getScaledInstance(lbl_semaforoProducor.getWidth(), lbl_semaforoProducor.getHeight(), Image.SCALE_SMOOTH);
		final ImageIcon Verde		= new ImageIcon(VerdeV);
		lbl_semaforoProducor.setIcon(Verde);
	}
	
	public static void semaforo_B(){
		final Image BVerde			= img_V.getScaledInstance(lblSemaforoBuffer.getWidth(), lblSemaforoBuffer.getHeight(), Image.SCALE_SMOOTH);
		final ImageIcon Verde		= new ImageIcon(BVerde);
		lblSemaforoBuffer.setIcon(Verde);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProductorconsumidor = new JFrame();
		frmProductorconsumidor.setFont(new Font("Serif", Font.PLAIN, 14));
		frmProductorconsumidor.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rober\\Dropbox\\Computo Distribuido- te quiero liz\\Parte1\\Imagenes\\-800x600\\salida2.jpg"));
		frmProductorconsumidor.setResizable(false);
		frmProductorconsumidor.setTitle("Productor-Consumidor");
		frmProductorconsumidor.setBounds(100, 100, 769, 469);
		frmProductorconsumidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProductorconsumidor.getContentPane().setLayout(null);
		
		JLabel lblProcesoConsumidor = new JLabel("Proceso Consumidor");
		lblProcesoConsumidor.setFont(new Font("Serif", Font.PLAIN, 12));
		lblProcesoConsumidor.setBounds(33, 11, 110, 30);
		frmProductorconsumidor.getContentPane().add(lblProcesoConsumidor);
		
		JLabel lblProcesoProductor = new JLabel("Proceso Productor");
		lblProcesoProductor.setFont(new Font("Serif", Font.PLAIN, 12));
		lblProcesoProductor.setBounds(615, 11, 110, 30);
		frmProductorconsumidor.getContentPane().add(lblProcesoProductor);
		
		
		
		
		JLabel lblimgConsumidor = new JLabel("[IMG CONSUMIDOR]");
		lblimgConsumidor.setBounds(43, 52, 71, 52);
		frmProductorconsumidor.getContentPane().add(lblimgConsumidor);
		ImageIcon imgThisImg = new ImageIcon("C:\\Users\\rober\\OneDrive\\Documents\\Eclipse\\Practica_9\\src\\imagenes\\creeper.png");
		lblimgConsumidor.setIcon(imgThisImg);
		
		JLabel lblimgProductor = new JLabel("[IMG PRODUCTOR]");
		lblimgProductor.setBounds(625, 52, 71, 52);
		ImageIcon imgThisImg1 = new ImageIcon("C:\\Users\\rober\\OneDrive\\Documents\\Eclipse\\Practica_9\\src\\imagenes\\steve.jpg");
		lblimgProductor.setIcon(imgThisImg1);
		frmProductorconsumidor.getContentPane().add(lblimgProductor);
		
		
		lbl_semaforoProducor.setBounds(503, 23, 83, 140);
		Image ROJO 		= img.getScaledInstance(lbl_semaforoProducor.getWidth(), lbl_semaforoProducor.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon SR	= new ImageIcon(ROJO);
	    lbl_semaforoProducor.setIcon(SR);
		frmProductorconsumidor.getContentPane().add(lbl_semaforoProducor);
		
		
		lbl_SemaforoConsumidor.setBounds(162, 20, 83, 147);
		lbl_SemaforoConsumidor.setIcon(SR);
		frmProductorconsumidor.getContentPane().add(lbl_SemaforoConsumidor);
		
		
		lblSemaforoBuffer.setBounds(357, 352, 64, 88);
		Image ROJOB		= img.getScaledInstance(lblSemaforoBuffer.getWidth(), lblSemaforoBuffer.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon SRB	= new ImageIcon(ROJOB);
		lblSemaforoBuffer.setIcon(SRB);
		frmProductorconsumidor.getContentPane().add(lblSemaforoBuffer);
		
		
		progressBar.setBounds(221, 319, 316, 14);
		frmProductorconsumidor.getContentPane().add(progressBar);
		
		JLabel lblElemento = new JLabel("Elemento");
		lblElemento.setBounds(199, 300, 59, 14);
		frmProductorconsumidor.getContentPane().add(lblElemento);
		
		JLabel lblVacio = new JLabel("Vacio");
		lblVacio.setBounds(521, 300, 33, 14);
		frmProductorconsumidor.getContentPane().add(lblVacio);
		
		JSeparator separator_P1 = new JSeparator();
		separator_P1.setForeground(Color.DARK_GRAY);
		separator_P1.setBackground(Color.DARK_GRAY);
		separator_P1.setBounds(430, 395, 224, 2);
		frmProductorconsumidor.getContentPane().add(separator_P1);
		
		JSeparator separator_P2 = new JSeparator();
		separator_P2.setOrientation(SwingConstants.VERTICAL);
		separator_P2.setForeground(Color.DARK_GRAY);
		separator_P2.setBackground(Color.DARK_GRAY);
		separator_P2.setBounds(652, 115, 2, 282);
		frmProductorconsumidor.getContentPane().add(separator_P2);
		
		JSeparator separator_C1 = new JSeparator();
		separator_C1.setForeground(Color.DARK_GRAY);
		separator_C1.setBackground(Color.DARK_GRAY);
		separator_C1.setBounds(73, 395, 274, 2);
		frmProductorconsumidor.getContentPane().add(separator_C1);
		
		JSeparator separator_C2 = new JSeparator();
		separator_C2.setForeground(Color.DARK_GRAY);
		separator_C2.setBackground(Color.DARK_GRAY);
		separator_C2.setOrientation(SwingConstants.VERTICAL);
		separator_C2.setBounds(73, 115, 2, 282);
		frmProductorconsumidor.getContentPane().add(separator_C2);
		
		JSpinner spinner_consumos = new JSpinner();
		spinner_consumos.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner_consumos.setBounds(339, 68, 40, 20);
		frmProductorconsumidor.getContentPane().add(spinner_consumos);
		
		JSpinner spinner_productos = new JSpinner();
		spinner_productos.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner_productos.setBounds(339, 124, 40, 20);
		frmProductorconsumidor.getContentPane().add(spinner_productos);
		
		JLabel lbl_Nconsumos = new JLabel("Articulos p/Consumir");
		lbl_Nconsumos.setBounds(310, 43, 134, 14);
		frmProductorconsumidor.getContentPane().add(lbl_Nconsumos);
		
		JLabel lblArticulosPproducir = new JLabel("Articulos p/Producir");
		lblArticulosPproducir.setBounds(310, 99, 134, 14);
		frmProductorconsumidor.getContentPane().add(lblArticulosPproducir);
		
		JLabel lblTiempoDeProduccion = new JLabel("Tiempo de Produccion");
		lblTiempoDeProduccion.setBounds(310, 155, 134, 14);
		frmProductorconsumidor.getContentPane().add(lblTiempoDeProduccion);
		
		JLabel lblTiempoConsumo = new JLabel("Tiempo de Consumo");
		lblTiempoConsumo.setBounds(310, 208, 134, 14);
		frmProductorconsumidor.getContentPane().add(lblTiempoConsumo);
		
		JSpinner spinner_TConsumo = new JSpinner();
		spinner_TConsumo.setModel(new SpinnerNumberModel(0, null, 10000, 100));
		spinner_TConsumo.setBounds(339, 233, 40, 20);
		frmProductorconsumidor.getContentPane().add(spinner_TConsumo);
		
		JSpinner spinner_TProduccion = new JSpinner();
		spinner_TProduccion.setModel(new SpinnerNumberModel(0, null, 10000, 100));
		spinner_TProduccion.setBounds(339, 180, 40, 20);
		frmProductorconsumidor.getContentPane().add(spinner_TProduccion);
		
		//SEMAFOROS VERDES
		
		//BUFFER
		Image VERDEB		= imgv.getScaledInstance(lblSemaforoBuffer.getWidth(), lblSemaforoBuffer.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon SVB		= new ImageIcon(VERDEB);
		
		
		//PRODUCTOR_CONSUMIDOR
		Image VERDE 		= imgv.getScaledInstance(lbl_semaforoProducor.getWidth(), lbl_semaforoProducor.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon SV		= new ImageIcon(VERDE);
		
		
		JButton btnComenzar = new JButton("COMENZAR");
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(spinner_TConsumo.getValue().toString());
				System.out.println(spinner_TProduccion.getValue().toString());
				System.out.println(spinner_productos.getValue());
				System.out.println(spinner_consumos.getValue());
				
				lbl_SemaforoConsumidor.setIcon(SV);
				lbl_semaforoProducor.setIcon(SR);
				lblSemaforoBuffer.setIcon(SVB);
				
				BufferLimitado	buffer	 		= new BufferLimitado((Integer)spinner_productos.getValue(),(Integer)spinner_productos.getValue()); 
				Productor		productor 		= new Productor( buffer , (Integer) spinner_productos.getValue()); 
				Consumidor 		consumidor		= new Consumidor( buffer , (Integer) spinner_TConsumo.getValue()); 
				
				
			}
		});
		btnComenzar.setBounds(310, 264, 113, 23);
		frmProductorconsumidor.getContentPane().add(btnComenzar);
		
		
	}
}


/*
//SEPARADORES PRODUCTOR
 * 
 *
separator_P1.setBackground(Color.RED);
separator_P2.setBackground(Color.RED);
separator_P1.setForeground(Color.RED);
separator_P2.setForeground(Color.RED);
//SEPARADORES CONSUMIDOR
 * 
 * 
separator_C1.setBackground(Color.RED);
separator_C2.setBackground(Color.RED);
separator_C1.setForeground(Color.RED);
separator_C2.setForeground(Color.RED);

//ICONO SEMAFOROS VERDES
 * 
 *  
lbl_SemaforoConsumidor.setIcon(SV);
lbl_semaforoProducor.setIcon(SV);
lblSemaforoBuffer.setIcon(SVB);

//ICONO SEMAFOROS ROJOS
 * 
 * 
lbl_SemaforoConsumidor.setIcon(SR);
lbl_semaforoProducor.setIcon(SR);
lblSemaforoBuffer.setIcon(SRB);


*/

