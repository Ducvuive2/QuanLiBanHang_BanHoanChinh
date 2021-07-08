/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyBanHang;

import QuanLyBanHangModel.GioHang;
import QuanLyBanHangModel.SanPham;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author khanh
 */
public class GioHangFrame extends javax.swing.JFrame {
    private ArrayList<GioHang> listGioHang = new ArrayList<>();
    private Thread threadNhan;


    /**
     * Creates new form GioHang
     */
    public GioHangFrame() {
        initComponents();

    }

    @Override
    public void dispose() {
        synchronized (threadNhan) {
            threadNhan.notify();
        }
        super.dispose();
    }

    private void reset() {
        jPanel5.removeAll();
        jPanel5.revalidate();
        jPanel5.repaint();
        initTongTien();
        initMenu();
    }

    private void initTongTien() {
        Integer soluong = 0;
        Integer tongtien = 0;
        for (GioHang gh : listGioHang) {
            if (gh.getChon() == 1) {
                soluong++;
                tongtien += gh.getSanpham().getGIA() * gh.getSoluong();
            }
        }
        lbTT.setText("(" + soluong + " sản phẩm)");
        jLabelTongtien.setText(tongtien + " đ");
    }

    private void initMenu() {
        for (GioHang gh : listGioHang) {
            javax.swing.JButton btnCong;
            javax.swing.JButton btnTru;
            javax.swing.JButton btnXoa;
            javax.swing.JCheckBox cbChon;
            javax.swing.JLabel lbAnh;
            javax.swing.JLabel lbChuTich;
            javax.swing.JLabel lbSoLuong;
            javax.swing.JLabel lbTen;
            javax.swing.JLabel lbTien;
            javax.swing.JPanel menuItem;
            javax.swing.JPanel jPanel1;


            menuItem = new javax.swing.JPanel();
            lbAnh = new javax.swing.JLabel();
            cbChon = new javax.swing.JCheckBox();
            lbTen = new javax.swing.JLabel();
            lbChuTich = new javax.swing.JLabel();
            lbTien = new javax.swing.JLabel();
            btnXoa = new javax.swing.JButton();
            btnTru = new javax.swing.JButton();
            lbSoLuong = new javax.swing.JLabel();
            btnCong = new javax.swing.JButton();
            jPanel1 = new javax.swing.JPanel();

            jPanel1.setBackground(new java.awt.Color(255, 153, 0));

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 0, Short.MAX_VALUE)
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 5, Short.MAX_VALUE)
            );
            menuItem.setBackground(new java.awt.Color(255, 255, 255));
            menuItem.setPreferredSize(new java.awt.Dimension(818, 100));

            cbChon.setBackground(new java.awt.Color(255, 255, 255));
            cbChon.setSelected(true);
            cbChon.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (cbChon.isSelected()) {
                        List<GioHang> match = listGioHang.stream().filter(it -> it.equals(gh)).collect(Collectors.toList());
                        match.get(0).setChon(1);
                        cbChon.setSelected(true);
                        initTongTien();
                    } else {
                        List<GioHang> match = listGioHang.stream().filter(it -> it.equals(gh)).collect(Collectors.toList());
                        match.get(0).setChon(0);
                        cbChon.setSelected(false);
                        initTongTien();
                    }

                }
            });
            lbTen.setBackground(new java.awt.Color(255, 255, 255));
            lbTen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            lbTen.setText(gh.getSanpham().getTENSP());
            lbTen.setToolTipText("");

            lbChuTich.setBackground(new java.awt.Color(255, 255, 255));
            lbChuTich.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
            lbChuTich.setText(gh.getSanpham().getNUOCSX());
            lbChuTich.setToolTipText("");

            lbTien.setBackground(new java.awt.Color(255, 255, 255));
            lbTien.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
            lbTien.setForeground(new java.awt.Color(255, 153, 51));
            lbTien.setText(gh.getSanpham().getGIA() + " đ");

            btnXoa.setBackground(new java.awt.Color(255, 255, 255));
            btnXoa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
            btnXoa.setForeground(new java.awt.Color(102, 102, 102));
            btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xoa.png"))); // NOI18N
            btnXoa.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    listGioHang.remove(gh);
                    reset();

                }
            });
            btnTru.setBackground(new java.awt.Color(204, 204, 204));
            btnTru.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
            btnTru.setText("-");
            btnTru.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (gh.getSoluong() > 0) {
                        List<GioHang> match = listGioHang.stream().filter(it -> it.equals(gh)).collect(Collectors.toList());
                        match.get(0).setSoluong(gh.getSoluong() - 1);
                        lbSoLuong.setText(match.get(0).getSoluong().toString());
                        initTongTien();
                    }
                }
            });
            lbSoLuong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            lbSoLuong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbSoLuong.setText(gh.getSoluong().toString());

            btnCong.setBackground(new java.awt.Color(204, 204, 204));
            btnCong.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
            btnCong.setText("+");
            btnCong.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    List<GioHang> match = listGioHang.stream().filter(it -> it.equals(gh)).collect(Collectors.toList());
                    match.get(0).setSoluong(gh.getSoluong() + 1);
                    lbSoLuong.setText(match.get(0).getSoluong().toString());
                    initTongTien();
                }
            });
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
                                    .addGroup(menuItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbChuTich, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(menuItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(menuItemLayout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(lbTien, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(menuItemLayout.createSequentialGroup()
                                                    .addGap(69, 69, 69)
                                                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(22, 22, 22)
                                    .addComponent(btnTru)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnCong)
                                    .addContainerGap(24, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            menuItemLayout.setVerticalGroup(
                    menuItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(menuItemLayout.createSequentialGroup()
                                    .addGroup(menuItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                                                                    .addGroup(menuItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                            .addComponent(lbTen)
                                                                                            .addComponent(lbTien))
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addGroup(menuItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                            .addComponent(btnXoa)
                                                                                            .addComponent(lbChuTich))
                                                                                    .addGap(0, 6, Short.MAX_VALUE)))))
                                                    .addGap(3, 3, 3))
                                            .addGroup(menuItemLayout.createSequentialGroup()
                                                    .addGap(30, 30, 30)
                                                    .addGroup(menuItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                                            .addComponent(lbSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(btnCong, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btnTru, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            jPanel5.add(menuItem);
        }
        lbTC.setText("("+listGioHang.size()+" SẢN PHẨM)");

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
        jCheckBox1 = new javax.swing.JCheckBox();
        btnXTC = new javax.swing.JButton();
        lbTC = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnXN = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbTT = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelTongtien = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(1230, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1230, 720));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(102, 102, 102));
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("CHỌN TẤT CẢ");

        btnXTC.setBackground(new java.awt.Color(255, 255, 255));
        btnXTC.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnXTC.setForeground(new java.awt.Color(102, 102, 102));
        btnXTC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xoa.png"))); // NOI18N
        btnXTC.setText("XOÁ TẤT CẢ");
        btnXTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXTCActionPerformed(evt);
            }
        });

        lbTC.setBackground(new java.awt.Color(255, 255, 255));
        lbTC.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbTC.setForeground(new java.awt.Color(102, 102, 102));
        lbTC.setText("(0 SẢN PHẨM)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addComponent(lbTC, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 410, Short.MAX_VALUE)
                .addComponent(btnXTC)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(btnXTC)
                    .addComponent(lbTC))
                .addGap(17, 17, 17))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnXN.setBackground(new java.awt.Color(255, 153, 102));
        btnXN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnXN.setForeground(new java.awt.Color(255, 255, 255));
        btnXN.setText("XÁC NHẬN GIỎ HÀNG");
        btnXN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXNActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Thông tin đơn hàng");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Tạm tính");

        lbTT.setBackground(new java.awt.Color(255, 255, 255));
        lbTT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTT.setForeground(new java.awt.Color(102, 102, 102));
        lbTT.setText("(0 sản phẩm)");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Tổng cộng");

        jLabelTongtien.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTongtien.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelTongtien.setForeground(new java.awt.Color(255, 153, 51));
        jLabelTongtien.setText(" 0 đ");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Đã bao gồm VAT (nếu có)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXN, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabelTongtien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTT)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelTongtien)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(15, 15, 15)
                .addComponent(btnXN, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 253, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXNActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnXNActionPerformed

    private void btnXTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXTCActionPerformed
        // TODO add your handling code here:
        listGioHang.removeAll(listGioHang);
        reset();
    }//GEN-LAST:event_btnXTCActionPerformed

    public void setThread(Thread thread, ArrayList<GioHang> list) {
        threadNhan = thread;
        listGioHang = list;

        reset();
    }

    public ArrayList<GioHang> getGioHang() {
        return listGioHang;
    }

    public static void main(String[] args) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXN;
    private javax.swing.JButton btnXTC;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelTongtien;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTC;
    private javax.swing.JLabel lbTT;
    // End of variables declaration//GEN-END:variables
}
