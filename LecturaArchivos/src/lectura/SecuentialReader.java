/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectura;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giwiro
 */
public class SecuentialReader {
 
    private String filePath;
    private FileInputStream inputFile;
    private BufferedInputStream bufferedInput;
    private DataInputStream inputStream;
    private List<Integer> cursors;

    public SecuentialReader(String filePath) {
        cursors = new ArrayList<>();
        this.filePath = filePath;
        initializeComponents();
    }
    
    private void initializeComponents(){
        try {
            inputFile = new FileInputStream(this.filePath);
            bufferedInput = new BufferedInputStream(inputFile);
            inputStream = new DataInputStream(bufferedInput);
    
        } catch (FileNotFoundException noFile) {
            System.err.println("File not found! " + noFile);
        } catch (Throwable anything) {
            System.err.println("Abnormal exception caught !: " + anything);
        }
    }
    
    public void readFile(){
        try {
            System.out.print("SecuentialReader >> cursors: [");
            while(true){
                int a = inputStream.readInt();
                cursors.add(a);
                System.out.print(a + ",");
            }
            
        } catch (EOFException eof) {
            System.out.print("]\n");
        } catch (FileNotFoundException noFile) {
            System.err.println("File not found! " + noFile);
        } catch (IOException io) {
            System.err.println("I/O error occurred: " + io);
        } catch (Throwable anything) {
            System.err.println("Abnormal exception caught !: " + anything);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(SecuentialReader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public List<Integer> getCursors() {
        return this.cursors;
    }
    
    
}
