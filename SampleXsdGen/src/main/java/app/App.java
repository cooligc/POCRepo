package app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.wiztools.xsdgen.ParseException;
import org.wiztools.xsdgen.XsdGen;

/**
 * 
 * @author sitakant
 *
 */
public class App {
	public static void main(String[] args) throws IOException, ParseException {
		XsdGen gen = new XsdGen();
		gen.parse(new File(App.class.getClassLoader().getResource("sample.xml").getFile()));
		File out = new File("C:\\a.xsd");
		gen.write(new FileOutputStream(out));
		System.out.println("XSD Generated ");
	}
}
