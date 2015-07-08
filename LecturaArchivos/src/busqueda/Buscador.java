/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busqueda;

import java.io.File;

/**
 *
 * @author giwiro
 */
public class Buscador{
    
    private static boolean found;
    private static String fileName1;
    private static String fileName2;
    private static String path1;
    private static String path2;
    /*public static void main(String[] args) {
        walkin(new File("d:/")); //Replace this with a suitable directory
        System.out.println(path);
    }*/
    
    public void buscar (String dir, String fileName1, String fileName2) {
        this.fileName1 = fileName1;
        this.fileName2 = fileName2;
        System.out.println("Buscando: " + this.fileName1 + " y " + this.fileName2);
        search(new File(dir));
    }
    
    public String getPath1 () {
        return path1;
    }
    
    public String getPath2 () {
        return path2;
    }
 
    private void search(File dir) {
        File listFile[] = dir.listFiles();
        
        if (listFile != null) {
            int i=0;
            while (i<listFile.length && !found) {
                if (listFile[i].isDirectory()) {
                    search(listFile[i]);
                } else {
                    if (listFile[i].getName().equals(fileName1)) {
                        path1 = listFile[i].getPath();
                    }
                    if (listFile[i].getName().equals(fileName2)) {
                        found=true;                        
                        path2 = listFile[i].getPath();
                    }
                }
                i++;
            }
        }
    }
}

