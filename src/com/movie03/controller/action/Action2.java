package com.movie03.controller.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action2 {
	public String execute(Map<String, Object> model) throws IOException;
	
}
