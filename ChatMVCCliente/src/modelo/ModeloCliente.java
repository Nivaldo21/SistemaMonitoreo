/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ControladorCliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.VistaJFrame;

/**

 */
public class ModeloCliente extends Thread {
    ControladorCliente controlador;
    final int PUERTO = 5000;
    // final String HOST = "192.168.1.139";
    final String HOST = "localhost";
    Socket socket;
    BufferedReader br;
    BufferedWriter bw;
    String NombreCliente="Default";
    
    public void setControlador(ControladorCliente controlador){
        this.controlador = controlador;
    }
    
    public void conectarConElServidor(){
        try {
            socket = new Socket(HOST, PUERTO);
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearFlujos(){
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarMensajeNombre(String mensaje){
        try {
            bw.write(mensaje);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarMensajePassword(String mensaje){
        try {
            bw.write(mensaje);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SolicitarStatus(){
        try {
            bw.write("Solicito Status");
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String recibirMensaje(){
        try {
            String mensaje = br.readLine();
            return mensaje;
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    @Override
    public void run(){
        while(true){
            String mensaje = recibirMensaje();
            controlador.agnadirMensajeATrasiego("El Servidor dice: " + mensaje);
            if(mensaje.equals("ACCESO PERMITIDO")){
            VistaJFrame.jButtonEnviar.setEnabled(false);
            VistaJFrame.jButton1.setEnabled(true);
            VistaJFrame.jTextFieldTextoAEnviar.setEnabled(false);
            VistaJFrame.jTextFieldTextoPassword.setEnabled(false);
            }
        }
    }
}