package com.minos.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.minos.bean.Friend;
import com.minos.bean.User;
import com.minos.model.userModel;

/**
 * Servlet implementation class friendService
 */
@WebServlet("/friendService")
public class friendService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public friendService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		userModel model = new userModel();
		List<Friend> friends = new ArrayList<Friend>();       //建立好友列表
		List<String> idList = new ArrayList<String>();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
        String json = bufferedReader.readLine();
        System.out.println(json); 
        String mac = new Gson().fromJson(json, User.class).getMac();
        String friendsJson = model.queryByMac(mac).getFriends();
        Type type = new TypeToken<List<String>>(){}.getType();
        idList = new Gson().fromJson(json,type);
        System.out.println(mac + "的好友有：" + friendsJson + idList.get(0).toString());
        
		String result = "";
		PrintWriter out = response.getWriter();
		
		result = new Gson().toJson(friends);
		System.out.println(result);
		
		out.write(result);
		out.flush();
		out.close();
				
	}

}
