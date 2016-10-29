package bibliotecacliente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import BRMIBD.RMIBD;

public class registrarLibro extends javax.swing.JFrame {

    public registrarLibro() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4060/BRMIBD");
            interfaz.mostrar();

            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            Object[] fila = new Object[9];
            for (int i = 0; i < interfaz.mostrar().size(); i++) {
                fila[0] = interfaz.mostrar().get(i).getCodigo();
                fila[1] = interfaz.mostrar().get(i).getNombre();
                fila[2] = interfaz.mostrar().get(i).getTitulo();
                fila[3] = interfaz.mostrar().get(i).getSubtitulo();
                fila[4] = interfaz.mostrar().get(i).getEditorial();
                fila[5] = interfaz.mostrar().get(i).getAutor();
                fila[6] = interfaz.mostrar().get(i).getSerie();
                fila[7] = interfaz.mostrar().get(i).getFecharegistro();
                fila[8] = interfaz.mostrar().get(i).getCantidad();

                modelo.addRow(fila);
                jTable1.setModel(modelo);
            }
        } catch (RemoteException | NotBoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txttitulo = new javax.swing.JTextField();
        txtsubtitulo = new javax.swing.JTextField();
        txteditorial = new javax.swing.JTextField();
        txtautor = new javax.swing.JTextField();
        txtserie = new javax.swing.JTextField();
        txtcodigo = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Libro");
        setFont(new java.awt.Font("Agency FB", 1, 10)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Libro"));

        jLabel1.setText("CODIGO:");

        jLabel2.setText("NOMBRE:");

        jLabel3.setText("TITULO:");

        jLabel4.setText("SUBTITULO:");

        jLabel5.setText("EDITORIAL:");

        jLabel6.setText("AUTOR:");

        jLabel7.setText("SERIE:");

        jLabel8.setText("FECHA:");

        jLabel9.setText("CANTIDAD:");

        txtsubtitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubtituloActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Buscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Guardar.png"))); // NOI18N
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Modificar.png"))); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Borrar2.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txttitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(txtnombre))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIngresar)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnModificar)
                                        .addGap(40, 40, 40)
                                        .addComponent(btnEliminar))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtserie, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                        .addComponent(txtautor, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txteditorial, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtsubtitulo, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtcantidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                        .addComponent(txtfecha, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addComponent(jLabel4))
                        .addContainerGap(80, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txttitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtsubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txteditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtautor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(txtserie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(8, 8, 8))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Titulo", "Subtitulo", "Editorial", "Autor", "Serie", "Fecha", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir2.png"))); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsubtituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubtituloActionPerformed
    }//GEN-LAST:event_txtsubtituloActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // Ingresar Libro
        
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int cod;
        String nom, tit, subt, edi, autor, serie, freg, cant;
        cod = Integer.parseInt(txtcodigo.getText());
        nom = txtnombre.getText();
        tit = txttitulo.getText();
        subt = txtsubtitulo.getText();
        edi = txteditorial.getText();
        autor = txtautor.getText();
        serie = txtserie.getText();
        freg = txtfecha.getText();
        cant = txtcantidad.getText();

        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4060/BRMIBD");
            interfaz.Ingresar(cod, nom, tit, subt, edi, autor, serie, freg, cant);
            JOptionPane.showMessageDialog(null, "Registro Con Exito");
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            txtcodigo.setText("");
            txtnombre.setText("");
            txttitulo.setText("");
            txtsubtitulo.setText("");
            txteditorial.setText("");
            txtautor.setText("");
            txtserie.setText("");
            txtfecha.setText("");
            txtcantidad.setText("");

            Object[] fila = new Object[9];
            for (int i = 0; i < interfaz.mostrar().size(); i++) {
                fila[0] = interfaz.mostrar().get(i).getCodigo();
                fila[1] = interfaz.mostrar().get(i).getNombre();
                fila[2] = interfaz.mostrar().get(i).getTitulo();
                fila[3] = interfaz.mostrar().get(i).getSubtitulo();
                fila[4] = interfaz.mostrar().get(i).getEditorial();
                fila[5] = interfaz.mostrar().get(i).getAutor();
                fila[6] = interfaz.mostrar().get(i).getSerie();
                fila[7] = interfaz.mostrar().get(i).getFecharegistro();
                fila[8] = interfaz.mostrar().get(i).getCantidad();
                modelo.addRow(fila);
                jTable1.setModel(modelo);
            }
        } catch (RemoteException | NotBoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //Modificar Libro
        
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int cod;
        String nom, tit, subt, edi, autor, serie, freg, cant;
        cod = Integer.parseInt(txtcodigo.getText());
        nom = txtnombre.getText();
        tit = txttitulo.getText();
        subt = txtsubtitulo.getText();
        edi = txteditorial.getText();
        autor = txtautor.getText();
        serie = txtserie.getText();
        freg = txtfecha.getText();
        cant = txtcantidad.getText();

        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4060/BRMIBD");
            interfaz.modificar(cod, nom, tit, subt, edi, autor, serie, freg, cant);
            JOptionPane.showMessageDialog(null, "modificado Con Exito");
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            txtcodigo.setText("");
            txtnombre.setText("");
            txttitulo.setText("");
            txtsubtitulo.setText("");
            txteditorial.setText("");
            txtautor.setText("");
            txtserie.setText("");
            txtfecha.setText("");
            txtcantidad.setText("");

            Object[] fila = new Object[9];
            for (int i = 0; i < interfaz.mostrar().size(); i++) {
                fila[0] = interfaz.mostrar().get(i).getCodigo();
                fila[1] = interfaz.mostrar().get(i).getNombre();
                fila[2] = interfaz.mostrar().get(i).getTitulo();
                fila[3] = interfaz.mostrar().get(i).getSubtitulo();
                fila[4] = interfaz.mostrar().get(i).getEditorial();
                fila[5] = interfaz.mostrar().get(i).getAutor();
                fila[6] = interfaz.mostrar().get(i).getSerie();
                fila[7] = interfaz.mostrar().get(i).getFecharegistro();
                fila[8] = interfaz.mostrar().get(i).getCantidad();
                modelo.addRow(fila);
                jTable1.setModel(modelo);
            }
        } catch (RemoteException | NotBoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Eliminar Libro

        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int cod = 0;

        int a = jTable1.getSelectedRow();

        if (a < 0) {
            JOptionPane.showMessageDialog(null, "debe seleccional una fila de la tabla");
        } else {
            int confirmar = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar el Registro? ");
            if (JOptionPane.OK_OPTION == confirmar) {

                try {
                    Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
                    RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4060/BRMIBD");
                    cod = (int) modelo.getValueAt(a, 0);
                    interfaz.eliminar(cod);
                    modelo.removeRow(a);
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");

                } catch (RemoteException | NotBoundException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // Buscar Libro
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4060/BRMIBD");
            int cod;

            cod = Integer.parseInt(txtcodigo.getText());

            if (interfaz.buscar_Libro(cod).isEmpty()) {

                JOptionPane.showMessageDialog(null, "no encontrado");
            } else {
                txtnombre.setText(interfaz.buscar_Libro(cod).get(0).getNombre());
                txttitulo.setText(interfaz.buscar_Libro(cod).get(0).getTitulo());
                txtsubtitulo.setText(interfaz.buscar_Libro(cod).get(0).getSubtitulo());
                txteditorial.setText(interfaz.buscar_Libro(cod).get(0).getEditorial());
                txtautor.setText(interfaz.buscar_Libro(cod).get(0).getAutor());
                txtserie.setText(interfaz.buscar_Libro(cod).get(0).getSerie());
                txtfecha.setText(interfaz.buscar_Libro(cod).get(0).getFecharegistro());
                txtcantidad.setText(interfaz.buscar_Libro(cod).get(0).getCantidad());

            }

        } catch (RemoteException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
    }//GEN-LAST:event_btnBuscarActionPerformed
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html;
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(registrarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registrarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registrarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registrarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrarLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtautor;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txteditorial;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtserie;
    private javax.swing.JTextField txtsubtitulo;
    private javax.swing.JTextField txttitulo;
    // End of variables declaration//GEN-END:variables
}
