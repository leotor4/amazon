package dao;

import model.Autor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {
    private Connection conexao;

    public AutorDAO(Connection conexaoIn){
        this.conexao = conexaoIn;
    }

    public void cadastraAutor(Autor autorIn){
        String insertUrl = "insert into autor(nome, email, datadenascimento, minicurriculo) values(?, ?, ?, ?);";
        try {
            PreparedStatement ps = conexao.prepareStatement(insertUrl);

            ps.setString(1, autorIn.getNome());
            ps.setString(2, autorIn.getEmail());
            ps.setDate(3, Date.valueOf(autorIn.getDataDeNascimento().toString()));
            ps.setString(4, autorIn.getMiniCurriculo());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Autor> listaAutores(){
        List<Autor> autores = new ArrayList<>();
        String queryUrl = "select * from autor;";

        try {
            PreparedStatement ps = conexao.prepareStatement(queryUrl);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Autor autorTmp = new Autor(rs.getString("nome"),
                        rs.getString("email"),
                        rs.getDate("datadenascimento").toLocalDate()
                        );

                autores.add(autorTmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autores;
    }
}
