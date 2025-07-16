package modelo;

import java.util.List;

public class Curso {
    private int codigo;
    private String nome;
    private int carga_horaria;
    private int limite_alunos;
    private boolean ativo;
    private List<Aluno> alunos;
    private int qtd_alunos;
    
    
    public Curso(int codigo, String nome, int carga_horaria, int limite_alunos){
        this.codigo = codigo;
        this.nome = nome;
        this.carga_horaria = carga_horaria;
        this.limite_alunos = limite_alunos;
        this.ativo = true;
        
    }

      public Curso() {
    }
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public int getLimite_alunos() {
        return limite_alunos;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCarga_horaria(int carga_horaria) {
       if (carga_horaria >= 20) {
            this.carga_horaria = carga_horaria;
        } else {
            throw new IllegalArgumentException("Carga horária mínima é 20 horas.");
        }
    }

    public void setLimite_alunos(int limite_alunos) {
         if (limite_alunos >= 1) {
            this.limite_alunos = limite_alunos;
        } else {
            throw new IllegalArgumentException("O limite de alunos deve ser no mínimo 1.");
        }
    }
    
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public List<Aluno> getAlunos() { 
        return alunos;
    } 
    public void adicionarAluno(Aluno aluno) {
        if (alunos.size() < limite_alunos) {
            alunos.add(aluno);
        }
    }
    public int getQtd_alunos() {
    return qtd_alunos;
}

    public void setQtd_alunos(int qtd_alunos) {
        this.qtd_alunos = qtd_alunos;
}
  @Override
    public String toString() {
    return this.getNome(); 
}

}
