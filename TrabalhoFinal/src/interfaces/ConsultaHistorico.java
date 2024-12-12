package interfaces;

import DAO.EmprestimoDAO;
import beans.View_HistoricoEmprestimo;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ConsultaHistorico extends javax.swing.JFrame {

    String filtroMatricula = null;
    String filtroNomeItem = null;

    public ConsultaHistorico() {
        initComponents();
        preencheTabela(filtroMatricula, filtroNomeItem);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grp_BtnConsulta = new javax.swing.ButtonGroup();
        JblConsulta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblConsulta = new javax.swing.JTable();
        JblNome = new javax.swing.JLabel();
        JblSelecione = new javax.swing.JLabel();
        Rda_BtnUsuario = new javax.swing.JRadioButton();
        Rda_BtnItem = new javax.swing.JRadioButton();
        JblMatricula = new javax.swing.JLabel();
        TxtNome = new javax.swing.JTextField();
        TxtMatricula = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JblConsulta.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        JblConsulta.setText("Consulta");

        TblConsulta.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        TblConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuário", "Matricula", "Item", "Status", "Data"
            }
        ));
        jScrollPane1.setViewportView(TblConsulta);

        JblNome.setFont(new java.awt.Font("Imprint MT Shadow", 0, 14)); // NOI18N
        JblNome.setText("Nome:");
        JblNome.setToolTipText("");

        JblSelecione.setFont(new java.awt.Font("Imprint MT Shadow", 0, 14)); // NOI18N
        JblSelecione.setText("Selecione:");

        Grp_BtnConsulta.add(Rda_BtnUsuario);
        Rda_BtnUsuario.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        Rda_BtnUsuario.setText("Usuário");
        Rda_BtnUsuario.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Rda_BtnUsuarioStateChanged(evt);
            }
        });
        Rda_BtnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rda_BtnUsuarioActionPerformed(evt);
            }
        });

        Grp_BtnConsulta.add(Rda_BtnItem);
        Rda_BtnItem.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        Rda_BtnItem.setText("Item");
        Rda_BtnItem.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Rda_BtnItemStateChanged(evt);
            }
        });
        Rda_BtnItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rda_BtnItemActionPerformed(evt);
            }
        });

        JblMatricula.setFont(new java.awt.Font("Imprint MT Shadow", 0, 14)); // NOI18N
        JblMatricula.setText("Matrícula:");

        TxtNome.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TxtNomeCaretUpdate(evt);
            }
        });

        TxtMatricula.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TxtMatriculaCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JblSelecione)
                                .addGap(18, 18, 18)
                                .addComponent(Rda_BtnUsuario)
                                .addGap(18, 18, 18)
                                .addComponent(Rda_BtnItem))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JblMatricula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JblConsulta)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(JblNome)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 215, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JblConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JblSelecione)
                    .addComponent(Rda_BtnUsuario)
                    .addComponent(Rda_BtnItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JblNome)
                    .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JblMatricula)
                    .addComponent(TxtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Rda_BtnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rda_BtnUsuarioActionPerformed
        TxtNome.setEnabled(false);
        TxtMatricula.setEnabled(true);
    }//GEN-LAST:event_Rda_BtnUsuarioActionPerformed

    private void Rda_BtnItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rda_BtnItemActionPerformed
        TxtNome.setEnabled(true);
        TxtMatricula.setEnabled(false);
    }//GEN-LAST:event_Rda_BtnItemActionPerformed

    private void Rda_BtnUsuarioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Rda_BtnUsuarioStateChanged
        preencheTabela(filtroMatricula, filtroNomeItem);
    }//GEN-LAST:event_Rda_BtnUsuarioStateChanged

    private void Rda_BtnItemStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Rda_BtnItemStateChanged
        preencheTabela(filtroMatricula, filtroNomeItem);
    }//GEN-LAST:event_Rda_BtnItemStateChanged

    private void TxtNomeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TxtNomeCaretUpdate
        filtroNomeItem = TxtNome.getText();
        preencheTabela(filtroMatricula, filtroNomeItem);
    }//GEN-LAST:event_TxtNomeCaretUpdate

    private void TxtMatriculaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TxtMatriculaCaretUpdate
        filtroMatricula = TxtMatricula.getText();
        preencheTabela(filtroMatricula, filtroNomeItem);
    }//GEN-LAST:event_TxtMatriculaCaretUpdate

    public void preencheTabela(String filtroMatricula, String filtroNomeItem) {
        try {
            EmprestimoDAO eDAO = new EmprestimoDAO();

            List<View_HistoricoEmprestimo> listaHistorico = eDAO.vw_HistoricoEmprestimos(filtroMatricula, filtroNomeItem);

            DefaultTableModel tabelaHistorico = (DefaultTableModel) TblConsulta.getModel();

            tabelaHistorico.setNumRows(0);

            for (View_HistoricoEmprestimo h : listaHistorico) {
                Object[] obj = new Object[]{
                    h.getResponsavel(),
                    h.getMatriculaUsuario(),
                    h.getItem(),
                    h.getStatus(),
                    h.getDataAtualizacao()
                };
                tabelaHistorico.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaHistorico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaHistorico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Grp_BtnConsulta;
    private javax.swing.JLabel JblConsulta;
    private javax.swing.JLabel JblMatricula;
    private javax.swing.JLabel JblNome;
    private javax.swing.JLabel JblSelecione;
    private javax.swing.JRadioButton Rda_BtnItem;
    private javax.swing.JRadioButton Rda_BtnUsuario;
    private javax.swing.JTable TblConsulta;
    private javax.swing.JTextField TxtMatricula;
    private javax.swing.JTextField TxtNome;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
