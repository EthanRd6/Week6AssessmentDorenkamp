package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Driver;
import model.MuscleCar;

/**
* @author Ethan Dorenkamp - edorenkamp
* CIS175 - Spring 2021
* Mar 4, 2021
*/
public class DriverHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week6AssessmentDorenkamp");
	
	public void addDriver(Driver d) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Driver> showAllDrivers() {
		EntityManager em = emfactory.createEntityManager();
		List<Driver> allItems = em.createQuery("SELECT i FROM Driver i").getResultList();
		return allItems;
	}
	
	public void deleteDriver(Driver toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Driver> typedQuery = em.createQuery("select d from"
+ " Driver d where d.driverName = :selectedName", Driver.class);
		
		typedQuery.setParameter("selectedName", toDelete.getDriverName());
		
		
		typedQuery.setMaxResults(1);
		
		Driver result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Driver searchForDriverById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Driver found = em.find(Driver.class, idToEdit);
		return found;
	}
	
	public void updateDriver(Driver toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Driver> searchForDriverByName(String driverName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Driver> typedQuery = em.createQuery("select d from Driver d where "
				+ "d.driverName = :selectedName", Driver.class);
		typedQuery.setParameter("selectedName", driverName);
		
		List<Driver> foundDrivers = typedQuery.getResultList();
		em.close();
		return foundDrivers;
	}
	
}
