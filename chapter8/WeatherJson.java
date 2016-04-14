/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module1.chapter8;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.text.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author hv
 */
public class WeatherJson extends javax.swing.JFrame {

    /**
     * Creates new form WeatherJson
     */
    public WeatherJson() {
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

        lblLocation = new javax.swing.JLabel();
        lblTemp = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblCondition = new javax.swing.JLabel();
        lblWind = new javax.swing.JLabel();
        lblSun = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblLocation.setFont(new java.awt.Font("Vivaldi", 1, 14)); // NOI18N
        lblLocation.setForeground(new java.awt.Color(51, 255, 51));

        lblTemp.setFont(new java.awt.Font("Vivaldi", 1, 36)); // NOI18N
        lblTemp.setForeground(new java.awt.Color(51, 255, 0));

        lblCondition.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        lblCondition.setForeground(new java.awt.Color(102, 255, 51));

        lblWind.setFont(new java.awt.Font("Vinhan", 1, 14)); // NOI18N
        lblWind.setForeground(new java.awt.Color(255, 0, 0));

        lblSun.setFont(new java.awt.Font("Vinhan", 1, 14)); // NOI18N
        lblSun.setForeground(new java.awt.Color(255, 0, 51));

        lblCountry.setFont(new java.awt.Font("Vivaldi", 1, 14)); // NOI18N
        lblCountry.setForeground(new java.awt.Color(51, 255, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWind, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSun, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblWind, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblSun, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            URL url = new URL("http://weather.yahooapis.com/forecastrss?w=1252431&u=c");
            org.w3c.dom.Document doc = ReadOrWriteXML.readXMLFromURL(url);
            NodeList locationElement = doc.getElementsByTagName("yweather:location");
            for(int i=0;i<locationElement.getLength();i++){
                Node n = locationElement.item(i);
                if(n.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element)n;
                    String s = eElement.getAttribute("city");
                    String r = eElement.getAttribute("country");
                    lblLocation.setText(s);
                    lblCountry.setText(r);
                }
            }
            NodeList conditionElement = doc.getElementsByTagName("yweather:condition");
            for(int i=0;i<conditionElement.getLength();i++){
                Node n = conditionElement.item(i);
                if(n.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element)n;
                    String s = eElement.getAttribute("text");
                    String code = eElement.getAttribute("code");
                    String temp = eElement.getAttribute("temp");
                    lblCondition.setText(s);
                    URL urlLogo = new URL("http://l.yimg.com/a/i/us/we/52/"+code+".gif");
                    ImageIcon icon = new ImageIcon(urlLogo);
                    icon.setImage(icon.getImage().getScaledInstance(52, 52, Image.SCALE_DEFAULT));
                    lblLogo.setIcon(icon);
                    lblTemp.setText(temp+"°C");
                }
            }
            NodeList windElement = doc.getElementsByTagName("yweather:wind");
            for(int i=0;i<windElement.getLength();i++){
                Node n = windElement.item(i);
                if(n.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element)n;
                    String s = eElement.getAttribute("speed");
                    lblWind.setText("Wind Speed: "+s+" km/h");
                }
            }
            NodeList sunElement = doc.getElementsByTagName("yweather:astronomy");
            for(int i=0;i<sunElement.getLength();i++){
                Node n = sunElement.item(i);
                if(n.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element)n;
                    String sunrise = eElement.getAttribute("sunrise");
                    String sunset = eElement.getAttribute("sunset");
                    lblSun.setText("Sunrise at: "+sunrise+", sunset at: "+sunset);
                }
            }
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(WeatherJson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(WeatherJson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WeatherJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(WeatherJson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeatherJson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeatherJson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeatherJson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WeatherJson form = new WeatherJson();
                form.setVisible(true);
                form.getContentPane().setBackground(Color.GRAY);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCondition;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblSun;
    private javax.swing.JLabel lblTemp;
    private javax.swing.JLabel lblWind;
    // End of variables declaration//GEN-END:variables
}