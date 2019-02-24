<%-- 
    Document   : infosSpectacle
    Created on : 21 févr. 2019, 12:23:19
    Author     : sedirih
--%>

<%@page import="java.util.List"%>
<%@page import="m2pcci.im2ag.MyTheatre.Models.Representation"%>
<%@page import="m2pcci.im2ag.MyTheatre.Models.Spectacle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Date de representations</title>
        <link href="styles/myTheatre.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Les representations:</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Date</th>
                    <th>Nombre de places disponibles</th>

                </tr>
            </thead>
            <tbody>
                <%
                    List<Spectacle> spectacles = (List<Spectacle>) request.getAttribute("lesSpectacles");
                    for (Spectacle sp : spectacles) {
                        if(spectacles.isEmpty()) { request.setAttribute("message", "Tous les spectacles sont reservés");} 
                %>
                <tr>
                    <td><%=sp.getNomS()%></td> 
                    <td><%=sp.getRepresentation(0).getDateRep()%></td>
                    <td><%=sp.getRepresentation(0).getNbrePlace()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
   <a class="site" href="index.html">chosir une autre date</a>
    </body>
</html>
