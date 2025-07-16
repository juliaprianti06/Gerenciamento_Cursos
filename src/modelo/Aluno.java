package modelo;

import java.time.LocalDate;
import javax.swing.JTextField;

public class Aluno {
    private int codigo;
    private String cpf;
    private String nome_aluno;
    private String email;
    private LocalDate data_nascimento;
    private boolean ativo;
    private Curso curso;

    public Aluno(int codigo, String cpf, String nome_aluno, String email, LocalDate data_nascimento) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome_aluno = nome_aluno;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.ativo = true; 
    }
    public Aluno() {
   
}
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        if (nome_aluno != null && nome_aluno.length() >= 3) {
            this.nome_aluno = nome_aluno;
        } else {
            throw new IllegalArgumentException("Nome deve ter no mínimo 3 caracteres.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email inválido.");
        }
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
