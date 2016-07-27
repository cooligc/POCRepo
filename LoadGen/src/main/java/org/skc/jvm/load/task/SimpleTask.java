package org.skc.jvm.load.task;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class SimpleTask implements Runnable {
	private static final Logger LOGGER = Logger.getLogger(SimpleTask.class);

	public void run() {
		
		
//		File file = new File(System.getProperty("user.home")+"/heapdump-1468907126509-when-dead-locked-detected.hprof");
		File file = new File(System.getProperty("user.home")+"/README.txt");
		LOGGER.info("Loaded file name "+file.getPath());
		
		try {
			byte[] bytes = FileUtils.readFileToByteArray(file);
			LOGGER.info("File details "+bytes);
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
		/*FileInputStream fin = null;
		try {
			fin = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		}
		LOGGER.info(file.length());

		int content;
		int i = 0;
		int j = 0;
		try {
			while ((content = fin.read()) != -1) {
				++j;
				i += 10;
				LOGGER.info(" .");
				if (j % 10 == 0) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						LOGGER.error(e);
					}
				}
			}
		} catch (IOException e) {
			LOGGER.error(e);
		}*/
	}

}
