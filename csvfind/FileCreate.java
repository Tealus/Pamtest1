/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvfind;

import com.opencsv.CSVWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Nold
 */
class FileCreate {

    public static void resultCSV(String out, ArrayList<String[]> csv, String enc) throws IOException {

        CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(out), enc), ';');
        writer.writeNext(HeadFind.headOut);
        for (int i = 0; i < csv.size(); i++) {
            String[] nextLine = csv.get(i);
            System.out.println(Arrays.toString(nextLine));
            writer.writeNext(nextLine);
        }
        writer.close();
    }
}
