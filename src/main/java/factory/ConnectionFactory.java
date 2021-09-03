package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection conexao;
    private String url ="jdbc:mysql://localhost:3306/amazon";
    private String username = "root";
    private String password = "root";

    public ConnectionFactory(){

    }

    private void connect() throws SQLException {
        this.conexao = DriverManager.getConnection(this.url, username, password);
    }

    public Connection getConexao() throws SQLException {
        if(this.conexao == null){
            connect();
        }
        return conexao;
    }
}
