package com.skc.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.log4j.Logger;

public class CSVUtils {

	private static final Logger LOGGER = Logger.getLogger(CSVUtils.class);
	
	private static final String[] FILE_HEADER_MAPPING = { "id", "bookName", "authorName", "isbn","content"};

	@SuppressWarnings("resource")
	public static final List<Book> readCsv(String fileName) {
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
		List<Book> books = new ArrayList<>();
		try(Reader reader = new FileReader(readFile(fileName))){
			new CSVParser(reader, csvFileFormat).getRecords().forEach(csvRecord->{
				Map<String,String> content = new HashMap<>();
				content.put("booksFor",csvRecord.get(4));
				books.add(new Book(Long.valueOf(csvRecord.get(0)), csvRecord.get(1), csvRecord.get(2), csvRecord.get(3),content));
			});
			LOGGER.info("List of books are "+books);
		} catch (FileNotFoundException e) {
			LOGGER.error("FileNotFoundException raised");
			e.printStackTrace();
		} catch (IOException e) {
			LOGGER.error("IOException raised");
			e.printStackTrace();
		} 
		return books;
	}

	private static File readFile(String fileName) {
		ClassLoader classLoader = CSVUtils.class.getClassLoader();
		return new File(classLoader.getResource(fileName).getFile());
	}

	public static final List<Book> readCsv(String fileName, String path) {
		return readCsv(path + fileName);
	}
}