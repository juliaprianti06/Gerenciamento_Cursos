package dao;
import factory.ConnectionFactory;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Aluno;
import modelo.Curso;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;


public class AlunoDAO {
     private Connection connection;
    public AlunoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
     public void adiciona(Aluno aluno) throws SQLException {
    String sqlVerifica = "SELECT " +
                        "(SELECT COUNT(*) FROM aluno WHERE curso_id = ?) AS total_alunos, " +
                        "(SELECT limite_alunos FROM curso WHERE curso_id = ?) AS limite_alunos";

    try (PreparedStatement stmtVerifica = connection.prepareStatement(sqlVerifica)) {
        int cursoId = aluno.getCurso().getCodigo();
        stmtVerifica.setInt(1, cursoId);
        stmtVerifica.setInt(2, cursoId);
        ResultSet rs = stmtVerifica.executeQuery();

        if (rs.next()) {
            int totalAlunos = rs.getInt("total_alunos");
            int limite = rs.getInt("limite_alunos");

            if (totalAlunos >= limite) {
                throw new SQLException("O curso já atingiu o limite de alunos permitidos");
            }
        } else {
            throw new SQLException("Curso não encontrado");
        }
    }

    String sql = "INSERT INTO aluno (cpf, nome_aluno, email, data_nascimento, status_aluno, curso_id) " +
                 "VALUES (?, ?, ?, ?, ?, ?)";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, aluno.getCpf());
        stmt.setString(2, aluno.getNome_aluno());
        stmt.setString(3, aluno.getEmail());
        stmt.setDate(4, Date.valueOf(aluno.getData_nascimento()));
        stmt.setBoolean(5, aluno.isAtivo());
        stmt.setInt(6, aluno.getCurso().getCodigo());
        stmt.executeUpdate();
    }
}


      public List<Aluno> listarTodos() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT a.*, c.curso_nome FROM aluno a LEFT JOIN curso c ON a.curso_id = c.curso_id";
        try (Connection conn = new ConnectionFactory().getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()
      ) {

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setCodigo(rs.getInt("aluno_id"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setNome_aluno(rs.getString("nome_aluno"));
                aluno.setEmail(rs.getString("email"));
                aluno.setData_nascimento(rs.getDate("data_nascimento").toLocalDate());
                aluno.setAtivo(rs.getBoolean("status_aluno"));
                alunos.add(aluno);
                
                Curso curso = new Curso();
                curso.setCodigo(rs.getInt("curso_id"));
                curso.setNome(rs.getString("curso_nome"));
                aluno.setCurso(curso);
            }
        }
        return alunos;
    }
 
    public List<Aluno> buscaAluno(String termo) throws SQLException {
    List<Aluno> lista = new ArrayList<>();
    String sql = "SELECT * FROM aluno WHERE nome_aluno LIKE ? OR cpf LIKE ?";

    try (Connection conn = new ConnectionFactory().getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        String likeTerm = "%" + termo + "%";
        stmt.setString(1, likeTerm);
        stmt.setString(2, likeTerm);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Aluno aluno = new Aluno();
            aluno.setCodigo(rs.getInt("aluno_id"));
            aluno.setNome_aluno(rs.getString("nome_aluno"));
            aluno.setCpf(rs.getString("cpf"));
            aluno.setEmail(rs.getString("email"));
            aluno.setData_nascimento(rs.getDate("data_nascimento").toLocalDate());
            aluno.setAtivo(rs.getBoolean("status_aluno"));
            aluno.setCodigo(rs.getInt("curso_id")); 
            lista.add(aluno);
        }
    }
    return lista;
}
 
    public boolean atualizarAluno(Aluno aluno) {
        String sqlVerifica = "SELECT COUNT(*) AS total, c.limite_alunos " +
                             "FROM aluno a JOIN curso c ON a.curso_id = c.curso_id " +
                             "WHERE c.curso_id = ? AND a.aluno_id != ?";

        try (Connection conn = new ConnectionFactory().getConnection()) {
            try (PreparedStatement stmtVerifica = conn.prepareStatement(sqlVerifica)) {
                stmtVerifica.setInt(1, aluno.getCurso().getCodigo());
                stmtVerifica.setInt(2, aluno.getCodigo());
                ResultSet rs = stmtVerifica.executeQuery();

                if (rs.next()) {
                    int totalAlunos = rs.getInt("total");
                    int limite = rs.getInt("limite_alunos");

                    if (totalAlunos >= limite) {
                        JOptionPane.showMessageDialog(null, "O curso já atingiu o limite de alunos permitidos.Tente novamente");
                        return false;
                    }
                }
            }

            String sql = "UPDATE aluno SET nome_aluno = ?, email = ?, data_nascimento = ?, status_aluno = ?, curso_id = ? WHERE aluno_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, aluno.getNome_aluno());
                stmt.setString(2, aluno.getEmail());
                if (aluno.getData_nascimento() != null) {
                    stmt.setDate(3, java.sql.Date.valueOf(aluno.getData_nascimento()));
                } else {
                    stmt.setNull(3, java.sql.Types.DATE);
                }
                stmt.setBoolean(4, aluno.isAtivo());
                stmt.setInt(5, aluno.getCurso().getCodigo());
                stmt.setInt(6, aluno.getCodigo());
                stmt.executeUpdate();
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar aluno: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
}


    public void deletarAluno(int Id) {
        String sql = "DELETE FROM aluno WHERE aluno_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, Id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar aluno: " + e.getMessage(), e);
        }
    }

       public void desabilitarAluno(String cpf) {
            String sql = "UPDATE aluno SET status_aluno = FALSE WHERE cpf = ?";
            try (Connection conn = new ConnectionFactory().getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, cpf); 
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
     }

      public void reabilitarAluno(int idAluno) {
        String sql = "UPDATE aluno SET status_aluno = true WHERE aluno_id = ?";
        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idAluno);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
      public DefaultTableModel carregarAlunos(int status) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Nome", "CPF", "Email", "Data de Nascimento", "Status", "Curso"});

     String sql = "SELECT aluno.*, curso.curso_nome " +
                 "FROM aluno " +
                 "LEFT JOIN curso ON aluno.curso_id = curso.curso_id " +
                 "WHERE aluno.status_aluno = ?";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, status);  
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("aluno_id"),
                rs.getString("nome_aluno"),
                rs.getString("cpf"),
                rs.getString("email"),
                rs.getDate("data_nascimento"),
                (rs.getInt("status_aluno") == 1 ? "Ativo" : "Inativo"),
                rs.getString("curso_nome")
            });
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao carregar alunos: " + e.getMessage());
    }

    return model;
}


        public void removerAluno(String cpf){
        String sql = "UPDATE aluno SET curso_id = NULL WHERE cpf = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public class ValidoCPF {

    public static boolean isCpfValido(String cpf) {
        CPFValidator validator = new CPFValidator();
        try {
            validator.assertValid(cpf); 
            return true;
        } catch (InvalidStateException e) {
            return false;
        }
    }
}


}
