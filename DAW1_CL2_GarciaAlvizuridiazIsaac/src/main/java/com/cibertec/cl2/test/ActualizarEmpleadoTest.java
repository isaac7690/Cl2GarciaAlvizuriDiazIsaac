package com.cibertec.cl2.test;

import com.cibertec.cl2.dao.EmpleadoDao;
import com.cibertec.cl2.dao.impl.EmpleadoDaoImpl;
import com.cibertec.cl2.model.Empleado;

public class ActualizarEmpleadoTest {

	public static void main(String[] args) {
		EmpleadoDao dao = new EmpleadoDaoImpl();
		Empleado empleado = dao.buscarEmpleado(1);
		System.out.println(empleado);
		
		empleado.setNombre("Isaac Manuel");
		empleado.setDni("11111111");
		String mensaje = dao.actualizarEmpleado(empleado);
		System.out.println(mensaje);
		System.out.println(empleado);
	}
}
