package bibliotecacliente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import BRMIBD.RMIBD;
import java.util.ArrayList;

public class registrarLibro extends javax.swing.JFrame {

    public registrarLibro() {

        initComponents();
      try {//cargar Categoria
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567/BRMIBD");
            interfaz.CargarCategorias();
            combocategoria.removeAllItems();
          for(int i=0; i<interfaz.CargarCategorias().size();i++){
              combocategoria.addItem(interfaz.CargarCategorias().get(i).getNombre());
          }

            
        } catch (RemoteException | NotBoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
//****************************************************************************************************
try {//cargar autor
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567/BRMIBD");
            interfaz.CargarAutor();
            comboautor.removeAllItems();
          for(int i=0; i<interfaz.CargarAutor().size();i++){
              comboautor.addItem(interfaz.CargarAutor().get(i).getNombre());
          }

            
        } catch (RemoteException | NotBoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }

//********************************************************************************************************
try {//cargar EDITORIAL
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567/BRMIBD");
            interfaz.CargarEditorial();
            comboeditorial.removeAllItems();
          for(int i=0; i<interfaz.CargarEditorial().size();i++){
              comboeditorial.addItem(interfaz.CargarEditorial().get(i).getEditorial());
          }

            
        } catch (RemoteException | NotBoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
//*****************************************************************************************************
try {//cargar PROCEDENCIA
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567/BRMIBD");
            interfaz.CargarProcedencia();
            comboprocedencia.removeAllItems();
          for(int i=0; i<interfaz.CargarProcedencia().size();i++){
              comboprocedencia.addItem(interfaz.CargarProcedencia().get(i).getProcedencia());
          }

            
        } catch (RemoteException | NotBoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
//**********************************************************************************************************
try {//cargar PROCEDENCIA
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567/BRMIBD");
            interfaz.CargarsubCategoria();
            combosubcategoria.removeAllItems();
          for(int i=0; i<interfaz.CargarsubCategoria().size();i++){
             combosubcategoria.addItem(interfaz.CargarsubCategoria().get(i).getSubcategoria());
          }

            
        } catch (RemoteException | NotBoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
//**********************************************************************************************************
      /*  cargarCategoria();
        cargarAutor();
        cargarEditorial();
        cargarProcedencia();
        cargarsubCategoria();
        limpiar();
       */ /**
         * ************************
         */
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567/BRMIBD");
            interfaz.mostrar();

            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            Object[] fila = new Object[12];
            for (int i = 0; i < interfaz.mostrar().size(); i++) {
                fila[0] = interfaz.mostrar().get(i).getCodigo();
                fila[1] = interfaz.mostrar().get(i).getNombre();
                fila[2] = interfaz.mostrar().get(i).getTitulo();
                fila[3] = interfaz.mostrar().get(i).getSubtitulo();
                fila[4] = interfaz.mostrar().get(i).getEditorial();
                fila[5] = interfaz.mostrar().get(i).getAutor();
                fila[6] = interfaz.mostrar().get(i).getCategoria();
                fila[7] = interfaz.mostrar().get(i).getSubcategoria();
                fila[8] = interfaz.mostrar().get(i).getProcedencia();
                fila[9] = interfaz.mostrar().get(i).getSerie();
                fila[10] = interfaz.mostrar().get(i).getFecha();
                fila[11] = interfaz.mostrar().get(i).getCantidad();

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
        txtnombre = new javax.swing.JTextField();
        txttitulo = new javax.swing.JTextField();
        txtsubtitulo = new javax.swing.JTextField();
        txtcodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        comboeditorial = new javax.swing.JComboBox<>();
        comboautor = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        combosubcategoria = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtserie = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        txtcantidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comboprocedencia = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        combocategoria = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Libro");
        setFont(new java.awt.Font("Agency FB", 1, 10)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Libro"));

        jLabel1.setText("CODIGO:");

        jLabel2.setText("NOMBRE:");

        jLabel3.setText("TITULO:");

        jLabel4.setText("SUBTITULO:");

        jLabel5.setText("EDITORIAL:");

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

        comboeditorial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel6.setText("AUTOR:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(72, 72, 72)
                                .addComponent(comboautor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3))
                                    .addGap(63, 63, 63)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtcodigo)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(21, 21, 21))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtsubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboeditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txttitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(62, 62, 62)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 21, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txttitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtsubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboeditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboautor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Titulo", "Subtitulo", "Editorial", "Autor", "Categoria", "SubCategoria", "Procedencia", "Serie", "Fecha", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel12.setText("SubCategoria:");

        jLabel7.setText("SERIE:");

        jLabel8.setText("FECHA:");

        jLabel9.setText("CANTIDAD:");

        jLabel11.setText("Procedencia:");

        jLabel10.setText("Categoria:");

        combocategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(combosubcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtfecha)
                            .addComponent(txtserie)
                            .addComponent(comboprocedencia, 0, 190, Short.MAX_VALUE)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(combocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(combosubcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboprocedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtserie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

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

        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Guardar.png"))); // NOI18N
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1411453578_cancel.png"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Nuevo.png"))); // NOI18N
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cancelar2.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnnuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIngresar)
                .addGap(18, 18, 18)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalir)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btncancelar)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(btnEliminar)
                .addComponent(btnModificar)
                .addComponent(btnIngresar)
                .addComponent(btnnuevo))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsubtituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubtituloActionPerformed
    }//GEN-LAST:event_txtsubtituloActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // Ingresar Libro

        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int cod;
        String nom, tit, subt, edi, autor, cat, subcat, proc, serie, fec, cant;
        cod = Integer.parseInt(txtcodigo.getText());
        nom = txtnombre.getText();
        tit = txttitulo.getText();
        subt = txtsubtitulo.getText();
        edi = (String) comboeditorial.getSelectedItem();
        autor = (String) comboautor.getSelectedItem();
        cat = (String) combocategoria.getSelectedItem();
        subcat = (String) combosubcategoria.getSelectedItem();
        proc = (String) comboprocedencia.getSelectedItem();
        serie = txtserie.getText();
        fec = txtfecha.getText();
        cant = txtcantidad.getText();

        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567/BRMIBD");
            interfaz.Ingresar(cod, nom, tit, subt, edi, autor, cat, subcat, proc, serie, fec, cant);
            JOptionPane.showMessageDialog(null, "Registro Con Exito");
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            limpiar();
            Object[] fila = new Object[12];
            for (int i = 0; i < interfaz.mostrar().size(); i++) {
                fila[0] = interfaz.mostrar().get(i).getCodigo();
                fila[1] = interfaz.mostrar().get(i).getNombre();
                fila[2] = interfaz.mostrar().get(i).getTitulo();
                fila[3] = interfaz.mostrar().get(i).getSubtitulo();
                fila[4] = interfaz.mostrar().get(i).getEditorial();
                fila[5] = interfaz.mostrar().get(i).getAutor();
                fila[6] = interfaz.mostrar().get(i).getCategoria();
                fila[7] = interfaz.mostrar().get(i).getSubcategoria();
                fila[8] = interfaz.mostrar().get(i).getProcedencia();
                fila[9] = interfaz.mostrar().get(i).getSerie();
                fila[10] = interfaz.mostrar().get(i).getFecha();
                fila[11] = interfaz.mostrar().get(i).getCantidad();

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
        String nom, tit, subt, edi, autor, cat, subcat, proc, serie, fec, cant;
        cod = Integer.parseInt(txtcodigo.getText());
        nom = txtnombre.getText();
        tit = txttitulo.getText();
        subt = txtsubtitulo.getText();
        edi = (String) comboeditorial.getSelectedItem();
        autor = (String) comboautor.getSelectedItem();
        cat = (String) combocategoria.getSelectedItem();
        subcat = (String) combosubcategoria.getSelectedItem();
        proc = (String) comboprocedencia.getSelectedItem();
        serie = txtserie.getText();
        fec = txtfecha.getText();
        cant = txtcantidad.getText();

        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567/BRMIBD");
            interfaz.modificar(cod, nom, tit, subt, edi, autor, cat, subcat, proc, serie, fec, cant);
            JOptionPane.showMessageDialog(null, "modificado Con Exito");
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            limpiar();
            Object[] fila = new Object[12];
            for (int i = 0; i < interfaz.mostrar().size(); i++) {
                fila[0] = interfaz.mostrar().get(i).getCodigo();
                fila[1] = interfaz.mostrar().get(i).getNombre();
                fila[2] = interfaz.mostrar().get(i).getTitulo();
                fila[3] = interfaz.mostrar().get(i).getSubtitulo();
                fila[4] = interfaz.mostrar().get(i).getEditorial();
                fila[5] = interfaz.mostrar().get(i).getAutor();
                fila[6] = interfaz.mostrar().get(i).getCategoria();
                fila[7] = interfaz.mostrar().get(i).getSubcategoria();
                fila[8] = interfaz.mostrar().get(i).getProcedencia();
                fila[9] = interfaz.mostrar().get(i).getSerie();
                fila[10] = interfaz.mostrar().get(i).getFecha();
                fila[11] = interfaz.mostrar().get(i).getCantidad();

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
                    RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567/BRMIBD");
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
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567/BRMIBD");
            int cod;

            cod = Integer.parseInt(txtcodigo.getText());

            if (interfaz.buscar_Libro(cod).isEmpty()) {

                JOptionPane.showMessageDialog(null, "no encontrado");
            } else {
                txtnombre.setText(interfaz.buscar_Libro(cod).get(0).getNombre());
                txttitulo.setText(interfaz.buscar_Libro(cod).get(0).getTitulo());
                txtsubtitulo.setText(interfaz.buscar_Libro(cod).get(0).getSubtitulo());

                comboeditorial.setSelectedItem(interfaz.buscar_Libro(cod).get(0).getEditorial());
                comboautor.setSelectedItem(interfaz.buscar_Libro(cod).get(0).getAutor());
                combocategoria.setSelectedItem(interfaz.buscar_Libro(cod).get(0).getCategoria());
                combosubcategoria.setSelectedItem(interfaz.buscar_Libro(cod).get(0).getSubcategoria());
                comboprocedencia.setSelectedItem(interfaz.buscar_Libro(cod).get(0).getProcedencia());
                txtserie.setText(interfaz.buscar_Libro(cod).get(0).getSerie());
                txtfecha.setText(interfaz.buscar_Libro(cod).get(0).getFecha());
                txtcantidad.setText(interfaz.buscar_Libro(cod).get(0).getCantidad());
                limpiarbuscar();

            }

        } catch (RemoteException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
    }//GEN-LAST:event_btnBuscarActionPerformed
    }
    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void combocategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combocategoriaActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        limpiarNuevo();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_btncancelarActionPerformed

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
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> comboautor;
    private javax.swing.JComboBox combocategoria;
    private javax.swing.JComboBox<String> comboeditorial;
    private javax.swing.JComboBox<String> comboprocedencia;
    private javax.swing.JComboBox<String> combosubcategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtserie;
    private javax.swing.JTextField txtsubtitulo;
    private javax.swing.JTextField txttitulo;
    // End of variables declaration//GEN-END:variables

    public void cargarCategoria() {

        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567");

            combocategoria.removeAllItems();

            ArrayList<Entidad.Categoria> lista1 = interfaz.CargarCategorias();

            for (int i = 0; i < lista1.size(); i++) {
                Entidad.Categoria ocat = lista1.get(i);
                combocategoria.addItem(ocat.getCodigo() + " - " + ocat.getNombre());
            }

        } catch (RemoteException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void cargarAutor() {

        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567");

            comboautor.removeAllItems();

            ArrayList<Entidad.Autor> lista1 = interfaz.CargarAutor();

            for (int i = 0; i < lista1.size(); i++) {
                Entidad.Autor aut = lista1.get(i);
                comboautor.addItem(aut.getCodigo() + " - " + aut.getNombre());
            }

        } catch (RemoteException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void cargarEditorial() {

        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567");

            comboeditorial.removeAllItems();

            ArrayList<Entidad.Editorial> lista1 = interfaz.CargarEditorial();

            for (int i = 0; i < lista1.size(); i++) {
                Entidad.Editorial edi = lista1.get(i);
                comboeditorial.addItem(edi.getCodigo() + " - " + edi.getEditorial());
            }

        } catch (RemoteException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void cargarProcedencia() {

        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567");

            comboprocedencia.removeAllItems();

            ArrayList<Entidad.Procedencia> lista1 = interfaz.CargarProcedencia();

            for (int i = 0; i < lista1.size(); i++) {
                Entidad.Procedencia proc = lista1.get(i);
                comboprocedencia.addItem(proc.getCodigo() + " - " + proc.getProcedencia());
            }

        } catch (RemoteException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void cargarsubCategoria() {

        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 4567);
            RMIBD interfaz = (RMIBD) registro.lookup("rmi://localhost:4567");

            combosubcategoria.removeAllItems();

            ArrayList<Entidad.subCategoria> lista1 = interfaz.CargarsubCategoria();

            for (int i = 0; i < lista1.size(); i++) {
                Entidad.subCategoria sub = lista1.get(i);
                combosubcategoria.addItem(sub.getCodigo() + " - " + sub.getSubcategoria());
            }

        } catch (RemoteException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
/*Limpiar formularios*/
    public void limpiar() {
        //Habilitar los botones
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btncancelar.setEnabled(false);
        btnsalir.setEnabled(true);
        btnBuscar.setEnabled(true);
        btnnuevo.setEnabled(true);
        btnIngresar.setEnabled(false);

        //Habilitar los campos
        txtcodigo.setEnabled(true);
        txtnombre.setEnabled(false);
        txttitulo.setEnabled(false);
        txtsubtitulo.setEnabled(false);
        comboeditorial.setEnabled(false);
        comboautor.setEnabled(false);
        combocategoria.setEnabled(false);
        combosubcategoria.setEnabled(false);
        comboprocedencia.setEnabled(false);
        txtserie.setEnabled(false);
        txtfecha.setEnabled(false);
        txtcantidad.setEnabled(false);

//        //Limpiar Campos
        txtcodigo.setText("");
        txtnombre.setText("");
        txttitulo.setText("");
        txtsubtitulo.setText("");
        comboeditorial.setSelectedIndex(0);
        comboautor.setSelectedIndex(0);
        combocategoria.setSelectedIndex(0);
        combosubcategoria.setSelectedIndex(0);
        comboprocedencia.setSelectedIndex(0);

        txtserie.setText("");
        txtfecha.setText("");
        txtcantidad.setText("");
    }

    public void limpiarNuevo() {
        //Habilitar los botones
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btncancelar.setEnabled(true);
        btnsalir.setEnabled(false);
        btnIngresar.setEnabled(true);

        btnBuscar.setEnabled(false);
        btnnuevo.setEnabled(false);

        //Habilitar los campos
        txtcodigo.setEnabled(true);
        txtnombre.setEnabled(true);
        txttitulo.setEnabled(true);
        txtsubtitulo.setEnabled(true);
        comboeditorial.setEnabled(true);
        comboautor.setEnabled(true);
        combocategoria.setEnabled(true);
        combosubcategoria.setEnabled(true);
        comboprocedencia.setEnabled(true);
        txtserie.setEnabled(true);
        txtfecha.setEnabled(true);
        txtcantidad.setEnabled(true);

    }

    public void limpiarregistrar() {
        //Habilitar los botones
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btncancelar.setEnabled(false);
        btnsalir.setEnabled(true);

        btnBuscar.setEnabled(true);
        btnnuevo.setEnabled(true);
        btnIngresar.setEnabled(false);

        //Habilitar los campos
        txtcodigo.setEnabled(true);
        txtnombre.setEnabled(false);
        txttitulo.setEnabled(false);
        txtsubtitulo.setEnabled(false);
        comboeditorial.setEnabled(false);
        comboautor.setEnabled(false);
        combocategoria.setEnabled(false);
        combosubcategoria.setEnabled(false);
        comboprocedencia.setEnabled(false);
        txtserie.setEnabled(false);
        txtfecha.setEnabled(false);
        txtcantidad.setEnabled(false);

        //Limpiar Campos
        txtcodigo.setText("");
        txtnombre.setText("");
        txttitulo.setText("");
        txtsubtitulo.setText("");
        comboeditorial.setSelectedIndex(0);
        comboautor.setSelectedIndex(0);
        combocategoria.setSelectedIndex(0);
        combosubcategoria.setSelectedIndex(0);
        comboprocedencia.setSelectedIndex(0);
        txtserie.setText("");
        txtfecha.setText("");
        txtcantidad.setText("");
    }

    public void limpiarbuscar() {
        //Habilitar los botones
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btncancelar.setEnabled(true);
        btnsalir.setEnabled(false);

        btnBuscar.setEnabled(true);
        btnnuevo.setEnabled(false);
        btnIngresar.setEnabled(false);

        //Habilitar los campos
        txtcodigo.setEnabled(false);
        txtnombre.setEnabled(true);
        txttitulo.setEnabled(true);
        txtsubtitulo.setEnabled(true);
        comboeditorial.setEnabled(true);
        comboautor.setEnabled(true);
        combocategoria.setEnabled(true);
        combosubcategoria.setEnabled(true);
        comboprocedencia.setEnabled(true);
        txtserie.setEnabled(false);
        txtfecha.setEnabled(false);
        txtcantidad.setEnabled(false);

    }
}
