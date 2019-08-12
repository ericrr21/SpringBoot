package com.MyBatis;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MyBatis.dto.ParamsQuery;
import com.MyBatis.persistence.mybatis.entities.UsuarioEntity;
import com.MyBatis.service.JoinService;
import com.MyBatis.service.UsuarioService;

@RestController
@RequestMapping("api")
public class api {
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private JoinService joinService;
	
	@RequestMapping(method = RequestMethod.GET,value = "/all",produces = "application/json")
	public List<UsuarioEntity> data(){
		return usuarioService.getAll();
	}
	
	@RequestMapping(method= RequestMethod.GET,value = "/user/{id}",produces = "application/json")
	public UsuarioEntity getUser(@PathParam("id") Integer id) {
		ParamsQuery paramsQuery = new ParamsQuery();
		paramsQuery.setId(id);
		return usuarioService.selectId(paramsQuery);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/join")
	public void join() {
		joinService.join();
	}

}
