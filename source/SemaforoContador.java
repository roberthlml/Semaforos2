package source;

import gui.MainWindow;

public class SemaforoContador { 
	int value; 
	
	public SemaforoContador( int initValue ) { 
		value = initValue;
		} 
	
	public synchronized void P() { 
		value--; 
		if( value < 0 ) {
			MainWindow.separadores_P();
			MainWindow.separadores_CV();
			Util.myWait( this );
		}
	} 
	
	public synchronized void V() { 
		value++;
		if( value <= 0 ){
			MainWindow.separadores_C();
			MainWindow.separadores_PV();
			notify();
		}
	}
	
	public int return_value(){
		return value;
	}
}