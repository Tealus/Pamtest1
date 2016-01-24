/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvfind;

/**
 *
 * @author Nold
 */
public class HeadFind {

    public HeadFind(String head, String[] hf) throws Exception {
        this.headName = head;
        for (String hf1 : hf) {
            System.out.println(hf1.indexOf(' ') + "  " + hf1.lastIndexOf(' '));
            if (!hf1.contains(" ")
                    || hf1.indexOf(' ') != hf1.lastIndexOf(' ')
                    || hf1.indexOf(' ') == -1) {
                throw new Exception("Неправильные колонки файла");
            } else if (hf1.contains(head)) {
                this.headFull = hf1;
                this.headType = colType(hf1);
            }
        }
    }

    private String headName;
    private String headType;
    private String headFull;

    public static String[] headOut;

    int colNum(String[] head) throws Exception {
        System.out.println("Имя:" + headName + "\n Тип " + headType + "\n headFull " + headFull);
        int num = -1;
        for (int i = 0; i < head.length; i++) {
            if (headFull.equals(head[i])) {
                num = i;
            }
        }
        if (num == -1) {
            throw new Exception("Во входящем файле указанный столбец не найден");
        } else {
            headOut = head;

            return num;
        }
    }

    private String colType(String head) throws Exception {
        if (head.indexOf(' ') != head.lastIndexOf(' ')) {
            throw new Exception("Неправильные колонки файла");
        } else {
            return (head.substring(head.indexOf(' ') + 1));
        }
    }

}
