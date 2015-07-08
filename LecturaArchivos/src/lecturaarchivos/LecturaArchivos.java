/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaarchivos;

import busqueda.Buscador;
import lectura.RandomReader;
import lectura.SecuentialReader;

/**
 *
 * @author giwiro
 */
public class LecturaArchivos {
    
    static final String DIR = "c:/";
    static final String file_name1 = "giwiro-sec.txt";
    static final String file_name2 = "giwiro-ran.txt";

    public static void main(String[] args) {
        Buscador buscador = new Buscador();
        buscador.buscar(DIR, file_name1, file_name2);
        
        SecuentialReader sr = new SecuentialReader(buscador.getPath1());
        sr.readFile();
        
        RandomReader rr = new RandomReader(buscador.getPath2());
        rr.setCursors(sr.getCursors());
        
        String mensaje = rr.readFile();

        System.out.println("Mensaje: " + mensaje);
        
        /*System.out.println(buscador.getPath1());
        System.out.println(buscador.getPath2());*/
    }
    
}
