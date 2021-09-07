/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.ejercicios;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class URLReader {

    public static void main(String[] args) throws Exception {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Ingrese una URL, ejemplo: http://google.com");
        String urlstr = myObj.nextLine();  // Read user input
        
        URL url = new URL(urlstr);
        try ( BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            
            String inputLine = null;
            Writer out = null;
            try {
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("resultado.html"), "UTF-8"));
                while ((inputLine = reader.readLine()) != null) {
                    try{
                        out.write(inputLine+"\n");
                        
                    } catch(IOException ex){
                        System.out.println("Mensaje excepcion escritura: " + ex.getMessage());
                    }
                }
                System.out.println("File resultado.html created");

            } catch (UnsupportedEncodingException | FileNotFoundException ex2) {
                System.out.println("Mensaje error 2: " + ex2.getMessage());
            } finally {
                try {
                    out.close();
                } catch (IOException ex3) {
                    System.out.println("Mensaje error cierre fichero: " + ex3.getMessage());
                }
            }
            
                   
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}
