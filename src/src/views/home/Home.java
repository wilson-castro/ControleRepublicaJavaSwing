/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.views.home;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;

public class Home extends javax.swing.JFrame {

    private volatile int myX = 0;
    private volatile int myY = 0;
  
    public Home() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_body = new javax.swing.JPanel();
        jPanel_toolbar = new javax.swing.JPanel();
        jPanel_actionsToolbar = new javax.swing.JPanel();
        jLabel_botaoFechar = new javax.swing.JLabel();
        jLabel_botaoMinimizar = new javax.swing.JLabel();
        jPanel_borderToobar = new javax.swing.JPanel();
        jPanel_sidebar = new javax.swing.JPanel();
        jPanel_container_imgHome = new javax.swing.JPanel();
        jLabel_imgHome = new javax.swing.JLabel();
        jPanel_lineIconHomeMainMenu = new javax.swing.JPanel();
        jPanel_menuItemPessoas = new src.components.JPanel_Rounded();
        jLabel_menuItemUsuarios = new javax.swing.JLabel();
        jPanel_menuItemDespesas = new src.components.JPanel_Rounded();
        jLabel_menuItemDespesas = new javax.swing.JLabel();
        jPanel_menuItemReservas = new src.components.JPanel_Rounded();
        jLabel_menuItemReservas = new javax.swing.JLabel();
        jPanel_menuItemValorPagoMes = new src.components.JPanel_Rounded();
        jLabel_menuItemValorPagoMes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(891, 480));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_body.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_body.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jPanel_body.setMinimumSize(new java.awt.Dimension(891, 480));
        jPanel_body.setPreferredSize(new java.awt.Dimension(891, 480));
        jPanel_body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_toolbar.setBackground(new java.awt.Color(60, 63, 65));
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

        jPanel_actionsToolbar.setBackground(null);
        jPanel_actionsToolbar.setPreferredSize(new java.awt.Dimension(100, 35));

        jLabel_botaoFechar.setBackground(null);
        jLabel_botaoFechar.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel_botaoFechar.setForeground(new java.awt.Color(204, 204, 204));
        jLabel_botaoFechar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_botaoFechar.setText("x");
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

        jLabel_botaoMinimizar.setBackground(null);
        jLabel_botaoMinimizar.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel_botaoMinimizar.setForeground(new java.awt.Color(204, 204, 204));
        jLabel_botaoMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_botaoMinimizar.setText("—");
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
                .addGap(0, 790, Short.MAX_VALUE)
                .addComponent(jPanel_actionsToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel_toolbarLayout.setVerticalGroup(
            jPanel_toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_actionsToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel_body.add(jPanel_toolbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 890, -1));

        jPanel_borderToobar.setBackground(new java.awt.Color(66, 69, 66));
        jPanel_borderToobar.setPreferredSize(new java.awt.Dimension(100, 1));

        javax.swing.GroupLayout jPanel_borderToobarLayout = new javax.swing.GroupLayout(jPanel_borderToobar);
        jPanel_borderToobar.setLayout(jPanel_borderToobarLayout);
        jPanel_borderToobarLayout.setHorizontalGroup(
            jPanel_borderToobarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        jPanel_borderToobarLayout.setVerticalGroup(
            jPanel_borderToobarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel_body.add(jPanel_borderToobar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 36, 890, -1));

        jPanel_sidebar.setBackground(new java.awt.Color(60, 63, 65));
        jPanel_sidebar.setMinimumSize(new java.awt.Dimension(210, 462));
        jPanel_sidebar.setPreferredSize(new java.awt.Dimension(220, 462));
        jPanel_sidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_container_imgHome.setBackground(null);
        jPanel_container_imgHome.setOpaque(false);

        jLabel_imgHome.setBackground(null);
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

        jPanel_lineIconHomeMainMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_lineIconHomeMainMenu.setPreferredSize(new java.awt.Dimension(190, 3));

        javax.swing.GroupLayout jPanel_lineIconHomeMainMenuLayout = new javax.swing.GroupLayout(jPanel_lineIconHomeMainMenu);
        jPanel_lineIconHomeMainMenu.setLayout(jPanel_lineIconHomeMainMenuLayout);
        jPanel_lineIconHomeMainMenuLayout.setHorizontalGroup(
            jPanel_lineIconHomeMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        jPanel_lineIconHomeMainMenuLayout.setVerticalGroup(
            jPanel_lineIconHomeMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel_sidebar.add(jPanel_lineIconHomeMainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 119, -1, -1));

        jPanel_menuItemPessoas.setBackground(new java.awt.Color(72, 75, 72));
        jPanel_menuItemPessoas.setRoundBottomLeft(10);
        jPanel_menuItemPessoas.setRoundBottomRight(10);
        jPanel_menuItemPessoas.setRoundTopLeft(10);
        jPanel_menuItemPessoas.setRoundTopRight(10);
        jPanel_menuItemPessoas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_menuItemPessoasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_menuItemPessoasMouseExited(evt);
            }
        });

        jLabel_menuItemUsuarios.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel_menuItemUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_menuItemUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_menuItemUsuarios.setText("USUÁRIOS");

        javax.swing.GroupLayout jPanel_menuItemPessoasLayout = new javax.swing.GroupLayout(jPanel_menuItemPessoas);
        jPanel_menuItemPessoas.setLayout(jPanel_menuItemPessoasLayout);
        jPanel_menuItemPessoasLayout.setHorizontalGroup(
            jPanel_menuItemPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_menuItemUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        jPanel_menuItemPessoasLayout.setVerticalGroup(
            jPanel_menuItemPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_menuItemUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel_sidebar.add(jPanel_menuItemPessoas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 190, -1));

        jPanel_menuItemDespesas.setBackground(new java.awt.Color(72, 75, 72));
        jPanel_menuItemDespesas.setPreferredSize(new java.awt.Dimension(12, 30));
        jPanel_menuItemDespesas.setRoundBottomLeft(10);
        jPanel_menuItemDespesas.setRoundBottomRight(10);
        jPanel_menuItemDespesas.setRoundTopLeft(10);
        jPanel_menuItemDespesas.setRoundTopRight(10);
        jPanel_menuItemDespesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_menuItemDespesasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_menuItemDespesasMouseExited(evt);
            }
        });

        jLabel_menuItemDespesas.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel_menuItemDespesas.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_menuItemDespesas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_menuItemDespesas.setText("DESPESAS");

        javax.swing.GroupLayout jPanel_menuItemDespesasLayout = new javax.swing.GroupLayout(jPanel_menuItemDespesas);
        jPanel_menuItemDespesas.setLayout(jPanel_menuItemDespesasLayout);
        jPanel_menuItemDespesasLayout.setHorizontalGroup(
            jPanel_menuItemDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_menuItemDespesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_menuItemDespesasLayout.setVerticalGroup(
            jPanel_menuItemDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_menuItemDespesas, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel_sidebar.add(jPanel_menuItemDespesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 209, 190, -1));

        jPanel_menuItemReservas.setBackground(new java.awt.Color(72, 75, 72));
        jPanel_menuItemReservas.setPreferredSize(new java.awt.Dimension(12, 30));
        jPanel_menuItemReservas.setRoundBottomLeft(10);
        jPanel_menuItemReservas.setRoundBottomRight(10);
        jPanel_menuItemReservas.setRoundTopLeft(10);
        jPanel_menuItemReservas.setRoundTopRight(10);
        jPanel_menuItemReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_menuItemReservasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_menuItemReservasMouseExited(evt);
            }
        });

        jLabel_menuItemReservas.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel_menuItemReservas.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_menuItemReservas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_menuItemReservas.setText("RESERVAS");

        javax.swing.GroupLayout jPanel_menuItemReservasLayout = new javax.swing.GroupLayout(jPanel_menuItemReservas);
        jPanel_menuItemReservas.setLayout(jPanel_menuItemReservasLayout);
        jPanel_menuItemReservasLayout.setHorizontalGroup(
            jPanel_menuItemReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_menuItemReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_menuItemReservasLayout.setVerticalGroup(
            jPanel_menuItemReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_menuItemReservas, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel_sidebar.add(jPanel_menuItemReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 257, 190, -1));

        jPanel_menuItemValorPagoMes.setBackground(new java.awt.Color(72, 75, 72));
        jPanel_menuItemValorPagoMes.setPreferredSize(new java.awt.Dimension(12, 30));
        jPanel_menuItemValorPagoMes.setRoundBottomLeft(10);
        jPanel_menuItemValorPagoMes.setRoundBottomRight(10);
        jPanel_menuItemValorPagoMes.setRoundTopLeft(10);
        jPanel_menuItemValorPagoMes.setRoundTopRight(10);
        jPanel_menuItemValorPagoMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_menuItemValorPagoMesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_menuItemValorPagoMesMouseExited(evt);
            }
        });

        jLabel_menuItemValorPagoMes.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel_menuItemValorPagoMes.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_menuItemValorPagoMes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_menuItemValorPagoMes.setText("VALOR PAGO NO MÊS");

        javax.swing.GroupLayout jPanel_menuItemValorPagoMesLayout = new javax.swing.GroupLayout(jPanel_menuItemValorPagoMes);
        jPanel_menuItemValorPagoMes.setLayout(jPanel_menuItemValorPagoMesLayout);
        jPanel_menuItemValorPagoMesLayout.setHorizontalGroup(
            jPanel_menuItemValorPagoMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_menuItemValorPagoMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_menuItemValorPagoMesLayout.setVerticalGroup(
            jPanel_menuItemValorPagoMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_menuItemValorPagoMes, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel_sidebar.add(jPanel_menuItemValorPagoMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 305, 190, -1));

        jPanel_body.add(jPanel_sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 37, -1, 442));

        getContentPane().add(jPanel_body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_botaoFecharMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_botaoFecharMouseEntered
        this.jLabel_botaoFechar.setBackground(Color.RED);
    }//GEN-LAST:event_jLabel_botaoFecharMouseEntered

    private void jLabel_botaoFecharMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_botaoFecharMouseExited
        this.jLabel_botaoFechar.setBackground(null);
    }//GEN-LAST:event_jLabel_botaoFecharMouseExited

    private void jLabel_botaoMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_botaoMinimizarMouseEntered
        this.jLabel_botaoMinimizar.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_jLabel_botaoMinimizarMouseEntered

    private void jLabel_botaoMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_botaoMinimizarMouseExited
        this.jLabel_botaoMinimizar.setBackground(null);
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

    private void jPanel_menuItemPessoasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_menuItemPessoasMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel_menuItemPessoasMouseEntered

    private void jPanel_menuItemPessoasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_menuItemPessoasMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel_menuItemPessoasMouseExited

    private void jPanel_menuItemDespesasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_menuItemDespesasMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel_menuItemDespesasMouseEntered

    private void jPanel_menuItemDespesasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_menuItemDespesasMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel_menuItemDespesasMouseExited

    private void jPanel_menuItemReservasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_menuItemReservasMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel_menuItemReservasMouseEntered

    private void jPanel_menuItemReservasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_menuItemReservasMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel_menuItemReservasMouseExited

    private void jPanel_menuItemValorPagoMesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_menuItemValorPagoMesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel_menuItemValorPagoMesMouseEntered

    private void jPanel_menuItemValorPagoMesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_menuItemValorPagoMesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel_menuItemValorPagoMesMouseExited

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_botaoFechar;
    private javax.swing.JLabel jLabel_botaoMinimizar;
    private javax.swing.JLabel jLabel_imgHome;
    private javax.swing.JLabel jLabel_menuItemDespesas;
    private javax.swing.JLabel jLabel_menuItemReservas;
    private javax.swing.JLabel jLabel_menuItemUsuarios;
    private javax.swing.JLabel jLabel_menuItemValorPagoMes;
    private javax.swing.JPanel jPanel_actionsToolbar;
    private javax.swing.JPanel jPanel_body;
    private javax.swing.JPanel jPanel_borderToobar;
    private javax.swing.JPanel jPanel_container_imgHome;
    private javax.swing.JPanel jPanel_lineIconHomeMainMenu;
    private src.components.JPanel_Rounded jPanel_menuItemDespesas;
    private src.components.JPanel_Rounded jPanel_menuItemPessoas;
    private src.components.JPanel_Rounded jPanel_menuItemReservas;
    private src.components.JPanel_Rounded jPanel_menuItemValorPagoMes;
    private javax.swing.JPanel jPanel_sidebar;
    private javax.swing.JPanel jPanel_toolbar;
    // End of variables declaration//GEN-END:variables
}
