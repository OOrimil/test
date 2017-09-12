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
 * @Controller로 컨트롤러가 설정되어 있는 부분을 확인함.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//로그를 남기기 위한 필드.
	/**
	 * Simply selects the home view to render by returning its name.
	 * URL : http://localhost:8081/myapp/WEB-INF/views/home.jsp
	 * 프로토콜 : http
	 * 도메인 주소 : localhost
	 * 사용 포트 : 8081
	 * 사용 서비스 : myapp
	 * URI : /WEB-INF/views/home.jsp
	 * 
	 * @RequestMapping은 URI를 찾는 것이다. 
	 * 즉 URI부분의 값이 value부분과 같으면 해당 메소드를 실행한다.
	 * 
	MVC모델에서의 페이지 추가
	
	1. JSP페이지에서 이동할 URI 지정
	
	2. 컨트롤러(homeController에서 받을 requestmapping 제작
	
	3. 이동할 view페이지 제작
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome Home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		
		//접속할 페이지의 이름(확장자 제외)
		return "home";
	}
	
	@RequestMapping(value = "/move", method = RequestMethod.GET)
	public String move() {

		//접속할 페이지의 이름(확장자 제외)
		return "move";
	}
	@RequestMapping(value = "/loginProc", method = RequestMethod.GET)
	public String loginProc() {

		//접속할 페이지의 이름(확장자 제외)
		return "loginForm";
	}
}
