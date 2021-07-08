/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHang;

import QuanLyBanHangDao.HoaDon_Dao;
import QuanLyBanHangDao.KhachHangDao;
import QuanLyBanHangDao.SanPhamDao;
import QuanLyBanHangModel.GioHang;
import QuanLyBanHangModel.KhachHang;
import QuanLyBanHangModel.NhanVien;
import QuanLyBanHangModel.SanPham;
import TrangChu.home;
import Util.MyColor;
import Util.MyConvert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author khanh
 */
public class BanHangNew extends javax.swing.JFrame {
    private ArrayList<SanPham> listSP = new ArrayList<>();
    private ArrayList<String> listLoaiSP = new ArrayList<>();
    private ArrayList<GioHang> listGioHang = new ArrayList<>();
    private KhachHang khachHang;
    private Thread threadGui;
    private Thread thread;


    /**
     * Creates new form BanHangNew
     */
    public BanHangNew() {
        initComponents();
        dataChange();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                {
                    synchronized (thread) {
                        // Pause
                        try { //code sau khi mở lại luồng chính
                            while (true) {
                                Thread.sleep(100);
                                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                                lbNGHD.setText(formatter.format(new Date(System.currentTimeMillis())));
                            }
                        } catch (InterruptedException e) {
                        }
                    }

                }
            }

        };

        thread = new Thread(runnable);

        //từ đây trở lên là trước khi luồng chính bị đóng
        thread.start();

    }

    public void dataChange() {
        listSP = SanPhamDao.queryAllSanPham();
        reset();
    }

    private void reset() {
        jPanelSP.removeAll();
        jPanelSP.repaint();
        paint();
    }

    private Integer isLoai = -1;

    public JPanel getPanel() {
        return jPanel1;
    }

    private void paint() {

        for (SanPham sp : listSP) {
            String[] words = sp.getTENSP().split("\\s");
            String StrTemp = words[0];

            List<String> matches = listLoaiSP.stream().filter(it -> it.contains(StrTemp)).collect(Collectors.toList());

            if (matches.isEmpty()) {
                listLoaiSP.add(StrTemp);
                matches.add(listLoaiSP.get(listLoaiSP.size() - 1));
                Integer sttcuaLoaiSP = listLoaiSP.indexOf(matches.get(0));
                Color colorTemp = MyColor.getMauBySo(sttcuaLoaiSP);


                JButton btnTemp = new javax.swing.JButton();
                btnTemp.setBackground(colorTemp);
                //  ImageIcon imgTemp = new javax.swing.ImageIcon(getClass().getResource("/drawable/bed.png"));

                btnTemp.setFont(new java.awt.Font("Tahoma", 0, 16));
                btnTemp.setHideActionText(true);
                btnTemp.setPreferredSize(new java.awt.Dimension(200, 120));

                btnTemp.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        Integer temp = MyColor.getSoByMau(btnTemp.getBackground());

                        if (isLoai != temp) {
                            isLoai = temp;

                            listSP = SanPhamDao.queryAllSanPhamByLoai(listLoaiSP.get(isLoai));

                            reset();
                        } else {
                            isLoai = -1;
                            listSP = SanPhamDao.queryAllSanPham();
                            reset();
                        }
                    }
                });
                jPanelDM.add(btnTemp);
                JLabel jLabelTemp = new JLabel();
                jLabelTemp.setText(matches.get(0));
                jLabelTemp.setHorizontalTextPosition(SwingConstants.CENTER);
                jLabelTemp.setHorizontalAlignment(SwingConstants.CENTER);
                jLabelTemp.setFont(new Font("Tahoma", 0, 16));
                jPanelDM.add(jLabelTemp);
            }

            Integer sttcuaLoaiSP = listLoaiSP.indexOf(matches.get(0));
            Color colorTemp = MyColor.getMauBySo(sttcuaLoaiSP);
            JButton btnSanPham = new JButton();
            btnSanPham.setBackground(colorTemp);
            btnSanPham.setFont(new java.awt.Font("Tahoma", 0, 16));
            btnSanPham.setHideActionText(true);
            btnSanPham.setPreferredSize(new java.awt.Dimension(200, 120));
            btnSanPham.setText("<html>" + sp.getMASP() + "<br>  " + sp.getTENSP() + " <br> Giá: " + sp.getGIA() + " <br> Nước sản xuất " + sp.getNUOCSX() + "</html>");
            btnSanPham.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String[] words = btnSanPham.getText().split("<html>");

                    String StrTemp = words[1];
                    String[] words2 = StrTemp.split("<br>");
                    String StrTemp2 = words2[0];

                    List<SanPham> match = listSP.stream().filter(it -> it.getMASP().toString().contains(StrTemp2)).collect(Collectors.toList());
                    TTSP child = new TTSP();
                    child.setVisible(true);
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            {
                                synchronized (threadGui) {
                                    // Pause
                                    try { //code sau khi mở lại luồng chính
                                        threadGui.wait();

                                        if (child.getKetQua() == 1) {
                                            List<GioHang> timtronggio = listGioHang.stream().filter(it -> it.equals(match.get(0))).collect(Collectors.toList());
                                            if (timtronggio.isEmpty()) {
                                                listGioHang.add(new GioHang(match.get(0), 1, 1));
                                            } else timtronggio.get(0).setSoluong(timtronggio.get(0).getSoluong() + 1);
                                            lbSSP.setText(MyConvert.parseIntToString(listGioHang.size()));
                                        }
                                    } catch (InterruptedException e) {
                                    }
                                }

                            }
                        }
                    };

                    threadGui = new Thread(runnable);
                    child.setDat(threadGui, match.get(0));

                    //từ đây trở lên là trước khi luồng chính bị đóng
                    threadGui.start();
                }
            });
            jPanelSP.add(btnSanPham);
        }
        if (listLoaiSP.size() < 4)
            for (int i = 0; i < 4 - listLoaiSP.size(); i++) {
                Button btnTemp = new Button();
                btnTemp.setBackground(Color.WHITE);
                btnTemp.setEnabled(false);
                jPanelDM.add(btnTemp);
            }
        jPanelDM.revalidate();
        jPanelDM.repaint();


        jPanelSP.revalidate();
        jPanelSP.repaint();
    }

    private void paintKh() {
        if (khachHang != null) {
            btnKH.setText("MAKH: " + khachHang.getMAKH() + "       |     Tên khách hàng: " + khachHang.getHOTEN() + "       |       Doanh số: " + khachHang.getDOANHSO());

        } else {
            btnKH.setText(" ");
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
        jPanel3 = new javax.swing.JPanel();
        btnGioHang = new javax.swing.JButton();
        lbNGHD = new javax.swing.JLabel();
        jLabelTN1 = new javax.swing.JLabel();
        btnKH = new javax.swing.JButton();
        jLabelDN = new javax.swing.JLabel();
        jLabelTN = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbSSP = new javax.swing.JLabel();
        btnTK = new javax.swing.JButton();
        btnM = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanelDM = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanelSP = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 720));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1100, 125));

        btnGioHang.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnGioHang.setText("Xem giỏ hàng");
        btnGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGioHangActionPerformed(evt);
            }
        });

        lbNGHD.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbNGHD.setText("Ngày hoá đơn");

        jLabelTN1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelTN1.setText("Ngày hoá đơn");

        btnKH.setBackground(new java.awt.Color(255, 255, 255));
        btnKH.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnKH.setHideActionText(true);
        btnKH.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnKH.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKHActionPerformed(evt);
            }
        });

        jLabelDN.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelDN.setText("Số sản phẩm");

        jLabelTN.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelTN.setText("Giỏ hàng");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drawable/giohang.png"))); // NOI18N

        lbSSP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbSSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSSP.setText("0");

        btnTK.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnTK.setText("Tìm kiếm");
        btnTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKActionPerformed(evt);
            }
        });

        btnM.setBackground(new java.awt.Color(255, 153, 51));
        btnM.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnM.setForeground(new java.awt.Color(255, 255, 255));
        btnM.setText("THANH TOÁN");
        btnM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnKH, javax.swing.GroupLayout.PREFERRED_SIZE, 1075, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(btnTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGap(741, 741, 741))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(btnM, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(689, 689, 689)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabelTN1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbNGHD, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(481, 481, 481)))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnGioHang, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelDN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelTN, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(lbSSP, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                        .addComponent(jLabel1))
                                .addGap(115, 115, 115))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(5, 5, 5)
                                                                .addComponent(jLabelTN, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabelDN, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbSSP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnGioHang))
                                                .addGap(8, 8, 8))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbNGHD, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelTN1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnTK)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnM)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(btnKH, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setPreferredSize(new java.awt.Dimension(1100, 44));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Danh mục các sản phẩm");

        jPanelDM.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelDM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addComponent(jPanelDM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanelSP.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSP.setLayout(new java.awt.GridLayout(0, 4));
        jScrollPane2.setViewportView(jPanelSP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1101, Short.MAX_VALUE)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKHActionPerformed
        // TODO add your handling code here:
        Object[] options = {"Chọn lại", "Xoá"};
        if (khachHang != null) {
            int result = JOptionPane.showOptionDialog(this,
                    "Bạn có muốn chọn lại hay xoá chọn khách hàng này?",
                    "Chi tiết",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (result == JOptionPane.NO_OPTION) {
                khachHang = null;
                btnKH.setText("");
                return;
            } else if (result == JOptionPane.DEFAULT_OPTION) return;
        }
        ChonKhachHang child = new ChonKhachHang();
        child.setVisible(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                {
                    synchronized (threadGui) {
                        // Pause
                        try { //code sau khi mở lại luồng chính
                            threadGui.wait();
                            khachHang = child.getKH();

                            paintKh();
                        } catch (InterruptedException e) {
                        }
                    }

                }
            }

        };

        threadGui = new Thread(runnable);
        child.setThead(threadGui);

        //từ đây trở lên là trước khi luồng chính bị đóng
        threadGui.start();
    }//GEN-LAST:event_btnKHActionPerformed

    private void btnTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnTKActionPerformed

    private void btnMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMActionPerformed
        // TODO add your handling code here:
        NhanVien temp = new NhanVien();
        temp.setMANV("NV01");

        String mess = HoaDon_Dao.muaHang(listGioHang, khachHang, home.getNhanVien() == null ? temp : home.getNhanVien());

        Object[] options = {"Chấp nhận"};
        int result = JOptionPane.showOptionDialog(this,
                mess,
                "Thông báo",
                JOptionPane.OK_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);


    }//GEN-LAST:event_btnMActionPerformed

    private void btnGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGioHangActionPerformed
        // TODO add your handling code here:
        GioHangFrame child = new GioHangFrame();
        child.setVisible(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                {
                    synchronized (threadGui) {
                        // Pause
                        try { //code sau khi mở lại luồng chính
                            threadGui.wait();

                            listGioHang = child.getGioHang();
                            lbSSP.setText(MyConvert.parseIntToString(listGioHang.size()));
                        } catch (InterruptedException e) {
                        }
                    }

                }
            }

        };

        threadGui = new Thread(runnable);
        child.setThread(threadGui, listGioHang);

        //từ đây trở lên là trước khi luồng chính bị đóng
        threadGui.start();
    }//GEN-LAST:event_btnGioHangActionPerformed

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
            java.util.logging.Logger.getLogger(BanHangNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHangNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHangNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHangNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHangNew().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGioHang;
    private javax.swing.JButton btnKH;
    private javax.swing.JButton btnM;
    private javax.swing.JButton btnTK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelDN;
    private javax.swing.JLabel jLabelTN;
    private javax.swing.JLabel jLabelTN1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelDM;
    private javax.swing.JPanel jPanelSP;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbNGHD;
    private javax.swing.JLabel lbSSP;
    // End of variables declaration//GEN-END:variables
}
