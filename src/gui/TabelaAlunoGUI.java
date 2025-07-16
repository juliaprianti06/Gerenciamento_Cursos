package gui;

import dao.AlunoDAO;
import dao.CursoDAO;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Aluno;
import modelo.Curso;

public class TabelaAlunoGUI extends javax.swing.JFrame {

   
    public TabelaAlunoGUI() throws SQLException {
        initComponents();
        setResizable(false);
        carregarTabela();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void carregarTabela() throws SQLException {
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
    modelo.setRowCount(0); 
    
    CursoDAO cursoDAO = new CursoDAO();
    List<Curso> listaCursos = cursoDAO.listarTodos();

    AlunoDAO dao = new AlunoDAO();
    List<Aluno> lista = dao.listarTodos();

    for (Aluno aluno : lista) {
        modelo.addRow(new Object[]{
            aluno.getCodigo(),
            aluno.getNome_aluno(),
            aluno.getCpf(),
            aluno.getEmail(),
            aluno.getData_nascimento(),
            aluno.isAtivo() ? "Ativo" : "Inativo",
            aluno.getCurso().getNome()
            
        });
    }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Busca = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        Atualizar = new javax.swing.JButton();
        Deletar = new javax.swing.JButton();
        Reabilitar = new javax.swing.JButton();
        Desabilitar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Relatório dos alunos ativos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Relatório dos alunos inativos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(153, 153, 153));
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome do Aluno", "CPF", "Email", "Data de Nascimento", "Status", "Curso do Aluno"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Busca:");

        Busca.setBackground(new java.awt.Color(204, 204, 204));
        Busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaActionPerformed(evt);
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

        Atualizar.setBackground(new java.awt.Color(0, 0, 0));
        Atualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Atualizar.setForeground(new java.awt.Color(255, 255, 255));
        Atualizar.setText("Atualizar");
        Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Busca, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Buscar)
                .addGap(28, 28, 28)
                .addComponent(Atualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Deletar)
                .addGap(36, 36, 36)
                .addComponent(Reabilitar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Desabilitar)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(114, 114, 114))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Busca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Reabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Desabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

   
       String formato = "%-5s %-20s %-15s %-30s %-12s %-8s %-20s%n";
            w.write(String.format(formato,
            model.getColumnName(0),
            model.getColumnName(1),
            model.getColumnName(2),
            model.getColumnName(3),
            model.getColumnName(4),
            model.getColumnName(5),
            model.getColumnName(6)
        ));

        w.write("\n");

        for (int i = 0; i < model.getRowCount(); i++) {
            w.write(String.format(formato,
                model.getValueAt(i, 0),
                model.getValueAt(i, 1),
                model.getValueAt(i, 2),
                model.getValueAt(i, 3),
                model.getValueAt(i, 4),
                model.getValueAt(i, 5),
                model.getValueAt(i, 6)
            ));
        }
            
        JOptionPane.showMessageDialog(null, "Tabela exportada com sucesso para:\n" + txt.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
    }    
    private void BuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaActionPerformed
       
    }//GEN-LAST:event_BuscaActionPerformed

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
        int linha = jTable1.getSelectedRow();
        if (linha == -1) {
            return;
        }
        int codigo = (int) jTable1.getValueAt(linha, 0);
        String nome_aluno = (String) jTable1.getValueAt(linha, 1);
        String cpf = (String) jTable1.getValueAt(linha, 2);
        String email = (String) jTable1.getValueAt(linha, 3);
        Object dataObj = jTable1.getValueAt(linha, 4);
        LocalDate dataNascimento;

        if (dataObj instanceof LocalDate) {
            dataNascimento = (LocalDate) dataObj;
        } else if (dataObj instanceof String) {
            dataNascimento = LocalDate.parse((String) dataObj);
        } else {
            throw new IllegalArgumentException("Formato de data inválido");
        }

        String statusStr = (String) jTable1.getValueAt(linha, 5);
        boolean ativo = "Ativo".equals(statusStr);
        String nome_curso = (String) jTable1.getValueAt(linha, 6);

    try {
        String novoNome = JOptionPane.showInputDialog(this, "Atualize o nome do aluno:", nome_aluno);
        if (novoNome == null || novoNome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo nome não pode ser vazio.Preencha novamente");
            return;
        }

        String novoEmail = JOptionPane.showInputDialog(this, "Atualize o email:", email);
        if (novoEmail == null || novoEmail.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O email não pode ser vazio.Preencha novamente");
            return;
        }

        String novaData = JOptionPane.showInputDialog(this, "Atualize a data de nascimento (AAAA-MM-DD):", dataNascimento.toString());
        if (novaData == null || novaData.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "A data de nascimento não pode ser vazia. Preencha novamente");
            return;
        }

        LocalDate novaDataNascimento;
        try {
            novaDataNascimento = LocalDate.parse(novaData.trim());
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Use AAAA-MM-DD");
            return;
        }

        String nomeCurso = JOptionPane.showInputDialog(this, "Atualize o curso do aluno:", nome_curso);
        if (nomeCurso == null || nomeCurso.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O nome do curso não pode ser vazio.Preencha novamente");
            return;
        }
       
        CursoDAO cursoDAO = new CursoDAO();
        List<Curso> cursos = cursoDAO.buscarPorNome(nomeCurso);
        Curso curso = cursos.get(0);

        if (curso == null) {
            JOptionPane.showMessageDialog(this, "Curso não encontrado: " + nomeCurso);
            return;
        }

       
        Aluno aluno = new Aluno();
        aluno.setCodigo(codigo);
        aluno.setNome_aluno(novoNome);
        aluno.setEmail(novoEmail);
        aluno.setData_nascimento(novaDataNascimento);
        aluno.setAtivo(ativo);
        aluno.setCurso(curso);

         boolean atualizado = new AlunoDAO().atualizarAluno(aluno);
         if (atualizado) {
             carregarTabela(); 
             JOptionPane.showMessageDialog(this, "Aluno atualizado com sucesso!");
         }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao atualizar o aluno: " + e.getMessage());
        e.printStackTrace();
    }


    }//GEN-LAST:event_AtualizarActionPerformed

    private void DeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarActionPerformed
        int linhaSelecionada = jTable1.getSelectedRow();

    if (linhaSelecionada != -1) {
        int idAluno = (int) jTable1.getValueAt(linhaSelecionada, 0); 

        int confirm = JOptionPane.showConfirmDialog(this,
                "Deseja realmente excluir o aluno com ID " + idAluno + "?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            AlunoDAO dao = new AlunoDAO();
            dao.deletarAluno(idAluno);
            JOptionPane.showMessageDialog(this, "Aluno excluído com sucesso!");
            try { 
                carregarTabela();
            } catch (SQLException ex) {
                Logger.getLogger(TabelaAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um aluno para excluir");
        }
    }//GEN-LAST:event_DeletarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
         try {
            String termo = Busca.getText();
            AlunoDAO dao = new AlunoDAO();
            List<Aluno> lista = dao.buscaAluno(termo);

            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);

            CursoDAO cursoDAO = new CursoDAO();

            for (Aluno aluno : lista) {
                String nomeCurso = cursoDAO.buscarNomePorId(aluno.getCodigo());
                modelo.addRow(new Object[]{
                    aluno.getCodigo(),
                    aluno.getNome_aluno(),
                    aluno.getCpf(),
                    aluno.getEmail(),
                    aluno.getData_nascimento(),
                    aluno.isAtivo() ? "Ativo" : "Inativo",
                    nomeCurso
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar aluno: " + ex.getMessage());
        }
    }//GEN-LAST:event_BuscarActionPerformed

    private void ReabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReabilitarActionPerformed
        int linhaSelecionada = jTable1.getSelectedRow();

    if (linhaSelecionada != -1) {
        int idAluno = (int) jTable1.getValueAt(linhaSelecionada, 0);
        AlunoDAO dao = new AlunoDAO();
        try {
            dao.reabilitarAluno(idAluno);
            JOptionPane.showMessageDialog(this, "Aluno reabilitado com sucesso");
            carregarTabela();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao reabilitar aluno: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um aluno para reabilitar");
    }
    }//GEN-LAST:event_ReabilitarActionPerformed

    private void DesabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesabilitarActionPerformed
        int linhaSelecionada = jTable1.getSelectedRow();
        if (linhaSelecionada != -1) {
            String cpf = (String) jTable1.getValueAt(linhaSelecionada, 2); 
            AlunoDAO dao = new AlunoDAO();
        try {
            dao.desabilitarAluno(cpf); 
            dao.removerAluno(cpf);
            JOptionPane.showMessageDialog(this, "Aluno desabilitado com sucesso");
            carregarTabela();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao desabilitar aluno: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um aluno para desabilitar");
    }


    }//GEN-LAST:event_DesabilitarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       AlunoDAO alunoDAO = new AlunoDAO();
       DefaultTableModel modelo = alunoDAO.carregarAlunos(1); 
       jTable1.setModel(modelo);
       try {
            exportarTabela("ativo");
        } catch (IOException ex) {
            Logger.getLogger(TabelaAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       AlunoDAO alunoDAO = new AlunoDAO();
       DefaultTableModel modelo = alunoDAO.carregarAlunos(0); 
       jTable1.setModel(modelo);
        try {
            exportarTabela("inativo");
        } catch (IOException ex) {
            Logger.getLogger(TabelaAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TabelaAlunoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabelaAlunoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabelaAlunoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabelaAlunoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TabelaAlunoGUI().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TabelaAlunoGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualizar;
    private javax.swing.JTextField Busca;
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
    // End of variables declaration//GEN-END:variables
}
