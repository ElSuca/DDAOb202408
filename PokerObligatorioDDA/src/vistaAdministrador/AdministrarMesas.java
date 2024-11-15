/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistaAdministrador;

import controladores.ControladorAdministrarMesas;
import java.util.ArrayList;
import modelo.Administrador;
import modelo.EventosGenerales;
import modelo.Fachada;
import modelo.Mano;
import modelo.Mesa;
import observador.Observable;
import vistas.vistaAdministrarMesas;

/**
 *
 * @author Usuario
 */
public class AdministrarMesas extends javax.swing.JDialog implements vistaAdministrarMesas {

    /**
     * Creates new form AdministrarMesas
     */
    private ControladorAdministrarMesas controlador;
    public Administrador admin;

    public AdministrarMesas(java.awt.Frame parent, boolean modal, Administrador a) {
        super(parent, modal);
        initComponents();
        setTitle("ADMINISTRACION DE MESAS - ADMIN: " + a.getNombreCompleto().toUpperCase());
        admin = a;
        controlador = new ControladorAdministrarMesas(this);
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
        listaMesas = new javax.swing.JList();
        lblNumMesa = new javax.swing.JLabel();
        lblJugadores = new javax.swing.JLabel();
        lblLuz = new javax.swing.JLabel();
        lblManoActual = new javax.swing.JLabel();
        lblTotalApostado = new javax.swing.JLabel();
        lblComision = new javax.swing.JLabel();
        lblRecaudado = new javax.swing.JLabel();
        lblEstadoMesa = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaManos = new javax.swing.JList();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnCrearMesa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        listaMesas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listaMesas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaMesasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaMesas);

        lblNumMesa.setText("Número de Mesa:");

        lblJugadores.setText("Jugadores:");

        lblLuz.setText("Apuesta Base (Luz):");

        lblManoActual.setText("Mano Actual:");
        lblManoActual.setToolTipText("");

        lblTotalApostado.setText("Total Apostado");
        lblTotalApostado.setToolTipText("");

        lblComision.setText("Porc. Comisión:");
        lblComision.setToolTipText("");

        lblRecaudado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblRecaudado.setForeground(new java.awt.Color(48, 84, 231));
        lblRecaudado.setText("TOTAL RECAUDADO:");
        lblRecaudado.setToolTipText("");

        lblEstadoMesa.setText("Estado Actual:");
        lblEstadoMesa.setToolTipText("");

        jScrollPane2.setViewportView(listaManos);

        jMenu1.setText("Seleccionar");

        btnCrearMesa.setText("Crear Mesa");
        btnCrearMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearMesaActionPerformed(evt);
            }
        });
        jMenu1.add(btnCrearMesa);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRecaudado, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(lblNumMesa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblJugadores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLuz, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblManoActual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotalApostado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblComision, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEstadoMesa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNumMesa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblJugadores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLuz)
                        .addGap(13, 13, 13)
                        .addComponent(lblManoActual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotalApostado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblComision)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEstadoMesa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblRecaudado)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearMesaActionPerformed
        new CrearMesa(this, false).setVisible(true);
    }//GEN-LAST:event_btnCrearMesaActionPerformed

    private void listaMesasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaMesasValueChanged
        seleccionMesa();
    }//GEN-LAST:event_listaMesasValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnCrearMesa;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblComision;
    private javax.swing.JLabel lblEstadoMesa;
    private javax.swing.JLabel lblJugadores;
    private javax.swing.JLabel lblLuz;
    private javax.swing.JLabel lblManoActual;
    private javax.swing.JLabel lblNumMesa;
    private javax.swing.JLabel lblRecaudado;
    private javax.swing.JLabel lblTotalApostado;
    private javax.swing.JList listaManos;
    private javax.swing.JList listaMesas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarMesas(ArrayList<Mesa> mesas) {
        ArrayList<String> listado = new ArrayList();
        for (Mesa m : mesas) {
            listado.add("Mesa N°" + m.getNumeroMesa() + "|" + m.getJugadores().size()
                    + "/" + m.getCantJugadores() + "|Luz:" + m.getLuz() + "|Mano:" + m.getManos().size()
                    + "|Total:" + m.getPozo() + "|Com.:" + m.getComision()
                    + "%|Rec.:" + m.getTotalRec() + "|Estado:" + m.getEstado().toString());
        }
        listaMesas.setListData(listado.toArray());
    }

    private void seleccionMesa() {
        controlador.seleccionMesa(listaMesas.getSelectedIndex());
    }

    @Override
    public void limpiarDetalles() {
        lblNumMesa.setText("Número de Mesa:");
        lblJugadores.setText("Jugadores: ");
        lblLuz.setText("Apuesta Base (Luz):");
        lblManoActual.setText("Mano Actual:");
        lblTotalApostado.setText("Total Apostado:");
        lblComision.setText("Porc. Comisión:");
        lblEstadoMesa.setText("Estado Actual:");
        lblRecaudado.setText("TOTAL RECAUDADO:");
    }

    @Override
    public void mostrarDetallesMesa(ArrayList<Mano> manos, int numeroMesa, int jugadores, int cantJugadores, int luz, int manoActual, int pozo, int comision, int totalRec, String estadoMesa) {
        mostrarManos(manos);
        lblNumMesa.setText("Número de Mesa: " + numeroMesa);
        lblJugadores.setText("Jugadores: " + jugadores + "/" + cantJugadores);
        lblLuz.setText("Apuesta Base (Luz): "+luz);
        lblManoActual.setText("Mano Actual: "+manoActual);
        lblTotalApostado.setText("Total Apostado: "+pozo);
        lblComision.setText("Porc. Comisión: "+comision);
        lblEstadoMesa.setText("Estado Actual: "+estadoMesa);
        lblRecaudado.setText("TOTAL RECAUDADO: "+totalRec);
    }

    private void mostrarManos(ArrayList<Mano> manos) {
        ArrayList<String> listado = new ArrayList();
        for (Mano m : manos) {
            listado.add("Mano N°"+m.getNumeroMano()+"Jugadores:"+m.getJugadores().size()
            +"Total Apostado"+m.getValorMano()+"Estado:"+m.getEstado().toString()
            +"Ganador"+m.getGanador().getNombreCompleto()
            +"Figura Ganadora:"+m.getFiguraGanadora().getNombre());
        }
        listaManos.setListData(listado.toArray());
    }
}
