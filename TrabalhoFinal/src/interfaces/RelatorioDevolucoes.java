package interfaces;

import DAO.EmprestimoDAO;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

public class RelatorioDevolucoes extends javax.swing.JFrame {

    public RelatorioDevolucoes() {
        initComponents();
        preencheTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblRelatorio = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JblTitulo.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        JblTitulo.setText("Empréstimos em atraso");

        TblRelatorio.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        TblRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuário", "Item", "Data de Vencimento", "Tempo de atraso"
            }
        ));
        jScrollPane1.setViewportView(TblRelatorio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(JblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void preencheTabela() {
        EmprestimoDAO eDAO = new EmprestimoDAO();
        List<Map<String, Object>> listaItensAtrasados = eDAO.procedureItensAtrasados();

        DefaultTableModel tabelaEmprestimo = (DefaultTableModel) TblRelatorio.getModel();
        tabelaEmprestimo.setNumRows(0);

        for (Map<String, Object> item : listaItensAtrasados) {
            Object[] obj = new Object[]{
                item.get("Responsavel"),
                item.get("Item"),
                item.get("Vencimento"),
                item.get("DiasAtraso")
            };
            tabelaEmprestimo.addRow(obj);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioDevolucoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JblTitulo;
    private javax.swing.JTable TblRelatorio;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
