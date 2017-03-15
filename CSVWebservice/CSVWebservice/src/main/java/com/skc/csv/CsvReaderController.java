package com.skc.csv;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/read")
public class CsvReaderController {

	@GetMapping("/csv/{fileName}")
	public List<Book> readCsv(@PathVariable("fileName") String fileName){
		return CSVUtils.readCsv(fileName+".csv");
	}
	
	@GetMapping("/test")
	public String test(){
		return "Hello World";
	}
}
