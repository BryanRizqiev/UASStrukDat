package main.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import main.controller.VehicleController;
import main.model.Vehicle;
import main.utility.JDBCUtil;
import main.utility.SQLCommand;

public class PanelKeluar extends javax.swing.JPanel {

    /**
     * Creates new form panelCreate
     */
    VehicleController vController;
    ArrayList<Vehicle> listsIsOut;

    public PanelKeluar(VehicleController vController, ArrayList<Vehicle> listsIsOut) {
        this.vController = vController;
        this.listsIsOut = listsIsOut;
        initComponents();
        updateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNopol = new javax.swing.JLabel();
        txtNopol1 = new javax.swing.JTextField();
        txtNopol2 = new javax.swing.JTextField();
        txtNopol3 = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnOut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(500, 520));

        labelNopol.setText("No Polisi *");

        txtNopol1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNopol1KeyReleased(evt);
            }
        });

        txtNopol2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNopol2KeyTyped(evt);
            }
        });

        txtNopol3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNopol3KeyTyped(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnOut.setText("Keluar");
        btnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Plat", "Tipe", "Warna", "Bayar", "Waktu Keluar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(250);
        }

        jLabel1.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel1.setText("Kendaraan Keluar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOut, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelNopol)
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNopol1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNopol2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNopol3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNopol)
                    .addComponent(txtNopol1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNopol2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNopol3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOut)
                    .addComponent(btnReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtNopol1.setDocument(new UpperCaseDocument());
        txtNopol3.setDocument(new UpperCaseDocument());
    }// </editor-fold>//GEN-END:initComponents

    private void btnOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutActionPerformed

        if (txtNopol1.getText().isEmpty() || txtNopol2.getText().isEmpty() || txtNopol3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isi semua form");
            return;
        }
        String nopol = txtNopol1.getText() + "_" + txtNopol2.getText() + "_" + txtNopol3.getText();

        if (!vController.isExist(nopol)) {
            JOptionPane.showMessageDialog(this, "Kendaraan tidak ada di parkiran");
            return;
        }

        try {
            SQLCommand.updateIsOut(nopol, vController);
            JOptionPane.showMessageDialog(this, "Kendaraan telah keluar dari parkiran");
            SQLCommand.getAllIsOut(listsIsOut);
            updateTable();
            txtNopol1.setText("");
            txtNopol2.setText("");
            txtNopol3.setText("");
        } catch (Exception ex) {
            Logger.getLogger(PanelKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOutActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtNopol1.setText("");
        txtNopol2.setText("");
        txtNopol3.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtNopol1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNopol1KeyReleased
        // Pindah form jika panjang teks di dalam textfield sudah mencapai 2 karakter
        if (txtNopol1.getText().length() == 2) {
            txtNopol2.requestFocus();
        }
    }//GEN-LAST:event_txtNopol1KeyReleased

    private void txtNopol2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNopol2KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c == java.awt.event.KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNopol2KeyTyped

    private void txtNopol3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNopol3KeyTyped
        if (txtNopol3.getText().length() >= 4) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNopol3KeyTyped

    // Lemot karena query
    private void updateTable() {
        try {
            DefaultTableModel dataModel = (DefaultTableModel) jTable1.getModel();
            dataModel.setRowCount(0);

            for (Vehicle data : listsIsOut) {
                dataModel.addRow(data.getDataVehicleOut());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Membuat kelas yang meng-override kelas AbstractDocument
    public static class UpperCaseDocument extends PlainDocument {

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str == null) {
                return;
            }
            super.insertString(offs, str.toUpperCase(), a);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOut;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelNopol;
    private javax.swing.JTextField txtNopol1;
    private javax.swing.JTextField txtNopol2;
    private javax.swing.JTextField txtNopol3;
    // End of variables declaration//GEN-END:variables
}
