
package src.models;


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
