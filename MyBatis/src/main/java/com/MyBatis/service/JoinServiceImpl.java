package com.MyBatis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyBatis.dao.JoinMapper;
@Service
public class JoinServiceImpl implements JoinService {
	
	@Autowired
	private JoinMapper joinMapper;
	
	@Transactional
	@Override
	public void join() {
		// TODO Auto-generated method stub
		List<HashMap<String,Object>> dataMap=joinMapper.test();
		 // Obtenemos todas las llaves del mapa.
		for(HashMap<String,Object> a: dataMap) {
			a.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
		}
		
       
	}

	@Override
	public List<HashMap<String, Object>> columns() {
		List<HashMap<String, Object>> columns = joinMapper.Columns();
		
		for(HashMap<String,Object> a: columns) {
			a.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
		}
		// TODO Auto-generated method stub
		return columns;
	}

}
