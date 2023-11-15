/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.JKOC.ui;

import java.util.ArrayList;
import obligatorio.JKOC.dominio.Crupier;
import obligatorio.JKOC.dominio.Sesion;
import obligatorio.JKOC.controllers.UsuariosConectadosVistaControlador;

/**
 *
 * @author ddauser
 */
public class DialogoUsuariosConectados extends DialogoBase implements UsuariosConectadosVista {

    private final UsuariosConectadosVistaControlador controlador;

    /**
     * Creates new form DialogoUsuariosConectados
     */
    public DialogoUsuariosConectados(java.awt.Frame parent, boolean modal, Crupier administrador) {
        super(parent, modal);
        initComponents();
        this.controlador = new UsuariosConectadosVistaControlador(this, administrador);
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
        lUsuariosConectados = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jScrollPane1.setViewportView(lUsuariosConectados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controlador.cerrandoVentana();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lUsuariosConectados;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarDatosDelAdministrador(Crupier administrador) {
        this.setTitle("Bienvenido/a " + administrador.getNombre());
    }

    @Override
    public void mostrarUsuariosConectados(ArrayList<Sesion> usuariosConectados) {
        lUsuariosConectados.setListData(usuariosConectados.toArray());
    }
}
