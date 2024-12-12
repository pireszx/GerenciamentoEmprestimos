package interfaces;

import DAO.EmprestimoDAO;
import beans.Emprestimo;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class RelatorioEmprestados extends javax.swing.JFrame {

    public RelatorioEmprestados() {
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
        JblTitulo.setText("Itens Com mais empréstimos");

        TblRelatorio.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        TblRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Quantidade de empréstimos"
            }
        ));
        jScrollPane1.setViewportView(TblRelatorio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JblTitulo)
                .addGap(64, 64, 64))
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
        List<Emprestimo> listaRelatorio = eDAO.procedureRelatorioItensMaisEmprestados();

        DefaultTableModel tabelaEmprestimo = (DefaultTableModel) TblRelatorio.getModel();
        tabelaEmprestimo.setNumRows(0);

        for (Emprestimo emprestimo : listaRelatorio) {
            Object[] obj = new Object[]{
                emprestimo.getId_item().getNome(),
                emprestimo.getEstado()
            };
            tabelaEmprestimo.addRow(obj);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioEmprestados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JblTitulo;
    private javax.swing.JTable TblRelatorio;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
