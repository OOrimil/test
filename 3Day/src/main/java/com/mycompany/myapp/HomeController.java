package com.mycompany.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 * @Controller�� ��Ʈ�ѷ��� �����Ǿ� �ִ� �κ��� Ȯ����.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//�α׸� ����� ���� �ʵ�.
	/**
	 * Simply selects the home view to render by returning its name.
	 * URL : http://localhost:8081/myapp/WEB-INF/views/home.jsp
	 * �������� : http
	 * ������ �ּ� : localhost
	 * ��� ��Ʈ : 8081
	 * ��� ���� : myapp
	 * URI : /WEB-INF/views/home.jsp
	 * 
	 * @RequestMapping�� URI�� ã�� ���̴�. 
	 * �� URI�κ��� ���� value�κа� ������ �ش� �޼ҵ带 �����Ѵ�.
	 * 
	MVC�𵨿����� ������ �߰�
	
	1. JSP���������� �̵��� URI ����
	
	2. ��Ʈ�ѷ�(homeController���� ���� requestmapping ����
	
	3. �̵��� view������ ����
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome Home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		
		//������ �������� �̸�(Ȯ���� ����)
		return "home";
	}
	
	@RequestMapping(value = "/move", method = RequestMethod.GET)
	public String move() {

		//������ �������� �̸�(Ȯ���� ����)
		return "move";
	}
	@RequestMapping(value = "/loginProc", method = RequestMethod.GET)
	public String loginProc() {

		//������ �������� �̸�(Ȯ���� ����)
		return "loginForm";
	}
}
