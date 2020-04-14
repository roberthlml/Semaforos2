package source;

public class Consumidor implements Runnable { 
	BufferLimitado b = null;
	int time;
	int x;
	
	public Consumidor( BufferLimitado initb , int _time) {
		b 		= initb; 
		time	= _time;
		new Thread( this ).start(); 
	}
	
	public void run() { 
		double item; 
		while( true ) { 
			item = b.fetch(); 
			x++;
			System.out.println( "Artículo extraído " + item ); 
			
			Util.mySleep(time); 
			} 
		}
	
	public int return_x(){
		return x;
	}
}