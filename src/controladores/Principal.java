package controladores;

import javax.swing.UIManager;

public class Principal {
	
	public static VentanaPrincipalControlador instanciaPrincipalControlador;
	
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			instanciaPrincipalControlador = new VentanaPrincipalControlador();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}