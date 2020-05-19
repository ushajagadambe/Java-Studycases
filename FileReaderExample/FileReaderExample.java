package fileExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
public static void main(String[] args) {
	File f=new File("test.txt");
		try {
			FileInputStream fi=new FileInputStream(f);
			int ch;
			while((ch=fi.read())!=-1)
			{
				System.out.println((char)ch);
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
}
