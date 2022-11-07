
package src.views.despesas;

import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import src.services.DataManager;
import src.models.Despesa;
import src.utils.Constantes;
import src.utils.DateLabelFormatter;

public class Despesas extends javax.swing.JPanel {    
    private JDatePickerImpl datePicker = null;
    
    private DefaultTableModel model = null;
    DataManager<Despesa> dmDespesa = null;

    public final void initDataManager() {
        try {
            dmDespesa = new DataManager<>(Despesa.class.getName(), Constantes.DIRETORIO_FILE, true, "despesas");
        } catch (Exception e) {
            System.out.println("Erro ao iniciar o data manager!" + e.getMessage());
        }

    }
    
    private void initJDatePicker(){
        if(this.datePicker == null) {
            UtilDateModel udModel = new UtilDateModel();
            Properties p = new Properties();
            p.put("text.today", "Hoje");
            p.put("text.month", "Mês");
            p.put("text.year", "Ano");
            
            JDatePanelImpl datePanel = new JDatePanelImpl(udModel, p);
            this.datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
            datePicker.setBounds(this.jPanel_inputDatePicker.getBounds());
            
            this.jPanel_inputDatePicker.add(this.datePicker);
            this.jPanel_inputDatePicker.revalidate();
            this.jPanel_inputDatePicker.repaint();
        }
    }

    public Despesas() {
        initComponents();
        initDataManager();
        initJDatePicker();
        this.model = (DefaultTableModel) jTable_despesas.getModel();
        refreshTable();
    }
    
       
    private void refreshTable() {
        model.setRowCount(0);
        try {
            dmDespesa = new DataManager<>(Despesa.class.getName(), Constantes.DIRETORIO_FILE, true, "despesas");
            dmDespesa.getDataManagerList().forEach(despesa -> {
                model.addRow(despesa.getValues());
            });
        } catch (Exception ex) {
            Logger.getLogger(Despesas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Despesa search(String id) throws Exception {
        String find = dmDespesa.getById(id);
        Despesa p = null;
        System.out.println(find + id);
        if (find != null) {
            p = dmDespesa.instantiate(find);
        }
        return p;
    }

    public void showResults(Despesa p) {
        model.setRowCount(0);
        model.addRow(p.getValues());
    }
    
    private void setEstadoPadraoBotoes() {
        this.jButton_salvar.setEnabled(false);
        this.jButton_Excluir.setEnabled(false);

        this.jButton_novo.setEnabled(true);
        this.jButton_atualizar.setEnabled(true);
    }
    
    private void limparInputs(){        
        this.jTextField_nome.setText(null);
        this.jComboBox_categoria.setSelectedIndex(0);
        this.jTextField_descricao.setText(null);
        this.jTextField_valor.setText(null);

        handleChangeTipoDespesa();
        initJDatePicker();
    }
    
    private void hideGroupDataDespesa() {
        jPanel_inputDatePicker.setVisible(false);
        jLabel_dataDespesa.setVisible(false);
    }
    
    private void showGroupDataDespesa() {
        jPanel_inputDatePicker.setVisible(true);
        jLabel_dataDespesa.setVisible(true);
    }
    
    private void hideCampoPrioridade() {
        jComboBox_prioridade.setSelectedIndex(0);
        jComboBox_prioridade.setEnabled(false);
    }
    
    private void showCampoPrioridade() {
        jComboBox_prioridade.setSelectedIndex(0);
        jComboBox_prioridade.setEnabled(true);
    }
    
    private void handleChangeTipoDespesa() {
        if(jComboBox_categoria.getSelectedIndex() == 0) {   
            hideCampoPrioridade();
            showGroupDataDespesa();
        } else {
            showCampoPrioridade();
            hideGroupDataDespesa();
        }
    }
    
    private void handleChangeNovo() {
        setEstadoPadraoBotoes();
        int option = JOptionPane.showConfirmDialog(this, "Deseja limpar os campos?");
        if (option == 0)   limparInputs();
        this.jButton_salvar.setEnabled(true);
    }
    
    private void handleChangeSalvar() throws Exception {
        
        String nome = jTextField_nome.getText();
        String descricao = jTextField_descricao.getText();
        String categoria = jComboBox_categoria.getSelectedItem().toString();
        boolean isDespesaFixa  = categoria.equals("Fixa");
        String prioridade = isDespesaFixa ? Constantes.DEFAULT_VALUE_PRIORIDADE : jComboBox_prioridade.getSelectedItem().toString();
        float valor = 0;
        
        boolean grupoCategoriaValido = isDespesaFixa ?
            (datePicker.getModel().isSelected())
            : Arrays.asList("1", "2", "3", "4", "5").contains(prioridade);
        
        boolean valorValido = false;
        
        try {
            valor = Float.parseFloat( jTextField_valor.getText() );
            valorValido = true;
        }catch (NumberFormatException nfe) {
            System.out.println("Valor inválido! "+nfe.getMessage());
        }
        
        if( (nome != null && !nome.isBlank())
            && (descricao != null && !descricao.isBlank())
            && (categoria.equals("Fixa") || categoria.equals("Variada") )
            && grupoCategoriaValido
            && valorValido
        ) {
            String inputLine = nome+";"+descricao+";"+categoria+";"+prioridade+";"+valor;
            Despesa novaDespesa;

            if(isDespesaFixa) {
                String mes = datePicker.getModel().getMonth()+"";
                String ano = datePicker.getModel().getYear()+"";
                novaDespesa = dmDespesa.createSeparated(inputLine, "despesas", mes, ano);
            } else 
                novaDespesa = dmDespesa.createSeparated(inputLine, "despesas");

            if (novaDespesa != null)  refreshTable();

            setEstadoPadraoBotoes();
            limparInputs();
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_despesas = new javax.swing.JTable();
        jPanel_inputs = new javax.swing.JPanel();
        jTextField_nome = new javax.swing.JTextField();
        jLabel_nome = new javax.swing.JLabel();
        jLabel_email = new javax.swing.JLabel();
        jLabel_totalRendimentos = new javax.swing.JLabel();
        jLabel_codAluno = new javax.swing.JLabel();
        jTextField_descricao = new javax.swing.JTextField();
        jTextField_valor = new javax.swing.JTextField();
        jLabel_totalRendimentos1 = new javax.swing.JLabel();
        jComboBox_categoria = new javax.swing.JComboBox<>();
        jComboBox_prioridade = new javax.swing.JComboBox<>();
        jPanel_inputDatePicker = new javax.swing.JPanel();
        jLabel_dataDespesa = new javax.swing.JLabel();
        jPanel_acoes = new javax.swing.JPanel();
        jButton_novo = new javax.swing.JButton();
        jButton_Excluir = new javax.swing.JButton();
        jButton_atualizar = new javax.swing.JButton();
        jTextField_pesquisar = new javax.swing.JTextField();
        jButton_pesquisar = new javax.swing.JButton();
        jButton_salvar = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));
        setMaximumSize(new java.awt.Dimension(670, 440));
        setMinimumSize(new java.awt.Dimension(670, 440));
        setPreferredSize(new java.awt.Dimension(670, 440));

        jTable_despesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Descrição", "Categoria", "Prioridade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_despesas.getTableHeader().setReorderingAllowed(false);
        jTable_despesas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable_despesasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTable_despesasFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_despesas);

        jPanel_inputs.setBackground(new java.awt.Color(51, 51, 51));
        jPanel_inputs.setMinimumSize(new java.awt.Dimension(670, 80));
        jPanel_inputs.setPreferredSize(new java.awt.Dimension(670, 80));
        jPanel_inputs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel_inputs.add(jTextField_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 10, 200, 30));

        jLabel_nome.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_nome.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nome.setText("Nome:");
        jPanel_inputs.add(jLabel_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 30));

        jLabel_email.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_email.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_email.setText("Descrição:");
        jPanel_inputs.add(jLabel_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 80, 30));

        jLabel_totalRendimentos.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_totalRendimentos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_totalRendimentos.setText("Prioridade:");
        jPanel_inputs.add(jLabel_totalRendimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 90, 30));

        jLabel_codAluno.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_codAluno.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_codAluno.setText("Categoria:");
        jPanel_inputs.add(jLabel_codAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 30));
        jPanel_inputs.add(jTextField_descricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 170, 30));
        jPanel_inputs.add(jTextField_valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 70, 30));

        jLabel_totalRendimentos1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_totalRendimentos1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_totalRendimentos1.setText("Valor:");
        jPanel_inputs.add(jLabel_totalRendimentos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 50, 30));

        jComboBox_categoria.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jComboBox_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fixa", "Variada" }));
        jComboBox_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_categoriaActionPerformed(evt);
            }
        });
        jPanel_inputs.add(jComboBox_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 90, 30));

        jComboBox_prioridade.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jComboBox_prioridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jComboBox_prioridade.setEnabled(false);
        jPanel_inputs.add(jComboBox_prioridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 90, 30));

        jPanel_inputDatePicker.setLayout(new javax.swing.BoxLayout(jPanel_inputDatePicker, javax.swing.BoxLayout.LINE_AXIS));
        jPanel_inputs.add(jPanel_inputDatePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 53, 150, 25));

        jLabel_dataDespesa.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_dataDespesa.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_dataDespesa.setText("Data:");
        jPanel_inputs.add(jLabel_dataDespesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 50, 30));

        jButton_novo.setText("Novo");
        jButton_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_novoActionPerformed(evt);
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
                .addComponent(jButton_Excluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_atualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel_acoesLayout.setVerticalGroup(
            jPanel_acoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_acoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_acoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_novo)
                    .addComponent(jButton_Excluir)
                    .addComponent(jButton_atualizar)
                    .addComponent(jTextField_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_salvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_inputs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel_acoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_inputs, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_acoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_novoActionPerformed
        handleChangeNovo();
    }//GEN-LAST:event_jButton_novoActionPerformed

    private void jButton_ExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ExcluirMouseClicked

        int option = JOptionPane.showConfirmDialog(this, "Confirma a exclusão?");
        if (option == 0) {
            for (int selectedRow : jTable_despesas.getSelectedRows()) {
                try {
                    String a = (String) jTable_despesas.getValueAt(selectedRow, 0).toString();
                    String file = dmDespesa.getFilePath() + "despesas_" + a.substring(0, 2) + "_" + a.substring(2, 6) + ".txt";
                    dmDespesa.deleteFromFile(a, file);
                } catch (Exception ex) {
                    Logger.getLogger(Despesas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            refreshTable();
            JOptionPane.showMessageDialog(this, "Deletado com sucesso!");
        }
    }//GEN-LAST:event_jButton_ExcluirMouseClicked

    private void jButton_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_atualizarActionPerformed
        refreshTable();
    }//GEN-LAST:event_jButton_atualizarActionPerformed

    private void jButton_pesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_pesquisarMouseClicked
        String id = this.jTextField_pesquisar.getText().trim();
        try {
            Despesa p = search(id);
            if (p == null) {
                JOptionPane.showMessageDialog(this, "Não foi encontrado ninguem com o id informado!");

            } else {
                showResults(p);
            }

        } catch (Exception ex) {
            Logger.getLogger(Despesas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_pesquisarMouseClicked

    private void jButton_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_salvarActionPerformed
        try {
            handleChangeSalvar();
        } catch (Exception ex) {
            Logger.getLogger(Despesas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_salvarActionPerformed

    private void jTable_despesasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable_despesasFocusGained
            this.jButton_Excluir.setEnabled(true);
    }//GEN-LAST:event_jTable_despesasFocusGained

    private void jTable_despesasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable_despesasFocusLost
        this.jButton_Excluir.setEnabled(false);
    }//GEN-LAST:event_jTable_despesasFocusLost

    private void jComboBox_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_categoriaActionPerformed
       this.handleChangeTipoDespesa();
    }//GEN-LAST:event_jComboBox_categoriaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Excluir;
    private javax.swing.JButton jButton_atualizar;
    private javax.swing.JButton jButton_novo;
    private javax.swing.JButton jButton_pesquisar;
    private javax.swing.JButton jButton_salvar;
    private javax.swing.JComboBox<String> jComboBox_categoria;
    private javax.swing.JComboBox<String> jComboBox_prioridade;
    private javax.swing.JLabel jLabel_codAluno;
    private javax.swing.JLabel jLabel_dataDespesa;
    private javax.swing.JLabel jLabel_email;
    private javax.swing.JLabel jLabel_nome;
    private javax.swing.JLabel jLabel_totalRendimentos;
    private javax.swing.JLabel jLabel_totalRendimentos1;
    private javax.swing.JPanel jPanel_acoes;
    private javax.swing.JPanel jPanel_inputDatePicker;
    private javax.swing.JPanel jPanel_inputs;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_despesas;
    private javax.swing.JTextField jTextField_descricao;
    private javax.swing.JTextField jTextField_nome;
    private javax.swing.JTextField jTextField_pesquisar;
    private javax.swing.JTextField jTextField_valor;
    // End of variables declaration//GEN-END:variables
}
