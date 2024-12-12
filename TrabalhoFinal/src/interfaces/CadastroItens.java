package interfaces;

import DAO.ItemDAO;
import beans.Item;

public class CadastroItens extends javax.swing.JFrame {

    public CadastroItens() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btn_GrpEstado = new javax.swing.ButtonGroup();
        jblCadastro = new javax.swing.JLabel();
        jblNome = new javax.swing.JLabel();
        jblCategoria = new javax.swing.JLabel();
        TxtNome = new javax.swing.JTextField();
        CmbCategoria = new javax.swing.JComboBox<>();
        BtnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jblCadastro.setBackground(new java.awt.Color(0, 0, 0));
        jblCadastro.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        jblCadastro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblCadastro.setText("Cadastro");

        jblNome.setFont(new java.awt.Font("Imprint MT Shadow", 0, 14)); // NOI18N
        jblNome.setText("Nome:");

        jblCategoria.setFont(new java.awt.Font("Imprint MT Shadow", 0, 14)); // NOI18N
        jblCategoria.setText("Categoria:");

        CmbCategoria.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        CmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chave", "Controle", "Caneta" }));
        CmbCategoria.setSelectedIndex(-1);

        BtnCadastrar.setFont(new java.awt.Font("Imprint MT Shadow", 0, 14)); // NOI18N
        BtnCadastrar.setText("Cadastrar");
        BtnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jblCadastro)
                .addContainerGap(91, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jblCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addComponent(BtnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jblCadastro)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jblNome)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jblCategoria)
                            .addComponent(CmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(BtnCadastrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastrarActionPerformed
        Item i = new Item();
        i.setNome(TxtNome.getText());
        i.setCategoria((String) CmbCategoria.getSelectedItem());

        ItemDAO iDAO = new ItemDAO();
        iDAO.inserir(i);
        limparFormulario();
    }//GEN-LAST:event_BtnCadastrarActionPerformed

    public void limparFormulario() {
        TxtNome.setText("");
        CmbCategoria.setSelectedIndex(-1);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroItens().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCadastrar;
    private javax.swing.ButtonGroup Btn_GrpEstado;
    private javax.swing.JComboBox<String> CmbCategoria;
    private javax.swing.JTextField TxtNome;
    private javax.swing.JLabel jblCadastro;
    private javax.swing.JLabel jblCategoria;
    private javax.swing.JLabel jblNome;
    // End of variables declaration//GEN-END:variables
}
