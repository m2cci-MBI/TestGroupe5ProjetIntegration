<%-- 
    Document   : nomSpectacle
    Created on : Feb 22, 2019, 12:08:29 PM
    Author     : Mouddy
--%>

<%@page import="java.util.List"%>
<%@page import="m2pcci.im2ag.MyTheatre.Models.Representation"%>
<%@page import="m2pcci.im2ag.MyTheatre.Models.Spectacle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nom de spectacle</title>
        <link href="styles/myTheatre.css" rel="stylesheet" type="text/css"/>
       
    </head>
    <body>
           <h1>Les representations correspondantes à votre choix:</h1>

        <table>
            <thead>
                <tr>
                    <th>Nom de spectacle</th>
                    <th>Date de representation</th>
                   

                </tr>
            </thead>
            <tbody>
                <%
                    List<Spectacle> spectacles = (List<Spectacle>) request.getAttribute("leSpectacle");
                    for (Spectacle sp : spectacles) {
                      
                %>
                <tr>
                    <td><%=sp.getNomS()%></td> 
                    <td><%=sp.getRepresentation(0).getDateRep()%></td>
                
                </tr>
                <%
                    }
                %>
                </tbody>
                   </table>
                <a class="site" href="index.html">chosir un autre spectacle</a>
    </body>
</html>
