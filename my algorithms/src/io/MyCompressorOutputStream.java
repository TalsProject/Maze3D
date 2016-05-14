package io;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {

	private OutputStream _out;
	
	public MyCompressorOutputStream(OutputStream out) {
		_out = out;
	}
	
	@Override
	public void write(int arg0) throws IOException {		
		_out.write(arg0);
	}

	@Override
	public void write(byte[] b) throws IOException {
		
		for (int j = 0; j < 9; j ++){
			_out.write(b[j]);
			
		}
		
		
		byte lastByte = b[9];
		int count = 1;
		
		for (int i = 10; i < b.length; i++) {
			if (b[i] == lastByte) {
				count++;
			} 
			else {
				while (count > 255) {
					_out.write(lastByte);
					_out.write(255);
					count -= 255;
				}				
				 
				_out.write(lastByte); 
				_out.write(count);
				
				lastByte = b[i];
				count = 1;
			}
		}		
		
		// write the last byte
		while (count > 255) {
			_out.write(lastByte);
			_out.write(255);
			count -= 255;
		}				
		_out.write(lastByte);
		_out.write(count);
	}	

}