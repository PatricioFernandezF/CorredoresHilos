package Logica;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Interfaz.Principal;

public class Corredor extends Thread {
	
	public int espera;
	public int x,y;
	public int posicion;
	public Equipo equipo;

	public JLabel corredor;
	
	public Corredor(int x, int y,int pos,Equipo equipo) {
		super();
		this.x = x;
		this.y = y;
		this.posicion=pos;
		this.equipo=equipo;
		
		corredor = new JLabel("");
		corredor.setIcon(new ImageIcon(Principal.class.getResource("/Resources/corredor.png")));
		corredor.setBounds(x, y, 65, 97);
		Principal.anadirCorredor(corredor);
		
		Random r=new Random();
		espera=r.nextInt(1000);
				
	}

	public void run() {
		
		System.out.println("El corredor "+posicion+" del equipo "+equipo.id+" ha empezado su carrera");
		

		while(x<equipo.posx[posicion])
		{
			try {
				x=x+10;
				Thread.sleep(espera);
				corredor.setBounds(x,y,65,97);
				//System.out.println("Posicion "+x);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("El corredor "+posicion+" ha terminado su carrera");
		if(posicion<3)
			equipo.relevo();
		
	}
	

}
