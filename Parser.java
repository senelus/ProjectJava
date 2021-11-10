import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

abstract public class Parser {
   public static void parseCSVtoCourse(String path, String courseName) throws IOException, CsvValidationException {
      var csvParser = new CSVParserBuilder().withSeparator(';').build();
      var csvReader = new CSVReaderBuilder(new FileReader(path)).withCSVParser(csvParser).build();
   }
}
