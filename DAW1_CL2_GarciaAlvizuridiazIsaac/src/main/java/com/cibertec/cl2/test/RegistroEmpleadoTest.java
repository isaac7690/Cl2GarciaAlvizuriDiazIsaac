package com.cibertec.cl2.test;

import com.cibertec.cl2.dao.EmpleadoDao;
import com.cibertec.cl2.dao.impl.EmpleadoDaoImpl;
import com.cibertec.cl2.model.Empleado;

public class RegistroEmpleadoTest {

	public static void main(String[] args) {
		EmpleadoDao dao = new EmpleadoDaoImpl();
		Empleado empleado = new Empleado("Isaac","Garcia Alvizuri Diaz","46345706");
		String mensaje = dao.registrarEmpleado(empleado);
		System.out.println(mensaje);
	}

}
