package com.movie03.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class CharEncFilter
 */
//모든요청에대하여 필터링
//톰켓의 web-study-11 실행시  CharEncFilter 실행
@WebFilter("/*")
public class CharEncFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CharEncFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		/*doPost()를 열때마다 매번 Encoding 하던 것을 Fileter를 통해 한번에 처리*/
		
		// pass the request along the filter chain
		System.out.println("필터: 요청파라미터한글인코딩");
		
		request.setCharacterEncoding("UTF-8");//요청전처리
		chain.doFilter(request, response);
		
		//다음번째 filter 로 넘김. 다음번째 filter가 없으면 doPost로 이동
		System.out.println("필터: 응답전송");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
