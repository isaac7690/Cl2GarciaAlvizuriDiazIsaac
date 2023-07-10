package com.cibertec.cl2.test;

import com.cibertec.cl2.dao.EmpleadoDao;
import com.cibertec.cl2.dao.impl.EmpleadoDaoImpl;
import com.cibertec.cl2.model.Empleado;

public class BuscarPorIdTest {

	public static void main(String[] args) {
		EmpleadoDao dao = new EmpleadoDaoImpl();
		Empleado empleado = dao.buscarEmpleado(1);
		System.out.println(empleado);
	}
}
