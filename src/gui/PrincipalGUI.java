package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrincipalGUI extends javax.swing.JFrame {

    private JButton btnCadastrarAluno;
    private JButton btnCadastrarCurso;

    
    public PrincipalGUI() {
        initComponents();
        setResizable(false);
    }
 private void initComponents() {
        btnCadastrarAluno = new JButton("Cadastrar Aluno");
        btnCadastrarCurso = new JButton("Cadastrar Curso");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestão de Cursos");

        // Ações dos botões
        btnCadastrarAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    new AlunoGUI().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PrincipalGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnCadastrarCurso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new CursoGUI().setVisible(true);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
        layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE) 
        .addComponent(btnCadastrarAluno)
        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED) 
        .addComponent(btnCadastrarCurso)
        .addGap(0, 0, Short.MAX_VALUE) 
        );

        layout.setVerticalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.CENTER)
        .addComponent(btnCadastrarAluno)
        .addComponent(btnCadastrarCurso)
        );
        
        btnCadastrarAluno.setBackground(Color.BLACK);
        btnCadastrarAluno.setForeground(Color.WHITE);
        btnCadastrarAluno.setFocusPainted(false); 

        btnCadastrarCurso.setBackground(Color.BLACK);
        btnCadastrarCurso.setForeground(Color.WHITE);
        btnCadastrarCurso.setFocusPainted(false);
        
        btnCadastrarAluno.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCadastrarCurso.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        btnCadastrarAluno.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.WHITE, 3),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

       btnCadastrarCurso.setBorder(BorderFactory.createCompoundBorder(
       BorderFactory.createLineBorder(Color.WHITE, 3),
       BorderFactory.createEmptyBorder(5, 10, 5, 10)
        )); 





        pack();
        setSize(400, 100);
        setLocationRelativeTo(null); // centraliza na tela
    }
   
  
 

  
    public static void main(String args[]) {
         try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (Exception e) {
            System.out.println("Falha ao aplicar FlatLaf");
        }

        java.awt.EventQueue.invokeLater(() -> {
            new PrincipalGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
