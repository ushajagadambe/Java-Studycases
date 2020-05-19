package fileExample;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamExample {
public static void main(String[] args) {
	FileInputStream in;
	try {
		in = new FileInputStream("test.txt");
		BufferedInputStream binput=new BufferedInputStream(in);
		int ch;
		while((ch=binput.read())!=-1)
		{
			System.out.print((char)ch);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
