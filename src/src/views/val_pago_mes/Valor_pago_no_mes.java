
package src.views.val_pago_mes;

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
import src.views.pessoas.Pessoas;

public class Valor_pago_no_mes extends javax.swing.JPanel {
    private DefaultTableModel model = null;
    
    DataManager<Pessoa> dmPessoa = null;
    DataManager<Reserva> dmReservas = null;

    
    public Valor_pago_no_mes() {
        initComponents();
        initDataManager();
        this.model = (DefaultTableModel) jTable_alunos.getModel();
        refreshTable();
    }
    
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
    
    private void refreshTable() {
        model.setRowCount(0);
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
        }

        try {

            List<String> codigoAlunosPresentesReservaMensal = new ArrayList<>();


            dmReservas.getDataManagerList().forEach( reserva -> {
                codigoAlunosPresentesReservaMensal.add(reserva.getCodigoAluno());
            });

            dmPessoa.getDataManagerList().forEach(pessoa -> {    
                if(!codigoAlunosPresentesReservaMensal.contains(pessoa.getCodigo())) {
                   model.addRow(pessoa.getValues());
                }
            });


        } catch (Exception ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void handlePesquiarValorReserva() {
       String mesDaReserva = jComboBox_mesReserva.getSelectedIndex()+1+"";
       int anoDaReserva = 0;
       
        boolean valorValido = false;
        
        try {
            anoDaReserva = Integer.parseInt( jTextField_ano.getText() );
            valorValido = true;
        }catch (NumberFormatException nfe) {
            System.out.println("Valor inválido! "+nfe.getMessage());
        }
       
       if(!mesDaReserva.isBlank() && valorValido) {
           
           float valorDaReserva = 0;
           
            try {
                
                jTextField_valorReserva.setText(
                    new DataManager<Reserva>(Reserva.class.getName(), Constantes.DIRETORIO_FILE, true,  "reservas_"+mesDaReserva+"_"+anoDaReserva+"")
                        .getDataManagerList().stream()
                        .map( Reserva::getValorContribuicao)
                        .reduce(valorDaReserva, Float::sum).toString()
                );
                
            } catch (Exception ex) {
                Logger.getLogger(Valor_pago_no_mes.class.getName()).log(Level.SEVERE, null, ex);
            }
       } else {
            JOptionPane.showMessageDialog(null, "Para Pesquisar, preencha o ano corretamente!");
       }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_inputs = new javax.swing.JPanel();
        jLabel_mesReseva = new javax.swing.JLabel();
        jTextField_ano = new javax.swing.JTextField();
        jLabel_anoReserva = new javax.swing.JLabel();
        jComboBox_mesReserva = new javax.swing.JComboBox<>();
        jTextField_valorReserva = new javax.swing.JTextField();
        jLabel_valorReseva = new javax.swing.JLabel();
        jButton_pesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_alunos = new javax.swing.JTable();
        jPanel_alunosInadi = new javax.swing.JPanel();
        jLabel_headerTableAlunos = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 0));

        jPanel_inputs.setBackground(new java.awt.Color(51, 51, 51));
        jPanel_inputs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_mesReseva.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_mesReseva.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_mesReseva.setText("Mês do valor da reseva:");
        jPanel_inputs.add(jLabel_mesReseva, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 30));

        jTextField_ano.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jPanel_inputs.add(jTextField_ano, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 37, 33));

        jLabel_anoReserva.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_anoReserva.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_anoReserva.setText("Ano:");
        jPanel_inputs.add(jLabel_anoReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, 33));

        jComboBox_mesReserva.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jComboBox_mesReserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        jComboBox_mesReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_mesReservaActionPerformed(evt);
            }
        });
        jPanel_inputs.add(jComboBox_mesReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, 33));

        jTextField_valorReserva.setEditable(false);
        jTextField_valorReserva.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jPanel_inputs.add(jTextField_valorReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 70, 30));

        jLabel_valorReseva.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_valorReseva.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_valorReseva.setText("Valor:");
        jPanel_inputs.add(jLabel_valorReseva, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 50, 30));

        jButton_pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images/icons8-pesquisar-15.png"))); // NOI18N
        jButton_pesquisar.setToolTipText("Buscar por nome");
        jButton_pesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_pesquisarMouseClicked(evt);
            }
        });
        jButton_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_pesquisarActionPerformed(evt);
            }
        });
        jPanel_inputs.add(jButton_pesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 8, 40, 33));

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
        jScrollPane1.setViewportView(jTable_alunos);

        jLabel_headerTableAlunos.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel_headerTableAlunos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_headerTableAlunos.setText("Alunos que estão Inadimplentes com o Cadastro de Reservas");

        javax.swing.GroupLayout jPanel_alunosInadiLayout = new javax.swing.GroupLayout(jPanel_alunosInadi);
        jPanel_alunosInadi.setLayout(jPanel_alunosInadiLayout);
        jPanel_alunosInadiLayout.setHorizontalGroup(
            jPanel_alunosInadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_alunosInadiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_headerTableAlunos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_alunosInadiLayout.setVerticalGroup(
            jPanel_alunosInadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_headerTableAlunos, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_inputs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                    .addComponent(jPanel_alunosInadi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_inputs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_alunosInadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_mesReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_mesReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_mesReservaActionPerformed

    private void jButton_pesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_pesquisarMouseClicked
        handlePesquiarValorReserva();
    }//GEN-LAST:event_jButton_pesquisarMouseClicked

    private void jButton_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_pesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_pesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_pesquisar;
    private javax.swing.JComboBox<String> jComboBox_mesReserva;
    private javax.swing.JLabel jLabel_anoReserva;
    private javax.swing.JLabel jLabel_headerTableAlunos;
    private javax.swing.JLabel jLabel_mesReseva;
    private javax.swing.JLabel jLabel_valorReseva;
    private javax.swing.JPanel jPanel_alunosInadi;
    private javax.swing.JPanel jPanel_inputs;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_alunos;
    private javax.swing.JTextField jTextField_ano;
    private javax.swing.JTextField jTextField_valorReserva;
    // End of variables declaration//GEN-END:variables
}
