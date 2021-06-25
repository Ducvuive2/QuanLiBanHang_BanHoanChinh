/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHang;



import QuanLyBanHangDao.KhachHangDao;
import QuanLyBanHangModel.KhachHang;
import java.awt.Color;
import java.awt.event.KeyEvent;
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
 * @author Nguyen Khang
 */


public class QuanLyKhachHang extends javax.swing.JFrame {
    
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    

    /**
     * Creates new form QuanLyKhachHang
     */
    public QuanLyKhachHang() {
        initComponents();
        Connect();
        KhachHang_Load();
        
        
    }

    
       public JPanel getJPanelQLKH()
    {
        return jPanelQLKH;
    }
    

    public void Connect(){ //ket noi csdl
        try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.print("ket noi thanh cong");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            

           conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","QuanLyBanHang", "qlbh");

           

        
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void KhachHang_Load(){
        
        ArrayList<KhachHang> khachhangs = new ArrayList<KhachHang>();    
        
        String sql = "SELECT * from KhachHang";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                KhachHang KH = new KhachHang();
               
                KH.setMAKH(rs.getString(1));
                KH.setHOTEN(rs.getString(2));
                KH.setNGSINH(rs.getDate(5));
                KH.setDCHI(rs.getString(3));
                KH.setSODT(rs.getString(4));
                KH.setDOANHSO(rs.getLong(6));
                KH.setNGDK(rs.getDate(7));
            
            khachhangs.add(KH);
            }
        }catch(SQLException e){
            e.printStackTrace();
                }   
        
        DefaultTableModel model  = new DefaultTableModel(){
            @Override// ko cho sua bang
            public boolean isCellEditable(int row, int column) {
                return false;
            }  
        };
        listKH.setModel(model);
        model.addColumn("MaKH");
        model.addColumn("HOTEN");
        model.addColumn("DCHI");
        model.addColumn("SODT");
        model.addColumn("NGSINH");
        model.addColumn("DOANHSO");
        model.addColumn("NGDK");
        
        
         for(KhachHang kh : khachhangs){
            model.addRow(new Object[]{
                kh.getMAKH(),kh.getHOTEN(),kh.getDCHI(),kh.getSODT(),kh.getNGSINH(),kh.getDOANHSO(),kh.getNGDK()});
        }
        
        
           
//        try {
//            ps = conn.prepareStatement("SELECT * FROM KHACHHANG ");
//            rs = ps.executeQuery();
//            
//            ResultSetMetaData rsd = rs.getMetaData();
//            int c = rsd.getColumnCount();
//          
//            DefaultTableModel model= (DefaultTableModel) listKH.getModel();
//            model.setRowCount(0);
//            
//            while (rs.next()){
//                Vector v1 = new Vector();
//                for(int i=1;i<=c;i++){
//                    v1.add(rs.getString("makh"));
//                    v1.add(rs.getString("hoten"));
//                    v1.add(rs.getString("dchi"));
//                    v1.add(rs.getString("sodt"));
//                    v1.add(rs.getDate("ngsinh"));
//                    
//                    v1.add(0);
//                    v1.add(rs.getDate("ngdk"));
//                   
//                   
//              }
//                model.addRow(v1);
//               listKH.setModel(model);
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
//        } 
    }
    
    public void LamMoi(){
       txtMaKH.setText("");
        txtHoTen.setText("");
        jDNgDK.setDate(null);
        jDNgSinh.setDate(null);
        
        txtDChi.setText("");
        txtSoDT.setText("");
        txtDoanhSo.setText("0");
         
  }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listKH = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jBTrangChu = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jBTimKiem = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jBThemMoi = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jBXoa = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jBCapNhat = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jBLamMoi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        LB = new javax.swing.JLabel();
        LBNS = new javax.swing.JLabel();
        txtDChi = new javax.swing.JTextField();
        LBDS = new javax.swing.JLabel();
        txtSoDT = new javax.swing.JTextField();
        LBNDK = new javax.swing.JLabel();
        txtDoanhSo = new javax.swing.JTextField();
        jDNgSinh = new com.toedter.calendar.JDateChooser();
        jDNgDK = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Họ tên", "Địa chỉ", "Số điện thoại", "Ngày sinh", "Doanh số", "Ngày đăng ký"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        listKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listKHMouseClicked(evt);
            }
        });
        listKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                listKHKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(listKH);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);

        jBTrangChu.setText("Trang chủ");
        jBTrangChu.setFocusable(false);
        jBTrangChu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBTrangChu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTrangChuActionPerformed(evt);
            }
        });
        jToolBar1.add(jBTrangChu);
        jToolBar1.add(jSeparator1);

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
        jToolBar1.add(jSeparator6);

        jBThemMoi.setText("Thêm mới");
        jBThemMoi.setFocusable(false);
        jBThemMoi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBThemMoi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBThemMoiActionPerformed(evt);
            }
        });
        jToolBar1.add(jBThemMoi);
        jToolBar1.add(jSeparator3);

        jBXoa.setText("    Xóa    ");
        jBXoa.setFocusable(false);
        jBXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBXoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBXoaActionPerformed(evt);
            }
        });
        jToolBar1.add(jBXoa);
        jToolBar1.add(jSeparator4);

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

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ KHÁCH HÀNG");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 204), null));

        jPanel1.setBackground(new java.awt.Color(0, 150, 235));

        jLabel2.setText("Mã Khách hàng");

        jLabel3.setText("Họ tên");

        jLabel4.setText("Địa chỉ");

        LB.setText("Số điện thoại");

        LBNS.setText("Ngày sinh");

        LBDS.setText("Doanh số");

        LBNDK.setText("Ngày đăng ký");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LBNDK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LBDS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LBNS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMaKH)
                                .addComponent(txtHoTen)
                                .addComponent(txtDoanhSo)
                                .addComponent(jDNgDK, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                .addComponent(jDNgSinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(txtDChi, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDChi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBNS, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDNgSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBDS, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDoanhSo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBNDK, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDNgDK, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listKHMouseClicked
        // TODO add your handling code here:
        LamMoi();
        int selectedIndex = listKH.getSelectedRow();
        listKH.setColumnSelectionInterval(0,6);
        txtMaKH.setText(listKH.getValueAt(selectedIndex, 0).toString());
        txtHoTen.setText(listKH.getValueAt(selectedIndex, 1).toString());

        jDNgSinh.setDate((Date) listKH.getValueAt(selectedIndex, 4));
        jDNgDK.setDate((Date) listKH.getValueAt(selectedIndex, 6));
        txtDChi.setText(listKH.getValueAt(selectedIndex, 2).toString());
        txtDoanhSo.setText(listKH.getValueAt(selectedIndex, 5).toString());
        txtSoDT.setText(listKH.getValueAt(selectedIndex, 3).toString());
        
    }//GEN-LAST:event_listKHMouseClicked

    private void listKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listKHKeyReleased
        // TODO add your handling code here:
        LamMoi();

        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN){
            int selectedIndex = listKH.getSelectedRow();
        listKH.setColumnSelectionInterval(0,6);
        txtMaKH.setText(listKH.getValueAt(selectedIndex, 0).toString());
        txtHoTen.setText(listKH.getValueAt(selectedIndex, 1).toString());

        jDNgSinh.setDate((Date) listKH.getValueAt(selectedIndex, 4));
        jDNgDK.setDate((Date) listKH.getValueAt(selectedIndex, 6));
        txtDChi.setText(listKH.getValueAt(selectedIndex, 2).toString());
        txtDoanhSo.setText(listKH.getValueAt(selectedIndex, 5).toString());
        txtSoDT.setText(listKH.getValueAt(selectedIndex, 3).toString());
        
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse((String)listKH.getValueAt(selectedIndex, 4));
            } catch (ParseException ex) {
                Logger.getLogger(QuanLyKhachHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            jDNgSinh.setDate(date);
            
            Date date1 = null;
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse((String)listKH.getValueAt(selectedIndex, 6));
            } catch (ParseException ex) {
                Logger.getLogger(QuanLyKhachHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            jDNgDK.setDate(date1);
            

        }
    }//GEN-LAST:event_listKHKeyReleased

    private void jBTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTrangChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBTrangChuActionPerformed

    private void jBTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTimKiemActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (txtMaKH.getText().equals("")){
            sb.append("Mã Khách hàng không được để trống!!!");
            txtMaKH.setBackground(Color.yellow);
        } else {
            txtMaKH.setBackground(Color.white);
        }
        if (sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            KhachHangDao dao = new KhachHangDao();
            KhachHang kh = dao.find(txtMaKH.getText());
            if (kh != null){
                //XuatThongTin
                txtMaKH.setText(kh.getMAKH());
                txtHoTen.setText(kh.getHOTEN());
                
                
                
                txtDChi.setText(kh.getDCHI());
                txtSoDT.setText(kh.getSODT());
                txtDoanhSo.setText(kh.getSODT());
                jDNgSinh.setDate(kh.getNGSINH());
                txtDoanhSo.setText(String.valueOf(kh.getDOANHSO()));
                jDNgDK.setDate(kh.getNGDK());
                
            } else
            JOptionPane.showMessageDialog(this, "Nhân viên tìm kiếm không hợp lệ!");

        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBTimKiemActionPerformed

    private void jBThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBThemMoiActionPerformed
        // TODO add your handling code here:

        StringBuilder sb = new StringBuilder();
        if (txtMaKH.getText().equals("")){
            sb.append("Mã nhân viên không được để trống!!!");
            txtMaKH.setBackground(Color.yellow);
        } else {
            txtMaKH.setBackground(Color.white);
        }
        if (sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            KhachHang kh = new KhachHang();
            kh.setMAKH(txtMaKH.getText());
            kh.setHOTEN(txtHoTen.getText());
            kh.setDCHI(txtDChi.getText());
            kh.setSODT(txtSoDT.getText());
            //Chuyen doi java.util.Date sang java.sql.Date
            if(jDNgSinh.getDate() != null ){
                java.util.Date utilNGSINH = jDNgSinh.getDate();
                java.sql.Date sqlNGSINH  = new java.sql.Date(utilNGSINH.getTime());
                kh.setNGSINH(sqlNGSINH);
            }
            kh.setDOANHSO(Long.valueOf(txtDoanhSo.getText()));
            if(jDNgDK.getDate() != null ){
                java.util.Date utilNGDK = jDNgDK.getDate();
                java.sql.Date sqlNGDK  = new java.sql.Date(utilNGDK.getTime());
                kh.setNGDK(sqlNGDK);
            }
            KhachHangDao dao = new KhachHangDao();
            dao.insert(kh);
            JOptionPane.showMessageDialog(this, "Khách hàng được thêm vào thành công!");
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
        KhachHang_Load();
    }//GEN-LAST:event_jBThemMoiActionPerformed

    private void jBXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBXoaActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (txtMaKH.getText().equals("")){
            sb.append("Mã khách hàng không được để trống!!!");
            txtMaKH.setBackground(Color.yellow);
        } else {
            txtMaKH.setBackground(Color.white);
        }
        if (sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{

            KhachHangDao dao = new KhachHangDao();

            int result = JOptionPane.showConfirmDialog(this,"Bạn có muốn xoá không? ","Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (result == JOptionPane.YES_OPTION){
                dao.delete(txtMaKH.getText());
                JOptionPane.showMessageDialog(this, "Khách hàng đã xóa thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Khách hàng chưa được xóa!");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
        KhachHang_Load();
    }//GEN-LAST:event_jBXoaActionPerformed

    private void jBCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCapNhatActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (txtMaKH.getText().equals("")){
            sb.append("Mã Khách hàng không được để trống!!!");
            txtMaKH.setBackground(Color.yellow);
        } else {
            txtMaKH.setBackground(Color.white);
        }
        if (sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            KhachHang kh = new KhachHang();
            kh.setMAKH(txtMaKH.getText());
            kh.setHOTEN(txtHoTen.getText());
            kh.setDCHI(txtDChi.getText());
            kh.setSODT(txtSoDT.getText());
            //Chuyen doi java.util.Date sang java.sql.Date
            if(jDNgSinh.getDate() != null ){
                java.util.Date utilNGSINH = jDNgSinh.getDate();
                java.sql.Date sqlNGSINH  = new java.sql.Date(utilNGSINH.getTime());
                kh.setNGSINH(sqlNGSINH);
            }
            kh.setDOANHSO(Long.valueOf(txtDoanhSo.getText()));
            if(jDNgDK.getDate() != null ){
                java.util.Date utilNGDK = jDNgDK.getDate();
                java.sql.Date sqlNGDK  = new java.sql.Date(utilNGDK.getTime());
                kh.setNGDK(sqlNGDK);
            }
            KhachHangDao dao = new KhachHangDao();
            dao.update(kh);
            JOptionPane.showMessageDialog(this, "Khách hàng được cập nhật thành công!");

        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
        KhachHang_Load();

    }//GEN-LAST:event_jBCapNhatActionPerformed

    private void jBLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLamMoiActionPerformed
        // TODO add your handling code here:
        LamMoi();
    }//GEN-LAST:event_jBLamMoiActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LB;
    private javax.swing.JLabel LBDS;
    private javax.swing.JLabel LBNDK;
    private javax.swing.JLabel LBNS;
    private javax.swing.JButton jBCapNhat;
    private javax.swing.JButton jBLamMoi;
    private javax.swing.JButton jBThemMoi;
    private javax.swing.JButton jBTimKiem;
    private javax.swing.JButton jBTrangChu;
    private javax.swing.JButton jBXoa;
    private com.toedter.calendar.JDateChooser jDNgDK;
    private com.toedter.calendar.JDateChooser jDNgSinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable listKH;
    private javax.swing.JTextField txtDChi;
    private javax.swing.JTextField txtDoanhSo;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSoDT;
    // End of variables declaration//GEN-END:variables
}
