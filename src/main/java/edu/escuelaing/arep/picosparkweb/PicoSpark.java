/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.picosparkweb;


public class PicoSpark {
    
    public static void get(String route, String body){
        PicoSparkServer pserver = PicoSparkServer.getInstance();
        pserver.get(route, body);
    }
    
    public static void port(int port){
        PicoSparkServer pserver = PicoSparkServer.getInstance();
        pserver.port(port);
    }
    
    public static void startServer(){
        PicoSparkServer pserver = PicoSparkServer.getInstance();
        pserver.startServer();
    }
    
}
