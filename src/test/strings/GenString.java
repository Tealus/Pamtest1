/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.strings;

import java.util.ArrayList;
import test.Param;
import java.util.Random;
import static test.strings.TextGet.generate;
/**
 *
 * @author Nold
 */
public class GenString {
//    public GenString() {
//    }
    //private static String[] title = {};
    ArrayList<Attribute> list = new ArrayList<Attribute>();
    ArrayList<String> titlenames = new ArrayList<String>();
    private String[] titlevar = {"Byte", "Short", "Integer", "Long", "Character", "Float", "String"};
    
    public String[] getTitleRow (int col) {
        Random random = new Random();
        for (int i=0;i<col;i++){
//            System.out.println("Числа:"+random.nextInt(titlevar.length)+titlevar[random.nextInt(titlevar.length)]);
            list.add(new Attribute(titlevar[(random.nextInt(titlevar.length))]));
            titlenames.add(list.get(i).getName()+" "+list.get(i).getType());
            //title = list.toArray(new String[list.size()]);
            //title[i] = list.get(i).getName();
        }
        return(titlenames.toArray(new String[titlenames.size()]));
    };
    
    
    public String[] getRndRow(Param paramlist) { 
        Random random = new Random();
        ArrayList<String> ourrow = new ArrayList<String>();
        for (int i=0; i<paramlist.getCol(); i++)
        {
        switch ( list.get(i).getType() ) 
            { 
            case "Byte": ourrow.add(Byte.toString((byte) random.nextInt(Byte.MAX_VALUE + 1))); break; 
            case "Short": ourrow.add(Short.toString((short) random.nextInt(Short.MAX_VALUE + 1))); break; 
            case "Integer": ourrow.add(Integer.toString(random.nextInt())); break;
            case "Long": ourrow.add(Long.toString(random.nextLong())); break;
            case "Character": ourrow.add(generate(1,1));  break;
            case "Float": ourrow.add(Float.toString(random.nextFloat())); break;
            case "String": ourrow.add(generate(1,paramlist.getLen())); break;            
            default: System.out.println("Неправильный тип");
            }   
        } 
        return(ourrow.toArray(new String[ourrow.size()]));
    }        
}

class Attribute {
    private static Integer ID=0;
    public Attribute(String type) {
        for (int i = 0; i<types.length; i++) {
            if (types[i].equals(type)) {this.type = type;}
        } 
        //this.name=generate(8, 12);
        this.name="ID "+(++ID);
    }

    private final String[] types = {"Byte", "Short", "Integer", "Long", "Character", "Float", "String"};
    
    private String type;
    public String getType() {
        return type;
    }
    
    private String name;
    public String getName() {
        return name;
    }
   
}