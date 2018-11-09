package DAO;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoJahu
{
  PreparedStatement stmt;
  ResultSet rs;
  Connection con = null;
  private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
  private final String stringDeConexao = "jdbc:oracle:thin:@//192.168.16.209:1521/dbprod";
  private final String usuario = "SAPCONSULTA";
  private final String senha = "N2r8gmKqBR";

  
  protected void open()
    throws Exception
  {
    try
    {
      Class.forName(DRIVER);
      this.con = DriverManager.getConnection(stringDeConexao, usuario, senha);
    }
    catch (Exception localException)
    {
      System.out.println("Erro na conexão com o Banco da JAHU" + localException.getMessage());
    }
  }
  
  protected void close()
    throws Exception
  {
    this.con.close();
  }
}
