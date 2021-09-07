/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.picosparkweb;

import edu.escuelaing.arep.httpserver.HttpServer;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class PicoSparkServer {
    
    private static PicoSparkServer _instance = new PicoSparkServer();
    private int httpPort = 36000;
    
    private PicoSparkServer(){
        
    }
    
    public static PicoSparkServer getInstance() {
        return _instance; 
    }
    
    Map<String, String> functions = new HashMap();
    HttpServer http = new HttpServer();
    
    public void get(String route, String body){
        functions.put(body, route);
    }
    
    public void startServer(){
        try {
            http.startServer(httpPort);
        } catch (IOException ex) {
            Logger.getLogger(PicoSparkServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void port(int serverPort){
        this.httpPort = serverPort;
    }
    
}
