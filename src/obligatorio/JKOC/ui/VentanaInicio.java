package obligatorio.JKOC.ui;

import obligatorio.JKOC.logica.FachadaServicios;

/**
 *
 * @author ddauser
 */
public class VentanaInicio extends javax.swing.JFrame {

    /**
     * Creates new form VentanaInicio
     */
    public VentanaInicio() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mLogin = new javax.swing.JMenuItem();
        mLoginAdministrador = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bienvenido a Sistema de Agendas");

        jMenu1.setText("Usuario");

        mLogin.setText("Login usuario");
        mLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLoginActionPerformed(evt);
            }
        });
        jMenu1.add(mLogin);

        mLoginAdministrador.setText("Login Administrador");
        mLoginAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLoginAdministradorActionPerformed(evt);
            }
        });
        jMenu1.add(mLoginAdministrador);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLoginActionPerformed
        this.loginUsuario();
    }//GEN-LAST:event_mLoginActionPerformed

    private void mLoginAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLoginAdministradorActionPerformed
        this.loginAdministrador();
    }//GEN-LAST:event_mLoginAdministradorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mLogin;
    private javax.swing.JMenuItem mLoginAdministrador;
    // End of variables declaration//GEN-END:variables

    private void loginUsuario() {
        new DialogoLoginUsuario(this, false).setVisible(true);
    }

    private void loginAdministrador() {
        new DialogoLoginAdministrador(this, false).setVisible(true);
    }
}
