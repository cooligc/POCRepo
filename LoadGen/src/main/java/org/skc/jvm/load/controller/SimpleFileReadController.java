package org.skc.jvm.load.controller;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/readFile")
public class SimpleFileReadController {
	
	public static final ConcurrentHashMap<AtomicLong, File> MAPS = new ConcurrentHashMap<AtomicLong, File>();
	
	public String loadFiles(){
		return "File is loaded";
	}

}
