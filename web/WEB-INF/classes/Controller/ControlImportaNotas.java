package Controller;

import DAO.ImpPed2JahuDao;
import DAO.ImportacaoMilanoDao;
import DAO.SID;
import Entity.ImportacaoMilano;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ControlImportaNotas
{
  public List<ImportacaoMilano> pesquisaNotasMilano(String paramString1, String paramString2)
  {
    List localList = null;
    System.out.println(" **************************************** " + paramString1);
    System.out.println("***************************************** " + paramString2);
    System.out.println(" **************************************** " + paramString1);
    System.out.println("***************************************** " + paramString2);
    ImportacaoMilanoDao localImportacaoMilanoDao = new ImportacaoMilanoDao();
    localList = localImportacaoMilanoDao.buscarMilano(paramString1, paramString2);
    return localList;
  }
  
  public String verificaDatas(String paramString1, String paramString2)
  {
    String str = "";
    if ((paramString1.isEmpty()) || (paramString1.equals(""))) {
      str = str + "Data Inicial Vazia ou Invalida ";
    }
    if ((paramString2.isEmpty()) || (paramString2.equals(""))) {
      str = str + "Data Final Vazia ou Invalida ";
    }
    return str;
  }
  
  public String importaNfSelecionadas(String[] paramArrayOfString)
  {
    String str1 = "";
    int i = 0;
    for (String str2 : paramArrayOfString)
    {
      i = Integer.parseInt(str2.toString());
      str1 = str1 + "Pegando dados da NF " + str2.toString() + "\n ";
      ImportacaoMilano localImportacaoMilano1 = new ImportacaoMilano();
      localImportacaoMilano1 = new ImportacaoMilanoDao().buscarNota(i);
      str1 = str1 + "Pegando itens da NF " + str2.toString() + "\n ";
      Object localObject1 = new ArrayList();
      localObject1 = new ImportacaoMilanoDao().buscarItens(Integer.valueOf(i));
      int m = 0;
      int n = 0;
      String[] arrayOfString2 = new String[((List)localObject1).size()];
      String[] arrayOfString3 = new String[((List)localObject1).size()];
      str1 = str1 + "Inicia verificação de ligação dos Produtos com Derivação \n ";
      for (int i1 = 0; i1 < ((List)localObject1).size(); i1++) {
        if (!new ImpPed2JahuDao().verificarLigacao(((ImportacaoMilano)((List)localObject1).get(i1)).getCodpro(), ((ImportacaoMilano)((List)localObject1).get(i1)).getCodder()).booleanValue())
        {
          m = 1;
          arrayOfString2[n] = ((ImportacaoMilano)((List)localObject1).get(i1)).getCodpro();
          arrayOfString3[n] = ((ImportacaoMilano)((List)localObject1).get(i1)).getCodder();
          n++;
        }
      }
      Object localObject3;
      if (m != 1)
      {
        str1 = str1 + "Produtos OK... Inicia Gravação da NF na Filial 1 \n ";
        new SID().selecionaFilial(Integer.valueOf(1));
        str1 = str1 + new SID().gravarCabecalho(localImportacaoMilano1);
        Object localObject2 = new ArrayList();
        localObject2 = new ImportacaoMilanoDao().buscarItens(Integer.valueOf(i));
        str1 = str1 + "Inicia Gravação dos Itens \n";
        localObject3 = ((List)localObject2).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ImportacaoMilano localImportacaoMilano2 = (ImportacaoMilano)((Iterator)localObject3).next();
          str1 = str1 + new SID().gravarItem(localImportacaoMilano2) + "\n";
        }
        new SID().selecionaFilial(Integer.valueOf(1));
      }
      else
      {
        for (int i2 = 0; i2 < n; i2++) {
          localObject3 = new ImportacaoMilanoDao().retornaNome(arrayOfString2[i2], arrayOfString3[i2]);
        }
      }
    }
    return str1;
  }
}
