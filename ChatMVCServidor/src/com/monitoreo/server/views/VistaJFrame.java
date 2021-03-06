/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitoreo.server.views;

import com.monitoreo.server.controller.ControladorServidor;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 */



public class VistaJFrame extends javax.swing.JFrame implements IVista {
    ControladorServidor controlador;
    /**
     * Creates new form VistaJFrame
     */
    
    //COMPONENTES DEL SEGUNDO PLANO
    private ImageIcon imgIcon;
    private TrayIcon trayIcon;
    private SystemTray sysTray;
    
    public VistaJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);        //COLOCAR LA APP EN EL CENTRO
        imgIcon = new ImageIcon(getClass().getResource("/com/monitoreo/utils/app.png")); //IMAGEN QUE SERÁ USADA COMO ICONO
        try {
            setIconImage(imgIcon.getImage());         //MANDAR IMAGEN AL FRAME
        } catch (Exception e) {
        }
        this.setTitle("Servidor"); //TÍTULO DE LA APP
        instanciarTray(); 
        
        
    }
    
    //MÉTODO PARA INSTANCIAR SYSTEM TRAY
    private void instanciarTray(){
        //ANTES DE ESTA LINEA DE CODIGO DEBERÁ CREARSE UN POPUP MENÚ EN AWT DE JAVA
        //SE INGRESA LA IMAGEN DE ICONO, UN TOOLTIP Y EL POPUP ANTES MENCIONADO QUE SERÁN LAS OPCIONES DEL USUARIO EN SEGUNDO PLANO
        trayIcon = new TrayIcon(imgIcon.getImage(), "tooltip del icono", popupMenu1);
        //ACOPLAR ICONO
        trayIcon.setImageAutoSize(true);
        //INSTANCIAR SYSTEM TRAY
        sysTray = SystemTray.getSystemTray();
        initSysTray(); //MANDAR A SEGUNDO PLANO LA APP DESDE QUE SE INICIA
    }
    
    private void initSysTray(){
        try {
            //SOLO SE INICIALIZA SI EL SISTEMA SOPORTA SYSTEM TRAY
            if(SystemTray.isSupported()){
                //SE AGREGA LA VARIABLE QUE CONTIENE EL ÍCONO, TOOLTIP Y POPUP
                sysTray.add(trayIcon);
                //OCULTAR LA VENTANA
                this.setVisible(false);
            }
        } catch (Exception e) {
            //EN CASO DE ERROR, MOSTRARLO
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        Abrir = new java.awt.MenuItem();
        Cerrar = new java.awt.MenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaTrasiego = new javax.swing.JTextArea();
        jLabelTextoAEnviar = new javax.swing.JLabel();
        jTextFieldTextoAEnviar = new javax.swing.JTextField();
        jButtonEnviar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        popupMenu1.setLabel("popupMenu1");
        popupMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupMenu1ActionPerformed(evt);
            }
        });

        Abrir.setLabel("Abrir");
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });
        popupMenu1.add(Abrir);

        Cerrar.setLabel("Cerrar");
        Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarActionPerformed(evt);
            }
        });
        popupMenu1.add(Cerrar);

        jTextAreaTrasiego.setBackground(new java.awt.Color(153, 153, 153));
        jTextAreaTrasiego.setColumns(20);
        jTextAreaTrasiego.setRows(5);
        jScrollPane1.setViewportView(jTextAreaTrasiego);

        jLabelTextoAEnviar.setText("Texto a Enviar:");

        jButtonEnviar.setText("Enviar");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Servidor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelTextoAEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTextoAEnviar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonEnviar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTextoAEnviar)
                    .addComponent(jTextFieldTextoAEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEnviar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void popupMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_popupMenu1ActionPerformed

    private void CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarActionPerformed
       System.exit(0);
    }//GEN-LAST:event_CerrarActionPerformed

    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActionPerformed
       //MOSTRAR VENTANA
        this.setVisible(true);
    }//GEN-LAST:event_AbrirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.MenuItem Abrir;
    private java.awt.MenuItem Cerrar;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTextoAEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaTrasiego;
    private javax.swing.JTextField jTextFieldTextoAEnviar;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void habilitarEnviar() {
        jButtonEnviar.setEnabled(true);
    }

    @Override
    public void deshabilitarEnviar() {
        jButtonEnviar.setEnabled(false);
    }

    @Override
    public void agnadirMensajeATrasiego(String mensaje) {
        jTextAreaTrasiego.append(mensaje + "\n");
    }

    @Override
    public void borrarTextoAEnviar() {
        jTextFieldTextoAEnviar.setText("");
    }

    @Override
    public void setControlador(ControladorServidor controlador) {
        this.controlador = controlador;
    }

    @Override
    public void hacerVisible() {
        setVisible(true);
    }
    
    public void inicializar(){
        jButtonEnviar.setActionCommand(ENVIAR);
        jButtonEnviar.addActionListener(controlador);
        
        
    }

    @Override
    public String getMensajeAEnviar() {
        return jTextFieldTextoAEnviar.getText();
    }

}
