/*
 * @version: 1.0 
 * @author: Jesús Mendoza Verduzco 11/2018.
 * @email contact: loginlock22@gmail.com
 */
package com.monitoreo.cliente.main;

import com.monitoreo.cliente.database.ConnectionDB;
import com.monitoreo.cliente.views.InizialateConfig;
import com.monitoreo.cliente.views.backframe;
import com.monitoreo.properties.Prop;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Jesús Mendoza Verduzco
 */
public class Monitoreo {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    ConnectionDB connDB;
    
    public Monitoreo() throws IOException{
        connDB = new ConnectionDB();
    }
    
    public static void main(String[] args) throws  FileNotFoundException, IOException {
        Properties p = new Properties();
        InputStream propertiesStream = ClassLoader.getSystemResourceAsStream("com/monitoreo/properties/configuracion.properties");
        p.load(propertiesStream);
        
        //getProperty devuelve un String
        String tipo = p.getProperty("inizializate.config");
        int con = Integer.parseInt(tipo);
        

        if(con == 0){
            InizialateConfig log = new InizialateConfig();
            log.setVisible(true);
            propertiesStream.close();
        }else {
            //Forma de mandar valor a una propiedad
            /*String ini = p.getProperty("inizializate.config");
            String host = p.getProperty("database.host");
            String puerto = p.getProperty("database.port");
            String name = p.getProperty("database.name");
            String user = p.getProperty("database.user");
            String pass = p.getProperty("database.password");
            String id_kiosco = p.getProperty("database.id_kiosco");
            String ws = p.getProperty("webservice.url");
            
            propertiesStream.close();
            int ret = Integer.parseInt(ini);
            int id = Integer.parseInt(id_kiosco);
            
            Prop pr = new Prop(ret,pass,puerto,user,id,name,ws,host);*/
            propertiesStream.close();
            InizialateConfig log = new InizialateConfig();
            log.setVisible(false);
            backframe ex = new backframe();
            ex.setVisible(true);
        }
    }
        
        
    
    
}
