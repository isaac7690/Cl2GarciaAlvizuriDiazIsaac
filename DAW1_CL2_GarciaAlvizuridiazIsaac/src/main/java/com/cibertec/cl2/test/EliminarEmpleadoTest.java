package com.cibertec.cl2.test;

import com.cibertec.cl2.dao.EmpleadoDao;
import com.cibertec.cl2.dao.impl.EmpleadoDaoImpl;

public class EliminarEmpleadoTest {

	public static void main(String[] args) {
		EmpleadoDao dao = new EmpleadoDaoImpl();
		
		String mensaje = dao.eliminarEmpleado(1);
		System.out.println(mensaje);
	}
}
