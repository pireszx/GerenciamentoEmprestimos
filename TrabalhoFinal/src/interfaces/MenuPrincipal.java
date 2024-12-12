package interfaces;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        MenuCadastro = new javax.swing.JMenu();
        MenuItemUsuario = new javax.swing.JMenuItem();
        MenuItemItem = new javax.swing.JMenuItem();
        MenuRegistro = new javax.swing.JMenu();
        MenuItemRegistro = new javax.swing.JMenuItem();
        MenuRelatorio = new javax.swing.JMenu();
        MenuItemEmprestimo = new javax.swing.JMenuItem();
        MenuItemDevolucao = new javax.swing.JMenuItem();
        MenuConsulta = new javax.swing.JMenu();
        MenuItemConsulta = new javax.swing.JMenuItem();
        MenuSair = new javax.swing.JMenu();
        MenuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MenuCadastro.setText("Cadastros");

        MenuItemUsuario.setText("Usuário");
        MenuItemUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemUsuarioActionPerformed(evt);
            }
        });
        MenuCadastro.add(MenuItemUsuario);

        MenuItemItem.setText("Item");
        MenuItemItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemItemActionPerformed(evt);
            }
        });
        MenuCadastro.add(MenuItemItem);

        jMenuBar1.add(MenuCadastro);

        MenuRegistro.setText("Registro");

        MenuItemRegistro.setText("Registro");
        MenuItemRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemRegistroActionPerformed(evt);
            }
        });
        MenuRegistro.add(MenuItemRegistro);

        jMenuBar1.add(MenuRegistro);

        MenuRelatorio.setText("Relatórios");

        MenuItemEmprestimo.setText("Mais emprestados");
        MenuItemEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemEmprestimoActionPerformed(evt);
            }
        });
        MenuRelatorio.add(MenuItemEmprestimo);

        MenuItemDevolucao.setText("Em atraso");
        MenuItemDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemDevolucaoActionPerformed(evt);
            }
        });
        MenuRelatorio.add(MenuItemDevolucao);

        jMenuBar1.add(MenuRelatorio);

        MenuConsulta.setText("Consulta");

        MenuItemConsulta.setText("Consulta");
        MenuItemConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemConsultaActionPerformed(evt);
            }
        });
        MenuConsulta.add(MenuItemConsulta);

        jMenuBar1.add(MenuConsulta);

        MenuSair.setText("Sair");

        MenuItemSair.setText("Sair");
        MenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemSairActionPerformed(evt);
            }
        });
        MenuSair.add(MenuItemSair);

        jMenuBar1.add(MenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MenuItemSairActionPerformed

    private void MenuItemUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemUsuarioActionPerformed
        CadastroUsuarios cadUsuario = new CadastroUsuarios();
        cadUsuario.setVisible(true);
    }//GEN-LAST:event_MenuItemUsuarioActionPerformed

    private void MenuItemItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemItemActionPerformed
        CadastroItens cadItens = new CadastroItens();
        cadItens.setVisible(true);
    }//GEN-LAST:event_MenuItemItemActionPerformed

    private void MenuItemRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemRegistroActionPerformed
        Registro registro = new Registro();
        registro.setVisible(true);
    }//GEN-LAST:event_MenuItemRegistroActionPerformed

    private void MenuItemEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemEmprestimoActionPerformed
        RelatorioEmprestados relatorio = new RelatorioEmprestados();
        relatorio.setVisible(true);
    }//GEN-LAST:event_MenuItemEmprestimoActionPerformed

    private void MenuItemDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemDevolucaoActionPerformed
        RelatorioDevolucoes relatorio = new RelatorioDevolucoes();
        relatorio.setVisible(true);
    }//GEN-LAST:event_MenuItemDevolucaoActionPerformed

    private void MenuItemConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemConsultaActionPerformed
        ConsultaHistorico consulta = new ConsultaHistorico();
        consulta.setVisible(true);
    }//GEN-LAST:event_MenuItemConsultaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuCadastro;
    private javax.swing.JMenu MenuConsulta;
    private javax.swing.JMenuItem MenuItemConsulta;
    private javax.swing.JMenuItem MenuItemDevolucao;
    private javax.swing.JMenuItem MenuItemEmprestimo;
    private javax.swing.JMenuItem MenuItemItem;
    private javax.swing.JMenuItem MenuItemRegistro;
    private javax.swing.JMenuItem MenuItemSair;
    private javax.swing.JMenuItem MenuItemUsuario;
    private javax.swing.JMenu MenuRegistro;
    private javax.swing.JMenu MenuRelatorio;
    private javax.swing.JMenu MenuSair;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
