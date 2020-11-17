/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;
import Login.Login;
import javax.swing.JOptionPane;
import Modelo.Usuario;
/**
 *
 * @author Fernando
 */
public class frmPrincipalAlumno extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipalAlumno() {
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

        desktopPane = new javax.swing.JDesktopPane();
        nombre_text = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mi_id_text = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        Alumnos = new javax.swing.JMenu();
        listar_alumnos_menu = new javax.swing.JMenuItem();
        listar_profesores_menu = new javax.swing.JMenuItem();
        consultar_Notas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Software de Ventas"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        desktopPane.setBackground(new java.awt.Color(0, 115, 202));

        nombre_text.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nombre_text.setForeground(new java.awt.Color(255, 255, 255));
        desktopPane.add(nombre_text);
        nombre_text.setBounds(140, 60, 330, 20);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mi Nombre:");
        desktopPane.add(jLabel3);
        jLabel3.setBounds(30, 60, 80, 19);

        mi_id_text.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        mi_id_text.setForeground(new java.awt.Color(255, 255, 255));
        desktopPane.add(mi_id_text);
        mi_id_text.setBounds(140, 30, 150, 20);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MI ID :");
        desktopPane.add(jLabel1);
        jLabel1.setBounds(30, 30, 60, 19);

        menuBar.setForeground(new java.awt.Color(0, 123, 247));

        fileMenu.setMnemonic('f');
        fileMenu.setText("Opciones");

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMenuItemMouseClicked(evt);
            }
        });
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        Alumnos.setMnemonic('e');
        Alumnos.setText("Alumnos");

        listar_alumnos_menu.setMnemonic('t');
        listar_alumnos_menu.setText("Listar alumnos de clase");
        Alumnos.add(listar_alumnos_menu);

        listar_profesores_menu.setMnemonic('y');
        listar_profesores_menu.setText("Listar Profesores");
        listar_profesores_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listar_profesores_menuActionPerformed(evt);
            }
        });
        Alumnos.add(listar_profesores_menu);

        consultar_Notas.setText("Consultar notas");
        Alumnos.add(consultar_Notas);

        menuBar.add(Alumnos);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void exitMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMenuItemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_exitMenuItemMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:        
    }//GEN-LAST:event_formWindowOpened

    private void listar_profesores_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listar_profesores_menuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listar_profesores_menuActionPerformed

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
            java.util.logging.Logger.getLogger(frmPrincipalAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipalAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipalAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipalAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

                
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new frmPrincipalAlumno().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Alumnos;
    public javax.swing.JMenuItem consultar_Notas;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JMenuItem listar_alumnos_menu;
    public javax.swing.JMenuItem listar_profesores_menu;
    private javax.swing.JMenuBar menuBar;
    public javax.swing.JLabel mi_id_text;
    public javax.swing.JLabel nombre_text;
    // End of variables declaration//GEN-END:variables

}
