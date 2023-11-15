package iu;

import iu.controladores.LoginVistaControlador;
import javax.swing.JOptionPane;
import logica.usuario.Sesion;
import utilidades.CrupierException;

public abstract class LoginVista extends javax.swing.JDialog implements VistaLogin {

    protected LoginVistaControlador controlador;

    public LoginVista(java.awt.Frame parent, boolean modal, boolean isCrupier) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.controlador = crearControlador();

//        if (isCrupier) {//Esto tiene que ir en el controlador de la vista
//            setTitle("Login Crupier");
//        } else {
//            setTitle("Login Jugador");
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_nombreUsuairo = new javax.swing.JLabel();
        txt_nombreUsuario = new javax.swing.JTextField();
        lbl_password = new javax.swing.JLabel();
        btn_ingresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbl_nombreUsuairo.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        lbl_nombreUsuairo.setText("Ingrese nombre usuario:");

        txt_nombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        txt_nombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreUsuarioActionPerformed(evt);
            }
        });

        lbl_password.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        lbl_password.setText("Ingrese password:");

        btn_ingresar.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        btn_ingresar.setText("Ingresar");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel1.setText("Login");

        txt_password.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_ingresar)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_password)
                                    .addComponent(lbl_nombreUsuairo))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_nombreUsuario)
                                    .addComponent(txt_password, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(436, 436, 436)
                        .addComponent(jLabel1)))
                .addContainerGap(323, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nombreUsuairo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_password, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104)
                .addComponent(btn_ingresar)
                .addGap(74, 74, 74))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreUsuarioActionPerformed

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        login();
    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_nombreUsuairo;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JTextField txt_nombreUsuario;
    private javax.swing.JPasswordField txt_password;
    // End of variables declaration//GEN-END:variables


    private void login() {
        String nombre = txt_nombreUsuario.getText();
        String password = String.valueOf(txt_password.getPassword());
        controlador.login(nombre, password);
    }
    
    protected abstract LoginVistaControlador crearControlador();
}