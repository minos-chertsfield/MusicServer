package com.minos.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.minos.bean.MusicInfo;
import com.minos.model.musicModel;

/**
 * Servlet implementation class discoverService
 */
@WebServlet("/discoverService")
public class discoverService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public discoverService() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		
		
		musicModel model = new musicModel();
		List<MusicInfo> musicInfos = model.queryAll();
		
		String result = "";
		PrintWriter out = response.getWriter();
		
		result = new Gson().toJson(musicInfos);
		System.out.println(result);
		
		out.write(result);
		out.flush();
		out.close();
		
	}

}
