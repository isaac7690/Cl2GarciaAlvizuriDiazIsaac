package com.cibertec.cl2.test;

import com.cibertec.cl2.dao.EmpleadoDao;
import com.cibertec.cl2.dao.impl.EmpleadoDaoImpl;

public class ListarEmpleadoTest {

	public static void main(String[] args) {
		EmpleadoDao dao = new EmpleadoDaoImpl();
		dao.listarEmpleados().stream().forEach(System.out::println);
	}
}
