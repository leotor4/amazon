package model;

import java.time.LocalDate;

public class Autor {
    private String nome;
    private String email;
    private LocalDate dataDeNascimento;
    private String miniCurriculo;

    public Autor(){

    };
    public Autor(String nome, String email, LocalDate dataDeNascimento, String miniCurriculo) {
        this.nome = nome;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
        this.miniCurriculo = miniCurriculo;
    }

    public Autor(String nome, String email, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getMiniCurriculo() {
        return miniCurriculo;
    }

    public void setMiniCurriculo(String miniCurriculo) {
        this.miniCurriculo = miniCurriculo;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                ", miniCurriculo='" + miniCurriculo + '\'' +
                '}';
    }
}
