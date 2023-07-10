package com.cibertec.cl2.dao.impl;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import com.cibertec.cl2.dao.EmpleadoDao;
import com.cibertec.cl2.model.Empleado;

public class EmpleadoDaoImpl implements EmpleadoDao {
	
	private static final String REGISTRO_OK = "Se Registró al empleado Correctamente";
	private static final String REGISTRO_ERROR = "No se Registró Correctamente al empleado";
	
	private static final String ACTUALIZA_OK = "Se Actualizó Correctamente al empleado";
	private static final String ACTUALIZA_ERROR = "No se Actualizó Correctamente al empleado";
	
	private static final String ELIMINA_OK = "Se Eliminó Correctamente al empleado";
	private static final String ELIMINA_ERROR = "No se Eliminó Correctamente al empleado";
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Cl2EmpleadoPU");
	EntityManager manager = factory.createEntityManager();

	public String registrarEmpleado(Empleado empleado) {
		String mensaje = REGISTRO_ERROR;
		if(!Objects.isNull(empleado)) {
		manager.getTransaction().begin();
		manager.persist(empleado);
		manager.getTransaction().commit();
		mensaje=REGISTRO_OK;
		manager.close();		
		}		
		return mensaje;
	}

	public Empleado buscarEmpleado(int id) {
		return buscarEmpleadoPorId(id);
	}
	
	private Empleado buscarEmpleadoPorId(int id) {
		return manager.find(Empleado.class, id);
	}

	public List<Empleado> listarEmpleados() {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Empleado> criteriaQuery = criteriaBuilder.createQuery(Empleado.class);
		Root<Empleado> registro = criteriaQuery.from(Empleado.class);
		CriteriaQuery<Empleado> todos = criteriaQuery.select(registro);
		TypedQuery<Empleado> lista = manager.createQuery(todos);
		return lista.getResultList();
	}

	public String actualizarEmpleado(Empleado empleado) {
		String mensaje = ACTUALIZA_ERROR;
		Empleado objeto = buscarEmpleadoPorId(empleado.getIdEmpleado());
		if(!Objects.isNull(objeto)) {
			manager.getTransaction().begin();
			objeto.setNombre(empleado.getNombre());
			objeto.setApellidos(empleado.getApellidos());
			objeto.setDni(empleado.getDni());
			manager.getTransaction().commit();
			manager.close();
			mensaje = ACTUALIZA_OK;
		}
		return mensaje;
	}

	public String eliminarEmpleado(int id) {
		String mensaje = ELIMINA_ERROR;
		Empleado objeto = buscarEmpleadoPorId(id);
		if(!Objects.isNull(objeto)) {
			manager.getTransaction().begin();
			manager.remove(objeto);
			manager.getTransaction().commit();
			manager.close();
			mensaje = ELIMINA_OK;
		}
		return mensaje;
	}
}
