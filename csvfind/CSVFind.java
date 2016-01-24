/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvfind;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Nold
 */
public class CSVFind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        Param comLine = new Param();
        String[] argv = {"-col", "ID4", "-exp", "9", "-enc", "cp1251", "-out", "C:/Java/Test/resultFind.csv", "-in", "C:/Java/Test/yourfile.csv"};
        JCommander jc = new JCommander(comLine);
        try {
            jc.parse(argv);
        } catch (ParameterException t) {
            throw new ParameterException("Параметры введены неправильно. Для справки используйте -help");
        }
        if (comLine.isHelp()) {
            jc.usage();
        }
        System.out.printf("Полученные параметры %s %s %s %s %s \n",
                comLine.getCol(), comLine.getExp(), comLine.getEnc(),
                comLine.getOut(), comLine.getIn());
        long timeSpent = System.currentTimeMillis() - startTime;

        FileFind nf = new FileFind();
        ArrayList<String[]> outStrings = new ArrayList<String[]>();

        try {
            outStrings.addAll(nf.arrGet(comLine));
        } catch (FileNotFoundException x) {
            System.out.println("Указанный файл не найден");
        }

        try {
            FileCreate.resultCSV(comLine.getOut(), outStrings, comLine.getEnc());
        } catch (IOException x) {
            System.out.println("Не удалось создать файл. Проверьте параметры");
        }

        System.out.println("программа выполнялась " + timeSpent + " миллисекунд");

//    CSVReader reader = new CSVReader (new FileReader(comLine.getIn()),';');
//    String[] nextLine;
//    ArrayList<String> outStrings = new ArrayList<String>();
//     while ((nextLine = reader.readNext()) != null) {
//            System.out.println(Arrays.toString(nextLine));
//            outStrings.add(Arrays.toString(nextLine));
//     }
        //System.out.println(outStrings.get(0));
//    CSVWriter writer = new CSVWriter (new FileWriter(comLine.getOut()),';');  
//    writer.writeNext(outStrings.toArray(new String[outStrings.size()]));
//    List myEntries = reader.readAll();
//    ArrayList outStrings = new ArrayList();
//    for (int i=0;i<myEntries.size();i++){
//        String[] val = myEntries.get(i).;
//        if (true){
//            System.out.println(val);
//            outStrings.add(val);
//        };
//    }
//    writer.writeAll(outStrings);
//    CsvToBean<CSVLine> bean = new CsvToBean<CSVLine>();
//    //Define strategy
//    //Header name to bean property name mapping
//    
//    Map<String, String> columnMapping = new HashMap<String, String>();
//    columnMapping.put("cifra", "cifra");
//    
//    HeaderColumnNameTranslateMappingStrategy<CSVLine> strategy = 
//        new HeaderColumnNameTranslateMappingStrategy<CSVLine>();
//    strategy.setType(CSVLine.class);
//    strategy.setColumnMapping(columnMapping);
//    //Parse the CSV
//    CSVReader reader = new CSVReader (new FileReader(comLine.getIn()),';');
//    List<CSVLine> car = bean.parse(strategy, reader);
//    System.out.println(car);    
    }
}
