
package iu;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Sistema;
import logica.mesa.Mesa;
import logica.usuario.Sesion;
import logica.usuario.UsuarioJugador;


public class Lobby extends javax.swing.JDialog {

    /**
     * Creates new form Lobby
     */
    Sesion sesion;
    public Lobby(java.awt.Frame parent, boolean modal, Sesion sesion) {
        super(parent, modal);
        initComponents();
        this.sesion = sesion;
        setTitle(mostrarNombre());
        buscarPartidas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_mensajeLobby = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbl_mensajeLobby.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_mensajeLobby.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_mensajeLobby.setText("Buscando partida... Espere un momento.");
        lbl_mensajeLobby.setFocusable(false);
        lbl_mensajeLobby.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(lbl_mensajeLobby, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(lbl_mensajeLobby, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_mensajeLobby;
    // End of variables declaration//GEN-END:variables

    private String mostrarNombre() {
       return this.sesion.getUsuario().getNombreCompleto();
    }

    private void buscarPartidas() {
     //  mensajeLobby("Buscando partida...Espere un momento.");
       List<Mesa> mesas = Sistema.getInstancia().listarMesas();
      
       //manejar los estados
       for(Mesa m : mesas){
//           if(!m.isEmpezo() && limiteJugadores(m.getJugadores())){
//              // this.setVisible(false); //quiero sacar la pantalla
//               JugarRuleta jugar = new JugarRuleta(null, false, this.sesion);
//               jugar.setVisible(true);
//           }
       }
    }

    private boolean limiteJugadores(List<UsuarioJugador> jugadores) { //esto retorna una excepcion
      if(jugadores.size() >1 && jugadores.size() <6){
          return true;
      }else{
          return false;
      }
    }

  

}
