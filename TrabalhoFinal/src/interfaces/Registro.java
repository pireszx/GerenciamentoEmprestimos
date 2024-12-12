package interfaces;

import DAO.EmprestimoDAO;
import DAO.ItemDAO;
import DAO.UsuarioDAO;
import beans.Emprestimo;
import beans.Item;
import beans.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class Registro extends javax.swing.JFrame {

    private Map<String, Item> itemMap = new HashMap<>();
    private Map<String, Usuario> usuarioMap = new HashMap<>();

    public Registro() {
        initComponents();
        preencherComboItem();
        preencherComboUsuario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grp_BtnRegistro = new javax.swing.ButtonGroup();
        JblRegistro = new javax.swing.JLabel();
        JblNome = new javax.swing.JLabel();
        JblSelecione = new javax.swing.JLabel();
        Rda_BtnEmprestimo = new javax.swing.JRadioButton();
        Rda_BtnDevolucao = new javax.swing.JRadioButton();
        BtnRegistrar = new javax.swing.JButton();
        CmbUsuario = new javax.swing.JComboBox<>();
        JblUsuario = new javax.swing.JLabel();
        CmbItem = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JblRegistro.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        JblRegistro.setText("Registro");

        JblNome.setFont(new java.awt.Font("Imprint MT Shadow", 0, 14)); // NOI18N
        JblNome.setText("Item:");

        JblSelecione.setFont(new java.awt.Font("Imprint MT Shadow", 0, 14)); // NOI18N
        JblSelecione.setText("Selecione:");

        Grp_BtnRegistro.add(Rda_BtnEmprestimo);
        Rda_BtnEmprestimo.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        Rda_BtnEmprestimo.setText("Empréstimo");
        Rda_BtnEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rda_BtnEmprestimoActionPerformed(evt);
            }
        });

        Grp_BtnRegistro.add(Rda_BtnDevolucao);
        Rda_BtnDevolucao.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        Rda_BtnDevolucao.setText("Devolução");
        Rda_BtnDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rda_BtnDevolucaoActionPerformed(evt);
            }
        });

        BtnRegistrar.setFont(new java.awt.Font("Imprint MT Shadow", 0, 14)); // NOI18N
        BtnRegistrar.setText("Registrar");
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });

        CmbUsuario.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N

        JblUsuario.setFont(new java.awt.Font("Imprint MT Shadow", 0, 14)); // NOI18N
        JblUsuario.setText("Usuário:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(JblRegistro)
                        .addGap(86, 98, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JblNome)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CmbItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JblUsuario)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CmbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JblSelecione)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Rda_BtnEmprestimo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Rda_BtnDevolucao)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(JblRegistro)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JblNome)
                    .addComponent(CmbItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JblUsuario)
                    .addComponent(CmbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JblSelecione)
                    .addComponent(Rda_BtnEmprestimo)
                    .addComponent(Rda_BtnDevolucao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(BtnRegistrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Rda_BtnEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rda_BtnEmprestimoActionPerformed

    }//GEN-LAST:event_Rda_BtnEmprestimoActionPerformed

    private void Rda_BtnDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rda_BtnDevolucaoActionPerformed

    }//GEN-LAST:event_Rda_BtnDevolucaoActionPerformed

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
        Emprestimo e = new Emprestimo();

        String estado = null;
        if (Rda_BtnEmprestimo.isSelected()) {
            estado = "emprestado";
        } else if (Rda_BtnDevolucao.isSelected()) {
            estado = "devolvido";
        }

        String nomeItemSelecionado = (String) CmbItem.getSelectedItem();
        String nomeUsuarioSelecionado = (String) CmbUsuario.getSelectedItem();

        Item itemSelecionado = itemMap.get(nomeItemSelecionado);
        Usuario usuarioSelecionado = usuarioMap.get(nomeUsuarioSelecionado);

        e.setId_item(itemSelecionado);
        e.setId_usuario(usuarioSelecionado);
        e.setEstado(estado);

        EmprestimoDAO eDAO = new EmprestimoDAO();
        eDAO.inserir(e);

        JOptionPane.showMessageDialog(this, "Registro efetuado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        limparFormulario();
    }//GEN-LAST:event_BtnRegistrarActionPerformed

    public void limparFormulario() {
        CmbItem.setSelectedIndex(-1);
        CmbUsuario.setSelectedIndex(-1);
        Grp_BtnRegistro.clearSelection();
    }

    public void preencherComboItem() {
        ItemDAO iDAO = new ItemDAO();
        List<Item> listaItens = iDAO.getItens();

        for (Item item : listaItens) {
            CmbItem.addItem(item.getNome());
            itemMap.put(item.getNome(), item);
        }

        CmbItem.setSelectedIndex(-1);
    }

    public void preencherComboUsuario() {
        UsuarioDAO uDAO = new UsuarioDAO();
        List<Usuario> listaUsuarios = uDAO.getUsuarios();

        for (Usuario usuario : listaUsuarios) {
            CmbUsuario.addItem(usuario.getNome());
            usuarioMap.put(usuario.getNome(), usuario);
        }

        CmbUsuario.setSelectedIndex(-1);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JComboBox<String> CmbItem;
    private javax.swing.JComboBox<String> CmbUsuario;
    private javax.swing.ButtonGroup Grp_BtnRegistro;
    private javax.swing.JLabel JblNome;
    private javax.swing.JLabel JblRegistro;
    private javax.swing.JLabel JblSelecione;
    private javax.swing.JLabel JblUsuario;
    private javax.swing.JRadioButton Rda_BtnDevolucao;
    private javax.swing.JRadioButton Rda_BtnEmprestimo;
    // End of variables declaration//GEN-END:variables
}
