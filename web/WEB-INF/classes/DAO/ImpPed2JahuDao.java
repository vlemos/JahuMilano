package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ImpPed2JahuDao
  extends DaoJahu
{
  public Boolean verificarLigacao(String paramString1, String paramString2)
  {
    try
    {
      open();
      this.stmt = this.con.prepareStatement("SELECT codpro FROM E075DER WHERE codpro = ? AND codder = ?");
      this.stmt.setString(1, paramString1);
      this.stmt.setString(2, paramString2);
      this.rs = this.stmt.executeQuery();
      if (this.rs.next())
      {
        close();
        return Boolean.valueOf(true);
      }
      close();
      return Boolean.valueOf(false);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public Boolean verificarSeNotaExiste(Integer paramInteger)
  {
    try
    {
      open();
      this.stmt = this.con.prepareStatement("SELECT nfc.codemp FROM erp.e440nfc nfc WHERE nfc.codfor = 424 AND nfc.tnspro = '1906' AND nfc.CodSnf = 'ENT' AND nfc.numnfc = ?");
      this.stmt.setInt(1, paramInteger.intValue());
      this.rs = this.stmt.executeQuery();
      if (this.rs.next())
      {
        close();
        return Boolean.valueOf(true);
      }
      close();
      return Boolean.valueOf(false);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}
