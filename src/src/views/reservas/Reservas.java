
package src.views.reservas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import src.models.Pessoa;
import src.models.Reserva;
import src.services.DataManager;
import src.utils.Constantes;

public class Reservas extends javax.swing.JPanel {    
    
    private DefaultTableModel model = null;
    DataManager<Reserva> dmReservas = null;
    DataManager<Pessoa> dmPessoa = null;
    
    
    private String getFilterDataManager() {
        LocalDate today = LocalDate.now();
        String monthP = today.getMonthValue() + "";
        String yearP = today.getYear() + "";
            
            return "reservas_"+monthP+"_"+yearP;
    }
    

    public final void initDataManager() {
        try {
            dmReservas = new DataManager<>(Reserva.class.getName(), Constantes.DIRETORIO_FILE, true,  getFilterDataManager());
            dmPessoa = new DataManager<>(Pessoa.class.getName(), Constantes.DIRETORIO_FILE + Constantes.NOME_BASE_FILE_USUARIOS);
        } catch (Exception e) {
            System.out.println("Erro ao iniciar o data manager!" + e.getMessage());
        }

    }
    
    public Reservas() {
        initComponents();
        initDataManager();
        this.model = (DefaultTableModel) jTable_reservas.getModel();
        refreshJComboBoxPessoas();
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
        refreshJComboBoxPessoas();
        if(jComboBox_pessoas.getItemCount() > 0 && jComboBox_pessoas.getItemAt(0) != null) this.jComboBox_pessoas.setSelectedIndex(0);
        this.jTextField_rendimento.setText(null);

    }
    
    private void refreshJComboBoxPessoas(){
        jComboBox_pessoas.removeAllItems();
        List<String> codigoAlunosPresentesReservaMensal = new ArrayList<>();
        
        dmReservas.getDataManagerList().forEach( reserva -> {
            codigoAlunosPresentesReservaMensal.add(reserva.getCodigoAluno());
        });
        
        dmPessoa.getDataManagerList().forEach(pessoa -> {    
            if(!codigoAlunosPresentesReservaMensal.contains(pessoa.getCodigo())) {
                String line = pessoa.getCodigo();
                line += Constantes.SEPARADOR_LINHAS_COMUM + pessoa.getNome();
                line +=Constantes.SEPARADOR_LINHAS_COMUM + pessoa.getTotalRendimentos();
            
              jComboBox_pessoas.addItem(line);
            }
        });
    }
    
    private void refreshTable(){
        model.setRowCount(0);
        try {
        
            dmReservas = new DataManager<>(Reserva.class.getName(), Constantes.DIRETORIO_FILE, true,  getFilterDataManager());
            dmReservas.getDataManagerList().forEach(reserva -> {
                model.addRow(reserva.getValues());
            });
        } catch (Exception ex) {
            Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Reserva search(String id) throws Exception {
        String find = dmReservas.getById(id);
        Reserva p = null;
        if (find != null) {
            p = dmReservas.instantiate(find);
        }
        return p;
    }

    private void showResults(Reserva p) {
        model.setRowCount(0);
        model.addRow(p.getValues());
    }
    
    private void handleChangeNovo() {
        setEstadoPadraoBotoes();
        this.jButton_salvar.setEnabled(true);
    }
    
    private void handleChangeSalvar() throws Exception {

        String linhaAlunoSelecionado = jComboBox_pessoas.getSelectedItem().toString();
        String[] camposAluno = linhaAlunoSelecionado.split(Constantes.SEPARADOR_LINHAS_COMUM);
        
        String codigoAluno = camposAluno[0];
        String nomeAluno = camposAluno[1];
        float valor = Float.parseFloat( jTextField_rendimento.getText() );
        String inputLine = codigoAluno+";"+nomeAluno+";"+valor;
        
        Reserva novaReserva;
        
        novaReserva = dmReservas.createSeparated(inputLine, "reservas");

        if (novaReserva != null) refreshTable();
        
        setEstadoPadraoBotoes();
        limparInputs();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_inputs = new javax.swing.JPanel();
        jComboBox_pessoas = new javax.swing.JComboBox<>();
        jTextField_rendimento = new javax.swing.JTextField();
        jLabel_pessoas = new javax.swing.JLabel();
        jLabel_rendimetno = new javax.swing.JLabel();
        jPanel_acoes = new javax.swing.JPanel();
        jButton_novo = new javax.swing.JButton();
        jButton_editar = new javax.swing.JButton();
        jButton_Excluir = new javax.swing.JButton();
        jButton_atualizar = new javax.swing.JButton();
        jTextField_pesquisar = new javax.swing.JTextField();
        jButton_pesquisar = new javax.swing.JButton();
        jButton_salvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_reservas = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 0, 204));

        jPanel_inputs.setBackground(new java.awt.Color(51, 51, 51));
        jPanel_inputs.setMinimumSize(new java.awt.Dimension(670, 80));
        jPanel_inputs.setPreferredSize(new java.awt.Dimension(670, 80));
        jPanel_inputs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox_pessoas.setBackground(new java.awt.Color(60, 63, 65));
        jComboBox_pessoas.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox_pessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_pessoasActionPerformed(evt);
            }
        });
        jPanel_inputs.add(jComboBox_pessoas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 200, 30));

        jTextField_rendimento.setEditable(false);
        jTextField_rendimento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel_inputs.add(jTextField_rendimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 60, 30));

        jLabel_pessoas.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_pessoas.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_pessoas.setText("Pessoa:");
        jPanel_inputs.add(jLabel_pessoas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        jLabel_rendimetno.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_rendimetno.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_rendimetno.setText("Redimento (5% da contribuição do aluno):");
        jPanel_inputs.add(jLabel_rendimetno, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, 30));

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
                .addContainerGap(63, Short.MAX_VALUE))
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

        jTable_reservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Código Aluno", "Nome Aluno", "Valor Contribuição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_reservas.getTableHeader().setReorderingAllowed(false);
        jTable_reservas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable_reservasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTable_reservasFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_reservas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel_inputs, javax.swing.GroupLayout.PREFERRED_SIZE, 660, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_acoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_inputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_acoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_novoActionPerformed
        handleChangeNovo();
    }//GEN-LAST:event_jButton_novoActionPerformed

    private void jButton_ExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ExcluirMouseClicked
        int option = JOptionPane.showConfirmDialog(this, "Confirma a exclusão?");
        if (option == 0) {
            for (int selectedRow : jTable_reservas.getSelectedRows()) {
                try {
                    String a = (String) jTable_reservas.getValueAt(selectedRow, 0).toString();
                    String file = dmReservas.getFilePath() + getFilterDataManager() + ".txt";
                    dmReservas.deleteFromFile(a, file);
                } catch (Exception ex) {
                    Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            refreshTable();
            refreshJComboBoxPessoas();
            JOptionPane.showMessageDialog(this, "Deletado com sucesso!");
        }
    }//GEN-LAST:event_jButton_ExcluirMouseClicked

    private void jButton_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_atualizarActionPerformed
        refreshTable();
    }//GEN-LAST:event_jButton_atualizarActionPerformed

    private void jButton_pesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_pesquisarMouseClicked
        String id = this.jTextField_pesquisar.getText().trim();
        try {
            Reserva p = search(id);
            if (p == null) {
                JOptionPane.showMessageDialog(this, "Não foi encontrado ninguem com o id informado!");

            } else {
                showResults(p);
            }

        } catch (Exception ex) {
            Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_pesquisarMouseClicked

    private void jButton_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_salvarActionPerformed
        try {
            handleChangeSalvar();
        } catch (Exception ex) {
            Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_salvarActionPerformed

    private void jTable_reservasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable_reservasFocusGained
        this.jButton_Excluir.setEnabled(true);
        this.jButton_editar.setEnabled(true);
    }//GEN-LAST:event_jTable_reservasFocusGained

    private void jTable_reservasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable_reservasFocusLost
        this.jButton_Excluir.setEnabled(false);
        this.jButton_editar.setEnabled(false);
    }//GEN-LAST:event_jTable_reservasFocusLost

    private void jComboBox_pessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_pessoasActionPerformed
       if(jComboBox_pessoas.getItemCount() > 0 && jComboBox_pessoas.getItemAt(0) != null) {
            String[] campos = jComboBox_pessoas.getSelectedItem().toString().split(Constantes.SEPARADOR_LINHAS_COMUM);
           float valorContribuicaoPeloRendimento = Float.parseFloat(campos[2]) * 0.05f;
           jTextField_rendimento.setText(valorContribuicaoPeloRendimento+"");
       }
    }//GEN-LAST:event_jComboBox_pessoasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Excluir;
    private javax.swing.JButton jButton_atualizar;
    private javax.swing.JButton jButton_editar;
    private javax.swing.JButton jButton_novo;
    private javax.swing.JButton jButton_pesquisar;
    private javax.swing.JButton jButton_salvar;
    private javax.swing.JComboBox<String> jComboBox_pessoas;
    private javax.swing.JLabel jLabel_pessoas;
    private javax.swing.JLabel jLabel_rendimetno;
    private javax.swing.JPanel jPanel_acoes;
    private javax.swing.JPanel jPanel_inputs;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_reservas;
    private javax.swing.JTextField jTextField_pesquisar;
    private javax.swing.JTextField jTextField_rendimento;
    // End of variables declaration//GEN-END:variables
}
