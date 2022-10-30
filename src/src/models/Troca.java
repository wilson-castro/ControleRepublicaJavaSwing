/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.models;

/**
 *
 * @author Ricardo Alves
 */
import javax.swing.JPanel;

public class Troca {

    protected JPanel raiz;
    protected JPanel ramos;

    public static void ChangePanel(JPanel raiz, JPanel ramos) {
        raiz.removeAll();
        raiz.revalidate();
        raiz.repaint();

        raiz.add(ramos);
        raiz.revalidate();
        raiz.repaint();

    }

}
