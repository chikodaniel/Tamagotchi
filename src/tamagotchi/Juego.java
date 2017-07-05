/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tamagotchi;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

/**
 *
 * @author Tio Ranchero
 */
public class Juego extends javax.swing.JFrame {
    Mascota miMascota ;
    int tamagotchiSeleccionado;
    String ruta = "C:\\Program Files (x86)\\save_file.txt";
    Timer Actualizacion = new Timer();
       
    public Juego(Mascota miMascota, int tamagotchiSeleccionado) {
        setTitle("Coleccionalos a todos!!™ (son solo 3) ");
        setSize(250,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        initComponents();
        this.miMascota = miMascota;
        this.tamagotchiSeleccionado = tamagotchiSeleccionado;
        
        lb_ImagenMascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tamagotchi/clases/" + miMascota.clase + ".png")));
        TimerTask Actualizar = new TimerTask(){
            public void run(){
                pb_Energia.setValue(miMascota.vida);
                pb_Tristeza.setValue(miMascota.tristeza);
                pb_Suciedad.setValue(miMascota.suciedad); 
                lb_Status.setText(miMascota.nombre + " está " + miMascota.status);
                lb_ImagenStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tamagotchi/status/" + miMascota.status + ".png")));
                guardar();
                pintar();
                revisarTamagotchi();
                lb_Nivel.setText(String.valueOf(miMascota.acelerador));
                      
            }
        };
        Actualizacion.scheduleAtFixedRate(Actualizar, 0, 750);
        
        lb_Nivel.setVisible(false);
    }
    
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        lb_Nivel = new javax.swing.JLabel();
        lb_Status = new javax.swing.JLabel();
        lb_ImagenStatus = new javax.swing.JLabel();
        lb_ImagenMascota = new javax.swing.JLabel();
        pb_Energia = new javax.swing.JProgressBar();
        pb_Tristeza = new javax.swing.JProgressBar();
        pb_Suciedad = new javax.swing.JProgressBar();
        lb_Energia = new javax.swing.JLabel();
        lb_Felicidad = new javax.swing.JLabel();
        lb_Suciedad = new javax.swing.JLabel();
        lb_fondoTama = new javax.swing.JLabel();
        bt_Alimentar = new javax.swing.JButton();
        bt_Acariciar = new javax.swing.JButton();
        bt_Bañar = new javax.swing.JButton();
        bt_CambiarMascota = new javax.swing.JButton();
        lb_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(670, 570));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(null);

        jButton1.setText("Presioname si te atreves");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(460, 20, 190, 30);
        jPanel1.add(lb_Nivel);
        lb_Nivel.setBounds(590, 120, 70, 30);

        lb_Status.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lb_Status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Status.setAlignmentX(0.5F);
        jPanel1.add(lb_Status);
        lb_Status.setBounds(90, 40, 490, 40);

        lb_ImagenStatus.setToolTipText("");
        jPanel1.add(lb_ImagenStatus);
        lb_ImagenStatus.setBounds(240, 120, 200, 200);

        lb_ImagenMascota.setToolTipText("");
        jPanel1.add(lb_ImagenMascota);
        lb_ImagenMascota.setBounds(240, 120, 200, 200);

        pb_Energia.setForeground(new java.awt.Color(0, 255, 102));
        pb_Energia.setValue(100);
        jPanel1.add(pb_Energia);
        pb_Energia.setBounds(190, 390, 390, 20);

        pb_Tristeza.setForeground(new java.awt.Color(0, 255, 102));
        jPanel1.add(pb_Tristeza);
        pb_Tristeza.setBounds(190, 440, 390, 20);

        pb_Suciedad.setForeground(new java.awt.Color(0, 255, 0));
        jPanel1.add(pb_Suciedad);
        pb_Suciedad.setBounds(190, 490, 390, 20);

        lb_Energia.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lb_Energia.setText("Vitalidad");
        jPanel1.add(lb_Energia);
        lb_Energia.setBounds(90, 390, 80, 21);

        lb_Felicidad.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lb_Felicidad.setText("Tristeza");
        jPanel1.add(lb_Felicidad);
        lb_Felicidad.setBounds(90, 440, 80, 21);

        lb_Suciedad.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lb_Suciedad.setText("Suecidad");
        jPanel1.add(lb_Suciedad);
        lb_Suciedad.setBounds(90, 490, 80, 21);

        lb_fondoTama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tamagotchi/imagenes/Nueva carpeta/67589061-happy-wallpapers_1.jpg"))); // NOI18N
        lb_fondoTama.setText("jLabel7");
        lb_fondoTama.setPreferredSize(new java.awt.Dimension(670, 570));
        jPanel1.add(lb_fondoTama);
        lb_fondoTama.setBounds(90, 80, 490, 240);

        bt_Alimentar.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        bt_Alimentar.setText("Alimentar");
        bt_Alimentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AlimentarActionPerformed(evt);
            }
        });
        jPanel1.add(bt_Alimentar);
        bt_Alimentar.setBounds(90, 340, 100, 27);

        bt_Acariciar.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        bt_Acariciar.setText("Acariciar");
        bt_Acariciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AcariciarActionPerformed(evt);
            }
        });
        jPanel1.add(bt_Acariciar);
        bt_Acariciar.setBounds(290, 340, 100, 27);

        bt_Bañar.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        bt_Bañar.setText("Bañar");
        bt_Bañar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_BañarActionPerformed(evt);
            }
        });
        jPanel1.add(bt_Bañar);
        bt_Bañar.setBounds(480, 340, 100, 27);

        bt_CambiarMascota.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        bt_CambiarMascota.setText("Cambiar Mascota");
        bt_CambiarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CambiarMascotaActionPerformed(evt);
            }
        });
        jPanel1.add(bt_CambiarMascota);
        bt_CambiarMascota.setBounds(30, 20, 170, 29);

        lb_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tamagotchi/imagenes/Nueva carpeta/VW2DYbL.png"))); // NOI18N
        lb_fondo.setText("jLabel9");
        jPanel1.add(lb_fondo);
        lb_fondo.setBounds(0, 0, 680, 580);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void bt_CambiarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_CambiarMascotaActionPerformed
        Actualizacion.cancel();
        guardar();
        this.dispose();
        Seleccion nuevoFrame = new Seleccion();
        nuevoFrame.setLocation(this.getLocation());
        nuevoFrame.setVisible(true);
    }//GEN-LAST:event_bt_CambiarMascotaActionPerformed

    private void bt_AlimentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AlimentarActionPerformed
         miMascota.alimentar();
    }//GEN-LAST:event_bt_AlimentarActionPerformed

    private void bt_AcariciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AcariciarActionPerformed
         miMascota.jugar();
    }//GEN-LAST:event_bt_AcariciarActionPerformed

    private void bt_BañarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_BañarActionPerformed
         miMascota.bañar();
    }//GEN-LAST:event_bt_BañarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
     JOptionPane.showMessageDialog(null, "Saliendo del Tamagotchi", "Hasta luego =)", JOptionPane.INFORMATION_MESSAGE);
     Actualizacion.cancel();
     guardar();
     System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        lb_Nivel.setVisible(true);
        miMascota.jugarHardcore();
    }//GEN-LAST:event_jButton1ActionPerformed
/**
     * @param args the command line arguments
     */
    
    
    public void pintar (){
        JProgressBar[] array_energias = {pb_Tristeza, pb_Suciedad, pb_Energia };
        for (int i =0; i < array_energias.length; i++){
            if (array_energias[i].getValue() >=60 ){
                if(array_energias[i] == pb_Energia){
                    array_energias[i].setForeground(Color.green);
                } else{
                    array_energias[i].setForeground(Color.red);
                }
            }
            else if(array_energias[i].getValue() >=30){
                array_energias[i].setForeground(Color.yellow);
            }
            else if(array_energias[i].getValue() >0){
                if(array_energias[i] == pb_Energia){
                    array_energias[i].setForeground(Color.red);
                } else{
                    array_energias[i].setForeground(Color.green);
                }
            }
        }
    }
    
    public void guardar(){
        
        String linea_txt = "";
        String arrayLineas[] = new String [5];
        int indiceLineas = 0;
        
        try {
            // Lectura de Tamagotchis guardados
            BufferedReader lector = new BufferedReader(new FileReader(ruta));
            while((linea_txt = lector.readLine()) != null){
                arrayLineas[indiceLineas] = linea_txt;
                indiceLineas++;
            }
            lector.close();
            // Escritura de nuevo Tamagotchi
            BufferedWriter guardado = new BufferedWriter(new FileWriter(ruta));
            for (int i = 0; i < arrayLineas.length; i++) { 
                if( arrayLineas[i] != null ){
                    if(i == (tamagotchiSeleccionado - 1)) {
                        guardado.write(miMascota.clase + "," + miMascota.nombre + "," + miMascota.status + "," +miMascota.vida +"," + miMascota.tristeza +"," + miMascota.suciedad);
                    } else {
                        guardado.write(arrayLineas[i]);
                    }
                    guardado.newLine();
                }
            }
            guardado.close();
        } catch ( IOException exception ) {
            JOptionPane.showMessageDialog(null,"No se pudo crear el Tamagotchi"  , "Ups, ha ocurrido un error" , JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void revisarTamagotchi (){
        String linea_txt = "";
        String arrayLineas[] = new String [5];
        int indiceLineas = 0;
        
        if ("Muerto".equals(miMascota.status)){
            Actualizacion.cancel();
            try {
                // Lectura de Tamagotchis guardados
                BufferedReader lector = new BufferedReader(new FileReader(ruta));
                while((linea_txt = lector.readLine()) != null){
                    arrayLineas[indiceLineas] = linea_txt;
                    indiceLineas++;
                }
                lector.close();
                // Escritura de nuevo Tamagotchi
                BufferedWriter guardado = new BufferedWriter(new FileWriter(ruta));
                for (int i = 0; i < arrayLineas.length; i++) { 
                    if( arrayLineas[i] != null ){
                        if(i != (tamagotchiSeleccionado - 1)) {
                            guardado.write(arrayLineas[i]);
                            guardado.newLine();
                        }
                    }
                }
                guardado.close();
            } catch ( IOException exception ) {
                JOptionPane.showMessageDialog(null,"Ocurrio un Error"  , "Ups, ha ocurrido un error" , JOptionPane.INFORMATION_MESSAGE);
            }
            JOptionPane.showMessageDialog(null,"Se petateo tu Tamagotchu"  , ":(" , JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            Seleccion nuevoFrame = new Seleccion();
            nuevoFrame.setLocation(this.getLocation());
            nuevoFrame.setVisible(true);
        }
    }
//        if(pb_Energia.getValue() >= 60){
//            pb_Energia.setForeground(Color.green);
//        }
//        else if(pb_Energia.getValue() >= 30){
//            pb_Energia.setForeground(Color.yellow);
//        }
//        else if(pb_Energia.getValue() >= 0){
//            pb_Energia.setForeground(Color.red);
//        }
//    }
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Juego().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Acariciar;
    private javax.swing.JButton bt_Alimentar;
    private javax.swing.JButton bt_Bañar;
    private javax.swing.JButton bt_CambiarMascota;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_Energia;
    private javax.swing.JLabel lb_Felicidad;
    private javax.swing.JLabel lb_ImagenMascota;
    private javax.swing.JLabel lb_ImagenStatus;
    private javax.swing.JLabel lb_Nivel;
    private javax.swing.JLabel lb_Status;
    private javax.swing.JLabel lb_Suciedad;
    private javax.swing.JLabel lb_fondo;
    private javax.swing.JLabel lb_fondoTama;
    private javax.swing.JProgressBar pb_Energia;
    private javax.swing.JProgressBar pb_Suciedad;
    private javax.swing.JProgressBar pb_Tristeza;
    // End of variables declaration//GEN-END:variables
}
