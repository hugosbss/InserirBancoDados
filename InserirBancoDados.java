package inserirbancodados;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirBancoDados {
    static final String banco = "jdbc:mysql://localhost:3306/concessionaria";
    public static void main (String [] args){
        Connection conexao = null;
        Statement consulta = null;
        ResultSet resultados = null;
        PreparedStatement minhainclusao = null;
        try {
        conexao = DriverManager.getConnection(banco, "root" , "");
        consulta = conexao.createStatement();
        resultados = consulta.executeQuery("Select * from veiculo");
        
        ResultSetMetaData colunas = resultados.getMetaData();
        int numeroColunas = colunas.getColumnCount();
        
        System.out.println("informações do Banco de Dados");
        minhainclusao = conexao.prepareStatement("insert into veiculo(descricao, fabricante) values (?,?)");
        
        String descricao = JOptionPane.showInputDialog(null, "Informe a descrição do veiculo");
        String fabricante = JOptionPane.showInputDialog(null, "Informe o fabricante do veiculo");
        
        minhainclusao.setString(1, descricao);
        minhainclusao.setString(2, fabricante);
        
        minhainclusao.executeUpdate();
        
        for (int i=1; i <= numeroColunas; i++ )
            System.out.println(colunas.getColumnName(i));
        while (resultados.next()) {
        for (int i=1; i <= numeroColunas; i++ )
            System.out.println(resultados.getString(i));
        }
        }
        catch (SQLException erro){
        erro.printStackTrace();
        }
        finally {
        try {
        resultados.close();
        consulta.close();
        conexao.close();
        }
        catch (Exception erronovo) {
            erronovo.printStackTrace();
        }
        }
    }    
}