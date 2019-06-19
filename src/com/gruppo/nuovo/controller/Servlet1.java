package com.gruppo.nuovo.controller;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gruppo.nuovo.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/nuovopost.html")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String autore = request.getParameter("autore");
		String titolo = request.getParameter("titolo");
		String testo = request.getParameter("testo");
		
		Connection conn = DbManager.getInstance().getConnection();
		
		try {
		
			String sql = "insert into post(autore, titolo, testo)" + "values ( ? , ? , ? )";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, autore);
			stmt.setString(2, titolo);
			stmt.setString(3, testo);
			ResultSet set = stmt.executeQuery();
			
			request.getRequestDispatcher("view/successo.jsp").forward(request, response);
			
		} catch(SQLException ex) {
			Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		
		
	
	}

}
