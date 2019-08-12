package com.MyBatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.MyBatis.dto.ParamsQuery;
import com.MyBatis.persistence.mybatis.entities.UsuarioEntity;

@Mapper
public interface UsuarioMapper {
	public List<UsuarioEntity> selectAll();
	
	public UsuarioEntity selectId(ParamsQuery paramsQuery);

}
