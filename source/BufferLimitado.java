package source;

import gui.MainWindow;

public class BufferLimitado
{
	final int size = 10;
	int aux_value = 0;
	double buffer[];
	int inBuf = 0, outBuf = 0;
	SemaforoBinario mutex = new SemaforoBinario(true);
	SemaforoContador isEmpty = new SemaforoContador(0);
	SemaforoContador isFull = new SemaforoContador( size );
	
	public BufferLimitado(int consumir, int producir) {
		double buff[] = new double [consumir];
		buffer = buff;
		isFull = new SemaforoContador(consumir);
	}
	
	public void deposit( double value )
	{
		isFull.P(); // espera si el buffer está lleno
		mutex.P(); // asegura la exclusión mutua
		buffer[inBuf] = value;
		inBuf = (inBuf + 1) % size;
		mutex.V();
		isEmpty.V(); // notifica a algún consumidor en espera
		aux_value++;
		if (aux_value>=100){
			aux_value=10;
		}if (aux_value>=90){
			aux_value=9;
		}if (aux_value>=80){
			aux_value=8;
		}if (aux_value>=70){
			aux_value=7;
		}if (aux_value>=60){
			aux_value=6;
		}if (aux_value>=50){
			aux_value=5;
		}if (aux_value>=40){
			aux_value=4;
		}if (aux_value>=30){
			aux_value=3;
		}if (aux_value>=20){
			aux_value=2;
		}if (aux_value>=10){
			aux_value=1;
		}
		MainWindow.barra(aux_value*10);
		MainWindow.semaforo_CV();
		MainWindow.semaforo_PR();
	}
	
	public double fetch()
	{
		double value;
		isEmpty.P(); // esperar si el buffer está vacío
		mutex.P(); // asegura la exclusión mutua
		value = buffer[outBuf]; // lee desde el buffer
		outBuf = (outBuf+1) % size;
		mutex.V();
		isFull.V(); // notifica a cualquier productor en espera
		aux_value--;
		MainWindow.semaforo_CR();
		MainWindow.semaforo_PV();
		if(aux_value>1&&aux_value<3){
			aux_value=2;
		}else
		if(aux_value>2&&aux_value<4){
			aux_value=3;
		}else
		if(aux_value>3&&aux_value<5){
			aux_value=4;
		}else
		if(aux_value>4&&aux_value<6){
			aux_value=5;
		}else
		if(aux_value>5&&aux_value<7){
			aux_value=6;
		}else
		if(aux_value>6&&aux_value<8){
			aux_value=7;
		}else
		if(aux_value>7&&aux_value<9){
			aux_value=8;
		}else
		if(aux_value>8&&aux_value>10){
			aux_value=9;
		}else
		if(aux_value>10){
			aux_value=9;
		}else
		if(aux_value<2)
			aux_value=2;
		
		MainWindow.barra(aux_value*10);
		return value;
	}
	
	public int return_auxvalue(){
		return aux_value;
	}
	/*public static void main(String[] args) {
		System.out.println("HIHI\nHIHI");
		
		// SEMAFORO BINARIO
		SemaforoBinario mutex = new SemaforoBinario(true);
		mutex.P();
		mutex.CR();
		mutex.V();		
		// SEMAFORO CONTADOR

	}*/
}

	
	