package testIOStreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TestStreamApp {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("E:\\workspace_adi\\TestInput.txt");
			BufferedInputStream bin = new BufferedInputStream(fin);
			int i;
			while ((i = bin.read()) != -1) { // i gives Ascii value of each
												// character in the text file
				System.out.print((char) i);
			}
			bin.close();
			fin.close();
			System.out.println("\n------------------------------\n");
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			FileInputStream fin = new FileInputStream("E:\\workspace_adi\\TestInput.txt");
			BufferedInputStream bin = new BufferedInputStream(fin);
			FileOutputStream fout = new FileOutputStream("E:\\workspace_adi\\TestOutput.txt");
			BufferedOutputStream bout = new BufferedOutputStream(fout);

			byte barr[] = new byte[10]; // this array read max 10 bytes at a
										// time from the file
			System.out.println("Inital values of the byte array");

			for (int j = 0; j < barr.length; j++) {
				System.out.print(barr[j] + ",");
			}
			System.out.println();

			int i;
			while ((i = bin.read(barr)) != -1) { // i returns number of bytes
													// read and the array barr
													// will get the bytes from
													// file

				System.out.println("No. of characters read = " + i);
				System.out.println("Values updated in byte array");
				for (int j = 0; j < 10; j++) {
					System.out.print(barr[j] + ",");
				}

				System.out.println();

				for (int j = 0; j < 10; j++) {
					int asciiCode = barr[j];
					System.out.print((char) asciiCode);
				}
				System.out.println();

				bout.write(barr);
				bout.flush();


			}
			bin.close();
			fin.close();
			bout.close();
			fout.close();
		} catch (Exception e) {
			System.out.println(e);
		}

//		try {
//			FileOutputStream fout = new FileOutputStream("E:\\workspace_adi\\TestOutput.txt");
//			BufferedOutputStream bout = new BufferedOutputStream(fout);
//			String s = "Welcome to javaTpoint.";
//			byte b[] = s.getBytes();
//			bout.write(b);
//			bout.flush();
//			bout.close();
//			fout.close();
//			System.out.println("success");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
