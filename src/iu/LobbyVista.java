package iu;

import iu.controladores.LobbyVistaControlador;
import iu.controladores.LoginVistaControlador;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Sistema;
import logica.mesa.Mesa;
import logica.mesa.TipoApuesta;
import logica.usuario.Sesion;
import logica.usuario.Usuario;
import logica.usuario.UsuarioJugador;

public class LobbyVista extends javax.swing.JDialog implements VistaLobby {

    protected LobbyVistaControlador controlador;
    Sesion sesion;

    public LobbyVista(java.awt.Frame parent, boolean modal, Sesion sesion) {
        super(parent, modal);
        initComponents();
        this.sesion = sesion;
        setTitle("Lobby de Crupier " + mostrarNombre());
        this.controlador = crearControlador();

        //mostrarTipoApuesta();
        //Sistema.getInstancia().agregar(this);
        // buscarPartidas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSeleccionesTA = new javax.swing.JLabel();
        btnCrearMesa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lTipoApuestas = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblSeleccionesTA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSeleccionesTA.setText("Seleccione un Tipo de Apuesta:");

        btnCrearMesa.setText("Crear Mesa");
        btnCrearMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearMesaActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lTipoApuestas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSeleccionesTA, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(198, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCrearMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblSeleccionesTA, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCrearMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearMesaActionPerformed
        controlador.crearMesa(lTipoApuestas.getSelectedValuesList());
    }//GEN-LAST:event_btnCrearMesaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearMesa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lTipoApuestas;
    private javax.swing.JLabel lblSeleccionesTA;
    // End of variables declaration//GEN-END:variables

    private String mostrarNombre() {
        return this.sesion.getUsuario().getNombreCompleto();
    }

    public void mostrarTiposApuesta(ArrayList<TipoApuesta> tipos) {
        lTipoApuestas.setListData(tipos.toArray());
    }

    @Override
    public void ejecutarCasoDeUsoInicial(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cerrarVentana() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarMensajeDeError(String mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    private void mostrarTipoApuesta(ArrayList<TipoApuesta> tiposApuesta) {
//        controlador.mostrarTiposDeApuesta();
//        lTiposApuestas.setListData((String[]) tiposApuesta.toArray());
//    }
    protected LobbyVistaControlador crearControlador() {
        return new LobbyVistaControlador(this);
    }
}
