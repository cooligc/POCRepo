package org.skc.jvm.load.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SimpleTask implements Runnable {

	public void run() {
		File file = new File("C:/abc.txt");
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(file.length());

		int content;
		int i = 0;
		int j = 0;
		try {
			while ((content = fin.read()) != -1) {
				++j;
				i += 10;
				System.out.print(" .");
				if (j % 10 == 0) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
