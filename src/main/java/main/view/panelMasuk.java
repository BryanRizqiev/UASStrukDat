package main.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import main.utility.JDBCUtil;
import main.utility.SQLCommand;

public class panelMasuk extends javax.swing.JPanel {

    /**
     * Creates new form panelCreate
     */
    public panelMasuk() {
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

        btnReset = new javax.swing.JButton();
        labelNopol = new javax.swing.JLabel();
        txtNopol = new javax.swing.JTextField();
        labelTipe = new javax.swing.JLabel();
        txtWarna = new javax.swing.JTextField();
        labelWarna = new javax.swing.JLabel();
        cbtipe = new javax.swing.JComboBox<>();
        btnSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        labelNopol.setText("No Polisi");

        labelTipe.setText("Tipe");

        labelWarna.setText("Warna");

        cbtipe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Motor", "Mobil" }));

        btnSimpan.setText("Masuk");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Plat", "Tipe", "Warna", "Waktu Masuk"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        jLabel1.setFont(new java.awt.Font("Inter", 3, 13)); // NOI18N
        jLabel1.setText("*biaya parkir : Rp. 1000/Jam");

        jLabel2.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel2.setText("Kendaraan Masuk");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelNopol)
                                .addGap(68, 68, 68)
                                .addComponent(txtNopol, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelWarna)
                                    .addComponent(labelTipe))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtWarna, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(cbtipe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNopol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNopol))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTipe)
                    .addComponent(cbtipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtWarna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelWarna))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtNopol.setDocument(new UpperCaseDocument());
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String nopol = txtNopol.getText().replace(" ", "_"),
                tipe = String.valueOf(cbtipe.getSelectedItem()),
                warna = txtWarna.getText();

        if (nopol.isEmpty() || warna.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isi semua form");
            return;
        }

        if (SQLCommand.isExist(nopol)) {
            JOptionPane.showMessageDialog(this, "Kendaraan sudah berada di parkiran");
            return;
        }

        try {
            SQLCommand.create(nopol, tipe, warna);
            JOptionPane.showMessageDialog(this, "Kendaraan berhasil parkir");
            updateTable();

            txtNopol.setText("");
            cbtipe.setSelectedIndex(0);
            txtWarna.setText("");
        } catch (Exception ex) {
            Logger.getLogger(panelMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtNopol.setText("");
        cbtipe.setSelectedIndex(0);
        txtWarna.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void updateTable() {
        try {
            DefaultTableModel dataModel = (DefaultTableModel) jTable1.getModel();
            dataModel.setRowCount(0);
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM vehicles WHERE is_out = 0 ORDER BY in_time ASC";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet res = st.executeQuery();

            while (res.next()) {
                String nopol = res.getString("nopol").replace("_", " ");
                String tipe = res.getString("type");
                String color = res.getString("color");
                String inTime = res.getString("in_time");
                dataModel.addRow(new Object[]{nopol, tipe, color, inTime});
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
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cbtipe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelNopol;
    private javax.swing.JLabel labelTipe;
    private javax.swing.JLabel labelWarna;
    private javax.swing.JTextField txtNopol;
    private javax.swing.JTextField txtWarna;
    // End of variables declaration//GEN-END:variables
}
