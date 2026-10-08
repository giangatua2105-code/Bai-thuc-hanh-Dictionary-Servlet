package com.codegym;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DictionaryServlet", urlPatterns = {"/translate"})
public class DictionaryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chao");
        dictionary.put("how", "The nao");
        dictionary.put("book", "Quyen sach");
        dictionary.put("computer", "May tinh");
        dictionary.put("student", "Sinh vien");
        dictionary.put("teacher", "Giao vien");
        dictionary.put("school", "Truong hoc");

        String searchWord = request.getParameter("word");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>Ket qua</title>");
            out.println("<style>body{font-family:Arial;display:flex;justify-content:center;align-items:center;min-height:100vh;background:linear-gradient(135deg,#667eea,#764ba2);margin:0;}.box{background:white;padding:40px;border-radius:12px;box-shadow:0 20px 40px rgba(0,0,0,0.2);text-align:center;min-width:350px;}a{display:inline-block;margin-top:20px;padding:10px 20px;background:#1b2a7a;color:white;text-decoration:none;border-radius:6px;}</style>");
            out.println("</head><body><div class='box'>");
            
            if (searchWord != null && !searchWord.trim().isEmpty()) {
                String result = dictionary.get(searchWord.trim().toLowerCase());
                
                if (result != null) {
                    out.println("<h2 style='color:#1b2a7a;'>Tu khoa: " + searchWord + "</h2>");
                    out.println("<h3 style='color:#27ae60;'>Nghia: " + result + "</h3>");
                } else {
                    out.println("<h2 style='color:red;'>Khong tim thay tu: " + searchWord + "</h2>");
                }
            } else {
                out.println("<h2 style='color:orange;'>Vui long nhap tu khoa!</h2>");
            }
            
            out.println("<a href='index.jsp'>Quay lai</a>");
            out.println("</div></body></html>");
        }
    }
}