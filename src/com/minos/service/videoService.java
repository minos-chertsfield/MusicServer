package com.minos.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.minos.bean.VideoInfo;
import com.minos.model.videoModel;

/**
 * Servlet implementation class videoService
 */
@WebServlet("/videoService")
public class videoService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public videoService() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		videoModel model = new videoModel();
		List<VideoInfo> videoInfos = model.queryAll();
		
		String result = "";
		PrintWriter out = response.getWriter();
		
		result = new Gson().toJson(videoInfos);
		System.out.println(result);
		
		out.write(result);
		out.flush();
		out.close();
		
	}

}
