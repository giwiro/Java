/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class RandomReader {
    
    private final String filePath;
    private File dataFile;
    private RandomAccessFile inputFile;
    private List<Integer> cursors;
    private StringBuilder sb;
    
    public RandomReader(String filePath){
        sb = new StringBuilder();
        this.filePath = filePath;
        this.dataFile = new File(filePath);
        try {
            this.inputFile = new RandomAccessFile(dataFile, "r");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RandomReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setCursors(List<Integer> c){
        this.cursors = c;
        System.out.println("RandomReader >> leer cursors: " + this.cursors+"\n");
    }
    
    public String readFile(){
        for (int i = 0; i < this.cursors.size(); i++) {
            int c = (int)this.cursors.get(i);
            try {
                inputFile.seek(c);
                char letra = inputFile.readChar();
                sb.append(letra);
            } catch (IOException ex) {
                Logger.getLogger(RandomReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sb.toString();
    }
    
}
