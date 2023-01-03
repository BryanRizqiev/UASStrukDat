package main.view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import main.controller.VehicleController;
import main.model.Vehicle;
import main.utility.SQLCommand;
import main.utility.Sorting;
import org.json.JSONObject;

public class PanelMasuk extends javax.swing.JPanel {

    /**
     * Creates new form panelCreate
     */
    VehicleController vController;
    ArrayList<Vehicle> listsIsOut;

    public PanelMasuk(VehicleController vController, ArrayList<Vehicle> listIsOut) {
        this.vController = vController;
        this.listsIsOut = listIsOut;
        initComponents();
        labelCapacity.setText("Kapasitas : " + vController.count() + " / " + vController.size());
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuItemLihat = new javax.swing.JMenuItem();
        menuItemKeluar = new javax.swing.JMenuItem();
        btnReset = new javax.swing.JButton();
        labelNopol = new javax.swing.JLabel();
        labelTipe = new javax.swing.JLabel();
        txtWarna = new javax.swing.JTextField();
        labelWarna = new javax.swing.JLabel();
        cbtipe = new javax.swing.JComboBox<>();
        btnIn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtNopol1 = new javax.swing.JTextField();
        txtNopol2 = new javax.swing.JTextField();
        txtNopol3 = new javax.swing.JTextField();
        labelNB = new javax.swing.JLabel();
        txtNB = new javax.swing.JTextField();
        labelNB1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        labelCapacity = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        menuItemLihat.setText("Lihat");
        menuItemLihat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLihatActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuItemLihat);

        menuItemKeluar.setText("Keluar");
        menuItemKeluar.setToolTipText("");
        menuItemKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemKeluarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuItemKeluar);

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        labelNopol.setText("No Polisi *");

        labelTipe.setText("Tipe *");

        labelWarna.setText("Warna *");

        cbtipe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Motor", "Mobil" }));

        btnIn.setText("Masuk");
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Plat", "Tipe", "Warna", "Nama / Brand", "Waktu Masuk"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(250);
        }

        jLabel2.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        jLabel2.setText("Kendaraan Masuk");

        txtNopol1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNopol1KeyTyped(evt);
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

        labelNB.setText("Nama / Brand");

        labelNB1.setText("Sort by: ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plat", "Waktu Masuk" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        labelCapacity.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        labelCapacity.setText("Kapasistas :");

        jButton1.setText("Bosan?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNopol)
                                    .addComponent(labelNB))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNB, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNopol1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNopol2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNopol3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelCapacity))
                                    .addComponent(cbtipe, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtWarna, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addComponent(labelTipe)
                            .addComponent(labelWarna))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelNB1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNopol)
                    .addComponent(txtNopol1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNopol2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNopol3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCapacity))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbtipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTipe))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWarna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelWarna))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNB)
                    .addComponent(txtNB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIn)
                    .addComponent(btnReset)
                    .addComponent(labelNB1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtNopol1.setDocument(new UpperCaseDocument());
        txtNopol3.setDocument(new UpperCaseDocument());
    }// </editor-fold>//GEN-END:initComponents

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {

        // blok kode dibawah ini berfungsi untuk insert ke tabel database dan meng-push data ke stack
        String nopol = txtNopol1.getText() + "_" + txtNopol2.getText() + "_" + txtNopol3.getText(),
                tipe = String.valueOf(cbtipe.getSelectedItem()),
                warna = txtWarna.getText(),
                nameOrBrand = txtNB.getText();

        if (txtNopol1.getText().isEmpty() || txtNopol2.getText().isEmpty() || txtNopol3.getText().isEmpty() || warna.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isi semua form");
            return;
        }

        // bisa tambahan fitur di dalam tipe, warna, nama atau mereknya apa
        if (vController.isExist(nopol)) {
            boolean isContinue = JOptionPane.showConfirmDialog(this, "Ada kendaraan dengan nopol yang sama di dalam, lanjutkan?", "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            if (!isContinue) {
                return;
            }
        }

        String selected = (String) cbtipe.getSelectedItem();
        int pay = (selected.equals("Motor")) ? 3000 : 5000;

        try {
            SQLCommand.create(nopol, tipe, warna, (!nameOrBrand.isEmpty() ? nameOrBrand : ""), pay, vController);
            JOptionPane.showMessageDialog(this, "Kendaraan berhasil parkir");
            updateTable();

            txtNopol1.setText("");
            txtNopol2.setText("");
            txtNopol3.setText("");
            cbtipe.setSelectedIndex(0);
            txtWarna.setText("");
            txtNB.setText("");
            labelCapacity.setText("Kapasitas : " + vController.count() + " / " + vController.size());
        } catch (Exception ex) {
            Logger.getLogger(PanelMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

        // membersihkan textfield
        txtNopol1.setText("");
        txtNopol2.setText("");
        txtNopol3.setText("");
        cbtipe.setSelectedIndex(0);
        txtWarna.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String choise = (String) jComboBox1.getSelectedItem();

        if (choise.equals("Plat") || choise.equals("Tipe") || choise.equals("Warna")) {
            Sorting.sort(vController.getDatas());
            updateTable();
        } else {
            Sorting.sortTime(vController.getDatas());
            updateTable();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void txtNopol3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNopol3KeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtNopol3.getText().length() > 2) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNopol3KeyTyped

    private void txtNopol2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNopol2KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == java.awt.event.KeyEvent.VK_BACK_SPACE) || (c == java.awt.event.KeyEvent.VK_DELETE))) {
            evt.consume();
        }
        if (txtNopol2.getText().length() == 4) {
            evt.consume();
            txtNopol3.requestFocus();
        }
    }//GEN-LAST:event_txtNopol2KeyTyped

    private void txtNopol1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNopol1KeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if (txtNopol1.getText().length() > 1) {
            evt.consume();
            txtNopol2.requestFocus();
        }
    }//GEN-LAST:event_txtNopol1KeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            int row = jTable1.rowAtPoint(evt.getPoint());
            // milih 1 baris dan akan di blok biru
            jTable1.setRowSelectionInterval(row, row);
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void menuItemLihatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLihatActionPerformed
        int row = jTable1.getSelectedRow();
        int id = (int) jTable1.getValueAt(row, 0);

        Vehicle vehicle = vController.getData(id);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Popup(vehicle).setVisible(true);
            }
        });
    }//GEN-LAST:event_menuItemLihatActionPerformed

    private void menuItemKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemKeluarActionPerformed
        int row = jTable1.getSelectedRow();

        boolean continueIt = JOptionPane.showConfirmDialog(this, "Yakin mau mengeluarkan?", "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        if (!continueIt) {
            return;
        }

        int id = (int) jTable1.getValueAt(row, 0);
        if (!vController.isExist(id)) {
            JOptionPane.showMessageDialog(this, "Kendaraan tidak ada di parkiran");
            return;
        }

        Timestamp now = new Timestamp(System.currentTimeMillis());
        now.setHours(now.getHours() - 7);

        Vehicle vehicle = vController.getData(id);
        vehicle.setOutTime(now);
        boolean printIt = JOptionPane.showConfirmDialog(this, "Kendaraan berhasil keluar, cetak?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        if (printIt) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Popup(vehicle).setVisible(true);
                }
            });
        }

        try {
            SQLCommand.updateIsOut(id, vController);
            JOptionPane.showMessageDialog(this, "Kendaraan telah keluar dari parkiran");
            SQLCommand.getAllIsOut(listsIsOut);
            updateTable();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            JOptionPane.showMessageDialog(this, "Error");
        }
    }//GEN-LAST:event_menuItemKeluarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        try {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://candaan-api.vercel.app/api/text/random"))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .GET()
                    .build();

            var responseFuture = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Ini sync");

            var response = responseFuture.get();

            if (response.statusCode() >= 400) {
                throw new IOException("Status >= 400");
            }

            // bug di tampilan
            JSONObject obj = new JSONObject(response.body());
            String data = obj.getString("data");

//            data = "<html>" + data + "</html>";
//            if (data.length() > 115) {
//                data = insertString(data, "<br><br>" , (int) (data.length() * 0.95));
//            }
            String finalData = data;
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    popupJokes(finalData);
                }
            });

        } catch (IOException | InterruptedException | ExecutionException exception) {
            System.out.println(exception.getMessage());
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static String insertString(String originalString, String stringToBeInserted, int index) {
        String newString = new String();

        for (int i = 0; i < originalString.length(); i++) {
            newString += originalString.charAt(i);
            if (i == index) {
                newString += stringToBeInserted;
            }
        }

        return newString;
    }

    private void popupJokes(String data) {
        PopupJokes popupJokes = new PopupJokes(data);
        popupJokes.setLocationRelativeTo(this);
        popupJokes.setVisible(true);
    }

    private void updateTable() {
        try {
            DefaultTableModel dataModel = (DefaultTableModel) jTable1.getModel();
            dataModel.setRowCount(0);

            Vehicle[] vehicles = vController.fetchDatas();

            for (Vehicle data : vehicles) {
                String timestamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(data.getInTime());
                dataModel.addRow(new Object[]{data.getId(), data.getNopol(), data.getType(), data.getColor(), data.getNameOrBrand(), timestamp});
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
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cbtipe;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelCapacity;
    private javax.swing.JLabel labelNB;
    private javax.swing.JLabel labelNB1;
    private javax.swing.JLabel labelNopol;
    private javax.swing.JLabel labelTipe;
    private javax.swing.JLabel labelWarna;
    private javax.swing.JMenuItem menuItemKeluar;
    private javax.swing.JMenuItem menuItemLihat;
    private javax.swing.JTextField txtNB;
    private javax.swing.JTextField txtNopol1;
    private javax.swing.JTextField txtNopol2;
    private javax.swing.JTextField txtNopol3;
    private javax.swing.JTextField txtWarna;
    // End of variables declaration//GEN-END:variables
}
