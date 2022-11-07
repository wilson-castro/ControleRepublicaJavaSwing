package src.views.pessoas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import src.models.Pessoa;
import src.services.DataManager;
import src.utils.Constantes;

public final class Pessoas extends javax.swing.JPanel {

    private DefaultTableModel model = null;
    DataManager<Pessoa> dmPessoa;
    
    private String idEdicao = null;

    public Pessoas() {
        initComponents();
        this.model = (DefaultTableModel) jTable_alunos.getModel();
        refreshTable();
    }

    private void setEstadoPadraoBotoes() {
        this.jButton_salvar.setEnabled(false);
        this.jButton_editar.setEnabled(false);
        this.jButton_Excluir.setEnabled(false);

        this.jButton_novo.setEnabled(true);
        this.jButton_atualizar.setEnabled(true);
    }

    private void limparInputs() {
        this.idEdicao = null;
        this.jTextField_rendimentos.setText(null);
        this.jTextField_nome.setText(null);
        this.jTextField_pesquisar.setText(null);
        this.jTextField_rendimentos.setText(null);
        this.jTextField_email1.setText(null);
    }

    private void handleChangeNovo() {
        setEstadoPadraoBotoes();
        int option = JOptionPane.showConfirmDialog(this, "Deseja limpar os campos?");
        if (option == 0) {
            limparInputs();
        }

        this.jButton_salvar.setEnabled(true);
    }

    private void handleChangeSalvar() throws Exception {
        String totalRendimentos = this.jTextField_rendimentos.getText();
        String nome = this.jTextField_nome.getText();
        String email = this.jTextField_email1.getText();
        float total = 0;
        
        boolean totalRendimentosValido = totalRendimentos != null && !totalRendimentos.isBlank();
        
        if(totalRendimentosValido) {
            try {
                total = Float.parseFloat(totalRendimentos);
            }catch (NumberFormatException nfe) {
                System.out.println("Total de Rendimentos inválido! "+nfe.getMessage());
                totalRendimentosValido =  false;
            }
        }
        
        if( (nome != null && !nome.isBlank()) 
            && (email !=null && !email.isBlank()) 
            && totalRendimentosValido) {
         
            String inputString = nome + ";" + email + ";" + total;
            
            if(idEdicao != null){
                dmPessoa.update(idEdicao, inputString);
                refreshTable();
            } else {
                Pessoa novaPessoa = dmPessoa.create(inputString);
                            
                if (novaPessoa != null) refreshTable();
            }

            setEstadoPadraoBotoes();
            limparInputs();   
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_inputs = new javax.swing.JPanel();
        jTextField_nome = new javax.swing.JTextField();
        jLabel_nome = new javax.swing.JLabel();
        jLabel_email = new javax.swing.JLabel();
        jTextField_rendimentos = new javax.swing.JTextField();
        jLabel_totalRendimentos = new javax.swing.JLabel();
        jTextField_email1 = new javax.swing.JTextField();
        jPanel_acoes = new javax.swing.JPanel();
        jButton_novo = new javax.swing.JButton();
        jButton_editar = new javax.swing.JButton();
        jButton_Excluir = new javax.swing.JButton();
        jButton_atualizar = new javax.swing.JButton();
        jTextField_pesquisar = new javax.swing.JTextField();
        jButton_pesquisar = new javax.swing.JButton();
        jButton_salvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_alunos = new javax.swing.JTable();

        setBackground(new java.awt.Color(102, 102, 102));
        setMaximumSize(new java.awt.Dimension(670, 440));
        setMinimumSize(new java.awt.Dimension(670, 440));

        jPanel_inputs.setBackground(new java.awt.Color(51, 51, 51));
        jPanel_inputs.setMinimumSize(new java.awt.Dimension(670, 80));
        jPanel_inputs.setPreferredSize(new java.awt.Dimension(670, 440));
        jPanel_inputs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel_inputs.add(jTextField_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 10, 240, 30));

        jLabel_nome.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_nome.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nome.setText("Nome:");
        jPanel_inputs.add(jLabel_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 30));

        jLabel_email.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_email.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_email.setText("Email: ");
        jPanel_inputs.add(jLabel_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 10, 60, 30));
        jPanel_inputs.add(jTextField_rendimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 130, 30));

        jLabel_totalRendimentos.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_totalRendimentos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_totalRendimentos.setText("Total de Rendimentos: ");
        jPanel_inputs.add(jLabel_totalRendimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 170, 30));
        jPanel_inputs.add(jTextField_email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 220, 30));

        jButton_novo.setText("Novo");
        jButton_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_novoActionPerformed(evt);
            }
        });

        jButton_editar.setText("Editar");
        jButton_editar.setEnabled(false);
        jButton_editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_editarMouseClicked(evt);
            }
        });

        jButton_Excluir.setText("Excluir");
        jButton_Excluir.setEnabled(false);
        jButton_Excluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_ExcluirMouseClicked(evt);
            }
        });

        jButton_atualizar.setText("Aualizar");
        jButton_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_atualizarActionPerformed(evt);
            }
        });

        jTextField_pesquisar.setToolTipText("Digite o nome");

        jButton_pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images/icons8-pesquisar-15.png"))); // NOI18N
        jButton_pesquisar.setToolTipText("Buscar por nome");
        jButton_pesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_pesquisarMouseClicked(evt);
            }
        });

        jButton_salvar.setText("Salvar");
        jButton_salvar.setEnabled(false);
        jButton_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_salvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_acoesLayout = new javax.swing.GroupLayout(jPanel_acoes);
        jPanel_acoes.setLayout(jPanel_acoesLayout);
        jPanel_acoesLayout.setHorizontalGroup(
            jPanel_acoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_acoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_salvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_novo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Excluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_atualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_acoesLayout.setVerticalGroup(
            jPanel_acoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_acoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_acoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_novo)
                    .addComponent(jButton_editar)
                    .addComponent(jButton_Excluir)
                    .addComponent(jButton_atualizar)
                    .addComponent(jTextField_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_salvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setMaximumSize(new java.awt.Dimension(185, 0));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(185, 0));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(185, 0));

        jTable_alunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Email", "Total Rend."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_alunos.setMaximumSize(new java.awt.Dimension(185, 0));
        jTable_alunos.setMinimumSize(new java.awt.Dimension(185, 0));
        jTable_alunos.getTableHeader().setReorderingAllowed(false);
        jTable_alunos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable_alunosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTable_alunosFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_alunos);
        if (jTable_alunos.getColumnModel().getColumnCount() > 0) {
            jTable_alunos.getColumnModel().getColumn(0).setResizable(false);
            jTable_alunos.getColumnModel().getColumn(0).setPreferredWidth(15);
            jTable_alunos.getColumnModel().getColumn(1).setResizable(false);
            jTable_alunos.getColumnModel().getColumn(2).setResizable(false);
            jTable_alunos.getColumnModel().getColumn(3).setResizable(false);
            jTable_alunos.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_acoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_inputs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel_inputs, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel_acoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_novoActionPerformed
        handleChangeNovo();
    }//GEN-LAST:event_jButton_novoActionPerformed

    private void jButton_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_salvarActionPerformed
        try {
            handleChangeSalvar();
        } catch (Exception ex) {
            Logger.getLogger(Pessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_salvarActionPerformed

    private void jButton_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_atualizarActionPerformed
        refreshTable();
    }//GEN-LAST:event_jButton_atualizarActionPerformed

    private void jButton_pesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_pesquisarMouseClicked
        String id = this.jTextField_pesquisar.getText().trim();
        try {
            Pessoa p = search(id);
            if (p == null) {
                JOptionPane.showMessageDialog(this, "Não foi encontrado ninguem com o id informado!");

            } else {
                showResults(p);
            }

        } catch (Exception ex) {
            Logger.getLogger(Pessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_pesquisarMouseClicked

    private void jButton_ExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ExcluirMouseClicked
        this.jButton_Excluir.setEnabled(!this.jButton_Excluir.isEnabled());
        this.jButton_editar.setEnabled(!this.jButton_Excluir.isEnabled());
        int option = JOptionPane.showConfirmDialog(this, "Confirma a exclusão?");
        if (option == 0) {
            for (int selectedRow : jTable_alunos.getSelectedRows()) {
                try {
                    String a = (String) jTable_alunos.getValueAt(selectedRow, 0);
                    dmPessoa.delete(a);

                } catch (Exception ex) {
                    Logger.getLogger(Pessoas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            refreshTable();
            JOptionPane.showMessageDialog(this, "Deletado com sucesso!");
        }
    }//GEN-LAST:event_jButton_ExcluirMouseClicked

    private void jTable_alunosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable_alunosFocusGained
        if(this.idEdicao == null ) {
            this.jButton_Excluir.setEnabled(true);
            this.jButton_editar.setEnabled(true);
        }
    }//GEN-LAST:event_jTable_alunosFocusGained

    private void jTable_alunosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable_alunosFocusLost
        this.jButton_Excluir.setEnabled(false);
        this.jButton_editar.setEnabled(false);
    }//GEN-LAST:event_jTable_alunosFocusLost

    private void jButton_editarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_editarMouseClicked
        if(jTable_alunos.getSelectedRows().length > 0 && idEdicao == null) {
            this.jButton_Excluir.setEnabled(false);
            this.jButton_editar.setEnabled(false);

            int firstSelectedRow = jTable_alunos.getSelectedRows()[0];

            try {
                
                idEdicao = (String) jTable_alunos.getValueAt(firstSelectedRow, 0);
                
                this.jTextField_nome.setText((String) jTable_alunos.getValueAt(firstSelectedRow, 1));
                this.jTextField_rendimentos.setText((String) jTable_alunos.getValueAt(firstSelectedRow, 3).toString());
                this.jTextField_email1.setText((String) jTable_alunos.getValueAt(firstSelectedRow, 2));
                
                this.jButton_salvar.setEnabled(true);
                
            } catch (NumberFormatException nex) {
                Logger.getLogger(Pessoas.class.getName()).log(Level.SEVERE, null, nex);
            }

        }
    }//GEN-LAST:event_jButton_editarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Excluir;
    private javax.swing.JButton jButton_atualizar;
    private javax.swing.JButton jButton_editar;
    private javax.swing.JButton jButton_novo;
    private javax.swing.JButton jButton_pesquisar;
    private javax.swing.JButton jButton_salvar;
    private javax.swing.JLabel jLabel_email;
    private javax.swing.JLabel jLabel_nome;
    private javax.swing.JLabel jLabel_totalRendimentos;
    private javax.swing.JPanel jPanel_acoes;
    private javax.swing.JPanel jPanel_inputs;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_alunos;
    private javax.swing.JTextField jTextField_email1;
    private javax.swing.JTextField jTextField_nome;
    private javax.swing.JTextField jTextField_pesquisar;
    private javax.swing.JTextField jTextField_rendimentos;
    // End of variables declaration//GEN-END:variables

    public void refreshTable() {
        model.setRowCount(0);
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
        }
        try {
            dmPessoa = new DataManager<>(Pessoa.class.getName(), Constantes.DIRETORIO_FILE + Constantes.NOME_BASE_FILE_USUARIOS);
            dmPessoa.getDataManagerList().forEach(pessoa -> {
                model.addRow(pessoa.getValues());
            });
        } catch (Exception ex) {
            Logger.getLogger(Pessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Pessoa search(String id) throws Exception {
        String find = dmPessoa.getById(id);
        Pessoa p = null;
        System.out.println(find + id);
        if (find != null) {
            p = dmPessoa.instantiate(find);
        }
        return p;
    }

    public void showResults(Pessoa p) {
        model.setRowCount(0);
        model.addRow(p.getValues());
    }
}
