package oop2.tp3.ejercicio2;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Reader {

    public Reader() throws FileNotFoundException {
    }
     public List<String[]> readCsv(List<String[]> csvData) throws IOException {
         CSVReader reader = new CSVReader(new FileReader("src/main/resources/data.csv"));
         String[] row = null;
         while ((row = reader.readNext()) != null) {
             csvData.add(row);
         }

         reader.close();
         csvData.remove(0);
         return csvData;
     }


}
