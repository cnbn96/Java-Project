/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trans;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.transform.*;
import org.xml.sax.SAXException;

/**
 *
 * @author BINH
 */
public class FrmTrans extends javax.swing.JFrame {

    /**
     * Creates new form FrmTrans
     */
    private DefaultTableModel modelTblTyGia;
    private DefaultComboBoxModel modelCbb;
    public int soTien;
    public FrmTrans() {
        initComponents();
        modelTblTyGia = (DefaultTableModel) tblDsTyGia.getModel();
        modelCbb = new DefaultComboBoxModel();
        cbbLoaiTien.setModel(modelCbb);
        txtThanhTienMua.setEditable(false);
        txtThanhTienBan.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDsTyGia = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbbLoaiTien = new javax.swing.JComboBox<>();
        txtNhapTien = new javax.swing.JTextField();
        txtThanhTienMua = new javax.swing.JTextField();
        txtThanhTienBan = new javax.swing.JTextField();
        btnTinhTien = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblDsTyGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên Ngoại Tệ", "Giá Mua", "Giá Bán"
            }
        ));
        jScrollPane1.setViewportView(tblDsTyGia);

        jLabel1.setText("Nhập Số Tiền:");

        jLabel2.setText("Loại Ngoại Tệ:");

        jLabel3.setText("Thành VNĐ");

        jLabel4.setText("Mua:");

        jLabel5.setText("Bán:");

        cbbLoaiTien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtThanhTienMua.setEnabled(false);

        txtThanhTienBan.setEnabled(false);
        txtThanhTienBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhTienBanActionPerformed(evt);
            }
        });

        btnTinhTien.setText("Tính Tiền");
        btnTinhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhTienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNhapTien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbLoaiTien, javax.swing.GroupLayout.Alignment.LEADING, 0, 116, Short.MAX_VALUE)
                            .addComponent(txtThanhTienMua)
                            .addComponent(txtThanhTienBan))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(btnTinhTien)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNhapTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbLoaiTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtThanhTienMua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtThanhTienBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnTinhTien)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtThanhTienBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhTienBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThanhTienBanActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            // TODO add your handling code here:
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("https://www.vietcombank.com.vn/ExchangeRates/ExrateXML.aspx");
            NodeList nl = doc.getElementsByTagName("Exrate");
            modelCbb.removeAllElements();
            modelCbb.addElement("");
            for(int i=0;i<nl.getLength();i++){
                String currencyCode,currencyName,buy,sell;
                currencyCode = nl.item(i).getAttributes().getNamedItem("CurrencyCode").getNodeValue();
                currencyName = nl.item(i).getAttributes().getNamedItem("CurrencyName").getNodeValue();
                buy = nl.item(i).getAttributes().getNamedItem("Buy").getNodeValue();
                sell = nl.item(i).getAttributes().getNamedItem("Sell").getNodeValue();
                modelTblTyGia.addRow(new Object[]{currencyCode,currencyName,buy,sell});                
                modelCbb.addElement(currencyCode);
            }
        } catch (SAXException ex) {
            Logger.getLogger(FrmTrans.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmTrans.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FrmTrans.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_formWindowOpened

    private void btnTinhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhTienActionPerformed
        soTien = Integer.parseInt(txtNhapTien.getText());
        if(cbbLoaiTien.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn loại Ngoại Tệ nào!");
        }else{
            String loaiNgoaiTe = (String)cbbLoaiTien.getSelectedItem();
            for(int i = 0;i<modelTblTyGia.getRowCount();i++){
                String ngoaiTe = (String)modelTblTyGia.getValueAt(i, 0);
                if(loaiNgoaiTe.equals(ngoaiTe)){
                    double giaMua = Double.parseDouble((String)modelTblTyGia.getValueAt(i, 2)) * soTien;
                    double giaBan = Double.parseDouble((String)modelTblTyGia.getValueAt(i, 3)) * soTien;
                    txtThanhTienMua.setText(String.valueOf(String.format("%.2f", giaMua)));
                    txtThanhTienBan.setText(String.valueOf(String.format("%.2f", giaBan)));
                }
            }
        }
    }//GEN-LAST:event_btnTinhTienActionPerformed

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
            java.util.logging.Logger.getLogger(FrmTrans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTrans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTrans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTrans.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTrans().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTinhTien;
    private javax.swing.JComboBox<String> cbbLoaiTien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDsTyGia;
    private javax.swing.JTextField txtNhapTien;
    private javax.swing.JTextField txtThanhTienBan;
    private javax.swing.JTextField txtThanhTienMua;
    // End of variables declaration//GEN-END:variables
}
