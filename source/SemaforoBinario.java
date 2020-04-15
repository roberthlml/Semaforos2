package source;

import gui.MainWindow;

public class SemaforoBinario { 
	boolean value; 
	SemaforoBinario( boolean initValue ) { 
		value = initValue; 
		System.out.println("hola "+initValue);
		} 
	public synchronized void P() { 
		MainWindow.separadores_P();
		MainWindow.separadores_CV();
		while( value == false ) 
			Util.myWait(this); //en cola de procesos bloqueados 
		value = false;
	} 
	
	public synchronized void V() { 
		MainWindow.separadores_C();
		MainWindow.separadores_PV();
		value = true;
		notify();
	}
	
	public synchronized void CR(){
		System.out.println("ESTOY EN LA ZONA CRITICA: ");
	}

}

