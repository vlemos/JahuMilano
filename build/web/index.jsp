<%-- 
    Document   : index
    Created on : 15/04/2014, 12:02:27
    Author     : vinicius.lemos
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="sql" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Importaçao Milano/Jahu</title>
        <meta charset="utf-8"/>
        
        <script>
            function mascara(src, mask){
                 var i = src.value.length;
                 var saida = mask.substring(0,1);
                 var texto = mask.substring(i)
                 if (texto.substring(0,1) != saida)
                    {
                        src.value += texto.substring(0,1);
                    }
              }
              
        </script>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
    </head>
    <body>
      <div class="well well-lg">
           <!-- Exibe Mensagem de retorno ao usuario -->
            <% if (!((request.getAttribute("msg") == "") || (request.getAttribute("msg")== null))) { 
             
                              out.println(request.getAttribute("msg")); 
            
            }%>
        
            <hr>
            <form name="pesqdados" method="post" id="pesqdados" action="ServletPesqNotas">
                
                <table border="0">
                    <tr>
                        <td>Data Inicial(Milano):</td>
                        <td><input class="form-control" type="date" name="DtInicial" class="datepicker"  maxlength="10"  value="<% out.print(request.getAttribute("dtinicial"));%>" onkeypress="mascara(this, '##/##/####');"></td>   
                        
                    </tr>
                    <tr>
                        <td>Data Final(Milano):</td>
                        <td><input class="form-control" type="date" name="DtFinal" class="datepicker"  maxlength="10" value="<% out.print(request.getAttribute("dtfinal"));%>" onkeypress="mascara(this, '##/##/####');"></td>   
                    </tr>

                    <tr>
                        <td>Usuario(Jahu):</td>
                        <td><input class="form-control" type="text" name="Usuario">  </td>   
                    </tr>
                    <tr>
                        <td>Senha(Jahu):</td>
                        <td><input  class="form-control" type="password" name="Senha"> </td>   
                    </tr>
                    <tr>
                        <td>Data Entrada(Jahu):</td>
                        <td><input  class="form-control" type="date" name="DtEntrada" maxlength="10" onkeypress="mascara(this,'##/##/####');"> </td>   
                    </tr>
                    <tr>
                        <td>                           
                            <input type="hidden" name="acao" id="acao" value="">
                            <input class="btn btn-lg btn-danger" type="reset" value="Limpar">
                        </td>   
                        <td>
                            <button type="submit" class="btn btn-lg btn-info" onclick="document.pesqdados.acao.value='pesquisar';" >Pesquisar</button>                           
                            <button type="submit"  class="btn btn-lg btn-warning" onclick="document.pesqdados.acao.value='importar';">Importar</button>

                        </td>
                            
                    </tr>
                </table>
                <hr>
                <center>
                    <table border ='2' width='70%' class="table table-hover">
                        <tr>
                            <td width='10%'>  </td> 
                            <td width='20%'><center>Data Emissão</center></td> 
                        <td width='20%'><center>Número da NF</center></td> 
                        <td width='20%'><center>Data Valor</center> </td>
                        </tr>
                        <c:forEach var="lista_notas" items="${lista_notas_milano}">
                            <tr>
                                <td><center><input type="checkbox" name="notas_selecionadas" id="notas_selecionadas" value='${lista_notas.numnfv}' checked="true"></center></td>
                            <td><center>${lista_notas.datemi}</center></td>    
                            <td><center>${lista_notas.numnfv}</center></td>    
                            <td><center>${lista_notas.vlrbpr}</center></td>    
                            </tr>
                        </c:forEach>
                    </table>
                </center>
            </form>  
      </div>
    </body>
</html>
