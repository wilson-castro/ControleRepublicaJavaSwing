
package src.views.infoReserva;

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

public class InfoReserva extends javax.swing.JPanel {
    private DefaultTableModel model = null;
    
    DataManager<Pessoa> dmPessoa = null;
    DataManager<Reserva> dmReservas = null;

    
    public InfoReserva() {
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
                
                dmReservas = new DataManager<>(Reserva.class.getName(), Constantes.DIRETORIO_FILE, true,  "reservas_"+mesDaReserva+"_"+anoDaReserva+"");
                
                jTextField_valorReserva.setText(
                    dmReservas
                        .getDataManagerList().stream()
                        .map( Reserva::getValorContribuicao)
                        .reduce(valorDaReserva, Float::sum).toString()
                );
                
                refreshTable();
                
            } catch (Exception ex) {
                Logger.getLogger(InfoReserva.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 0));

        jPanel_inputs.setBackground(new java.awt.Color(51, 51, 51));

        jLabel_mesReseva.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_mesReseva.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_mesReseva.setText("Mês do valor da reseva:");

        jTextField_ano.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N

        jLabel_anoReserva.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_anoReserva.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_anoReserva.setText("Ano:");

        jComboBox_mesReserva.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jComboBox_mesReserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        jTextField_valorReserva.setEditable(false);
        jTextField_valorReserva.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N

        jLabel_valorReseva.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_valorReseva.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_valorReseva.setText("Valor:");

        jButton_pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images/icons8-pesquisar-15.png"))); // NOI18N
        jButton_pesquisar.setToolTipText("Buscar por nome");
        jButton_pesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_pesquisarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel_inputsLayout = new javax.swing.GroupLayout(jPanel_inputs);
        jPanel_inputs.setLayout(jPanel_inputsLayout);
        jPanel_inputsLayout.setHorizontalGroup(
            jPanel_inputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_inputsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel_inputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_mesReseva, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_inputsLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jComboBox_mesReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jLabel_anoReserva)
                .addGap(9, 9, 9)
                .addComponent(jTextField_ano, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel_valorReseva, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTextField_valorReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel_inputsLayout.setVerticalGroup(
            jPanel_inputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_inputsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_inputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_valorReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_valorReseva, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_ano, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_mesReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_mesReseva, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_anoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
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
        jScrollPane1.setViewportView(jTable_alunos);

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Aluno que estão Inadimplentes com o Cadastro de Reservas do mês (padrão mês corrente)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_inputs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_inputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_pesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_pesquisarMouseClicked
        handlePesquiarValorReserva();
    }//GEN-LAST:event_jButton_pesquisarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_pesquisar;
    private javax.swing.JComboBox<String> jComboBox_mesReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_anoReserva;
    private javax.swing.JLabel jLabel_mesReseva;
    private javax.swing.JLabel jLabel_valorReseva;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_inputs;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_alunos;
    private javax.swing.JTextField jTextField_ano;
    private javax.swing.JTextField jTextField_valorReserva;
    // End of variables declaration//GEN-END:variables
}
