package com.emc.interview.servlet;

import java.io.IOException;
import java.math.BigInteger;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.emc.interview.fibonacci.Fibonacci;


/**
 * Servlet implementation class FibonacciServlet
 */
public class FibonacciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(FibonacciServlet.class);
	private static String succeededRVSuffix = "],\"code\" : 1000}";
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FibonacciServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long current = System.currentTimeMillis();

		ServletOutputStream out = response.getOutputStream();
		response.setContentType("text/json; charset=UTF-8");

		String s = request.getParameter("n");

		try {
			Validator.validate(s);
		} catch (ValidatorException ve) {
			out.print("{\"code\": " + ve.getCode());
			out.print(",\"message\": \"" + ve.getMessage() + "\"}");
		
			logger.error("n=" + s + "; code=" + ve.getCode() +";IP=" + request.getRemoteAddr() + ";Timecost=" + (System.currentTimeMillis() - current) );
			return;
		}

		out.print("{\"data\":[");

		int n = Integer.parseInt(s);
		int index = 1;
		for (BigInteger i : new Fibonacci(n)) {
			if (index < n) {
				out.print(i + ",");
				index++;
			} else
				out.print(i.toString());
		}
                System.out.print("add by lishunju");
	
		out.print(succeededRVSuffix);
	        System.out.print("add by lishunju");	
		logger.info("n=" + s + "; code=1000" +";IP=" + request.getRemoteAddr() + ";Timecost=" + (System.currentTimeMillis() - current) );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
