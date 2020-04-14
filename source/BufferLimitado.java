package source;

public class BufferLimitado
{
	final int size = 10;
	int aux_value = 1;
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
	}
	
	public double fetch()
	{
		aux_value--;
		double value;
		isEmpty.P(); // esperar si el buffer está vacío
		mutex.P(); // asegura la exclusión mutua
		value = buffer[outBuf]; // lee desde el buffer
		outBuf = (outBuf+1) % size;
		mutex.V();
		isFull.V(); // notifica a cualquier productor en espera
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

	
	