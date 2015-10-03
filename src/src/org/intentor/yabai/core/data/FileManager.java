package org.intentor.yabai.core.data;

import org.intentor.yabai.util.StringUtils;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Reads and writes to files.
 */
public class FileManager {
	/** File name. */
	private final String fileName;
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param fileName File name.
	 */
	public FileManager(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Writes a String to the file.
	 * 
	 * @param data String to write.
	 */
	public void write(String data) {
		try {
            File file = new File(this.fileName);
            FileOutputStream output = new FileOutputStream(file);
			
			byte[] bytes = StringUtils.getBytes(data);
			
			for (int i = 0; i < bytes.length - 1; i++){
				output.write((int)bytes[i]);
			}
        	
            output.close();
        } catch (IOException ex){
			System.out.println(ex.getMessage());
        }
	}
	
	/**
	 * Reads a String from the file.
	 * 
	 * @return String read.
	 */
	public String read() {
		StringBuilder builder = new StringBuilder();
			
		try {
            File file = new File(this.fileName);
			InputStream stream = new FileInputStream(file);
			DataInputStream input = new DataInputStream(stream);
			
			char ch;			
			while (input.available() > 0) {
				ch = (char)input.readByte();
				builder.append(ch);
			} 
			
			input.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
		return builder.toString();
	}
}