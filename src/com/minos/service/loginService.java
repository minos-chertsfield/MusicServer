package com.minos.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.minos.bean.User;
import com.minos.model.userModel;
import com.sun.net.httpserver.Authenticator.Result;



/**
 * Servlet implementation class loginService
 */
@WebServlet("/loginService")
public class loginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public loginService() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
 
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
        String json = bufferedReader.readLine();
        System.out.println(json); 
        
        Gson gson = new Gson();
        String mac = gson.fromJson(json, User.class).getMac();
        String uid = gson.fromJson(json, User.class).getUid();
        String password = gson.fromJson(json, User.class).getPassword();
        
        userModel model = new userModel();
        User user = model.queryByMac(mac);     //查询到对应用户
        
        String result = "";
        PrintWriter out = response.getWriter();
        
        System.out.println("传过来的" + uid);
        System.out.println("数据库的" + user.getUid());
        if (user.getUid().equals(uid) && user.getPassword().equals(password)) {
			result = gson.toJson(user);      //登录成功，回传对象
		} else {
			result = "fail";     //登录失败
		}
        
        out.write(result);
        out.flush();
        out.close();
	}

}
