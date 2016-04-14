/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankeralgorithm;

import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author BINH
 * by cnbn96
 */
public class Frm extends javax.swing.JFrame {

    JTextField[] AvailableTextFieldArray;
    JTextField[][] MaxTextFieldArray;
    JTextField[][] AllocateTextFieldArray;
    JTextField[][] NeedTextFieldArray;
    int Processes;
    int Resource;
    static int safe[] = new int[30];

    static boolean safety(int a[], int all[][], int need[][], int r1, int c1) {
        int c = c1;
        int r = r1;
        int avail[] = new int[c];
        int al[][] = new int[r][c];
        int nd[][] = new int[r][c];
        for (int i = 0; i < c; i++) {
            avail[i] = a[i];
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                nd[i][j] = need[i][j];
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                al[i][j] = all[i][j];
            }
        }
        boolean fin[] = new boolean[r];
        for (int i = 0; i < r; i++) {
            fin[i] = false;
        }

        int check = 0;
        int check1 = 0;

        do {
            for (int i = 0; i < r; i++) {
                boolean flag = true;
                if (fin[i] == false) {
                    for (int j = 0; j < c; j++) {
                        if (nd[i][j] > avail[j]) {
                            flag = false;
                        }
                    }
                    if (flag) {
                    for (int j = 0; j < c; j++) {
                        avail[j] += al[i][j];
                    }
                    System.out.println(i+","+check);
                    safe[check] = i;
                    check++;
                    fin[i] = true;
                    }
                }
            }
            check1++;
        }while(check<r && check1<r);
        if(check>r)
            return false;
        else
            return true;
    }
    
    static public boolean requestFunction(int a[], int need[][], int all[][], int req[], int pick1, int p1,int r1){
        int pick = pick1;
        int p = p1;
        int r = r1;
        int avail[] = new int[r];
        int nd[][]= new int[p][r];
        int al[][]= new int[p][r];
        int rq[] = new int[r];
        for(int i=0;i<r;i++)
            avail[i] = a[i];
        for(int i=0;i<r;i++)
            rq[i] = req[i];
        for(int i=0;i<p;i++){
            for(int j=0;j<r;j++){
                nd[i][j] = need[i][j];
            }
        }
        for(int i=0;i<p;i++){
            for(int j=0;j<r;j++){
                al[i][j] =  all[i][j];
            }
        }
        boolean flag = true;
        for(int i=0;i<r;i++){
            if(nd[pick][i]<rq[i])
                flag = false;
        }
        if(flag){
            for(int i=0;i<r;i++){
                if(avail[i]<rq[i])
                    flag=false;
            }
            if(flag){
                for(int i=0;i<r;i++){
                    all[pick][i] += rq[i];
                    nd[pick][i] -= rq[i];
                    avail[i] -= rq[i];
                }
                if(safety(a, all, need, p, r)){
                    return true;
                }else{
                    System.out.println("deadlock");
                }
            }else{
                System.out.println("So wait");
            }
        }else{
            System.out.println("Lỗi need < request");
        }
        return false;
    }
    public void fillNeed(int Process, int Resource){
        pNeed.removeAll();
        NeedTextFieldArray = new JTextField[Process][Resource];
        Insets sNeed = pNeed.getInsets();
        Dimension s1;
        int x = 5;
        int y = 10;
        for(int i = 0; i<Process;i++){
            x=5;
            for(int j = 0;j<Resource;j++){
                NeedTextFieldArray[i][j] = new JTextField();
                s1 = NeedTextFieldArray[i][j].getPreferredSize();
                NeedTextFieldArray[i][j].setBounds(x+sNeed.left, y+sNeed.top, s1.width+15, s1.height);
                pNeed.add(NeedTextFieldArray[i][j]);
                x+=35;
            }
            y+=30;
        }
        int w = (35*(this.Resource+1));
        int h = (35*(this.Processes+1));
        pNeed.setSize(w,h);
        pNeed.setPreferredSize(new Dimension(w,h));
    }
    public void fill(int Process, int Resource){
        pMax.removeAll();
        pAvailable.removeAll();
        pAllocate.removeAll();
        AvailableTextFieldArray = new JTextField[Resource];
        MaxTextFieldArray = new JTextField[Process][Resource];
        AllocateTextFieldArray = new JTextField[Process][Resource];
        
        Insets sMax = pMax.getInsets();
        Dimension sizeMax;
        int x=5;
        int y=10;
        for(int i=0;i<Process;i++){
            x = 5;
            for(int j=0;j<Resource;j++){
                MaxTextFieldArray[i][j] = new JTextField();
                sizeMax = MaxTextFieldArray[i][j].getPreferredSize();
                MaxTextFieldArray[i][j].setBounds(x+sMax.left, y+sMax.top, sizeMax.width+15, sizeMax.height);
                pMax.add(MaxTextFieldArray[i][j]);
                x+=35;
            }
            y+=30;
        }
        x=5;
        y=10;
        for(int i=0;i<Process;i++){
            x = 5;
            for(int j=0;j<Resource;j++){
                AllocateTextFieldArray[i][j] = new JTextField();
                sizeMax = AllocateTextFieldArray[i][j].getPreferredSize();
                AllocateTextFieldArray[i][j].setBounds(x+sMax.left, y+sMax.top, sizeMax.width+15, sizeMax.height);
                pAllocate.add(AllocateTextFieldArray[i][j]);
                x+=35;
            }
            y+=30;
        }
        int w = (35*(this.Resource+1));
        int h = (35*(this.Processes+1));
        pMax.setSize(w,h);
        pMax.setPreferredSize(new Dimension(w,h));
        pAllocate.setSize(w,h);
        pAllocate.setPreferredSize(new Dimension(w,h));
        
        x = 5;
        y = 0;
        Dimension sizeAvail;
        for(int i = 0 ; i<Resource;i++){
            AvailableTextFieldArray[i] = new JTextField();
            sizeAvail = AvailableTextFieldArray[i].getPreferredSize();
            AvailableTextFieldArray[i].setBounds(x+sMax.left, y+sMax.top, sizeAvail.width+15, sizeAvail.height);
            pAvailable.add(AvailableTextFieldArray[i]);
            x+=35;
        } 
        pAvailable.setSize(w,1);
        pAvailable.setPreferredSize(new Dimension(w,1));
    }

    /**
     * Creates new form MainFrm
     */
    public Frm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProcess = new javax.swing.JButton();
        btnResource = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnCheck = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblResult = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pAllocate = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pMax = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pAvailable = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        pNeed = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        btnResource.setText("Resource");
        btnResource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResourceActionPerformed(evt);
            }
        });

        btnDone.setText("DONE");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnCheck.setText("Check");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        jLabel1.setText("Result: ");

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Allocate"));

        javax.swing.GroupLayout pAllocateLayout = new javax.swing.GroupLayout(pAllocate);
        pAllocate.setLayout(pAllocateLayout);
        pAllocateLayout.setHorizontalGroup(
            pAllocateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );
        pAllocateLayout.setVerticalGroup(
            pAllocateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pAllocate);

        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Max"));

        pMax.setPreferredSize(new java.awt.Dimension(179, 276));

        javax.swing.GroupLayout pMaxLayout = new javax.swing.GroupLayout(pMax);
        pMax.setLayout(pMaxLayout);
        pMaxLayout.setHorizontalGroup(
            pMaxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );
        pMaxLayout.setVerticalGroup(
            pMaxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(pMax);

        jScrollPane3.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Available"));

        javax.swing.GroupLayout pAvailableLayout = new javax.swing.GroupLayout(pAvailable);
        pAvailable.setLayout(pAvailableLayout);
        pAvailableLayout.setHorizontalGroup(
            pAvailableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
        );
        pAvailableLayout.setVerticalGroup(
            pAvailableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(pAvailable);

        jScrollPane4.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Need"));

        javax.swing.GroupLayout pNeedLayout = new javax.swing.GroupLayout(pNeed);
        pNeed.setLayout(pNeedLayout);
        pNeedLayout.setHorizontalGroup(
            pNeedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pNeedLayout.setVerticalGroup(
            pNeedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(pNeed);

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(btnProcess)
                                .addGap(34, 34, 34)
                                .addComponent(btnResource)
                                .addGap(32, 32, 32)
                                .addComponent(btnDone)
                                .addGap(38, 38, 38)
                                .addComponent(btnCheck)
                                .addGap(26, 26, 26)
                                .addComponent(jButton1)
                                .addGap(28, 28, 28)
                                .addComponent(btnExit))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(lblResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProcess)
                    .addComponent(btnResource)
                    .addComponent(btnDone)
                    .addComponent(btnExit)
                    .addComponent(btnCheck)
                    .addComponent(jButton1))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        int r = this.Processes;
        int c = this.Resource;
        int avail[] = new int[c];
        for(int i=0;i<c;i++){
            avail[i] = Integer.parseInt(AvailableTextFieldArray[i].getText());
        }
        
        int max[][] = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                max[i][j] = Integer.parseInt(MaxTextFieldArray[i][j].getText());
            }
        }
        int all[][] = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                all[i][j] = Integer.parseInt(AllocateTextFieldArray[i][j].getText());
            }
        }
        int nd[][] = new int [r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                fillNeed((i+1),(j+1));
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                nd[i][j] = max[i][j] - all[i][j];
                NeedTextFieldArray[i][j].setText(nd[i][j]+"");
            }
        }
        if(safety(avail, all, nd, r, c)){
            String s = "System in Safe State,squence: ";
            for(int i = 0;i<r;i++){
                s += safe[i]+",";
            }
            lblResult.setText(s.substring(0, s.length()));
        }else{
            lblResult.setText("System in Unsafe");
        }
        
        if((JOptionPane.showConfirmDialog(null,"Do you want to Request?"))==JOptionPane.OK_OPTION){
            int pick;
            do{
                pick = Integer.parseInt(JOptionPane.showInputDialog("What number you wanna Request:"));
            }while(pick >= c);
            int rq[] = new int[r];
            for(int i=0;i<c;i++){
                rq[i] = Integer.parseInt(JOptionPane.showInputDialog("Resource"+i+": "));
            }
            if(requestFunction(avail,nd,all,rq,pick,r,c)){
                String s = "Can be grant";
                System.out.println(s);
                for(int i=0;i<c;i++){
                    all[pick][i] += rq[i];
                    nd[pick][i] -= rq[i];
                    avail[i] -= rq[i];
                }
                if(safety(avail, all, nd, r, c)){
                    String x = "System in Safe State,squence:";
                    for(int i=0;i<r;i++){
                        x+=safe[i]+",";
                    }
                    JOptionPane.showMessageDialog(null, x.substring(0, x.length()));
                }else{
                    JOptionPane.showMessageDialog(null,"System in Unsafe");
                }
            }
        }
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        this.Processes = Integer.parseInt(JOptionPane.showInputDialog("Number of Process: "));
    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnResourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResourceActionPerformed
        this.Resource = Integer.parseInt(JOptionPane.showInputDialog("Number of Resource: "));
    }//GEN-LAST:event_btnResourceActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        int r = this.Processes;
        int c = this.Resource;
        for(int i=0;i<r;i++){
            for(int j =0;j<c;j++){
                fill((i+1),(j+1));     
            }
        }
    }//GEN-LAST:event_btnDoneActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pMax.removeAll();
        pAllocate.removeAll();
        pNeed.removeAll();
        pAvailable.removeAll();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnResource;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblResult;
    private javax.swing.JPanel pAllocate;
    private javax.swing.JPanel pAvailable;
    private javax.swing.JPanel pMax;
    private javax.swing.JPanel pNeed;
    // End of variables declaration//GEN-END:variables
}
