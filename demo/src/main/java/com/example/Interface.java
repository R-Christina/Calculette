package com.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Interface extends JFrame{
    private JTextField champA = new JTextField(10);
    private JTextField champB = new JTextField(10);
    private JTextField champC = new JTextField(10);
    private JLabel messageUser = new JLabel("Résultat :");

    public Interface() {
        super("Calcul d'équation du second degré");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        messageUser.setHorizontalAlignment(SwingConstants.CENTER);
        add(messageUser, BorderLayout.NORTH);

        // Champs a, b, c
        JPanel center = new JPanel(new GridLayout(3, 2, 6, 6));
        center.add(new JLabel("a :")); center.add(champA);
        center.add(new JLabel("b :")); center.add(champB);
        center.add(new JLabel("c :")); center.add(champC);
        add(center, BorderLayout.CENTER);

        // Bouton calcul
        JButton btn = new JButton("Calculer");
        btn.addActionListener(this::resultSecondDegre);
        JPanel south = new JPanel();
        south.add(btn);
        add(south, BorderLayout.SOUTH);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    private void resultSecondDegre(ActionEvent e) {
        try {
            double a = parseInt(champA.getText());
            double b = parseInt(champB.getText());
            double c = parseInt(champC.getText());

            Calculatrice calcul = new Calculatrice(a, b, c);
            double[] resultat = calcul.CalculSecondDegre();

            if (resultat == null) {
                messageUser.setText("Aucune solution (delta < 0)");
            } else if (resultat.length == 1) {
                messageUser.setText("Delta " + resultat[0] + " , x = " + resultat[1]);
            } else {
                messageUser.setText("Delta " + resultat[0] + " Deux solutions : x1 = " + resultat[1] + " , x2 = " + resultat[2]);
            }
        } catch (NumberFormatException ex) {
            messageUser.setText("Mauvaise saisie, entrez des nombres valides");
        }
    }

    private int parseInt(String text) {
        if (text == null || text.trim().isEmpty())
            throw new NumberFormatException("null");
        return Integer.parseInt(text.trim().replace(',', '.'));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Interface::new);
    }
}
