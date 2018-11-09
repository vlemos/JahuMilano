package DAO;

import Entity.ImportacaoMilano;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

public class SID
{
  Logger logger = Logger.getLogger("lopes");
  
  public String gravarCabecalho(ImportacaoMilano paramImportacaoMilano)
  {
    String str1 = "";
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
      URL localURL = new URL("http://sapiensmid/sapiensweb/conector?SIS=CO&LOGIN=SID&ACAO=EXESENHA&NOMUSU=ImpJahuMilano&SENUSU=myGs5bjVnj&PROXACAO=SID.NFC.GRAVAR&CODFOR=424&NUMNFC=" + paramImportacaoMilano.getNumnfv() + "&TipNfe=5&CODSNF=ENT&TNSPRO=1906&DATENT=" + localSimpleDateFormat.format(paramImportacaoMilano.getDatemi()) + "&DATEMI=" + localSimpleDateFormat.format(paramImportacaoMilano.getDatemi()) + "&VLRINF=" + paramImportacaoMilano.getVlrbpr() + "&CHVNEL=" + paramImportacaoMilano.getChvdoe() +"&CODSEL=1");
      this.logger.info(localURL.toString());
      URLConnection localURLConnection = localURL.openConnection();
      localURLConnection.setDoOutput(true);
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(localURLConnection.getOutputStream());
      localOutputStreamWriter.flush();
      InputStreamReader localInputStreamReader = new InputStreamReader(localURLConnection.getInputStream());
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
        Object localObject1 = null;
        try
        {
          str1 = str1 + "retorno Gravação do Cabeçalho \n";
          String str2 = "";
          while ((str2 = localBufferedReader.readLine()) != null)
          {
            this.logger.info(str2);
            str1 = str1 + str2 + "\n";
          }
          localBufferedReader.close();
        }
        catch (Throwable localThrowable2)
        {
          localObject1 = localThrowable2;
          throw localThrowable2;
        }
        finally
        {
          if (localBufferedReader != null) {
            if (localObject1 != null) {
              try
              {
                localBufferedReader.close();
              }
              catch (Throwable localThrowable3)
              {
                ((Throwable)localObject1).addSuppressed(localThrowable3);
              }
            } else {
              localBufferedReader.close();
            }
          }
        }
      }
      catch (Exception localException2)
      {
        throw new Exception(localException2.getMessage());
      }
    }
    catch (Exception localException1)
    {
      System.out.println("Erro Ao gravar Cabeçalho da NF " + localException1.getMessage());
    }
    return str1;
  }
  
  public String gravarItem(ImportacaoMilano paramImportacaoMilano)
  {
    String str1 = "";
    try
    {
      URL localURL = new URL("http://sapiensmid/sapiensweb/conector?SIS=CO&LOGIN=SID&ACAO=EXESENHA&NOMUSU=ImpJahuMilano&SENUSU=myGs5bjVnj&PROXACAO=SID.NFC.GRAVARPRODUTO&CODFOR=424&NUMNFC=" + paramImportacaoMilano.getNumnfv() + "&CODSNF=ENT&TNSPRO=1906&CODPRO=" + paramImportacaoMilano.getCodpro() + "&CODDER=" + paramImportacaoMilano.getCodder() + "&QTDREC=" + paramImportacaoMilano.getQtdfat() + "&PREUNI=" + paramImportacaoMilano.getPreven() + "&SEQIPC=" + paramImportacaoMilano.getSeqipv() + "&CODDEP=402&CODENQ=999");
      this.logger.info(localURL.toString());
      URLConnection localURLConnection = localURL.openConnection();
      localURLConnection.setDoOutput(true);
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(localURLConnection.getOutputStream());
      localOutputStreamWriter.flush();
      InputStreamReader localInputStreamReader = new InputStreamReader(localURLConnection.getInputStream());
      BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
      str1 = str1 + "retorno da gravação dos itens  \n";
      String str2 = "";
      while ((str2 = localBufferedReader.readLine()) != null)
      {
        str1 = str1 + str2 + "\n";
        this.logger.info(str2);
      }
      localBufferedReader.close();
    }
    catch (Exception localException)
    {
      System.out.println("Erro ao Gravar Itens " + localException.getMessage());
    }
    return str1;
  }
  
  public void fecharNota(String paramString1, String paramString2)
  {
    try
    {
      URL localURL = new URL("http://ntmasan.masan.com.br/sapiensweb/conector.exe?SIS=CO&LOGIN=SID&ACAO=EXESENHA&NOMUSU=amor61&SENUSU=2fd6zded&PROXACAO=SID.Nfc.Fechar&CODFOR=145&CODSNF=" + paramString1 + "&NUMNFC=" + paramString2);
      System.out.println(localURL.toString());
      URLConnection localURLConnection = localURL.openConnection();
      localURLConnection.setDoOutput(true);
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(localURLConnection.getOutputStream());
      localOutputStreamWriter.flush();
      InputStreamReader localInputStreamReader = new InputStreamReader(localURLConnection.getInputStream());
      BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
      System.out.println("\n** retorno da página web (Nota) **");
      String str = "";
      while ((str = localBufferedReader.readLine()) != null) {
        System.out.println(str);
      }
      localBufferedReader.close();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void selecionaFilial(Integer paramInteger)
  {
    try
    {
      URL localURL = new URL("http://sapiensmid/sapiensweb/conector?SIS=CO&LOGIN=SID&ACAO=EXESENHA&NOMUSU=ImpJahuMilano&SENUSU=myGs5bjVnj&PROXACAO=SID.SRV.ALTEMPFIL&CODEMP=1&CODFIL=" + paramInteger);
      URLConnection localURLConnection = localURL.openConnection();
      localURLConnection.setDoOutput(true);
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(localURLConnection.getOutputStream());
      localOutputStreamWriter.flush();
      InputStreamReader localInputStreamReader = new InputStreamReader(localURLConnection.getInputStream());
      BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
      String str = "";
      while ((str = localBufferedReader.readLine()) != null) {
        System.out.println(str);
      }
      localBufferedReader.close();
    }
    catch (Exception localException)
    {
      System.out.println("Erro Ao selecionar Filial 1 " + localException.getMessage());
    }
  }
}
