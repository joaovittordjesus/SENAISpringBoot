package webapp.newsletterjdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
    //Atributps de conexão
    private static final String url = "jdbc:postgresql://localhost:5432/diogotarde";
    private static final String usuario = "postgres"; //Nome do banco de dados
    private static final String senha = "postgres"; //Senha do banco de dados

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e){
            throw new RuntimeException("Erro ao obter conexão com o banco de dados", e);
        }

    }
    
    public static void closeConnection(Connection connection){
        try{
            if(connection != null){
                connection.close();
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    //Metodo para fechar a conexao e o objeto PreparedStatement
    public static void closeConnection(Connection connection, PreparedStatement stmt){
        closeConnection(connection);
        try{
            if(stmt != null){
                stmt.close();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
