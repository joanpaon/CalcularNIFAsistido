/*
 * Copyright 2017 José A. Pacheco Ondoño - joanpaon@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.forms;

import java.awt.Color;
import java.awt.Image;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.Properties;
import javax.swing.ImageIcon;
import org.japo.java.lib.UtilesApp;
import org.japo.java.lib.UtilesDNI;
import org.japo.java.lib.UtilesSwing;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class GUI extends javax.swing.JFrame implements ClipboardOwner {

    // Propiedades APP
    private Properties prpApp;

    // Constructor
    public GUI() {
        // Inicializar GUI - PREVIA
        beforeInit();

        // Construcción - GUI
        initComponents();

        // Inicializar GUI - POSTERIOR
        afterInit();
    }

    // Inicializar GUI - PREVIA
    private void beforeInit() {
        // Restaurar Estado Previo
        restaurarEstado();

        // Otras inicializaciones
    }

    // Inicializar GUI - POSTERIOR
    private void afterInit() {
        // Icono Ventana - Recurso
        URL urlICN = ClassLoader.getSystemResource("img/favicon.png");
        setIconImage(new ImageIcon(urlICN).getImage());

        // Icono Portapapeles
        URL urlCLP = ClassLoader.getSystemResource("img/clipboard.png");
        Image imgCLP = new ImageIcon(urlCLP).getImage();
        UtilesSwing.asignarImagenEscalada(lblClip, imgCLP);

        // Otras inicializaciones
    }

    // Persistencia > Estado Actual
    private void restaurarEstado() {
        // Carga Propiedades App
        prpApp = UtilesApp.cargarPropiedades();

        // Establece Lnf
        UtilesSwing.establecerLnF(prpApp.getProperty("lnf",
            UtilesSwing.WINDOWS));

        // Activa Singleton
        if (!UtilesApp.activarInstancia(
            prpApp.getProperty("puerto_bloqueo",
                UtilesApp.PUERTO_BLOQUEO))) {
            UtilesSwing.terminarPrograma(this);
        }

        // Otras propiedades
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txfDNI = new javax.swing.JTextField();
        lblDNI = new javax.swing.JLabel();
        lblClip = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calcular NIF Asistido");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txfDNI.setColumns(9);
        txfDNI.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        txfDNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfDNIActionPerformed(evt);
            }
        });
        txfDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfDNIKeyPressed(evt);
            }
        });

        lblDNI.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        lblDNI.setText("*");

        lblClip.setPreferredSize(new java.awt.Dimension(63, 63));
        lblClip.setRequestFocusEnabled(false);
        lblClip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClipMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDNI)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDNI))
                    .addComponent(lblClip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        procesarCerrarVentana(evt);
    }//GEN-LAST:event_formWindowClosing

    private void txfDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfDNIActionPerformed
        gestionarNIF(evt);
    }//GEN-LAST:event_txfDNIActionPerformed

    private void lblClipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClipMouseClicked
        gestionarPortapapeles(evt);
    }//GEN-LAST:event_lblClipMouseClicked

    private void txfDNIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfDNIKeyPressed
        txfDNI.setBackground(Color.WHITE);
    }//GEN-LAST:event_txfDNIKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblClip;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JTextField txfDNI;
    // End of variables declaration//GEN-END:variables
    //
    // Evento de Ventana - Cerrando
    public void procesarCerrarVentana(WindowEvent e) {
        // Memorizar Estado Actual
        memorizarEstado();
    }

    // Estado Actual > Persistencia
    private void memorizarEstado() {
        // Memoriza Estado Actual

        // Guardar Estado Actual
//        UtilesApp.guardarPropiedades(prpApp);
    }

    public void gestionarNIF(ActionEvent e) {
        try {
            // Texto introducido por el usuario
            String texto = txfDNI.getText();

            // Número de DNI
            int numero = Integer.parseInt(texto);

            // Procesa el numero
            if (UtilesDNI.validarNumeroDNI(numero)) {
                // Calcular letra
                char letra = UtilesDNI.calcularLetraDNI(numero);

                // Publicar la letra
                lblDNI.setText(letra + "");
            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            // DNI incorrecto
            lblDNI.setText("*");
        }
    }

    // Notificación Pérdida Propiedad Portapapeles
    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        // No hacer nada
    }

    private void gestionarPortapapeles(MouseEvent evt) {
        // Señaliza Texto Copiado
        txfDNI.setBackground(new Color(184, 244, 244));

        // Campo de texto > Portapapeles
        UtilesSwing.ponerTextoPortapapeles(
            txfDNI.getText() + lblDNI.getText(), this);
    }
}
