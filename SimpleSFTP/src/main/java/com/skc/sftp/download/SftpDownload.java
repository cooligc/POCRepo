package com.skc.sftp.download;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SftpDownload {
	public void download(String remoteFile) throws NumberFormatException, JSchException, SftpException, IOException {
		JSch jsch = new JSch();
		Session session = jsch.getSession(System.getProperty("sftp.user"), System.getProperty("sftp.host"),
				Integer.valueOf(System.getProperty("sftp.port")));
		session.setPassword(System.getProperty("sftp.pwd"));
		session.setConfig("StrictHostKeyChecking", "no");
		System.out.println("Establishing Connection...");
		session.connect(4000);
		System.out.println("Connection established.");
		System.out.println("Crating SFTP Channel.");
		ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
		sftpChannel.connect();
		System.out.println("SFTP Channel created.");
		InputStream out = null;
		out = sftpChannel.get(remoteFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(out));
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
		sftpChannel.disconnect();
		session.disconnect();
	}
}
