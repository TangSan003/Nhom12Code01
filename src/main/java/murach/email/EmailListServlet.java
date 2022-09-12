/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bao
 */
package murach.email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import murach.business.User;
import murach.data.UserDB;

public class EmailListServlet extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                          throws ServletException, IOException
    {
        String url = "/index.html";
        String action = request.getParameter("action");
        if (action==null)
        {
            action = "join";
        }
        if (action.equals("join"))
        {
            url = "/index.html";
        }
        else if (action.equals("add"))
        {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            
            User user = new User(firstName, lastName, email);
            UserDB.insert(user);
            
            request.setAttribute("user",user);
            url = "thanks.jsp";
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }   
}

