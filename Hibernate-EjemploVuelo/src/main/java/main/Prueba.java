package main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Vuelo;
import modelo.Vuelo.TipoVuelo;
import utilidades.Utilidades;



//import transparencias.mapeos.Vuelo.TipoVuelo;

public class Prueba {

	/**
	 * M�todo para actualizar un autor
	 * 
	 * @param aut
	 */
	public void creaActualizaVuelo(Vuelo vuelo) {
		// Conseguimos un objeto sesi�n para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacci�n
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesi�n
			session.saveOrUpdate(vuelo);
			// Commit de la transacci�n
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurri� un error:" + e.getMessage());
		} finally {
			/*
			 * Cuidado que al hacer close, los objetos pasan a estado detached,
			 * si hago close y luego fuera del try un return del objeto no
			 * tendr� acceso al valor de sus propiedades, �nicamente la clave
			 * primaria
			 */
			session.close();
		}

	}

	/**
	 * M�todo para recuperar un vuelo
	 * 
	 * @param id
	 * @return
	 */
	public Vuelo recuperaVuelo(int id) {
		// Conseguimos un objeto sesi�n para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Vuelo vue = new Vuelo();

		// abrimos una transacci�n
		session.beginTransaction();
		// Recuperamos el empleado
		vue = (Vuelo) session.load(Vuelo.class, id);
		// Commit de la transacci�n
		session.getTransaction().commit();
		
		return vue;
	}

	public static void main(String[] args) {
		Vuelo vue = new Vuelo();

		Vuelo vueR;

		vue.setHoraSalida(new Date());
		char[] codigo={'A','0','2','3',};
		vue.setCodigo(codigo);
		vue.setLongitud(5);
		vue.setNumero(333);
		vue.setTexto("Vuelo de prueba");
		vue.setTipo(TipoVuelo.ASIA);
		

		Prueba prueba = new Prueba();
		prueba.creaActualizaVuelo(vue);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Vuelo almacenado:" + vue.getId());
		vueR = prueba.recuperaVuelo(vue.getId());
		System.out.println("Vuelo recuperado:" + vueR.toString());

		// Cerramos la factoria de sesiones, sino el programa no finalizar�
		Utilidades.getSessionFactory().close();
	}

}
