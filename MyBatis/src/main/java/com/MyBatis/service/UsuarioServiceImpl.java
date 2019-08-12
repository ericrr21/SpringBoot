package com.MyBatis.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyBatis.dao.UsuarioMapper;
import com.MyBatis.dto.ParamsQuery;
import com.MyBatis.persistence.mybatis.entities.UsuarioEntity;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioMapper usuarioMapper;

	@Override
	@Transactional
	public List<UsuarioEntity> getAll() {
	List<UsuarioEntity> lista = usuarioMapper.selectAll();
	
		return lista;
	}

	@Override
	public UsuarioEntity selectId(ParamsQuery paramsQuery) {
	UsuarioEntity uEntity = usuarioMapper.selectId(paramsQuery);
		return uEntity;
	}

}
