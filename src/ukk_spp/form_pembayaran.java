/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukk_spp;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MyPC
 */
public class form_pembayaran extends javax.swing.JFrame {
     Connection con;
    DefaultTableModel tm;
    String idpembayaran;
    
    
    public void connect() {
        con= null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/db_spp","root", "");
        }
    catch (Exception e) {
            System.out.print("EROR KONEKSI KE DATABASES:\n" + e + "\n\n");
        }
    }
    
    private void refreshTable() {
        tm = new DefaultTableModel(null, new Object[] {"N0", "Nama Petugas", "NISN", "Nama Siswa", "Tanggal", "Bulan Bayar ", "Tarif", "Jumlah Bayar"});
        tbPembayaran.setModel(tm);
        tbPembayaran.removeColumn(tbPembayaran.getColumnModel().getColumn(0));
        tm.getDataVector().removeAllElements();
        try {
            PreparedStatement s = con.prepareStatement("SELECT pembayaran.id_pembayaran, user.nama_user, pembayaran.nisn, "
                + "siswa.nama, pembayaran.tgl_bayar, pembayaran.bulan_bayar, spp.nominal, pembayaran.jumlah_dibayar FROM pembayaran INNER JOIN "
                + "siswa USING(nisn) INNER JOIN spp on siswa.id_spp = spp.id_spp inner join user on "
                + "pembayaran.id_user = user.id_user");
            ResultSet r = s.executeQuery();
            while(r.next()){
                Object[] data={
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getString(4),
                    r.getString(5),
                    r.getString(6),
                    r.getString(7),
                    r.getString(8)
                 };
                 tm.addRow(data);
            }
        } catch (Exception e) {
            System.out.print("EROR KUERI KE DATABASE:\n" + e + "\n\n");
                }
            }
    
    public void cbidpetugas() {
        try {
            PreparedStatement s = con.prepareStatement("SELECT * FROM user WHERE level='admin' or level='petugas'");
            ResultSet r = s.executeQuery();
            while (r.next()) {
                cbIdpetugas.addItem(r.getString("nama_user"));
            }
            }catch (Exception e) {
        }
    }
    
    public void cbnisn() {
        try {
            PreparedStatement s = con.prepareStatement("SELECT * FROM siswa");
            ResultSet r = s.executeQuery();
            while (r.next()) {
                cbNisn.addItem(r.getString("nisn"));
            }
            }catch (Exception e) {
        }
    }
    
    private void nominal(){
        try {
            PreparedStatement s = con.prepareStatement("SELECT * FROM spp");
            ResultSet r = s.executeQuery();
            while (r.next()) {
                cbtarif.addItem(r.getString("nominal"));
            }
        }catch(Exception e){
            }
        }
    
    

    /**
     * Creates new form form_pembayaran
     */
    public form_pembayaran() {
        initComponents();
        connect();
        cbidpetugas();
        cbnisn();
        nominal();
        refreshTable();
       txtidpetugas.hide();
       txtTarif.hide();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbIdpetugas = new javax.swing.JComboBox<>();
        cbNisn = new javax.swing.JComboBox<>();
        jTgl = new com.toedter.calendar.JDateChooser();
        txtJmlbayar = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtidpetugas = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTarif = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSiswa = new javax.swing.JTextField();
        cbtarif = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbBulan = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPembayaran = new javax.swing.JTable();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 255), new java.awt.Color(51, 51, 255), new java.awt.Color(51, 51, 255), new java.awt.Color(51, 51, 255)));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("DATA PEMBAYARAN");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ukk_spp/icons-Pembayaran-1-removebg-preview (1) (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("NAMA PETUGAS");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("NISN");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("TGL BAYAR");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("JUMLAH BAYAR");

        cbIdpetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIdpetugasActionPerformed(evt);
            }
        });
        cbIdpetugas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbIdpetugasKeyPressed(evt);
            }
        });

        cbNisn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNisnActionPerformed(evt);
            }
        });
        cbNisn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbNisnKeyPressed(evt);
            }
        });

        btnTambah.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ukk_spp/icon_tambah-removebg-preview.png"))); // NOI18N
        btnTambah.setText("SAVE");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ukk_spp/edit-removebg-preview (1).png"))); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ukk_spp/delete-removebg-preview (1).png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtidpetugas.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("TARIF SPP");

        txtTarif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTarifActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NAMA SISWA");

        cbtarif.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Tarif" }));
        cbtarif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtarifActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("BULAN BAYAR");

        cbBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(230, 230, 230)
                                .addComponent(txtTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtJmlbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbNisn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbIdpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(txtidpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbtarif, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addGap(37, 37, 37)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbIdpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbNisn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbtarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtJmlbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 255), new java.awt.Color(51, 51, 255), new java.awt.Color(51, 51, 255), new java.awt.Color(51, 51, 255)));

        tbPembayaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tbPembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPembayaranMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPembayaran);

        btnCari.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ukk_spp/cari__1_-removebg-preview.png"))); // NOI18N
        btnCari.setText("CARI");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel7.setText("Cari Berdasarkan Nama Siswa");

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ukk_spp/exit-removebg-preview (1).png"))); // NOI18N
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(btnCari)
                .addGap(26, 26, 26)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(169, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(50, 50, 50))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnExit)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if ( cbIdpetugas.getSelectedItem().equals("") || cbNisn.getSelectedItem().equals("") || txtSiswa.getText().equals("") || cbBulan.getSelectedItem().equals("")|| txtTarif.getText().equals("") || txtJmlbayar.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Data harus terisi semua!");
        }else {
        String tampilTanggal = "yyyy-MM-dd";
        SimpleDateFormat df = new SimpleDateFormat(tampilTanggal);
        String tanggal = String.valueOf(df.format(jTgl.getDate()));
        
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE pembayaran SET id_user=?, nisn=?, tgl_bayar=?, bulan_bayar=?, id_spp=?, jumlah_dibayar=? WHERE id_pembayaran=?");
            ps.setInt(1, 0);
            ps.setString(2, txtidpetugas.getText());
            ps.setString(3, cbNisn.getSelectedItem().toString());
            ps.setString(4, tanggal);
            ps.setString(5, cbBulan.getSelectedItem().toString());
            ps.setString(6, txtTarif.getText());
            ps.setString(7, txtJmlbayar.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data telah di update" );
            
            refreshTable();
            cbIdpetugas.setSelectedItem("");
            cbNisn.setSelectedItem("");
            txtJmlbayar.setText("");
        } catch (Exception e) {
            System.out.print("ERROR KUERI KE DATABSE:\n" + e + "\n\n");
        }
        }
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        if (cbIdpetugas.getSelectedItem().equals("") || cbNisn.getSelectedItem().equals("") || txtSiswa.getText().equals("") || cbBulan.getSelectedItem().equals("") || txtTarif.getText().equals("") || txtJmlbayar.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Data harus terisi semua!");
        }else {
        String tampilTanggal = "yyyy-MM-dd";
        SimpleDateFormat df = new SimpleDateFormat(tampilTanggal);
        String tanggal = String.valueOf(df.format(jTgl.getDate()));
        
        
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO pembayaran VALUES (?,?,?,?,?,?,?)");
            ps.setInt(1, 0);
            ps.setString(2, txtidpetugas.getText());
            ps.setString(3, cbNisn.getSelectedItem().toString());
            ps.setString(4, tanggal);
            ps.setString(5, cbBulan.getSelectedItem().toString());
            ps.setString(6, txtTarif.getText());
            ps.setString(7, txtJmlbayar.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data telah tersimpan" );
            
            refreshTable();
            cbIdpetugas.setSelectedItem("");
            cbNisn.setSelectedItem("");
            txtJmlbayar.setText("");
        } catch (Exception e) {
            System.out.print("ERROR KUERI KE DATABSE:\n" + e + "\n\n");
        }
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String tampilTanggal = "yyyy-MM-dd";
        SimpleDateFormat df = new SimpleDateFormat(tampilTanggal);
        String tanggal = String.valueOf(df.format(jTgl.getDate()));
        
        
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM pembayaran WHERE id_pembayaran=?");
            ps.setString(1, idpembayaran);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data telah di hapus" );
            
            refreshTable();
            cbIdpetugas.setSelectedItem("");
            cbNisn.setSelectedItem("");
            txtJmlbayar.setText("");
        } catch (Exception e) {
            System.out.print("ERROR KUERI KE DATABSE:\n" + e + "\n\n");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        dispose();
        login log = new login();
        log.show();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        tm = new DefaultTableModel(null, new Object[] {"No", "Nama Petugas", "NISN", "Nama Siswa", "Tanggal", "Bulan Bayar","Tarif", "Jumlah Bayar"});
        tbPembayaran.setModel(tm);
        tbPembayaran.removeColumn(tbPembayaran.getColumnModel().getColumn(0));
        tm.getDataVector().removeAllElements();
        try {
            PreparedStatement s = con.prepareStatement("SELECT pembayaran.id_pembayaran, user.nama_user, pembayaran.nisn, "
                + "siswa.nama, pembayaran.tgl_bayar, pembayaran.bulan_bayar, spp.nominal, pembayaran.jumlah_dibayar FROM pembayaran INNER JOIN "
                + "siswa USING(nisn) INNER JOIN spp on siswa.id_spp = spp.id_spp inner join user on "
                + "pembayaran.id_user = user.id_user WHERE nama LIKE '%" + txtCari.getText().toString() +"%'");
            ResultSet r = s.executeQuery();
            while(r.next()){
                Object[] data={
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getString(4),
                    r.getString(5),
                    r.getString(6),
                    r.getString(7),
                    r.getString(8)
                 };
                 tm.addRow(data);
            }
        } catch (Exception e) {
            System.out.print("EROR KUERI KE DATABASE:\n" + e + "\n\n");
                }
    }//GEN-LAST:event_btnCariActionPerformed

    private void tbPembayaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPembayaranMouseClicked
        // TODO add your handling code here:
        int i = tbPembayaran.getSelectedRow();
        if (i== -1) {
            return;
        }
        
        String Idpembayaran = (String) tm.getValueAt(i, 0);
        idpembayaran=Idpembayaran;
        
        String idpetugas = (String) tm.getValueAt(i, 1);
        cbIdpetugas.setSelectedItem(idpetugas);
        
        String nisn = (String) tm.getValueAt(i, 2);
        cbNisn.setSelectedItem(nisn);
        
        String siswa = (String) tm.getValueAt(i, 3);
        txtSiswa.setText(siswa);
        
        String tgl_bayar = (String) tm.getValueAt(i, 4);
        jTgl.setDate(Date.valueOf(tgl_bayar));
        
        String bulan = (String) tm.getValueAt(i, 5);
        cbBulan.setSelectedItem(bulan);
        
        String nominal = (String) tm.getValueAt(i, 6);
        cbtarif.setSelectedItem(nominal);
        
        String jmlbayar = (String) tm.getValueAt(i, 7);
        txtJmlbayar.setText(jmlbayar);
    }//GEN-LAST:event_tbPembayaranMouseClicked

    private void cbIdpetugasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbIdpetugasKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbIdpetugasKeyPressed

    private void cbNisnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbNisnKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cbNisnKeyPressed

    private void cbIdpetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIdpetugasActionPerformed
        // TODO add your handling code here:
        try {
            PreparedStatement s = con.prepareStatement("SELECT * FROM user where nama_user='"+ cbIdpetugas.getSelectedItem().toString() +"'");
            ResultSet r = s.executeQuery();
            while (r.next()) {
                txtidpetugas.setText(r.getString("id_user"));
            }
            }catch (Exception e) {
        }
    }//GEN-LAST:event_cbIdpetugasActionPerformed

    private void txtTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTarifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTarifActionPerformed

    private void cbNisnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNisnActionPerformed
        // TODO add your handling code here:
         try {
                PreparedStatement s = con.prepareStatement("SELECT * FROM siswa WHERE nisn='"+ cbNisn.getSelectedItem().toString() +"'");
            ResultSet r = s.executeQuery();
            while (r.next()) {
                txtSiswa.setText(r.getString("nama"));
            }
            }catch (Exception e) {
        }
    }//GEN-LAST:event_cbNisnActionPerformed

    private void cbtarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtarifActionPerformed
        // TODO add your handling code here:
        try {
                PreparedStatement s = con.prepareStatement("SELECT * FROM spp WHERE nominal='"+ cbtarif.getSelectedItem().toString() +"'");
            ResultSet r = s.executeQuery();
            while (r.next()) {
                txtTarif.setText(r.getString("id_spp"));
                txtJmlbayar.setText(r.getString("nominal"));
            }
            }catch (Exception e) {
        }
    }//GEN-LAST:event_cbtarifActionPerformed

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
            java.util.logging.Logger.getLogger(form_pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_pembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cbBulan;
    private javax.swing.JComboBox<String> cbIdpetugas;
    private javax.swing.JComboBox<String> cbNisn;
    private javax.swing.JComboBox<String> cbtarif;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jTgl;
    private javax.swing.JTable tbPembayaran;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtJmlbayar;
    private javax.swing.JTextField txtSiswa;
    private javax.swing.JTextField txtTarif;
    private javax.swing.JTextField txtidpetugas;
    // End of variables declaration//GEN-END:variables
}