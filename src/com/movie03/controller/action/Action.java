package com.movie03.controller.action;

import java.io.IOException;
import java.util.Map;

public interface Action {
	public String execute(Map<String, Object> reqModel, Map<String, Object> respModel) throws IOException;
	
}
