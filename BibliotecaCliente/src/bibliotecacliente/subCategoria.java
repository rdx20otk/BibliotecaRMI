/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecacliente;

import BRMIBD.RMIBD;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dani silva
 */
public class subCategoria extends javax.swing.JFrame {

    /**
     * Creates new form subCategoria
     */
    public subCategoria() {
        initComponents();
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567/BRMIBD");
            interfaz.CargarCategorias();
            combocategorias.removeAllItems();
          for(int i=0; i<interfaz.CargarCategorias().size();i++){
              combocategorias.addItem(interfaz.CargarCategorias().get(i).getNombre());
          }

            
        } catch (RemoteException | NotBoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }

     //   cargarCategoria();
//limpiar();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567/BRMIBD");
            interfaz.mostrarsubCategoria();

            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            Object[] fila = new Object[3];
            for (int i = 0; i < interfaz.mostrarsubCategoria().size(); i++) {
                fila[0] = interfaz.mostrarsubCategoria().get(i).getCodigo();
                fila[1] = interfaz.mostrarsubCategoria().get(i).getSubcategoria();
                fila[2] = interfaz.mostrarsubCategoria().get(i).getCategoria();

                modelo.addRow(fila);
                tabla.setModel(modelo);
            }
        } catch (RemoteException | NotBoundException e) {
            JOptionPane.showMessageDialog(null, e);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtsubcategoria = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        combocategorias = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btningresar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Codigo:");

        jLabel3.setText("subCategoria:");

        jLabel5.setText("Categorias");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtsubcategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(combocategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtsubcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(combocategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Buscar:");

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Buscar.png"))); // NOI18N
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtbuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "SubCategoria", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Nuevo.png"))); // NOI18N
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btningresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Guardar.png"))); // NOI18N
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Borrar2.png"))); // NOI18N
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Modificar.png"))); // NOI18N
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cancelar2.png"))); // NOI18N
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1411453578_cancel.png"))); // NOI18N
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnnuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btningresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnmodificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btneliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btncancelar))
                    .addComponent(btnsalir))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btncancelar)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnnuevo)
                        .addComponent(btningresar)
                        .addComponent(btnmodificar)
                        .addComponent(btneliminar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalir))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567/BRMIBD");
            int cod;

            cod = Integer.parseInt(txtbuscar.getText());

            if (interfaz.buscarsubCategoria(cod).isEmpty()) {

                JOptionPane.showMessageDialog(null, "no encontrado");
            } else {
                txtcodigo.setText(Integer.toString(interfaz.buscarsubCategoria(cod).get(0).getCodigo()));

                txtsubcategoria.setText(interfaz.buscarsubCategoria(cod).get(0).getSubcategoria());
                combocategorias.setSelectedItem(interfaz.buscarsubCategoria(cod).get(0).getCategoria());
                limpiarbuscar();
            }

        } catch (RemoteException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        int cod;
        String nom, cat;

        cod = Integer.parseInt(txtcodigo.getText());
        nom = txtsubcategoria.getText();
        cat = (String) combocategorias.getSelectedItem();

        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567/BRMIBD");

            interfaz.IngresarsubCategoria(cod, nom, cat);

            JOptionPane.showMessageDialog(null, "Registro Con Exito");
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            limpiar();

            Object[] fila = new Object[3];
            for (int i = 0; i < interfaz.mostrarsubCategoria().size(); i++) {

                fila[0] = interfaz.mostrarsubCategoria().get(i).getCodigo();
                fila[1] = interfaz.mostrarsubCategoria().get(i).getSubcategoria();
                fila[2] = interfaz.mostrarsubCategoria().get(i).getCategoria();

                modelo.addRow(fila);
                tabla.setModel(modelo);
            }
        } catch (RemoteException | NotBoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_btningresarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int cod;
        String nom, cat;
        cod = Integer.parseInt(txtcodigo.getText());
        nom = txtsubcategoria.getText();
        cat = (String) combocategorias.getSelectedItem();

        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567/BRMIBD");
            interfaz.modificarsubCategoria(cod, nom, cat);
            JOptionPane.showMessageDialog(null, "modificado Con Exito");
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            limpiar();

            Object[] fila = new Object[3];
            for (int i = 0; i < interfaz.mostrarsubCategoria().size(); i++) {

                fila[0] = interfaz.mostrarsubCategoria().get(i).getCodigo();
                fila[1] = interfaz.mostrarsubCategoria().get(i).getSubcategoria();
                fila[2] = interfaz.mostrarsubCategoria().get(i).getCategoria();

                modelo.addRow(fila);
                tabla.setModel(modelo);
            }
        } catch (RemoteException | NotBoundException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int cod = 0;

        int a = tabla.getSelectedRow();

        if (a < 0) {
            JOptionPane.showMessageDialog(null, "debe seleccional una fila de la tabla");
        } else {
            int confirmar = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar el Registro? ");
            if (JOptionPane.OK_OPTION == confirmar) {

                try {
                    Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
                    RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567/BRMIBD");
                    cod = (int) modelo.getValueAt(a, 0);
                    interfaz.eliminarsubCategoria(cod);
                    modelo.removeRow(a);
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");

                } catch (RemoteException | NotBoundException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        limpiarNuevo();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnsalirActionPerformed

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
            java.util.logging.Logger.getLogger(subCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(subCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(subCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(subCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new subCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btningresar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> combocategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtsubcategoria;
    // End of variables declaration//GEN-END:variables
          public void cargarCategoria() {

        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567");

            combocategorias.removeAllItems();

            ArrayList<Entidad.Categoria> lista1 = interfaz.CargarCategorias();

            for (int i = 0; i < lista1.size(); i++) {
                Entidad.Categoria ocat = lista1.get(i);
                combocategorias.addItem(ocat.getNombre());
            }

        } catch (RemoteException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /*Limpiar formularios*/
    public void limpiar() {
        //Habilitar los botones
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(true);
        btncancelar.setEnabled(false);
        btnsalir.setEnabled(true);
        btnbuscar.setEnabled(true);
        btnnuevo.setEnabled(true);
        btningresar.setEnabled(false);

        //Habilitar los campos
        txtcodigo.setEnabled(false);
        txtsubcategoria.setEnabled(false);
                txtbuscar.setEnabled(true);

        combocategorias.setEnabled(false);

        //Limpiar Campos
        txtcodigo.setText("");
        txtsubcategoria.setText("");
        txtbuscar.setText("");

        combocategorias.setSelectedIndex(0);

    }

    public void limpiarNuevo() {
        //Habilitar los botones
        btnmodificar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(true);
        btnsalir.setEnabled(false);
        btningresar.setEnabled(true);

        btnbuscar.setEnabled(false);
        btnnuevo.setEnabled(false);

        //Habilitar los campos
        txtcodigo.setEnabled(true);
        txtsubcategoria.setEnabled(true);
          txtbuscar.setEnabled(false);
        combocategorias.setEnabled(true);

    }

    public void limpiarregistrar() {
        //Habilitar los botones
        btnmodificar.setEnabled(true);
        btneliminar.setEnabled(true);
        btncancelar.setEnabled(false);
        btnsalir.setEnabled(true);

        btnbuscar.setEnabled(true);
        btnnuevo.setEnabled(true);
        btningresar.setEnabled(false);

        //Habilitar los campos
        txtcodigo.setEnabled(true);
        txtsubcategoria.setEnabled(false);
        txtbuscar.setEnabled(false);
        combocategorias.setEnabled(false);

        //Limpiar Campos
        txtcodigo.setText("");
        txtsubcategoria.setText("");

        combocategorias.setSelectedIndex(0);

    }

    public void limpiarbuscar() {
        //Habilitar los botones
        btnmodificar.setEnabled(true);
        btneliminar.setEnabled(true);
        btncancelar.setEnabled(true);
        btnsalir.setEnabled(false);

        btnbuscar.setEnabled(false);
        btnnuevo.setEnabled(false);
        btningresar.setEnabled(false);

        //Habilitar los campos
        txtcodigo.setEnabled(false);
        txtsubcategoria.setEnabled(true);
                txtbuscar.setEnabled(false);

        combocategorias.setEnabled(true);
    }
}
