package io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {

	private InputStream _in;
	
	public MyDecompressorInputStream(InputStream in) {
		_in = in;
	}
	
	public byte[] readToByeArray() throws IOException {
		ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
		read(byteArrayOut);
		return byteArrayOut.toByteArray();
	}
	
	public int read(ByteArrayOutputStream byteArrayOut) throws IOException {
		for (int i = 0; i < 9; i++) {
			byteArrayOut.write(_in.read());
		}
		
		int lastByte = _in.read();
		int size = _in.read();
		int count = 9;
		
		while (size!= -1){
			
			for (int i = 0; i < size; i++){
				byteArrayOut.write(lastByte);
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

