/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import ejerciciocolas.Fila;
import ejerciciocolas.GestorFilas;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Martin
 */
public class FrmColaDeportes extends javax.swing.JFrame {

    /**
     * Creates new form InterfazColaDeportes
     */
    public FrmColaDeportes() {
        initComponents();
        modelo.addColumn("Evento");
        modelo.addColumn("Reloj");
        modelo.addColumn("RND Dep");
        modelo.addColumn("Deporte");
        modelo.addColumn("Tiempo Entre Llegadas");
        modelo.addColumn("Proxima Llegada");
        modelo.addColumn("Cola");
        modelo.addColumn("Estado - CANCHA 1");
        modelo.addColumn("RND Ocup - CANCHA 1");
        modelo.addColumn("Tiempo Ocup - CANCHA 1");
        modelo.addColumn("Fin Ocup - CANCHA 1");
        modelo.addColumn("Estado - CANCHA 2");
        modelo.addColumn("RND Ocup - CANCHA 2");
        modelo.addColumn("Tiempo Ocup - CANCHA 2");
        modelo.addColumn("Fin Ocup - CANCHA 2");
        modelo.addColumn("ACUM Espera - Basket");
        modelo.addColumn("ACUM Espera - Futbol");
        modelo.addColumn("ACUM Espera - HandBall");
    }

    private DefaultTableModel modelo = new DefaultTableModel();
    private GestorFilas listaFilas;
    private ArrayList<Fila> filas = new ArrayList<>();
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        configuracion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_cantidadSim = new javax.swing.JTextField();
        btn_generar = new javax.swing.JButton();
        vector = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResultados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        configuracion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Cantidad de Simulaciones");

        btn_generar.setText("Generar");
        btn_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout configuracionLayout = new javax.swing.GroupLayout(configuracion);
        configuracion.setLayout(configuracionLayout);
        configuracionLayout.setHorizontalGroup(
            configuracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configuracionLayout.createSequentialGroup()
                .addContainerGap(308, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txt_cantidadSim, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_generar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(316, Short.MAX_VALUE))
        );
        configuracionLayout.setVerticalGroup(
            configuracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configuracionLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(configuracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_cantidadSim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_generar))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        vector.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Evento", "Reloj", "RND Dep", "Deporte", "Tiempo Entre Llegadas", "Proxima Llegada", "Cola", "Estado - CANCHA 1", "RND Ocup - CANCHA 1", "Tiempo Ocup - CANCHA 1", "Fin Ocup - CANCHA 1", "Estado - CANCHA 2", "RND Ocup - CANCHA 2", "Tiempo Ocup - CANCHA 2", "Fin Ocup - CANCHA 2", "ACUM Espera Basket", "ACUM Espera Futbol", "ACUM Espera Handball"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableResultados);

        javax.swing.GroupLayout vectorLayout = new javax.swing.GroupLayout(vector);
        vector.setLayout(vectorLayout);
        vectorLayout.setHorizontalGroup(
            vectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        vectorLayout.setVerticalGroup(
            vectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vectorLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(vector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(configuracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(configuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarActionPerformed
        // TODO add your handling code here:
        modelo.setRowCount(0);
        
        int cantidadSim = Integer.parseInt(txt_cantidadSim.getText());
        //verificar valor de cantidadSim
        listaFilas = new GestorFilas();
        //agrego filas
        
        for (int i = 0; i < cantidadSim; i++) {
                listaFilas.generarNuevoEvento(); 
        }
        Object [] fila = new Object[18];
        filas = listaFilas.getListaFilas();
        
        for (int i = 0; i < filas.size(); i++) {

            fila[0] = filas.get(i).getEvento();
            fila[1] = round(filas.get(i).getReloj(), 2);
            fila[2] = round(filas.get(i).getRndDeporte(), 2);
            fila[3] = filas.get(i).getDeporte();
            fila[4] = round(filas.get(i).getTiempoEntreLlegadas(), 2);
            fila[5] = round(filas.get(i).getProxLlegada(), 2);
            fila[6] = filas.get(i).getCola();
            fila[7] = filas.get(i).getCancha1().getEstado();
            fila[8] = round(filas.get(i).getCancha1().getRndOcupacion(), 2);
            fila[9] = round(filas.get(i).getCancha1().getTiempoOcupacion(), 2);
            fila[10] = round(filas.get(i).getCancha1().getFinOcupacion(), 2);
            fila[11] = filas.get(i).getCancha2().getEstado();
            fila[12] = round(filas.get(i).getCancha2().getRndOcupacion(), 2);
            fila[13] = round(filas.get(i).getCancha2().getTiempoOcupacion(), 2);
            fila[14] = round(filas.get(i).getCancha2().getFinOcupacion(), 2);
            fila[15] = round(filas.get(i).getAcumuladorBasket(),2);
            fila[16] = round(filas.get(i).getAcumuladorFutbol(),2);
            fila[17] = round(filas.get(i).getAcumuladorHandBall(),2);

            
            modelo.addRow(fila);
        }
        
            fila[0] ="-";
            fila[1] = "-";
            fila[2] = "-";
            fila[3] = "-";
            fila[4] = "-";
            fila[5] = "-";
            fila[6] = "-";
            fila[7] = "-";
            fila[8] = "-";
            fila[9] = "-";
            fila[10] = "-";
            fila[11] = "-";
            fila[12] = "-";
            fila[13] = "-";
            fila[14] = "-";
            fila[15] = filas.get(filas.size()-1).getAcumuladorBasket()/listaFilas.getContadorBasket();
            fila[16] = filas.get(filas.size()-1).getAcumuladorFutbol()/listaFilas.getContadorFutbol();
            fila[17] = filas.get(filas.size()-1).getAcumuladorHandBall()/listaFilas.getContadorHandBall();
            
            modelo.addRow(fila);
        
        jTableResultados.setModel(modelo);
    }//GEN-LAST:event_btn_generarActionPerformed

    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
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
            java.util.logging.Logger.getLogger(FrmColaDeportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmColaDeportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmColaDeportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmColaDeportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmColaDeportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_generar;
    private javax.swing.JPanel configuracion;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResultados;
    private javax.swing.JTextField txt_cantidadSim;
    private javax.swing.JPanel vector;
    // End of variables declaration//GEN-END:variables
}
