package gui;


import dao.CursoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Curso;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.table.TableModel;



public class TabelaCursoGUI extends javax.swing.JFrame {
    public TabelaCursoGUI() {
        initComponents();
        mostrarTabela();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void mostrarTabela() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); 

    try {
        List<Curso> cursos = new CursoDAO().listarTodos(); 

        for (Curso curso : cursos) {
            model.addRow(new Object[]{
                curso.getCodigo(),
                curso.getNome(),
                curso.getCarga_horaria(),
                curso.getQtd_alunos(),
                curso.getLimite_alunos(),
                curso.isAtivo() ? "Sim" : "Não"
                
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar os cursos: " + e.getMessage());
    }
    }

    private void buscarporNome(String nome) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); 

        try {
            List<Curso> cursos = new CursoDAO().buscarPorNome(nome);

            for (Curso curso : cursos) {
                model.addRow(new Object[]{
                    curso.getCodigo(),
                    curso.getNome(),
                    curso.getCarga_horaria(),
                    curso.getQtd_alunos(),
                    curso.getLimite_alunos(),
                    curso.isAtivo() ? "Sim" : "Não"
                   
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar cursos: " + e.getMessage());
        }
    } 
    public DefaultTableModel exibirCursos() {
    DefaultTableModel model = new DefaultTableModel(
        new String[]{"ID", "Nome", "Carga Horária", "Limite", "Qtd Alunos", "Ativo"}, 0);

    try {
        List<Curso> cursos = new CursoDAO().listarTodos();
        for (Curso curso : cursos) {
            model.addRow(new Object[]{
                curso.getCodigo(),
                curso.getNome(),
                curso.getCarga_horaria(),
                curso.getLimite_alunos(),
                curso.getQtd_alunos(),
                curso.isAtivo() ? "Sim" : "Não"
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao listar cursos: " + e.getMessage());
    }

    return model;
}
    
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        Deletar = new javax.swing.JButton();
        Reabilitar = new javax.swing.JButton();
        Desabilitar = new javax.swing.JButton();
        Atualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setBackground(new java.awt.Color(153, 153, 153));
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome do Curso", "Carga Horária", "Quantidade de alunos", "Limite de Vaga", "Ativo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Busca:");

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setCaretColor(new java.awt.Color(0, 0, 0));
        jTextField1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        Buscar.setBackground(new java.awt.Color(0, 0, 0));
        Buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Buscar.setForeground(new java.awt.Color(255, 255, 255));
        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        Deletar.setBackground(new java.awt.Color(0, 0, 0));
        Deletar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Deletar.setForeground(new java.awt.Color(255, 255, 255));
        Deletar.setText("Deletar");
        Deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarActionPerformed(evt);
            }
        });

        Reabilitar.setBackground(new java.awt.Color(0, 0, 0));
        Reabilitar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Reabilitar.setForeground(new java.awt.Color(255, 255, 255));
        Reabilitar.setText("Reabilitar");
        Reabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReabilitarActionPerformed(evt);
            }
        });

        Desabilitar.setBackground(new java.awt.Color(0, 0, 0));
        Desabilitar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Desabilitar.setForeground(new java.awt.Color(255, 255, 255));
        Desabilitar.setText("Desabilitar");
        Desabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesabilitarActionPerformed(evt);
            }
        });

        Atualizar.setBackground(new java.awt.Color(0, 0, 0));
        Atualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Atualizar.setForeground(new java.awt.Color(255, 255, 255));
        Atualizar.setText("Atualizar");
        Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cadastrar novo aluno");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Relatório dos Cursos ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Atualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Deletar))
                    .addComponent(jButton1))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Desabilitar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Reabilitar))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Desabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Reabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void exportarTabela(String titulo) throws IOException {
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("Escolher local para salvar");
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

    int resultado = chooser.showOpenDialog(null);
    if (resultado == JFileChooser.APPROVE_OPTION) {
        File pasta = chooser.getSelectedFile();
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do arquivo:");

        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome de arquivo inválido");
            return;
        }

        File txt = new File(pasta, nome + ".txt");

        try (FileWriter w = new FileWriter(txt)) {
            
        TableModel model = jTable1.getModel();

   
        String formato = "%-10s %-30s %-15s %-10s %-10s %-10s%n";
            w.write(String.format(formato,
            model.getColumnName(0),
            model.getColumnName(1),
            model.getColumnName(2),
            model.getColumnName(3),
            model.getColumnName(4),
            model.getColumnName(5)
        ));

        for (int col = 0; col < model.getColumnCount(); col++) {
            
        }
        w.write("\n");

        for (int i = 0; i < model.getRowCount(); i++) {
            w.write(String.format(formato,
                model.getValueAt(i, 0),
                model.getValueAt(i, 1),
                model.getValueAt(i, 2),
                model.getValueAt(i, 3),
                model.getValueAt(i, 4),
                model.getValueAt(i, 5)
            ));
        }
            
        JOptionPane.showMessageDialog(null, "Tabela exportada com sucesso para:\n" + txt.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo: " + e.getMessage());
        }
    }    
}
    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
         String nomeBusca = jTextField1.getText().trim();
         buscarporNome(nomeBusca);
    }//GEN-LAST:event_BuscarActionPerformed

    private void DeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarActionPerformed
        int linha = jTable1.getSelectedRow();
        if (linha == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um curso para deletar");
        return;
    }

    int codigo = (int) jTable1.getValueAt(linha, 0);

    int confirma = JOptionPane.showConfirmDialog(this, "Deseja realmente deletar o curso selecionado?", "Confirmação", JOptionPane.YES_NO_OPTION);
    if (confirma == JOptionPane.YES_OPTION) {
        try {
            new CursoDAO().deletar(codigo);
            mostrarTabela();
            JOptionPane.showMessageDialog(this, "Curso deletado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar curso: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_DeletarActionPerformed

    private void ReabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReabilitarActionPerformed
        int linha = jTable1.getSelectedRow();
    if (linha == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um curso para reabilitar");
        return;
    }

    int codigo = (int) jTable1.getValueAt(linha, 0);

    try {
        new CursoDAO().habilitar(codigo);
        mostrarTabela();
        JOptionPane.showMessageDialog(this, "Curso reabilitado com sucesso");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao reabilitar curso: " + e.getMessage());
    }

    }//GEN-LAST:event_ReabilitarActionPerformed

    private void DesabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesabilitarActionPerformed
        int linha = jTable1.getSelectedRow();
    if (linha == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um curso para desabilitar.");
        return;
    }

    int codigo = (int) jTable1.getValueAt(linha, 0);

    try {
        new CursoDAO().desabilitar(codigo);
        mostrarTabela();
        JOptionPane.showMessageDialog(this, "Curso desabilitado com sucesso");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao desabilitar curso: " + e.getMessage());
    }
    }//GEN-LAST:event_DesabilitarActionPerformed

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
    int linha = jTable1.getSelectedRow();
        if (linha == -1) {
            return;
        
        }

        int codigo = (int) jTable1.getValueAt(linha, 0);
        String nome = (String) jTable1.getValueAt(linha, 1);
        int carga_horaria = (int) jTable1.getValueAt(linha, 2);
        int limite_alunos = (int) jTable1.getValueAt(linha, 3);
        boolean ativo = "Sim".equals(jTable1.getValueAt(linha, 4));

        try {

            String novoNome = JOptionPane.showInputDialog(this, "Atualize o nome do curso:", nome);
        if (novoNome == null || novoNome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo nome não pode ser vazio");
            return;            
        }
            String carga_horariastr = JOptionPane.showInputDialog(this, "Atualize a carga horária do curso:", carga_horaria);
        if (carga_horariastr == null || carga_horariastr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha a carga horária");
            return;
        }
        int novacarga_horaria;
        try {
        novacarga_horaria = Integer.parseInt(carga_horariastr.trim());
        }   catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Carga horária deve ser um número válido");
        return;
        } 
            String limite_alunosstr = JOptionPane.showInputDialog(this, "Atualize a quantidade de alunos", limite_alunos);
            if (limite_alunosstr == null || limite_alunosstr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha o número de alunos");
            return;
        }
         int novolimite_alunos;
        try {
        novolimite_alunos = Integer.parseInt(limite_alunosstr.trim());
        }   catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "A quantidade de alunos deve ser um número válido");
        return;
        } 
        
        Curso curso = new Curso();
        curso.setCodigo(codigo);
        curso.setNome(novoNome);
        curso.setCarga_horaria(novacarga_horaria);
        curso.setLimite_alunos(novolimite_alunos);
        curso.setAtivo(ativo);
       
         if (curso.getNome().length() < 3) {
                throw new IllegalArgumentException("O nome deve ter no mínimo 3 caracteres.Preencha novamente");
            }
            if (curso.getCarga_horaria() < 20) {
                throw new IllegalArgumentException(" A carga horária mínima: 20h. Preencha novamente");
            }
            if (curso.getLimite_alunos() < 1) {
                throw new IllegalArgumentException("O Limite de alunos deve ser pelo menos 1. Preencha novamente");
            }

        new CursoDAO().atualizar(curso);
        mostrarTabela();
        JOptionPane.showMessageDialog(this, "Curso atualizado com sucesso.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar curso: " + e.getMessage());
        } 
        
    }//GEN-LAST:event_AtualizarActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
 private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         AlunoGUI telaCadastro = null;
        try {
            telaCadastro = new AlunoGUI();
        } catch (SQLException ex) {
            Logger.getLogger(TabelaCursoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
          telaCadastro.setVisible(true);
        this.dispose();
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TabelaCursoGUI curso = new TabelaCursoGUI();
        DefaultTableModel modelo = curso.exibirCursos();
        jTable1.setModel(modelo);
        try {
            exportarTabela("Cursos");
        } catch (IOException ex) {
            Logger.getLogger(TabelaCursoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TabelaCursoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabelaCursoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabelaCursoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabelaCursoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabelaCursoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualizar;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Deletar;
    private javax.swing.JButton Desabilitar;
    private javax.swing.JButton Reabilitar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

