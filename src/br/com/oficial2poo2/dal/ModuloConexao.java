
package br.com.oficial2poo2.dal;

import java.sql.*;
        
public class ModuloConexao {
    //método responsável por estabelecer a conexão como banco de dados
    public static Connection conector(){
        Connection conexao = null; 
        //a linha abaixo chama o driver
        String driver = "com.mysql.cj.jdbc.Driver";
        //armazenando informações do banco de dados
        String url = "jdbc:mysql://localhost:3306/bancodedados";
        String user = "root";
        String password = "123456";
        //estabelecendo a conexão com o banco de dados com tratamento de excessão
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            System.err.println("Ops!!! Falha na Conexão com o Banco de Dados.");
            System.err.println(e);
            return null;
        }
            
      
    }
}
