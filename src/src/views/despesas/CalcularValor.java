/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.views.despesas;

import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import src.models.Despesa;
import src.models.Pessoa;
import src.services.DataManager;
import src.utils.Constantes;

/**
 *
 * @author Ricardo Alves
 */
public final class CalcularValor extends javax.swing.JPanel {

    DataManager<Despesa> dmDespesa = null;
    DataManager<Pessoa> dmPessoa = null;
    private DefaultTableModel model = null;

    public final void initDataManager() {
        try {
            dmDespesa = new DataManager<>(Despesa.class.getName(), Constantes.DIRETORIO_FILE, true, "despesas");
            dmPessoa = new DataManager<>(Pessoa.class.getName(), Constantes.DIRETORIO_FILE + Constantes.NOME_BASE_FILE_USUARIOS);
        } catch (Exception e) {
            System.out.println("Erro ao iniciar o data manager!" + e.getMessage());
        }

    }

    public final void initAno() {
        dmDespesa.getDataManagerList().forEach(item -> {
            String newItem = item.getCodigo().substring(2, 6);
            int itemCount = jComboBox_ano.getItemCount();
            boolean canAdd = true;
            for (int i = 0; i < itemCount; i++) { // Valida se a opção já existe 
                String itemCombo = jComboBox_ano.getItemAt(i);
                if (newItem.equalsIgnoreCase(itemCombo)) {
                    canAdd = false;
                }
            }
            if (canAdd) {
                this.jComboBox_ano.addItem(newItem);
            }
        });
    }

    public Object[] orderColums(Object[] values) {
        Object[] retArray = new Object[7];
        String codigo = values[0].toString();
        String mes = codigo.substring(0, 2);
        String ano = codigo.substring(2, 6);
        retArray[0] = values[0];
        retArray[1] = values[1];
        retArray[2] = values[2];
        retArray[3] = values[3];
        retArray[4] = values[4];
        retArray[5] = mes + "/" + ano;
        retArray[6] = values[5];
        return retArray;
    }

    private void refreshTable() {
        model.setRowCount(0);

        try {
            dmDespesa = new DataManager<>(Despesa.class.getName(), Constantes.DIRETORIO_FILE, true, "despesas");
            dmDespesa.getDataManagerList().forEach(despesa -> {
                model.addRow(orderColums(despesa.getValues()));
            });
        } catch (Exception ex) {
            Logger.getLogger(Despesas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CalcularValor() {
        initComponents();
        this.model = (DefaultTableModel) jTable_despesas.getModel();
        initDataManager();
        initAno();
        refreshTable();
        applyFilters();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_despesas = new javax.swing.JTable();
        jPanel_inputs = new javax.swing.JPanel();
        jTextField_porcentagem = new javax.swing.JTextField();
        jLabel_valorAPagar = new javax.swing.JLabel();
        jComboBox_ano = new javax.swing.JComboBox<>();
        jLabel_mesReseva = new javax.swing.JLabel();
        calcular = new javax.swing.JButton();
        jComboBox_mes = new javax.swing.JComboBox<>();
        jLabel_mesReseva1 = new javax.swing.JLabel();
        jLabel_valorAPagarPorcentagem = new javax.swing.JLabel();
        jTextField_valor = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setMaximumSize(new java.awt.Dimension(670, 440));
        jPanel1.setMinimumSize(new java.awt.Dimension(670, 440));

        jTable_despesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Descrição", "Categoria", "Prioridade", "Data", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_despesas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable_despesas);

        jPanel_inputs.setBackground(new java.awt.Color(51, 51, 51));
        jPanel_inputs.setMinimumSize(new java.awt.Dimension(670, 80));
        jPanel_inputs.setPreferredSize(new java.awt.Dimension(670, 80));
        jPanel_inputs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField_porcentagem.setEditable(false);
        jPanel_inputs.add(jTextField_porcentagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 100, 30));

        jLabel_valorAPagar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_valorAPagar.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_valorAPagar.setText("Porcentagem de participação(%):");
        jPanel_inputs.add(jLabel_valorAPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, 30));

        jComboBox_ano.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jComboBox_ano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jComboBox_ano.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_anoItemStateChanged(evt);
            }
        });
        jPanel_inputs.add(jComboBox_ano, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 110, 30));

        jLabel_mesReseva.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_mesReseva.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_mesReseva.setText("Ano:");
        jPanel_inputs.add(jLabel_mesReseva, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 40, 30));

        calcular.setText("Calcular");
        calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularActionPerformed(evt);
            }
        });
        jPanel_inputs.add(calcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 110, 30));

        jComboBox_mes.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jComboBox_mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        jComboBox_mes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_mesItemStateChanged(evt);
            }
        });
        jPanel_inputs.add(jComboBox_mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 140, 30));

        jLabel_mesReseva1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_mesReseva1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_mesReseva1.setText("Mês:");
        jPanel_inputs.add(jLabel_mesReseva1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        jLabel_valorAPagarPorcentagem.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel_valorAPagarPorcentagem.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_valorAPagarPorcentagem.setText("Valor a pagar (R$):");
        jPanel_inputs.add(jLabel_valorAPagarPorcentagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, 30));

        jTextField_valor.setEditable(false);
        jPanel_inputs.add(jTextField_valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 80, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_inputs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel_inputs, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularActionPerformed
        int[] rows = jTable_despesas.getSelectedRows();
        float total = 0;
        float qtdMediaPagar = 0;
        float porcentamPagar = 0;
        
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        
        for (int i = 0; i < rows.length; i++) {
            int row = rows[i];
            float value = (float) model.getValueAt(row, 6); // Pega o valor da linha
            total += value;
        }

        qtdMediaPagar = (total / dmPessoa.getDataManagerList().size());
        porcentamPagar = (qtdMediaPagar*100)/total;
        
        this.jTextField_porcentagem.setText(decimalFormat.format(porcentamPagar) + "");
        this.jTextField_valor.setText(decimalFormat.format(qtdMediaPagar)+"");
    

    }//GEN-LAST:event_calcularActionPerformed

    private void jComboBox_anoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_anoItemStateChanged
        applyFilters();
    }//GEN-LAST:event_jComboBox_anoItemStateChanged

    private void jComboBox_mesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_mesItemStateChanged
        applyFilters();
    }//GEN-LAST:event_jComboBox_mesItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcular;
    private javax.swing.JComboBox<String> jComboBox_ano;
    private javax.swing.JComboBox<String> jComboBox_mes;
    private javax.swing.JLabel jLabel_mesReseva;
    private javax.swing.JLabel jLabel_mesReseva1;
    private javax.swing.JLabel jLabel_valorAPagar;
    private javax.swing.JLabel jLabel_valorAPagarPorcentagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_inputs;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_despesas;
    private javax.swing.JTextField jTextField_porcentagem;
    private javax.swing.JTextField jTextField_valor;
    // End of variables declaration//GEN-END:variables

    public String searchValue() {
        String value = (String) jComboBox_ano.getSelectedItem();
        String valueMes = (String) jComboBox_mes.getSelectedItem();
        String search = "";
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        if (valueMes.equalsIgnoreCase(meses[0])) {
            search = "01" + value;
        }
        if (valueMes.equalsIgnoreCase(meses[1])) {
            search = "02" + value;
        }
        if (valueMes.equalsIgnoreCase(meses[2])) {
            search = "03" + value;
        }
        if (valueMes.equalsIgnoreCase(meses[3])) {
            search = "04" + value;
        }
        if (valueMes.equalsIgnoreCase(meses[4])) {
            search = "05" + value;
        }
        if (valueMes.equalsIgnoreCase(meses[5])) {
            search = "06" + value;
        }
        if (valueMes.equalsIgnoreCase(meses[6])) {
            search = "07" + value;
        }
        if (valueMes.equalsIgnoreCase(meses[7])) {
            search = "08" + value;
        }
        if (valueMes.equalsIgnoreCase(meses[8])) {
            search = "09" + value;
        }
        if (valueMes.equalsIgnoreCase(meses[9])) {
            search = "10" + value;
        }
        if (valueMes.equalsIgnoreCase(meses[10])) {
            search = "11" + value;
        }
        if (valueMes.equalsIgnoreCase(meses[11])) {
            search = "12" + value;
        }

        return search;

    }

    public void applyFilters() {
        String search = searchValue();
        model.setRowCount(0);
        dmDespesa.getIfContains(search).forEach((item) -> {
            Despesa d = new Despesa(item);
            model.addRow(orderColums(d.getValues()));
        });
    }
}
