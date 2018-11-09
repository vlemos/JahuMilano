package DAO;

import Entity.ImportacaoMilano;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ImportacaoMilanoDao
  extends DaoMilano
{
  public List<ImportacaoMilano> buscarMilano(String paramString1, String paramString2)
  {
    try
    {
      open();
      System.out.print("Conectou BD da Milano ");
      this.stmt = this.con.prepareStatement("select nfv.codfil, nfv.datsai, nfv.datemi, nfv.codsnf, nfv.numnfv, nfv.codcli, nfv.VLRBPR, ide.CHVDOE, nfv.obsnfv from sapiens2.e140nfv nfv inner join sapiens2.e140ipv ipv on nfv.codemp = ipv.codemp and nfv.codfil = ipv.codfil and nfv.numnfv = ipv.numnfv and nfv.codsnf = ipv.codsnf inner join sapiens2.e085cli cli on nfv.codcli = cli.codcli inner join sapiens2.e075pro pro on ipv.codemp = pro.codemp and ipv.codpro = pro.codpro inner join sapiens2.e075der der on ipv.codemp = der.codemp and ipv.codpro = der.codpro and ipv.codder = der.codder left join sapiens2.e140ide ide on nfv.codemp = ide.codemp and nfv.codfil = ide.codfil and nfv.numnfv = ide.numnfv and nfv.codsnf = ide.codsnf where nfv.datemi between ? and ?  and nfv.tnspro in ('5906','5906B') and cli.codcli = 103720 and nfv.codfil = 1 and nfv.sitnfv in (2, 4) group by nfv.codfil, nfv.datsai, nfv.datemi, nfv.codsnf, nfv.numnfv, nfv.codcli, nfv.obsnfv, nfv.VLRBPR, ide.CHVDOE order by nfv.datemi");
      LocalDate localLocalDate1 = LocalDate.parse(paramString1);
      LocalDate localLocalDate2 = LocalDate.parse(paramString2);
      Date localDate1 = Date.valueOf(localLocalDate1);
      Date localDate2 = Date.valueOf(localLocalDate2);
      this.stmt.setDate(1, localDate1);
      this.stmt.setDate(2, localDate2);
      this.rs = this.stmt.executeQuery();
      ArrayList localArrayList = new ArrayList();
      while (this.rs.next()) {
        if (!new ImpPed2JahuDao().verificarSeNotaExiste(Integer.valueOf(this.rs.getInt("numnfv"))).booleanValue())
        {
          ImportacaoMilano localImportacaoMilano = new ImportacaoMilano();
          localImportacaoMilano.setCodfil(Integer.valueOf(this.rs.getInt("codfil")));
          localImportacaoMilano.setDatemi(this.rs.getDate("datemi"));
          localImportacaoMilano.setCodsnf(this.rs.getString("codsnf"));
          localImportacaoMilano.setNumnfv(Integer.valueOf(this.rs.getInt("numnfv")));
          localImportacaoMilano.setCodcli(this.rs.getString("codcli"));
          localImportacaoMilano.setVlrbpr(Float.valueOf(this.rs.getFloat("vlrbpr")));
          localImportacaoMilano.setChvdoe(this.rs.getString("chvdoe"));
          localImportacaoMilano.setObs(this.rs.getString("obsNfv"));
          localArrayList.add(localImportacaoMilano);
        }
      }
      close();
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public List<ImportacaoMilano> buscarItens(Integer paramInteger)
  {
    try
    {
      open();
      String query = "select nfv.codfil, nfv.datsai, nfv.datemi, nfv.codsnf, nfv.numnfv, nfv.codcli, cli.nomcli, cli.apecli, ipv.codpro, ipv.codder, pro.despro, der.desder, ipv.qtdfat, ipv.qtddev, ipv.PREVEN, ide.CHVDOE, nfv.tnspro,  ipv.seqipv from sapiens2.e140nfv nfv inner join sapiens2.e140ipv ipv on (nfv.codemp = ipv.codemp and nfv.codfil = ipv.codfil and nfv.numnfv = ipv.numnfv and nfv.codsnf = ipv.codsnf) inner join sapiens2.e085cli cli on (nfv.codcli = cli.codcli) inner join sapiens2.e075pro pro on (ipv.codemp = pro.codemp and ipv.codpro = pro.codpro) inner join sapiens2.e075der der on (ipv.codemp = der.codemp and ipv.codpro = der.codpro and ipv.codder = der.codder) left join sapiens2.e140ide ide on (nfv.codemp = ide.codemp and nfv.codfil = ide.codfil and nfv.numnfv = ide.numnfv and nfv.codsnf = ide.codsnf) where nfv.datemi between to_date('01/10/2013','DD/MM/YYYY') and sysdate and nfv.tnspro in ('5906','5906B') and nfv.numnfv = ? and nfv.codfil = 1 and cli.codcli = 103720 and nfv.sitnfv in (2, 4)";     
      /*
      String query = "select nfv.codfil, nfv.datsai, nfv.datemi, nfv.codsnf, nfv.numnfv, nfv.codcli, cli.nomcli, cli.apecli, ipv.codpro, ipv.codder, pro.despro, der.desder, ipv.qtdfat, ipv.qtddev, ipv.PREVEN, ide.CHVDOE, nfv.tnspro,  ipv.seqipv from sapiens2.e140nfv nfv inner join sapiens2.e140ipv ipv on nfv.codemp = ipv.codemp and nfv.codfil = ipv.codfil and nfv.numnfv = ipv.numnfv and nfv.codsnf = ipv.codsnf inner join sapiens2.e085cli cli on nfv.codcli = cli.codcli inner join sapiens2.e075pro pro on ipv.codemp = pro.codemp and ipv.codpro = pro.codpro inner join sapiens2.e075der der on ipv.codemp = der.codemp and ipv.codpro = der.codpro and ipv.codder = der.codder left join sapiens2.e140ide ide on nfv.codemp = ide.codemp and nfv.codfil = ide.codfil and nfv.numnfv = ide.numnfv and nfv.codsnf = ide.codsnf and nfv.datemi >= '01/10/2013' and nfv.tnspro = '5906' and nfv.numnfv = ? and nfv.codfil = 1 and cli.codcli = 103720 and nfv.sitnfv in (2, 4)";     
      */
    
      this.stmt = this.con.prepareStatement(query);
      this.stmt.setInt(1, paramInteger);
      this.rs = this.stmt.executeQuery();
      ArrayList localArrayList = new ArrayList();
      while (this.rs.next())
      {
        ImportacaoMilano localImportacaoMilano = new ImportacaoMilano();
        localImportacaoMilano.setCodfil(Integer.valueOf(this.rs.getInt("codfil")));
        localImportacaoMilano.setDatemi(this.rs.getDate("datemi"));
        localImportacaoMilano.setCodsnf(this.rs.getString("codsnf"));
        localImportacaoMilano.setNumnfv(Integer.valueOf(this.rs.getInt("numnfv")));
        localImportacaoMilano.setCodcli(this.rs.getString("codcli"));
        localImportacaoMilano.setCodpro(this.rs.getString("codpro"));
        localImportacaoMilano.setCodder(this.rs.getString("codder"));
        localImportacaoMilano.setQtdfat(this.rs.getDouble("qtdfat"));
        localImportacaoMilano.setPreven(this.rs.getDouble("preven"));
        localImportacaoMilano.setChvdoe(this.rs.getString("chvdoe"));
        localImportacaoMilano.setTnspro(this.rs.getString("tnspro"));
        localImportacaoMilano.setSeqipv(Integer.valueOf(this.rs.getInt("seqipv")));
        localArrayList.add(localImportacaoMilano);
      }
      close();
      return localArrayList;
    }
    catch (Exception localException)
    {
      System.out.println("erro ao buscar os itens " + localException.getMessage());
    }
    return null;
  }
  
  public ImportacaoMilano retornaNome(String paramString1, String paramString2)
  {
    try
    {
      open();
      this.stmt = this.con.prepareStatement("select pro.despro, der.desder from sapiens2.e075pro pro INNER JOIN sapiens2.e075der der ON pro.codpro = der.codpro AND pro.codpro = ? AND der.codder = ?");
      this.stmt.setString(1, paramString1);
      this.stmt.setString(2, paramString2);
      this.rs = this.stmt.executeQuery();
      ImportacaoMilano localImportacaoMilano = new ImportacaoMilano();
      if (this.rs.next())
      {
        localImportacaoMilano.setDespro(this.rs.getString("despro"));
        localImportacaoMilano.setDesder(this.rs.getString("desder"));
      }
      close();
      return localImportacaoMilano;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public ImportacaoMilano buscarNota(int paramInt)
  {
    ImportacaoMilano localImportacaoMilano = new ImportacaoMilano();
    try
    {
      open();
      this.stmt = this.con.prepareStatement("select nfv.codfil, nfv.datsai, nfv.datemi, nfv.codsnf, nfv.numnfv, nfv.codcli, nfv.VLRBPR, ide.CHVDOE, nfv.obsnfv from sapiens2.e140nfv nfv inner join sapiens2.e140ipv ipv on nfv.codemp = ipv.codemp and nfv.codfil = ipv.codfil and nfv.numnfv = ipv.numnfv and nfv.codsnf = ipv.codsnf inner join sapiens2.e085cli cli on nfv.codcli = cli.codcli inner join sapiens2.e075pro pro on ipv.codemp = pro.codemp and ipv.codpro = pro.codpro inner join sapiens2.e075der der on ipv.codemp = der.codemp and ipv.codpro = der.codpro and ipv.codder = der.codder left join sapiens2.e140ide ide on nfv.codemp = ide.codemp and nfv.codfil = ide.codfil and nfv.numnfv = ide.numnfv and nfv.codsnf = ide.codsnf where nfv.tnspro in ('5906','5906B') and nfv.numnfv = ? and cli.codcli = 103720 and nfv.codfil = 1 and nfv.sitnfv in (2, 4) group by nfv.codfil, nfv.datsai, nfv.datemi, nfv.codsnf, nfv.numnfv, nfv.codcli, nfv.obsnfv, nfv.VLRBPR, ide.CHVDOE order by nfv.datemi");
      this.stmt.setInt(1, paramInt);
      this.rs = this.stmt.executeQuery();
      while (this.rs.next())
      {
        localImportacaoMilano.setCodfil(Integer.valueOf(this.rs.getInt("codfil")));
        localImportacaoMilano.setDatemi(this.rs.getDate("datemi"));
        localImportacaoMilano.setCodsnf(this.rs.getString("codsnf"));
        localImportacaoMilano.setNumnfv(Integer.valueOf(this.rs.getInt("numnfv")));
        localImportacaoMilano.setCodcli(this.rs.getString("codcli"));
        localImportacaoMilano.setVlrbpr(Float.valueOf(this.rs.getFloat("vlrbpr")));
        localImportacaoMilano.setChvdoe(this.rs.getString("chvdoe"));
        localImportacaoMilano.setObs(this.rs.getString("obsNfv"));
        String str = this.rs.getString("chvdoe").substring(25, 26);
        localImportacaoMilano.setCodsel(str);
      }
      close();
      return localImportacaoMilano;
    }
    catch (Exception localException)
    {
      System.out.println("erro ao buscar A NF  " + localException.getMessage());
    }
    return null;
  }
}
