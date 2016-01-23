/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

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
    
@Parameter(names = { "-col" }, description = "количество колонок csv файла") private Integer col = 5;
 
@Parameter(names = { "-row" }, description = "количество строк csv файла") private Integer row = 10;

@Parameter(names = { "-len" }, description = "максимальная длина String элементов csv файла") private Integer len = 25;

@Parameter(names = { "-out" }, description = "имя выходного файла") private String out = "result.csv";

    public Integer getCol() {
        return col;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getLen() {
        return len;
    }

    public String getOut() {
        return out;
    }
}
