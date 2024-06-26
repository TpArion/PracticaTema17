/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package es.medac.tema17.practica.mascotas.interfaces;

import es.medac.tema17.practica.mascotas.controller.ConsultasMascotasApp;
import es.medac.tema17.practica.mascotas.model.pacientes;
import es.medac.tema17.practica.mascotas.model.pesos;
import es.medac.tema17.practica.mascotas.model.vacunas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrés
 */
public class InsertarVacunas extends javax.swing.JFrame {

    /**
     * Creates new form InsertarPesos
     */
    public InsertarVacunas() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldIdMascota = new javax.swing.JTextField();
        jTextFieldFechaActual = new javax.swing.JTextField();
        jTextFieldEnfermedad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonSalir = new javax.swing.JButton();
        jButtonInsertarPeso = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jTextFieldFechaProxima = new javax.swing.JTextField();
        jButtonEliminarVacunas = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTextFieldIdMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 60, -1));
        getContentPane().add(jTextFieldFechaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 60, -1));
        getContentPane().add(jTextFieldEnfermedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 60, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 100, 120));

        jButtonSalir.setBackground(new java.awt.Color(204, 204, 255));
        jButtonSalir.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButtonSalir.setText("SALIR");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 90, 30));

        jButtonInsertarPeso.setText("INSERTAR");
        jButtonInsertarPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarPesoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInsertarPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jButtonVolver.setBackground(new java.awt.Color(204, 204, 255));
        jButtonVolver.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButtonVolver.setText("VOLVER");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, 30));
        getContentPane().add(jTextFieldFechaProxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 60, -1));

        jButtonEliminarVacunas.setText("ELIMINAR");
        jButtonEliminarVacunas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarVacunasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminarVacunas, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Fecha Próxima:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 100, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Fecha Actual:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 80, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Enfermedad:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 80, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("IdMascota: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 70, 20));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setText("INSERCCIÓN DE VACUNAS ");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 320, 50));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 290, 170));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/medac/tema17/practica/mascotas/interfaces/imagenes/imagen.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInsertarPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarPesoActionPerformed
        // TODO add your handling code here:
        
        //Botón para insertar la vacuna
        PreparedStatement ps = null;
        boolean InserccionExitosa = false;

        int IdMascota = Integer.parseInt(jTextFieldIdMascota.getText());
        String FechaActual = jTextFieldFechaActual.getText();
        String Enfermedad = jTextFieldEnfermedad.getText();
        String FechaProxima = jTextFieldFechaProxima.getText();

        ConsultasMascotasApp con1 = new ConsultasMascotasApp();

        vacunas van1 = new vacunas(IdMascota, FechaActual, Enfermedad, FechaProxima);
        String informe = van1.imprimir();
        jTextArea1.setText("Ha insertado lo siguiente: " + informe);

        try {

            con1.insertarVacunas(IdMascota, FechaActual, Enfermedad, FechaProxima);

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                jTextArea1.setText("Ha insertado los datos correctamente. " + informe);
                InserccionExitosa = true;
            } else {
                jTextArea1.setText("No se encontró al paciente con id: " + IdMascota);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertarYModificarPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonInsertarPesoActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        // TODO add your handling code here:
        InsertarYModificarPacientes gestiondedatos = new InsertarYModificarPacientes();
        gestiondedatos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonEliminarVacunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarVacunasActionPerformed
        // TODO add your handling code here:
        PreparedStatement ps = null;
        boolean InserccionExitosa = false;
        
        int IdMascota = Integer.parseInt(jTextFieldIdMascota.getText());
        
        ConsultasMascotasApp con1 = new ConsultasMascotasApp();
        
        con1.eliminarVacunas(IdMascota);
        
        jTextArea1.setText("Se ha"+ "\n"+ "eliminado la vacuna"+"\n"+"correctamente.");
    }//GEN-LAST:event_jButtonEliminarVacunasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InsertarVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertarVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertarVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertarVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertarVacunas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEliminarVacunas;
    private javax.swing.JButton jButtonInsertarPeso;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldEnfermedad;
    private javax.swing.JTextField jTextFieldFechaActual;
    private javax.swing.JTextField jTextFieldFechaProxima;
    private javax.swing.JTextField jTextFieldIdMascota;
    // End of variables declaration//GEN-END:variables
}
