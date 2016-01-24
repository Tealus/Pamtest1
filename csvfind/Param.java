/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvfind;

import com.beust.jcommander.Parameter;
/**
 *
 * @author Nold
 */
public class Param {

    @Parameter(names = { "-help", "-?" }, help = true) private boolean help;

    public boolean isHelp() {
        return help;
    }
    
    @Parameter(names = { "-col" }, description = "имя столбца для поиска csv файла") private String col;
    @Parameter(names = { "-exp" }, description = "выражение для поиска csv файла") private String exp;
    @Parameter(names = { "-enc" }, description = "кодировка csv файла") private String enc;
    @Parameter(names = { "-out" }, description = "имя выходного файла") private String out = "result.csv";
    @Parameter(names = { "-in" }, description = "имя входного файла") private String in;
        

    public String getCol() {
        return col;
    }

    public String getExp() {
        return exp;
    }
    
    public String getEnc() {
        return enc;
    }    

    public String getIn() {
        return in;
    }

    public String getOut() {
        return out;
    }
}
