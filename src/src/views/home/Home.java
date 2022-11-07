package src.views.home;

import java.awt.Color;
import java.awt.Component;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import src.models.Despesa;
import src.models.Troca;
import src.services.DataManager;
import src.utils.Constantes;
import src.views.despesas.CalcularValor;
import src.views.despesas.Despesas;
import src.views.pessoas.Pessoas;
import src.views.reservas.Reservas;
import src.views.infoReserva.InfoReserva;

public class Home extends javax.swing.JFrame {

    private volatile int myX = 0;
    private volatile int myY = 0;

    private ModulosApp moduloAtual = null;

    private void handleShowValorAPagarMesAtual() {
        try {
            float valorAPagar = 0;
            LocalDate today = LocalDate.now();
            String monthP = String.format("%02d", today.getMonthValue());
            String yearP = today.getYear() + "";

            JOptionPane.showMessageDialog(this,
                    "O Valor a pagar no mês corrente é: "
                    + new DataManager<Despesa>(Despesa.class.getName(), Constantes.DIRETORIO_FILE, true, "despesas_" + monthP + "_" + yearP)
                            .getDataManagerList().stream()
                            .map(Despesa::getValor_despesa)
                            .reduce(valorAPagar, Float::sum).toString(),
                    "Informativo do Sistema", 1
            );
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Home() {
        initComponents();
    }

    private void setDefaultColorAllMenuItems() {
        this.jLabel_menuItemPessoas.setBackground(new Color(28, 28, 28));
        this.jLabel_menuItemDespesas.setBackground(new Color(28, 28, 28));
        this.jLabel_menuItemReservas.setBackground(new Color(28, 28, 28));
        this.jLabel_menuItemInfoReserva.setBackground(new Color(28, 28, 28));
        this.jLabel_menuItemCalcular.setBackground(new Color(28, 28, 28));
    }

    private Color getColorDoMenuItemPeloModuloAtual(ModulosApp modulo) {
        return modulo.equals(moduloAtual) ? new Color(255, 57, 54) : new Color(28, 28, 28);
    }

    private void handleItemMenuExited(ModulosApp moduleExited) {
        Color corPadraoItemMenu = getColorDoMenuItemPeloModuloAtual(moduleExited);

        switch (moduleExited) {
            case PESSOAS ->
                this.jLabel_menuItemPessoas.setBackground(corPadraoItemMenu);
            case DESPESAS ->
                this.jLabel_menuItemDespesas.setBackground(corPadraoItemMenu);
            case RESERVAS ->
                this.jLabel_menuItemReservas.setBackground(corPadraoItemMenu);
            case INFO_RESERVA ->
                this.jLabel_menuItemInfoReserva.setBackground(corPadraoItemMenu);
            case CALCULAR ->
                this.jLabel_menuItemCalcular.setBackground(corPadraoItemMenu);
            case VALOR_PAGAR ->
                this.jLabel_menuItemValorAPagar.setBackground(corPadraoItemMenu);
            default -> {
                setDefaultColorAllMenuItems();
            }
        }
    }

    private void handleColorItemMenuSelected(ModulosApp moduloSelecionado) {
        Color corPadraoItemMenu = new Color(255, 75, 72);
        Color corModuloSelecionado = new Color(255, 57, 54);

        setDefaultColorAllMenuItems();
        switch (moduloSelecionado) {
            case PESSOAS ->
                this.jLabel_menuItemPessoas.setBackground(corModuloSelecionado);
            case DESPESAS ->
                this.jLabel_menuItemDespesas.setBackground(corModuloSelecionado);
            case RESERVAS ->
                this.jLabel_menuItemReservas.setBackground(corModuloSelecionado);
            case INFO_RESERVA ->
                this.jLabel_menuItemInfoReserva.setBackground(corModuloSelecionado);
            case CALCULAR ->
                this.jLabel_menuItemCalcular.setBackground(corModuloSelecionado);
            case VALOR_PAGAR ->
                this.jLabel_menuItemValorAPagar.setBackground(corModuloSelecionado);
            default -> {
                this.jLabel_menuItemPessoas.setBackground(corPadraoItemMenu);
                this.jLabel_menuItemDespesas.setBackground(corPadraoItemMenu);
                this.jLabel_menuItemReservas.setBackground(corPadraoItemMenu);
                this.jLabel_menuItemInfoReserva.setBackground(corPadraoItemMenu);
                this.jLabel_menuItemValorAPagar.setBackground(corPadraoItemMenu);
                this.jLabel_menuItemCalcular.setBackground(corPadraoItemMenu);
            }
        }
    }

    private void handleItemMenuSelected(ModulosApp moduloSelecionado, Component component) {
        handleColorItemMenuSelected(moduloSelecionado);
        moduloAtual = moduloSelecionado;

        this.jPanel_container.removeAll();
        this.jPanel_container.repaint();
        this.jPanel_container.revalidate();

        this.jPanel_container.add(component);
        this.jPanel_container.repaint();
        this.jPanel_container.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_body = new javax.swing.JPanel();
        jPanel_toolbar = new javax.swing.JPanel();
        jPanel_actionsToolbar = new javax.swing.JPanel();
        jLabel_botaoFechar = new javax.swing.JLabel();
        jLabel_botaoMinimizar = new javax.swing.JLabel();
        jPanel_sidebar = new javax.swing.JPanel();
        jPanel_container_imgHome = new javax.swing.JPanel();
        jLabel_imgHome = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel_menuItemDespesas1 = new src.components.JPanel_Rounded();
        jLabel_menuItemInfoReserva = new javax.swing.JLabel();
        jLabel_menuItemValorAPagar = new javax.swing.JLabel();
        jLabel_menuItemCalcular = new javax.swing.JLabel();
        jLabel_menuItemPessoas = new javax.swing.JLabel();
        jLabel_menuItemDespesas = new javax.swing.JLabel();
        jLabel_menuItemReservas = new javax.swing.JLabel();
        jPanel_container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_body.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_body.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel_body.setMinimumSize(new java.awt.Dimension(891, 480));
        jPanel_body.setPreferredSize(new java.awt.Dimension(891, 480));
        jPanel_body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_toolbar.setBackground(new java.awt.Color(34, 34, 34));
        jPanel_toolbar.setPreferredSize(new java.awt.Dimension(100, 35));
        jPanel_toolbar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel_toolbarMouseDragged(evt);
            }
        });
        jPanel_toolbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel_toolbarMousePressed(evt);
            }
        });

        jPanel_actionsToolbar.setBackground(new java.awt.Color(102, 102, 102));
        jPanel_actionsToolbar.setPreferredSize(new java.awt.Dimension(100, 35));

        jLabel_botaoFechar.setBackground(new java.awt.Color(34, 34, 34));
        jLabel_botaoFechar.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel_botaoFechar.setForeground(new java.awt.Color(204, 204, 204));
        jLabel_botaoFechar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_botaoFechar.setText("x");
        jLabel_botaoFechar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_botaoFechar.setMinimumSize(new java.awt.Dimension(7, 20));
        jLabel_botaoFechar.setOpaque(true);
        jLabel_botaoFechar.setPreferredSize(new java.awt.Dimension(50, 20));
        jLabel_botaoFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_botaoFecharMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_botaoFecharMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel_botaoFecharMousePressed(evt);
            }
        });

        jLabel_botaoMinimizar.setBackground(new java.awt.Color(34, 34, 34));
        jLabel_botaoMinimizar.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel_botaoMinimizar.setForeground(new java.awt.Color(204, 204, 204));
        jLabel_botaoMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_botaoMinimizar.setText("—");
        jLabel_botaoMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_botaoMinimizar.setOpaque(true);
        jLabel_botaoMinimizar.setPreferredSize(new java.awt.Dimension(50, 18));
        jLabel_botaoMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_botaoMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_botaoMinimizarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel_botaoMinimizarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_actionsToolbarLayout = new javax.swing.GroupLayout(jPanel_actionsToolbar);
        jPanel_actionsToolbar.setLayout(jPanel_actionsToolbarLayout);
        jPanel_actionsToolbarLayout.setHorizontalGroup(
            jPanel_actionsToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_actionsToolbarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel_botaoMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel_botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel_actionsToolbarLayout.setVerticalGroup(
            jPanel_actionsToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_actionsToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel_botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel_botaoMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel_toolbarLayout = new javax.swing.GroupLayout(jPanel_toolbar);
        jPanel_toolbar.setLayout(jPanel_toolbarLayout);
        jPanel_toolbarLayout.setHorizontalGroup(
            jPanel_toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_toolbarLayout.createSequentialGroup()
                .addContainerGap(790, Short.MAX_VALUE)
                .addComponent(jPanel_actionsToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel_toolbarLayout.setVerticalGroup(
            jPanel_toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_actionsToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel_body.add(jPanel_toolbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 890, -1));

        jPanel_sidebar.setBackground(new java.awt.Color(34, 34, 34));
        jPanel_sidebar.setMinimumSize(new java.awt.Dimension(210, 462));
        jPanel_sidebar.setPreferredSize(new java.awt.Dimension(220, 462));
        jPanel_sidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_container_imgHome.setOpaque(false);

        jLabel_imgHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images/icons8-casa-96.png"))); // NOI18N

        javax.swing.GroupLayout jPanel_container_imgHomeLayout = new javax.swing.GroupLayout(jPanel_container_imgHome);
        jPanel_container_imgHome.setLayout(jPanel_container_imgHomeLayout);
        jPanel_container_imgHomeLayout.setHorizontalGroup(
            jPanel_container_imgHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_imgHome, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel_container_imgHomeLayout.setVerticalGroup(
            jPanel_container_imgHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_imgHome, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel_sidebar.add(jPanel_container_imgHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 19, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(28, 28, 28));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel_sidebar.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 113, 220, 10));

        jPanel_menuItemDespesas1.setBackground(new java.awt.Color(28, 28, 28));
        jPanel_menuItemDespesas1.setPreferredSize(new java.awt.Dimension(12, 30));
        jPanel_menuItemDespesas1.setRoundBottomLeft(10);
        jPanel_menuItemDespesas1.setRoundBottomRight(10);
        jPanel_menuItemDespesas1.setRoundTopLeft(10);
        jPanel_menuItemDespesas1.setRoundTopRight(10);

        jLabel_menuItemInfoReserva.setBackground(new java.awt.Color(28, 28, 28));
        jLabel_menuItemInfoReserva.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel_menuItemInfoReserva.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_menuItemInfoReserva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_menuItemInfoReserva.setText("INFO RESERVA");
        jLabel_menuItemInfoReserva.setMaximumSize(new java.awt.Dimension(73, 19));
        jLabel_menuItemInfoReserva.setMinimumSize(new java.awt.Dimension(73, 19));
        jLabel_menuItemInfoReserva.setOpaque(true);
        jLabel_menuItemInfoReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_menuItemInfoReservaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_menuItemInfoReservaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel_menuItemInfoReservaMousePressed(evt);
            }
        });

        jLabel_menuItemValorAPagar.setBackground(new java.awt.Color(28, 28, 28));
        jLabel_menuItemValorAPagar.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel_menuItemValorAPagar.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_menuItemValorAPagar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_menuItemValorAPagar.setText("VALOR À PAGAR");
        jLabel_menuItemValorAPagar.setMaximumSize(new java.awt.Dimension(73, 19));
        jLabel_menuItemValorAPagar.setMinimumSize(new java.awt.Dimension(73, 19));
        jLabel_menuItemValorAPagar.setOpaque(true);
        jLabel_menuItemValorAPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_menuItemValorAPagarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_menuItemValorAPagarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel_menuItemValorAPagarMousePressed(evt);
            }
        });

        jLabel_menuItemCalcular.setBackground(new java.awt.Color(28, 28, 28));
        jLabel_menuItemCalcular.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel_menuItemCalcular.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_menuItemCalcular.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_menuItemCalcular.setText("CALCULAR VALOR");
        jLabel_menuItemCalcular.setMaximumSize(new java.awt.Dimension(73, 19));
        jLabel_menuItemCalcular.setMinimumSize(new java.awt.Dimension(73, 19));
        jLabel_menuItemCalcular.setOpaque(true);
        jLabel_menuItemCalcular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_menuItemCalcularMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_menuItemCalcularMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel_menuItemCalcularMousePressed(evt);
            }
        });

        jLabel_menuItemPessoas.setBackground(new java.awt.Color(28, 28, 28));
        jLabel_menuItemPessoas.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel_menuItemPessoas.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_menuItemPessoas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_menuItemPessoas.setText("PESSOAS");
        jLabel_menuItemPessoas.setMaximumSize(new java.awt.Dimension(73, 19));
        jLabel_menuItemPessoas.setMinimumSize(new java.awt.Dimension(73, 19));
        jLabel_menuItemPessoas.setOpaque(true);
        jLabel_menuItemPessoas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_menuItemPessoasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_menuItemPessoasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel_menuItemPessoasMousePressed(evt);
            }
        });

        jLabel_menuItemDespesas.setBackground(new java.awt.Color(28, 28, 28));
        jLabel_menuItemDespesas.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel_menuItemDespesas.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_menuItemDespesas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_menuItemDespesas.setText("DESPESAS");
        jLabel_menuItemDespesas.setOpaque(true);
        jLabel_menuItemDespesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_menuItemDespesasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_menuItemDespesasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel_menuItemDespesasMousePressed(evt);
            }
        });

        jLabel_menuItemReservas.setBackground(new java.awt.Color(28, 28, 28));
        jLabel_menuItemReservas.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel_menuItemReservas.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_menuItemReservas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_menuItemReservas.setText("RESERVAS");
        jLabel_menuItemReservas.setMaximumSize(new java.awt.Dimension(73, 19));
        jLabel_menuItemReservas.setMinimumSize(new java.awt.Dimension(73, 19));
        jLabel_menuItemReservas.setOpaque(true);
        jLabel_menuItemReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_menuItemReservasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_menuItemReservasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel_menuItemReservasMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_menuItemDespesas1Layout = new javax.swing.GroupLayout(jPanel_menuItemDespesas1);
        jPanel_menuItemDespesas1.setLayout(jPanel_menuItemDespesas1Layout);
        jPanel_menuItemDespesas1Layout.setHorizontalGroup(
            jPanel_menuItemDespesas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_menuItemDespesas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel_menuItemCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel_menuItemInfoReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel_menuItemValorAPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_menuItemDespesas1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel_menuItemDespesas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_menuItemPessoas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_menuItemReservas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
        );
        jPanel_menuItemDespesas1Layout.setVerticalGroup(
            jPanel_menuItemDespesas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_menuItemDespesas1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel_menuItemPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_menuItemReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_menuItemDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_menuItemInfoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_menuItemValorAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_menuItemCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel_sidebar.add(jPanel_menuItemDespesas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 200, 320));

        jPanel_body.add(jPanel_sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 29, -1, 470));

        jPanel_container.setBackground(new java.awt.Color(51, 51, 51));
        jPanel_container.setMaximumSize(new java.awt.Dimension(670, 440));
        jPanel_container.setMinimumSize(new java.awt.Dimension(670, 440));
        jPanel_container.setLayout(new java.awt.CardLayout());
        jPanel_body.add(jPanel_container, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 36, 669, 460));

        getContentPane().add(jPanel_body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_botaoFecharMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_botaoFecharMouseEntered
        this.jLabel_botaoFechar.setBackground(Color.RED);
    }//GEN-LAST:event_jLabel_botaoFecharMouseEntered

    private void jLabel_botaoFecharMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_botaoFecharMouseExited
        this.jLabel_botaoFechar.setBackground(new Color(34, 34, 34));
    }//GEN-LAST:event_jLabel_botaoFecharMouseExited

    private void jLabel_botaoMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_botaoMinimizarMouseEntered
        this.jLabel_botaoMinimizar.setBackground(new Color(60, 63, 65));
    }//GEN-LAST:event_jLabel_botaoMinimizarMouseEntered

    private void jLabel_botaoMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_botaoMinimizarMouseExited
        this.jLabel_botaoMinimizar.setBackground(new Color(34, 34, 34));
    }//GEN-LAST:event_jLabel_botaoMinimizarMouseExited

    private void jLabel_botaoFecharMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_botaoFecharMousePressed
        System.exit(0);
    }//GEN-LAST:event_jLabel_botaoFecharMousePressed

    private void jLabel_botaoMinimizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_botaoMinimizarMousePressed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel_botaoMinimizarMousePressed

    private void jPanel_toolbarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_toolbarMouseDragged
        int deltaX = evt.getXOnScreen() - myX;
        int deltaY = evt.getYOnScreen() - myY;

        setLocation(deltaX, deltaY);
    }//GEN-LAST:event_jPanel_toolbarMouseDragged

    private void jPanel_toolbarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_toolbarMousePressed
        myX = evt.getX();
        myY = evt.getY();
    }//GEN-LAST:event_jPanel_toolbarMousePressed

    private void jLabel_menuItemPessoasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_menuItemPessoasMouseEntered
        this.jLabel_menuItemPessoas.setBackground(new Color(255, 86, 81));
    }//GEN-LAST:event_jLabel_menuItemPessoasMouseEntered

    private void jLabel_menuItemDespesasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_menuItemDespesasMouseEntered
        this.jLabel_menuItemDespesas.setBackground(new Color(255, 86, 81));
    }//GEN-LAST:event_jLabel_menuItemDespesasMouseEntered

    private void jLabel_menuItemReservasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_menuItemReservasMouseEntered
        this.jLabel_menuItemReservas.setBackground(new Color(255, 86, 81));
    }//GEN-LAST:event_jLabel_menuItemReservasMouseEntered

    private void jLabel_menuItemInfoReservaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_menuItemInfoReservaMouseEntered
        this.jLabel_menuItemInfoReserva.setBackground(new Color(255, 86, 81));
    }//GEN-LAST:event_jLabel_menuItemInfoReservaMouseEntered

    private void jLabel_menuItemPessoasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_menuItemPessoasMouseExited
        handleItemMenuExited(ModulosApp.PESSOAS);
    }//GEN-LAST:event_jLabel_menuItemPessoasMouseExited

    private void jLabel_menuItemDespesasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_menuItemDespesasMouseExited
        handleItemMenuExited(ModulosApp.DESPESAS);
    }//GEN-LAST:event_jLabel_menuItemDespesasMouseExited

    private void jLabel_menuItemReservasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_menuItemReservasMouseExited
        handleItemMenuExited(ModulosApp.RESERVAS);
    }//GEN-LAST:event_jLabel_menuItemReservasMouseExited

    private void jLabel_menuItemInfoReservaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_menuItemInfoReservaMouseExited
        handleItemMenuExited(ModulosApp.INFO_RESERVA);
    }//GEN-LAST:event_jLabel_menuItemInfoReservaMouseExited

    private void jLabel_menuItemPessoasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_menuItemPessoasMousePressed
        Pessoas in = new Pessoas();
        Troca.ChangePanel(jPanel_container, in);
        handleItemMenuSelected(ModulosApp.PESSOAS, in);
    }//GEN-LAST:event_jLabel_menuItemPessoasMousePressed

    private void jLabel_menuItemDespesasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_menuItemDespesasMousePressed
        Despesas in = new Despesas();
        Troca.ChangePanel(jPanel_container, in);
        handleItemMenuSelected(ModulosApp.DESPESAS, in);
    }//GEN-LAST:event_jLabel_menuItemDespesasMousePressed

    private void jLabel_menuItemReservasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_menuItemReservasMousePressed
        Reservas in = new Reservas();
        Troca.ChangePanel(jPanel_container, in);
        handleItemMenuSelected(ModulosApp.RESERVAS, in);
    }//GEN-LAST:event_jLabel_menuItemReservasMousePressed

    private void jLabel_menuItemInfoReservaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_menuItemInfoReservaMousePressed
        InfoReserva in = new InfoReserva();
        Troca.ChangePanel(jPanel_container, in);
        handleItemMenuSelected(ModulosApp.INFO_RESERVA, in);
    }//GEN-LAST:event_jLabel_menuItemInfoReservaMousePressed

    private void jLabel_menuItemCalcularMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_menuItemCalcularMouseEntered
        this.jLabel_menuItemCalcular.setBackground(new Color(255, 86, 81));
    }//GEN-LAST:event_jLabel_menuItemCalcularMouseEntered

    private void jLabel_menuItemCalcularMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_menuItemCalcularMouseExited
        handleItemMenuExited(ModulosApp.CALCULAR);
    }//GEN-LAST:event_jLabel_menuItemCalcularMouseExited

    private void jLabel_menuItemCalcularMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_menuItemCalcularMousePressed
        CalcularValor in = new CalcularValor();
        Troca.ChangePanel(jPanel_container, in);
        handleItemMenuSelected(ModulosApp.CALCULAR, in);
    }//GEN-LAST:event_jLabel_menuItemCalcularMousePressed

    private void jLabel_menuItemValorAPagarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_menuItemValorAPagarMouseEntered
        this.jLabel_menuItemValorAPagar.setBackground(new Color(255, 86, 81));
    }//GEN-LAST:event_jLabel_menuItemValorAPagarMouseEntered

    private void jLabel_menuItemValorAPagarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_menuItemValorAPagarMouseExited
        handleItemMenuExited(ModulosApp.VALOR_PAGAR);
    }//GEN-LAST:event_jLabel_menuItemValorAPagarMouseExited

    private void jLabel_menuItemValorAPagarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_menuItemValorAPagarMousePressed
        handleShowValorAPagarMesAtual();
    }//GEN-LAST:event_jLabel_menuItemValorAPagarMousePressed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_botaoFechar;
    private javax.swing.JLabel jLabel_botaoMinimizar;
    private javax.swing.JLabel jLabel_imgHome;
    private javax.swing.JLabel jLabel_menuItemCalcular;
    private javax.swing.JLabel jLabel_menuItemDespesas;
    private javax.swing.JLabel jLabel_menuItemInfoReserva;
    private javax.swing.JLabel jLabel_menuItemPessoas;
    private javax.swing.JLabel jLabel_menuItemReservas;
    private javax.swing.JLabel jLabel_menuItemValorAPagar;
    private javax.swing.JPanel jPanel_actionsToolbar;
    private javax.swing.JPanel jPanel_body;
    private javax.swing.JPanel jPanel_container;
    private javax.swing.JPanel jPanel_container_imgHome;
    private src.components.JPanel_Rounded jPanel_menuItemDespesas1;
    private javax.swing.JPanel jPanel_sidebar;
    private javax.swing.JPanel jPanel_toolbar;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

}
