package com.skc.sftp.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SftpUpload {
	
	public void uploadFile(String path) throws NumberFormatException, JSchException, SftpException, FileNotFoundException{
		JSch jSch = new JSch();
		Session session = jSch.getSession(System.getProperty("sftp.user"), System.getProperty("sftp.host"), Integer.valueOf(System.getProperty("sftp.port")));
		session.setPassword(System.getProperty("sftp.pwd"));
		session.setConfig("StrictHostKeyChecking", "no");
        System.out.println("Establishing Connection...");
        session.connect();
        System.out.println("Connection established.");
        System.out.println("Crating SFTP Channel.");
        Channel channel =  session.openChannel("sftp");
        ChannelSftp sftpChannel = (ChannelSftp) channel;
        sftpChannel.connect(4000);
        sftpChannel.cd(System.getProperty("sftp.dir"));
        File file = new File(this.getClass().getClassLoader().getResource(path).getFile());
        sftpChannel.put(new FileInputStream(file),file.getName());
	}

}
