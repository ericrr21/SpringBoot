package com.MyBatis.service;

import java.util.HashMap;
import java.util.List;

public interface JoinService {
	public void join();
	
	public List<HashMap<String, Object>> columns();

}
