
package src.views.pessoas;

import src.models.Pessoa;


public class Pessoas extends javax.swing.JPanel {

    public Pessoas() {
        initComponents();
    }
    
    private void setEstadoPadraoBotoes(){
        this.jButton_salvar.setEnabled(false);
        this.jButton_editar.setEnabled(false);
        this.jButton_Excluir.setEnabled(false);
        
        this.jButton_novo.setEnabled(true);
        this.jButton_cancelar.setEnabled(true);
    }
    
    private void limparInputs() {
        this.jTextField_codAluno.setText(null);
        this.jTextField_email.setText(null);
        this.jTextField_nome.setText(null);
        this.jTextField_pesquisar.setText(null);
        this.jFormattedTextField_totalRendimentos.setText(null);
    }
    
    private void handleChangeNovo(){
        setEstadoPadraoBotoes();
        limparInputs();
        
        this.jButton_salvar.setEnabled(true);
    }
    
    private void handleChangeSalvar(){
        String totalRendimentos = this.jFormattedTextField_totalRendimentos.getText();
        String nome = this.jTextField_nome.getText();
        String email = this.jTextField_email.getText();
                
        boolean valorDoNomeValido = nome != null && !nome.isBlank(); 
        boolean valorDoEmailValido = email != null && !email.isBlank();
        boolean valorTotalRendimentosValido = totalRendimentos != null && !totalRendimentos.isBlank();
        
        System.out.println(valorDoNomeValido);
        System.out.println(valorDoEmailValido);
        System.out.println(valorTotalRendimentosValido);
        
        valorTotalRendimentosValido = valorTotalRendimentosValido && totalRendimentos.matches("[-+]?[0-9]*\\.?[0-9]+");
        
        System.out.println(totalRendimentos.matches("[-+]?[0-9]*\\.?[0-9]+"));
        
        if(valorDoEmailValido && valorDoNomeValido && valorTotalRendimentosValido){
           float valorTotalRendimentos = Float.parseFloat(totalRendimentos);
           
           Pessoa novaPessoa = Pessoa.create(nome, email, valorTotalRendimentos);
           
           if(novaPessoa != null){
            System.out.println(novaPessoa.toString());               
           }
           
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_inputs = new javax.swing.JPanel();
        jTextField_nome = new javax.swing.JTextField();
        jLabel_nome = new javax.swing.JLabel();
        jLabel_email = new javax.swing.JLabel();
        jTextField_email = new javax.swing.JTextField();
        jFormattedTextField_totalRendimentos = new javax.swing.JFormattedTextField();
        jLabel_totalRendimentos = new javax.swing.JLabel();
        jLabel_codAluno = new javax.swing.JLabel();
        jTextField_codAluno = new javax.swing.JTextField();
        jPanel_acoes = new javax.swing.JPanel();
        jButton_novo = new javax.swing.JButton();
        jButton_editar = new javax.swing.JButton();
        jButton_Excluir = new javax.swing.JButton();
        jButton_cancelar = new javax.swing.JButton();
        jTextField_pesquisar = new javax.swing.JTextField();
        jButton_pesquisar = new javax.swing.JButton();
        jButton_salvar = new javax.swing.JButton();
        jPanel_tabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_alunos = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));

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
        jPanel_inputs.add(jTextField_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 220, 30));

        jFormattedTextField_totalRendimentos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        jPanel_inputs.add(jFormattedTextField_totalRendimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 160, 30));

        jLabel_totalRendimentos.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_totalRendimentos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_totalRendimentos.setText("Total de Rendimentos: ");
        jPanel_inputs.add(jLabel_totalRendimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 50, 170, 30));

        jLabel_codAluno.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_codAluno.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_codAluno.setText("Código do Aluno: ");
        jPanel_inputs.add(jLabel_codAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, 30));

        jTextField_codAluno.setEditable(false);
        jTextField_codAluno.setBackground(new java.awt.Color(70, 73, 75));
        jPanel_inputs.add(jTextField_codAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 130, 30));

        jButton_novo.setText("Novo");
        jButton_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_novoActionPerformed(evt);
            }
        });

        jButton_editar.setText("Editar");
        jButton_editar.setEnabled(false);

        jButton_Excluir.setText("Excluir");
        jButton_Excluir.setEnabled(false);

        jButton_cancelar.setText("Cancelar");
        jButton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelarActionPerformed(evt);
            }
        });

        jTextField_pesquisar.setToolTipText("Digite o nome");

        jButton_pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images/icons8-pesquisar-15.png"))); // NOI18N
        jButton_pesquisar.setToolTipText("Buscar por nome");

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
                .addComponent(jButton_cancelar)
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
                    .addComponent(jButton_cancelar)
                    .addComponent(jTextField_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_salvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        jTable_alunos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable_alunos);
        if (jTable_alunos.getColumnModel().getColumnCount() > 0) {
            jTable_alunos.getColumnModel().getColumn(0).setResizable(false);
            jTable_alunos.getColumnModel().getColumn(0).setPreferredWidth(15);
            jTable_alunos.getColumnModel().getColumn(1).setResizable(false);
            jTable_alunos.getColumnModel().getColumn(2).setResizable(false);
            jTable_alunos.getColumnModel().getColumn(3).setResizable(false);
            jTable_alunos.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        javax.swing.GroupLayout jPanel_tabelaLayout = new javax.swing.GroupLayout(jPanel_tabela);
        jPanel_tabela.setLayout(jPanel_tabelaLayout);
        jPanel_tabelaLayout.setHorizontalGroup(
            jPanel_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_tabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel_tabelaLayout.setVerticalGroup(
            jPanel_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_tabelaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_inputs, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
            .addComponent(jPanel_acoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_tabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_inputs, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel_acoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel_tabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_novoActionPerformed
        handleChangeNovo();
    }//GEN-LAST:event_jButton_novoActionPerformed

    private void jButton_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_salvarActionPerformed
        handleChangeSalvar();
    }//GEN-LAST:event_jButton_salvarActionPerformed

    private void jButton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarActionPerformed
       setEstadoPadraoBotoes();
       limparInputs();
    }//GEN-LAST:event_jButton_cancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Excluir;
    private javax.swing.JButton jButton_cancelar;
    private javax.swing.JButton jButton_editar;
    private javax.swing.JButton jButton_novo;
    private javax.swing.JButton jButton_pesquisar;
    private javax.swing.JButton jButton_salvar;
    private javax.swing.JFormattedTextField jFormattedTextField_totalRendimentos;
    private javax.swing.JLabel jLabel_codAluno;
    private javax.swing.JLabel jLabel_email;
    private javax.swing.JLabel jLabel_nome;
    private javax.swing.JLabel jLabel_totalRendimentos;
    private javax.swing.JPanel jPanel_acoes;
    private javax.swing.JPanel jPanel_inputs;
    private javax.swing.JPanel jPanel_tabela;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_alunos;
    private javax.swing.JTextField jTextField_codAluno;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_nome;
    private javax.swing.JTextField jTextField_pesquisar;
    // End of variables declaration//GEN-END:variables
}
