package com.umai.faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.umai.faq.model.service.FaqServiceImple;
import com.umai.faq.model.vo.Faq;

/**
 * Servlet implementation class FaqDeleteController
 */
@WebServlet("/delete.faq")
public class FaqDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Faq faq = new Faq();
		faq.setFaqNum(Integer.parseInt(request.getParameter("dFaqNum")));
		
		int result = new FaqServiceImple().deleteFaq(faq);
		
		HttpSession session = request.getSession();
		if(result>0) {
			session.setAttribute("alertMsg", "FAQ 삭제가 완료되었습니다.");
			response.sendRedirect(request.getContextPath()+"/faqList.faq?cPage=1");
		}else {
			session.setAttribute("alertMsg", "FAQ 삭제에 실패하였습니다.");
			response.sendRedirect(request.getContextPath()+"/faqList.faq?cPage=1");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
