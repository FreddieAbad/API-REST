package com.javarevolutions.ws.rest.service;
import com.javarevolutions.ws.rest.vo.VOUsuario;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path ("/JavaRevolutions")
public class ServiceLoginJR {
	
	@POST
	@Path("/ValidaUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})

	public VOUsuario validaUsuario(VOUsuario vo)
	{
		vo.setUserValido(false);
		if (vo.getUsuario().equals("Java") && vo.getPassword().equals("Revolutions"))
		{
			vo.setUserValido(true);
		}
		return vo;
	}
}
