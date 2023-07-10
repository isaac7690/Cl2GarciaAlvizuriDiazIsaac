package com.cibertec.cl2.dao;

import java.util.List;

import com.cibertec.cl2.model.Empleado;

public interface EmpleadoDao {
	
	public String registrarEmpleado(Empleado empleado);
	public Empleado buscarEmpleado(int id);
	public List<Empleado> listarEmpleados();
	public String actualizarEmpleado(Empleado empleado);
	public String eliminarEmpleado(int id);

}
