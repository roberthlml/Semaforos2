package source;

import java.util.Random; 
public class Productor implements Runnable { 
	BufferLimitado b = null; 
	int x=0;
	int time;
	public Productor( BufferLimitado initb, int _time) {
		b 		= initb; 
		time	= _time;
		new Thread( this ).start(); 
	}
	
	public void run() { 
			double item; 
			Random r = new Random(); 
			while( true ) { 
			item = r.nextDouble(); 
			System.out.println( "Artículo producido " + item ); 
			b.deposit( item ); 
			x++;
			Util.mySleep(time); 
		} 
	}
	
	public int return_x(){
		return x;
	}
}
