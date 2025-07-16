package dao;
import factory.ConnectionFactory;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Curso;
public class CursoDAO {
     private Connection connection;
    public CursoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void adiciona(Curso curso){
        String sql = "INSERT INTO curso(curso_nome, carga_horaria, limite_alunos, status_curso) VALUES (?, ?, ?, ?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getCarga_horaria());
            stmt.setInt(3, curso.getLimite_alunos());
            stmt.setBoolean(4, curso.isAtivo());

            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir curso: " + e.getMessage(), e);
        }
    }
     public List<Curso> listarTodos() throws SQLException {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT curso.*, \n" +
       "(SELECT COUNT(*) FROM aluno WHERE aluno.curso_id = curso.curso_id) AS qtd_alunos\n" +
        "FROM curso;";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Curso curso = new Curso();
                curso.setCodigo(rs.getInt("curso_id"));
                curso.setNome(rs.getString("curso_nome"));
                curso.setCarga_horaria(rs.getInt("carga_horaria"));
                curso.setQtd_alunos(rs.getInt("qtd_alunos"));
                curso.setLimite_alunos(rs.getInt("limite_alunos"));
                curso.setAtivo(rs.getBoolean("status_curso"));
                cursos.add(curso);
            }
   }
        return cursos;
    }
     public List<Curso> buscarPorNome(String nome) throws Exception {
    List<Curso> lista = new ArrayList<>();
    String sql = "SELECT * FROM curso WHERE curso_nome LIKE ?";

    try (PreparedStatement pst = connection.prepareStatement(sql)) {
        pst.setString(1, "%" + nome + "%");
        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setCodigo(rs.getInt("curso_id"));
                curso.setNome(rs.getString("curso_nome"));
                curso.setCarga_horaria(rs.getInt("carga_horaria"));
                curso.setLimite_alunos(rs.getInt("limite_alunos"));
                curso.setAtivo(rs.getBoolean("status_curso"));
                lista.add(curso);
            }
        }
    }
    return lista;
}
     public void atualizar(Curso curso) throws SQLException {
        String sql = "UPDATE curso SET curso_nome = ?, carga_horaria = ?, limite_alunos = ?, status_curso = ? WHERE curso_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getCarga_horaria());
            stmt.setInt(3, curso.getLimite_alunos());
            stmt.setBoolean(4, curso.isAtivo());
            stmt.setInt(5, curso.getCodigo());
            stmt.executeUpdate();
        }
    }
    public void deletar(int Id) throws SQLException {
       String sqlDesvincularAlunos = "UPDATE aluno SET curso_id = NULL WHERE curso_id = ?";
       String sqlExcluirCurso = "DELETE FROM curso WHERE curso_id = ?";

        try (Connection conn = new ConnectionFactory().getConnection()) {
            conn.setAutoCommit(false);  

        try (PreparedStatement stmt1 = conn.prepareStatement(sqlDesvincularAlunos);
             PreparedStatement stmt2 = conn.prepareStatement(sqlExcluirCurso)) {

            stmt1.setInt(1, Id);
            stmt1.executeUpdate();

            stmt2.setInt(1, Id);
            int linhasAfetadas = stmt2.executeUpdate();

            if (linhasAfetadas > 0) {
                conn.commit(); 
                JOptionPane.showMessageDialog(null, "Curso deletado com sucesso.");
            } else {
                conn.rollback();  
                JOptionPane.showMessageDialog(null, "Curso não encontrado.");
            }

        } catch (SQLException e) { 
            throw e;
        }
    }
    }
    public void habilitar(int codigo) throws SQLException {
        String sql = "UPDATE curso SET status_curso = TRUE WHERE curso_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        }
    }

    public void desabilitar(int codigo) throws SQLException {
        String sql = "UPDATE curso SET status_curso = FALSE WHERE curso_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        }
    }
    
    public String buscarNomePorId(int cursoId) throws SQLException {
    String sql = "SELECT curso_nome FROM curso WHERE curso_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql))  {
        stmt.setInt(1, cursoId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString("curso_nome");
        }
    }
    return "Curso não encontrado";
}

}
     


