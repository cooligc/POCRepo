package app;

import java.io.IOException;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.skc.sftp.download.SftpDownload;
import com.skc.sftp.upload.SftpUpload;

public class App {
	
	public static void main(String[] args) throws NumberFormatException, JSchException, SftpException, IOException {
		System.setProperty("sftp.user","bob");
		System.setProperty("sftp.host","192.168.92.128");
		System.setProperty("sftp.port","22");
		System.setProperty("sftp.pwd","bob");
		System.setProperty("sftp.dir","/");
		
		System.out.println("File Uploading Started");
		SftpUpload sftpUpload = new SftpUpload();
		sftpUpload.uploadFile("file/upload/abc.txt");
		
		System.out.println("File successfully uploaded");
		System.out.println("\n\n---------------------------------------");
		System.out.println("File download started");
		
		SftpDownload sftpDownload = new SftpDownload();
		sftpDownload.download("abc.txt");
		
		System.out.println("File successfully downloaded");
		
	}
}
