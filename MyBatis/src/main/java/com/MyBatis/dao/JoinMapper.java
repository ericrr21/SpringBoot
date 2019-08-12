package com.MyBatis.dao;

import java.util.HashMap;
import java.util.List;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JoinMapper {
	
	public 	List<HashMap<String,Object>> test();
	public List<HashMap<String, Object>> Columns();
	

}