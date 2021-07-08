/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHang;

import QuanLyBanHangDao.SanPhamDao;
import QuanLyBanHangModel.SanPham;
import Util.MyConvert;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @author khanh
 */
public class SanPhamFrame extends javax.swing.JFrame {
    private ArrayList<SanPham> listSanPham = new ArrayList<>();
    private ArrayList<SanPham> listSelectd = new ArrayList<>();
    private Thread threadGui;
    private JCheckBox cbTemp = new JCheckBox();
    private SanPham spIsSelected;

    /**
     * Creates new form SanPhamFrame
     */
    public SanPhamFrame() {
        initComponents();
        dataChange();
    }

    public JPanel getPanel() {
        return jPanelQLSP;
    }

    private void dataChange() {
        listSanPham = SanPhamDao.queryAllSanPham();
        reset();
    }

    private void reset() {
        jPanel5.removeAll();
        jPanel5.revalidate();
        jPanel5.repaint();
        initSanPham();
    }

    private void initSanPham() {
        for (SanPham sp : listSanPham) {
            javax.swing.JButton btnCong;
            javax.swing.JButton btnTru;
            javax.swing.JCheckBox cbChon;
            javax.swing.JPanel jPanel1;
            javax.swing.JLabel lbAnh;
            javax.swing.JLabel lbDVT;
            javax.swing.JLabel lbGIA;
            javax.swing.JLabel lbMSP;
            javax.swing.JLabel lbNSX;
            javax.swing.JLabel lbSoLuong;
            javax.swing.JLabel lbTSP;
            javax.swing.JPanel menuItem;
            menuItem = new javax.swing.JPanel();
            lbAnh = new javax.swing.JLabel();
            cbChon = new javax.swing.JCheckBox();
            lbMSP = new javax.swing.JLabel();
            jPanel1 = new javax.swing.JPanel();
            lbTSP = new javax.swing.JLabel();
            lbDVT = new javax.swing.JLabel();
            lbNSX = new javax.swing.JLabel();
            lbGIA = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            menuItem.setBackground(new java.awt.Color(255, 255, 255));
            menuItem.setPreferredSize(new java.awt.Dimension(1100, 100));

            cbChon.setBackground(new java.awt.Color(255, 255, 255));
            cbChon.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (cbChon.isSelected() == true) {
                        cbChon.setSelected(false);
                        listSelectd.remove(sp);

                    } else {
                        cbChon.setSelected(true);
                        listSelectd.add(sp);
                    }

                }
            });

            lbMSP.setBackground(new java.awt.Color(255, 255, 255));
            lbMSP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            lbMSP.setText(sp.getMASP());
            lbMSP.setToolTipText("");

            jPanel1.setBackground(new java.awt.Color(255, 153, 0));

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 0, Short.MAX_VALUE)
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 8, Short.MAX_VALUE)
            );

            lbTSP.setBackground(new java.awt.Color(255, 255, 255));
            lbTSP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            lbTSP.setText(sp.getTENSP());
            lbTSP.setToolTipText("");

            lbDVT.setBackground(new java.awt.Color(255, 255, 255));
            lbDVT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            lbDVT.setText(sp.getDVT());
            lbDVT.setToolTipText("");

            lbNSX.setBackground(new java.awt.Color(255, 255, 255));
            lbNSX.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            lbNSX.setText(sp.getNUOCSX());
            lbNSX.setToolTipText("");

            lbGIA.setBackground(new java.awt.Color(255, 255, 255));
            lbGIA.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            lbGIA.setText(MyConvert.parseIntToString(sp.getGIA()));
            lbGIA.setToolTipText("");

            javax.swing.GroupLayout menuItemLayout = new javax.swing.GroupLayout(menuItem);
            menuItem.setLayout(menuItemLayout);
            menuItemLayout.setHorizontalGroup(
                    menuItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(menuItemLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(cbChon)
                                    .addGap(34, 34, 34)
                                    .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbMSP, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(32, 32, 32)
                                    .addComponent(lbGIA, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(20, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            menuItemLayout.setVerticalGroup(
                    menuItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(menuItemLayout.createSequentialGroup()
                                    .addGroup(menuItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(menuItemLayout.createSequentialGroup()
                                                    .addGap(37, 37, 37)
                                                    .addComponent(cbChon)
                                                    .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(menuItemLayout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addGroup(menuItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(lbAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addGroup(menuItemLayout.createSequentialGroup()
                                                                    .addGroup(menuItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                            .addComponent(lbMSP, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(lbTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(lbDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(lbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(lbGIA, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addGap(0, 6, Short.MAX_VALUE)))))
                                    .addGap(3, 3, 3)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            jPanel5.add(menuItem);
        }
        jPanel5.revalidate();
        jPanel5.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelQLSP = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jBfind = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jBInsert = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jBDelete = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jBUpDate = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbMSP = new javax.swing.JLabel();
        lbMSP1 = new javax.swing.JLabel();
        lbDVT = new javax.swing.JLabel();
        lbNSX = new javax.swing.JLabel();
        lbGIA = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelQLSP.setBackground(new java.awt.Color(255, 255, 255));
        jPanelQLSP.setPreferredSize(new java.awt.Dimension(1000, 640));

        jToolBar1.setBackground(new java.awt.Color(255, 204, 204));
        jToolBar1.setRollover(true);

        jBfind.setBackground(new java.awt.Color(255, 204, 204));
        jBfind.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jBfind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newIcon/find.png"))); // NOI18N
        jBfind.setText("Tìm kiếm");
        jBfind.setFocusable(false);
        jBfind.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBfind.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBfindActionPerformed(evt);
            }
        });
        jToolBar1.add(jBfind);
        jToolBar1.add(jSeparator2);

        jBInsert.setBackground(new java.awt.Color(255, 204, 204));
        jBInsert.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jBInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newIcon/insert.png"))); // NOI18N
        jBInsert.setText("Thêm mới");
        jBInsert.setFocusable(false);
        jBInsert.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBInsert.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInsertActionPerformed(evt);
            }
        });
        jToolBar1.add(jBInsert);
        jToolBar1.add(jSeparator3);

        jBDelete.setBackground(new java.awt.Color(255, 204, 204));
        jBDelete.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jBDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newIcon/delete.png"))); // NOI18N
        jBDelete.setText("    Xóa   ");
        jBDelete.setFocusable(false);
        jBDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(jBDelete);
        jToolBar1.add(jSeparator4);

        jBUpDate.setBackground(new java.awt.Color(255, 204, 204));
        jBUpDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jBUpDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newIcon/edit.png"))); // NOI18N
        jBUpDate.setText("Cập nhật");
        jBUpDate.setFocusable(false);
        jBUpDate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBUpDate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBUpDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUpDateActionPerformed(evt);
            }
        });
        jToolBar1.add(jBUpDate);
        jToolBar1.add(jSeparator5);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(jPanel5);

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        lbMSP.setBackground(new java.awt.Color(255, 255, 255));
        lbMSP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbMSP.setText("Mã sản phẩm");
        lbMSP.setToolTipText("");

        lbMSP1.setBackground(new java.awt.Color(255, 255, 255));
        lbMSP1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbMSP1.setText("Tên sản phẩm");
        lbMSP1.setToolTipText("");

        lbDVT.setBackground(new java.awt.Color(255, 255, 255));
        lbDVT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbDVT.setText("đơn vị tinh");
        lbDVT.setToolTipText("");

        lbNSX.setBackground(new java.awt.Color(255, 255, 255));
        lbNSX.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbNSX.setText("nước sản xuất");
        lbNSX.setToolTipText("");

        lbGIA.setBackground(new java.awt.Color(255, 255, 255));
        lbGIA.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbGIA.setText("giá");
        lbGIA.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(lbMSP, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbMSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(lbGIA, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(194, 194, 194))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbMSP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbMSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbGIA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelQLSPLayout = new javax.swing.GroupLayout(jPanelQLSP);
        jPanelQLSP.setLayout(jPanelQLSPLayout);
        jPanelQLSPLayout.setHorizontalGroup(
                jPanelQLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelQLSPLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanelQLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1278, Short.MAX_VALUE)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelQLSPLayout.setVerticalGroup(
                jPanelQLSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelQLSPLayout.createSequentialGroup()
                                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanelQLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanelQLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBfindActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jBfindActionPerformed

    private void jBInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInsertActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jBInsertActionPerformed

    private void jBDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActionPerformed
        // TODO add your handling code here:
        if (listSelectd.isEmpty())

            JOptionPane.showMessageDialog(null, "Bạn chưa chọn khuyến mãi nào", "Thông tin", JOptionPane.INFORMATION_MESSAGE);
        else {
            Object[] options = {"Có", "Không"};
            int result = JOptionPane.showOptionDialog(this,
                    "Bạn có chắc muốn xoá những sản phẩm này",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);

            if (result == JOptionPane.YES_OPTION) {
                for (SanPham sp : listSelectd) {
                    SanPhamDao.delete(sp);
                }
                Object[] options2 = {"Chấp nhận"};


                dataChange();

            }
        }
    }//GEN-LAST:event_jBDeleteActionPerformed

    private void jBUpDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUpDateActionPerformed
        // TODO add your handling code here:
        if(listSelectd.size()>1)
        {
            Object[] options = {"Chấp nhận"};
            int result = JOptionPane.showOptionDialog(this,
                    "Vui lòng chọn chỉ 1 sản phẩm ",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            return;
        }
        XuLyThongTinSanPham child = new XuLyThongTinSanPham();
        child.setVisible(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                {
                    synchronized (threadGui) {
                        // Pause
                        try { //code sau khi mở lại luồng chính
                            threadGui.wait();

                            dataChange();
                        } catch (InterruptedException e) {
                        }
                    }

                }
            }


        };

        threadGui = new Thread(runnable);
        child.setSua(threadGui,listSelectd.get(0));

        //từ đây trở lên là trước khi luồng chính bị đóng
        threadGui.start();

    }//GEN-LAST:event_jBUpDateActionPerformed

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
            java.util.logging.Logger.getLogger(SanPhamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanPhamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanPhamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanPhamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SanPhamFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDelete;
    private javax.swing.JButton jBInsert;
    private javax.swing.JButton jBUpDate;
    private javax.swing.JButton jBfind;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelQLSP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbDVT;
    private javax.swing.JLabel lbGIA;
    private javax.swing.JLabel lbMSP;
    private javax.swing.JLabel lbMSP1;
    private javax.swing.JLabel lbNSX;
    // End of variables declaration//GEN-END:variables
}
