package test;
import com.beust.jcommander.JCommander;
import java.io.*; 
import java.util.logging.*;
import com.beust.jcommander.ParameterException;

public class GenTest {
 
    public static void main(String[] args) {
    long startTime = System.currentTimeMillis();           
    Param comLine = new Param();
//String[] argv = {};
    JCommander jc = new JCommander(comLine);
    try {jc.parse (args);}
    catch(ParameterException t) {throw new ParameterException ("Параметры введены неправильно. Для справки используйте -help");}
    if (comLine.isHelp()) jc.usage();
    System.out.printf("Полученные параметры %d %d %d %s \n", comLine.getCol(), comLine.getRow(), comLine.getLen(), comLine.getOut());  
    GenFile gc = new GenFile(comLine);
    long timeSpent = System.currentTimeMillis() - startTime;
    System.out.println("программа выполнялась " + timeSpent + " миллисекунд");

//    File fl = new File("TestName");
//        try {
//            fl.createNewFile();
//            print("Новый файл создан");
//        }
//         catch (IOException ex) {
//            Logger.getLogger(GenTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//     
//    
//    print ("Имя файла:" + fl .getName()); 
//    print("Путь:" + fl.getPath()); 
//    print("Полный путь:" + fl.getAbsolutePath()); 
//    print("Родительский каталог:" + fl.getParent()); 
//    print(fl.exists() ? "существует" : "не существует"); 
//    print(fl.canWrite() ? "можно записывать" : "нельзя записывать"); 
//    print(fl.canRead() ? "можно читать" : "нельзя читать"); 
//    print("is" + ("Директория? "+ (fl.isDirectory() ? "да": " нет") )); 
//    print(fl.isFile() ? "обычный файл" : "не обычный файл"); 
//    print("Последняя модификация файла:" + fl. lastModified()); 
//    print("Размер файла:" + fl.length() + " Bytes");               
    }
  
//    static void print(String s){ 
//    System.out.println(s); 
//    }    
    
}
