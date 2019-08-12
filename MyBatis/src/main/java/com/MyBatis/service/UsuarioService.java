package com.MyBatis.service;

import java.util.List;

import com.MyBatis.dto.ParamsQuery;
import com.MyBatis.persistence.mybatis.entities.UsuarioEntity;

public interface UsuarioService {
	public List<UsuarioEntity> getAll();
	public UsuarioEntity selectId(ParamsQuery paramsQuery);
}
