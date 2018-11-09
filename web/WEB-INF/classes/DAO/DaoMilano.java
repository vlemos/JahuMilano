package DAO;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoMilano
{
  PreparedStatement stmt;
  ResultSet rs;
  Connection con = null;
  private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
  private final String stringDeConexao = "jdbc:oracle:thin:@//192.168.15.158:1521/MILANO";
  private final String usuario = "jahu-consulta";
  private final String senha = "J#!a@HU##";
  
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
      System.out.println(" erro na conexão com o Banco da Milano " + localException.getMessage());
    }
  }
  
  protected void close()
    throws Exception
  {
    this.con.close();
  }
}
