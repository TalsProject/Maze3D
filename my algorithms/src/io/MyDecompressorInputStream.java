package io;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {

	private InputStream _in;
	
	public MyDecompressorInputStream(InputStream in) {
		_in = in;
	}
	
	@Override
	public int read(byte[] b) throws IOException {
		
		_in.read(b,0,9);
		
		int lastByte = _in.read();
		int size = _in.read();
		int count = 9;
		
		while (size!= -1){
			
			for (int i = 0; i < size; i++){
			
				b[count] = (byte) lastByte;
				count++;
			}
		
			lastByte = _in.read();
			size = _in.read();
		}
			
		return count + 1;
	}

	
	@Override
	public int read() throws IOException {
		return _in.read();
	}


}

