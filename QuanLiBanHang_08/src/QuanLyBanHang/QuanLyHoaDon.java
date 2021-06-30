/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHang;

import QuanLyBanHangDao.CTHD_Dao;
import QuanLyBanHangDao.HoaDon_Dao;
import QuanLyBanHangHelper.OracleJDBCConnection;
import QuanLyBanHangModel.CTHD;
import QuanLyBanHangModel.HoaDon;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;


/**
 *
 * @author Nguyen Linh
 */
public class QuanLyHoaDon extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyHoaDon
     */
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public QuanLyHoaDon() {
        initComponents();
        getContentPane().setBackground(Color.white); 
        Connect();
        HoaDon_Load();
        CTHD_Load();
    }
      /*public JPanel getJPanelNV()
    {
        return Panel_QuanLyHoaDon;
    }*/
    public JPanel getJPanelhd()
    {
        return Panel_QuanLyHoaDon;
    }
    
      public void Connect(){ //ket noi csdl
        try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.print("ket noi thanh cong");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
           conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","QuanLyBanHang", "qlbh");
        
        } catch (SQLException ex) {
            //Logger.getLogger(QuanLyHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void HoaDon_Load(){
           
        try {
            ps = conn.prepareStatement("SELECT * FROM HOADON ");
            rs = ps.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();
            //System.out.println(c);
            DefaultTableModel model = (DefaultTableModel) listHD.getModel();
            model.setRowCount(0);
            while (rs.next()){
                Vector v1 = new Vector();
               // for(int i=1;i<=c;i++){
                    v1.add(rs.getInt("SOHD"));
                    v1.add(rs.getDate("NGHD"));
                    v1.add(rs.getString("MAKH"));
                    v1.add(rs.getString("MANV"));
                    v1.add(rs.getLong("TRIGIA"));
                   // System.out.println("QuanLyBanHang.QuanLyHoaDon.HoaDon_Load()");
            //  }
                model.addRow(v1);
               listHD.setModel(model);
            }
            System.out.println("QuanLyBanHang.QuanLyHoaDon.HoaDon_Load()");
            
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
     public void CTHD_Load(){
           
        try {
            ps = conn.prepareStatement("SELECT * FROM CTHD ");
            rs = ps.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();
            //System.out.println(c);
            DefaultTableModel model = (DefaultTableModel) list_CTHD.getModel();
            model.setRowCount(0);
            while (rs.next()){
                Vector v1 = new Vector();
               // for(int i=1;i<=c;i++){
                    v1.add(rs.getString("MASP"));
                    v1.add(rs.getInt("SOHD"));
                    v1.add(rs.getInt("SL"));
//                    v1.add(rs.getString("MANV"));
//                    v1.add(rs.getLong("TRIGIA"));
                   // System.out.println("QuanLyBanHang.QuanLyHoaDon.HoaDon_Load()");
            //  }
                model.addRow(v1);
               list_CTHD.setModel(model);
            }
           // System.out.println("QuanLyBanHang.QuanLyHoaDon.HoaDon_Load()");
            
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void LamMoi(){
        txt_SoHD.setText("");
        txt_SoHD.setText("");
        txt_TriGia.setText("");
        txt_MaNV.setText("");
        txt_MaKH.setText("");
  }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_QuanLyHoaDon = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jBTimKiem = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jBCapNhat = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jBLamMoi = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_SoHD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_MaKH = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_MaNV = new javax.swing.JTextField();
        txt_TriGia = new javax.swing.JTextField();
        Date_NgayHD = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_CTHD = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listHD = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        jBTimKiem.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jBTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newIcon/find.png"))); // NOI18N
        jBTimKiem.setText("Tìm kiếm");
        jBTimKiem.setFocusable(false);
        jBTimKiem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBTimKiem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTimKiemActionPerformed(evt);
            }
        });
        jToolBar1.add(jBTimKiem);
        jToolBar1.add(jSeparator4);

        jBCapNhat.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jBCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newIcon/edit.png"))); // NOI18N
        jBCapNhat.setText("Cập nhật");
        jBCapNhat.setFocusable(false);
        jBCapNhat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBCapNhat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCapNhatActionPerformed(evt);
            }
        });
        jToolBar1.add(jBCapNhat);
        jToolBar1.add(jSeparator5);

        jBLamMoi.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jBLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newIcon/refresh.png"))); // NOI18N
        jBLamMoi.setText("Làm mới");
        jBLamMoi.setFocusable(false);
        jBLamMoi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBLamMoi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLamMoiActionPerformed(evt);
            }
        });
        jToolBar1.add(jBLamMoi);
        jToolBar1.add(jSeparator6);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Số HĐ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Ngày HĐ");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Mã Khách Hàng");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Mã NV");

        txt_MaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaKHActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Trị giá");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_SoHD)
                    .addComponent(txt_MaKH)
                    .addComponent(txt_MaNV)
                    .addComponent(txt_TriGia)
                    .addComponent(Date_NgayHD, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_SoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Date_NgayHD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_TriGia, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));

        list_CTHD.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        list_CTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã SP", "Số HD", "Số Lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        list_CTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_CTHDMouseClicked(evt);
            }
        });
        list_CTHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                list_CTHDKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(list_CTHD);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Bảng hoá đơn");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Bảng CTHD");

        listHD.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        listHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "SỐ HOÁ ĐƠN", "NGÀY HOÁ ĐƠN", "MÃ KHÁCH HÀNG", "MÃ NHÂN VIÊN", "TRỊ GIÁ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        listHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listHDMouseClicked(evt);
            }
        });
        listHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                listHDKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(listHD);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(348, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(294, 294, 294))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(254, 254, 254)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addGap(19, 19, 19))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(331, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout Panel_QuanLyHoaDonLayout = new javax.swing.GroupLayout(Panel_QuanLyHoaDon);
        Panel_QuanLyHoaDon.setLayout(Panel_QuanLyHoaDonLayout);
        Panel_QuanLyHoaDonLayout.setHorizontalGroup(
            Panel_QuanLyHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_QuanLyHoaDonLayout.createSequentialGroup()
                .addGroup(Panel_QuanLyHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Panel_QuanLyHoaDonLayout.setVerticalGroup(
            Panel_QuanLyHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_QuanLyHoaDonLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_QuanLyHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1101, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Panel_QuanLyHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 687, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Panel_QuanLyHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTimKiemActionPerformed
        // TODO add your handling code here:
          StringBuilder sb = new StringBuilder();
        if (txt_SoHD.getText().equals("")){
            sb.append("Số hoá đơn không được để trống!!!");
            txt_SoHD.setBackground(Color.yellow);
        } else {
             txt_SoHD.setBackground(Color.white);
        }
        if (sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
      try{      
        HoaDon_Dao dao = new HoaDon_Dao();
        HoaDon hd = dao.find(Integer.parseInt(txt_SoHD.getText()));
        if (hd != null){
            //XuatThongTin
        txt_SoHD.setText(String.valueOf(hd.getSoHD()));
        //txt.setText(hd.getHoTen());
        Date_NgayHD.setDate(hd.getNGHD());
        txt_MaNV.setText(hd.getMaNV());
        txt_MaKH.setText(hd.getMaKH());
        txt_TriGia.setText(String.valueOf(hd.getTriGia()));
        } else
        JOptionPane.showMessageDialog(this, "Số hoá đơn tìm kiếm không hợp lệ!");
        
      } catch (Exception e){
          JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
          e.printStackTrace();
      }  
    }//GEN-LAST:event_jBTimKiemActionPerformed

    private void jBCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCapNhatActionPerformed
        // TODO add your handling code here:
        /*StringBuilder sb = new StringBuilder();
        if (txtMahd.getText().equals("")){
            sb.append("Mã nhân viên không được để trống!!!");
            txtMahd.setBackground(Color.yellow);
        } else {
             txtMahd.setBackground(Color.white);
        }
        if (sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
      try{  
        HoaDon hd = new HoaDon();
        hd.setMahd(txtMahd.getText());
        hd.setHoTen(txtHoTen.getText());
        //Chuyen doi java.util.Date sang java.sql.Date
        if(jDNgVL.getDate() != null ){
        java.util.Date utilStartDate = jDNgVL.getDate();
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
        hd.setNgVL(sqlStartDate);
    }
        gtNam.setText("Nam");
        gtNu.setText("Nu");
        if(gtNam.isSelected()){
            hd.setGioiTinh(gtNam.getText());
        }
        if (gtNu.isSelected()){
             hd.setGioiTinh(gtNu.getText());
        }
        hd.setCMND(txtCMND.getText());
        hd.setDiaChi(txtDiaChi.getText());
        hd.setSoDT(txtSDT.getText());
        hd.setPassword(txtMatKhau.getText());    
        hd.setLoaihd(TxtLoaiHoaDon.getText());
        hd.setUserID(txtUserID.getText());
        HoaDonDao dao = new HoaDonDao();
        dao.update(hd);    
        JOptionPane.showMessageDialog(this, "Nhân viên được cập nhật thành công!");
        
      } catch (Exception e){
          JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
          e.printStackTrace();
      }  
      HoaDon_Load();
        */
    }//GEN-LAST:event_jBCapNhatActionPerformed

    private void jBLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLamMoiActionPerformed
        // TODO add your handling code here:
        LamMoi();
    }//GEN-LAST:event_jBLamMoiActionPerformed

    private void list_CTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_CTHDMouseClicked
        // TODO add your handling code here:
//        System.out.println("DMmmmm");
//        LamMoi();
//        int selectedIndex = listHD.getSelectedRow();
//        //listHD.setColumnSelectionInterval(0,7);
//        txt_SoHD.setText(listHD.getValueAt(selectedIndex, 0).toString());
//        txt_MaKH.setText(listHD.getValueAt(selectedIndex, 2).toString());
//
//        Date_NgayHD.setDate((Date) listHD.getValueAt(selectedIndex, 1));
//        // gioi tinh
//        txt_MaNV.setText(listHD.getValueAt(selectedIndex, 3).toString());        
//        txt_TriGia.setText(listHD.getValueAt(selectedIndex, 4).toString());
//        
//        System.out.println("DMmmmm");
        /*Xuat ban CTHD*/
       
        try{
            CTHD_Dao cthd_dao= new CTHD_Dao();
            ArrayList<CTHD> cthds = new ArrayList<CTHD>();
            cthds = cthd_dao.find(Integer.parseInt(txt_SoHD.getText()));
            //System.out.println("dsad"+cthds.size());
            ResultSetMetaData rsd = rs.getMetaData();
            
            DefaultTableModel model = (DefaultTableModel) list_CTHD.getModel();
            model.setRowCount(0);
            
            for(int i=0 ; i< cthds.size();i++){
                Vector v1 = new Vector();
              //  for(int i=1;i<=c;i++){
                    v1.add(rs.getString("MASP"));
                    v1.add(rs.getInt("SOHD"));
                    v1.add(rs.getInt("SL"));
             // }
                model.addRow(v1);
               //listNV.setModel(model);
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
             e.printStackTrace();
             //System.out.println("QuanLyBanHang.QuanLyHoaDon.list_CTHDMouseClicked()");
        }
    }//GEN-LAST:event_list_CTHDMouseClicked

    private void list_CTHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_list_CTHDKeyReleased
        // TODO add your handling code here:
//        LamMoi();
//        
//        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN){
//        int selectedIndex = listhd.getSelectedRow();
//        listhd.setColumnSelectionInterval(0,7);
//        txtMahd.setText(listhd.getValueAt(selectedIndex, 0).toString());
//        txtHoTen.setText(listhd.getValueAt(selectedIndex, 1).toString());
//        jDNgVL.setDate((Date) listhd.getValueAt(selectedIndex, 2));
//       
//        // gioi tinh
//        
//        String sex = listhd.getValueAt(selectedIndex, 3).toString();
//        if (sex.equals("Nu")){
//            gtNu.setSelected(true);
//            gtNam.setSelected(false);
//        } else if (sex.equals("Nam")){ gtNam.setSelected(true);
//        gtNu.setSelected(false);
//        }
//        
//        txtCMND.setText(listhd.getValueAt(selectedIndex, 4).toString());
//        txtDiaChi.setText(listhd.getValueAt(selectedIndex, 5).toString());
//        txtSDT.setText(listhd.getValueAt(selectedIndex, 6).toString());
//        txtUserID.setText(listhd.getValueAt(selectedIndex, 7).toString());
//        txtMatKhau.setText(listhd.getValueAt(selectedIndex, 8).toString());
//        TxtLoaiHoaDon.setText(listhd.getValueAt(selectedIndex, 9).toString());
//        Date date = null;
//        try {
//            date = new SimpleDateFormat("yyyy-MM-dd").parse((String)listhd.getValueAt(selectedIndex, 2));
//        } catch (ParseException ex) {
//            Logger.getLogger(QuanLyHoaDon.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        jDNgVL.setDate(date);
//           
//       }
    }//GEN-LAST:event_list_CTHDKeyReleased

    private void txt_MaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MaKHActionPerformed

    private void listHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listHDMouseClicked
        // TODO add your handling code here:
        LamMoi();
        int selectedIndex = listHD.getSelectedRow();
        //listHD.setColumnSelectionInterval(0,7);
        txt_SoHD.setText(listHD.getValueAt(selectedIndex, 0).toString());
        txt_MaKH.setText(listHD.getValueAt(selectedIndex, 2).toString());

        Date_NgayHD.setDate((Date) listHD.getValueAt(selectedIndex, 1));
        // gioi tinh
        txt_MaNV.setText(listHD.getValueAt(selectedIndex, 3).toString());        
        txt_TriGia.setText(listHD.getValueAt(selectedIndex, 4).toString());
        
        
        //System.out.println("dmmmmmmm");
        
//         try{
            //CTHD_Dao cthd_dao= new CTHD_Dao();
            //ArrayList<CTHD> cthds = new ArrayList<CTHD>();
             //System.out.println(Integer.parseInt(txt_SoHD.getText()));
            //cthds = cthd_dao.find(Integer.parseInt(txt_SoHD.getText()));
            //System.out.println("dsad"+ cthds.size());
           
           
            
                 try{
                      String SQL = "select * from CTHD where sohd= ?";
                      Connection conn = OracleJDBCConnection.getJDBCConnection();
                      PreparedStatement ps = conn.prepareStatement(SQL);
                      ps.setInt(1,Integer.parseInt(txt_SoHD.getText()));
                       ResultSet rs = ps.executeQuery();
               //System.out.println(soHD);      
                   // ps.setInt(1,Integer.parseInt(txt_SoHD.getText()));
                    ResultSetMetaData rsd = rs.getMetaData();
                    DefaultTableModel model = (DefaultTableModel) list_CTHD.getModel();
                    model.setRowCount(0);
                   
                   while(rs.next()){
                     CTHD cthd = new CTHD();
                      Vector v1 = new Vector();
                     // System.out.println(rs.getString("masp"));
                        v1.add(rs.getString("masp"));
                        v1.add(rs.getInt("sohd"));
                        v1.add(rs.getInt("sl"));
                        model.addRow(v1);
                   }
            //System.out.println("QuanLyBanHangDao dfsfsdffas"+ cthds.size());
        }catch(Exception e){
        }
            
//            ResultSetMetaData rsd = rs.getMetaData();
//            
//            DefaultTableModel model = (DefaultTableModel) list_CTHD.getModel();
//            model.setRowCount(0);
//            
//            for(int i=0 ; i< cthds.size();i++){
//                Vector v1 = new Vector();
//              //  for(int i=1;i<=c;i++){
//                    v1.add(rs.getString("MASP"));
//                    v1.add(rs.getInt("SOHD"));
//                    v1.add(rs.getInt("SL"));
//             // }
//                model.addRow(v1);
//               //listNV.setModel(model);
//            }
//        }catch(Exception e){
//             JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
//             e.printStackTrace();
//             //System.out.println("QuanLyBanHang.QuanLyHoaDon.list_CTHDMouseClicked()");
//        }
        
        
    }//GEN-LAST:event_listHDMouseClicked

    private void listHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listHDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_listHDKeyReleased

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
            java.util.logging.Logger.getLogger(QuanLyHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Date_NgayHD;
    private javax.swing.JPanel Panel_QuanLyHoaDon;
    private javax.swing.JButton jBCapNhat;
    private javax.swing.JButton jBLamMoi;
    private javax.swing.JButton jBTimKiem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable listHD;
    private javax.swing.JTable list_CTHD;
    private javax.swing.JTextField txt_MaKH;
    private javax.swing.JTextField txt_MaNV;
    private javax.swing.JTextField txt_SoHD;
    private javax.swing.JTextField txt_TriGia;
    // End of variables declaration//GEN-END:variables
}
