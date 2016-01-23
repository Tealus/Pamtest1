/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import test.strings.GenString;

/**
 *
 * @author Nold
 */
public class GenFile {

    public GenFile(Param paramlist) {
    
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(paramlist.getOut()), ';');

//            String[] entries = "зкшмуе;дом;труба".split(";");
//            writer.writeNext(entries);

            GenString gs = new GenString();
            writer.writeNext(gs.getTitleRow(paramlist.getCol()));
            
            for (int i=0;i<paramlist.getRow();i++){
                writer.writeNext(gs.getRndRow(paramlist));
            }
            writer.close();
            
//            for (int i=0;i<paramlist.getRow();i++){
//                String[] line = gs.getRndRow(paramlist);
//            }
            
        } catch (IOException ex) {
            System.err.println("Ошибка создания файла с указанным именем");
        }
        
    }
}