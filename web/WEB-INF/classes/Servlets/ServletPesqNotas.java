package Servlets;

import Controller.ControlImportaNotas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletPesqNotas
  extends HttpServlet
{
  protected void processRequest(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    paramHttpServletResponse.setContentType("text/html;charset=UTF-8");
    PrintWriter localPrintWriter = paramHttpServletResponse.getWriter();
    try
    {
      localPrintWriter.println("<!DOCTYPE html>");
      localPrintWriter.println("<html>");
      localPrintWriter.println("<head>");
      localPrintWriter.println("<title>Servlet ServletPesqNotas</title>");
      localPrintWriter.println("</head>");
      localPrintWriter.println("<body>");
      localPrintWriter.println("<h1>Servlet ServletPesqNotas at " + paramHttpServletRequest.getContextPath() + "</h1>");
      localPrintWriter.println("</body>");
      localPrintWriter.println("</html>");
    }
    finally
    {
      localPrintWriter.close();
    }
  }
  
  protected void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    doPost(paramHttpServletRequest, paramHttpServletResponse);
  }
  
  protected void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws ServletException, IOException
  {
    ControlImportaNotas localControlImportaNotas = new ControlImportaNotas();
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    String str5 = "";
    String str6 = paramHttpServletRequest.getParameter("acao");
    if (str6.equals("pesquisar"))
    {
      str1 = paramHttpServletRequest.getParameter("DtInicial");
      str2 = paramHttpServletRequest.getParameter("DtFinal");
      str3 = paramHttpServletRequest.getParameter("Usuario");
      str4 = paramHttpServletRequest.getParameter("Senha");
      str5 = paramHttpServletRequest.getParameter("DtEntrada");
      paramHttpServletRequest.setAttribute("msg", localControlImportaNotas.verificaDatas(str1, str2));
      paramHttpServletRequest.setAttribute("lista_notas_milano", localControlImportaNotas.pesquisaNotasMilano(str1, str2));
    }
    if (str6.equals("importar"))
    {
      String[] localObject = paramHttpServletRequest.getParameterValues("notas_selecionadas");
      if (localObject != null)
      {
        String str7 = localControlImportaNotas.importaNfSelecionadas((String[])localObject);
        paramHttpServletRequest.setAttribute("msg", str7.replace("\n", "<br>"));
      }
      else
      {
        paramHttpServletRequest.setAttribute("msg", "Realize uma pesquisa e Selecione alguma nota antes de iniciar a importação");
      }
    }
    paramHttpServletRequest.setAttribute("dtinicial", str1);
    paramHttpServletRequest.setAttribute("dtfinal", str2);
    Object localObject = paramHttpServletRequest.getRequestDispatcher("/index.jsp");
    ((RequestDispatcher)localObject).forward(paramHttpServletRequest, paramHttpServletResponse);
  }
  
  public String getServletInfo()
  {
    return "Short description";
  }
}
