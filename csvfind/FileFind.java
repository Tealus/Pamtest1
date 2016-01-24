/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvfind;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Nold
 */
public class FileFind {

    public ArrayList<String[]> arrGet(Param paramlist) throws FileNotFoundException, Exception {

        CSVReader reader = new CSVReader(new FileReader(paramlist.getIn()), ';');
        String[] nextLine;
        ArrayList<String[]> outStrings = new ArrayList<String[]>();

        nextLine = reader.readNext();
        HeadFind hf = new HeadFind(paramlist.getCol(), nextLine);
        int num = hf.colNum(nextLine);     //определение номера столбца

        while ((nextLine = reader.readNext()) != null) {
            if (nextLine[num].equals(paramlist.getExp())) {
                outStrings.add(nextLine);
            }
        }
        reader.close();
        if (outStrings.isEmpty()) {
            throw new Exception("Искомое выражение в файле не найдено");
        }
        return outStrings;
    }
;

}
