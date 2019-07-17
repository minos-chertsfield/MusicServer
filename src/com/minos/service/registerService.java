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



/**
 * Servlet implementation class registerService
 */
@WebServlet("/registerService")
public class registerService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public registerService() {
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
		
		boolean flag = false;    //用于判断响应结果
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
 
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
        String json = bufferedReader.readLine();   //读取客户端信息
        System.out.println(json);    //输出Json数据
        
        Gson gson = new Gson();
        String uid = gson.fromJson(json, User.class).getUid();
        String mac = gson.fromJson(json, User.class).getMac();
        
        userModel model = new userModel();
        User user = model.queryByMac(mac);
        if (user!=null) {
			flag = false;
		} else {
			model.insertUser(gson.fromJson(json, User.class));
			flag = true;
		}
        
//        User user = model.queryByUid(uid);     //查询结果
        
        PrintWriter out = response.getWriter();
        String result = "";
        if (flag) {
			result = "success";
		} else {
			result = "fail";
		}
        
        System.out.println(result);
        
        out.write(result);   //返回结果
        out.flush();
        out.close();
	}

}
