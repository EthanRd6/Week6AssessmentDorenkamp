package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.MuscleCar;

/**
* @author Ethan Dorenkamp - edorenkamp
* CIS175 - Spring 2021
* Feb 11, 2021
*/
public class MuscleCarHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week6AssessmentDorenkamp");
	
	public void insertItem(MuscleCar mc) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(mc);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<MuscleCar> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<MuscleCar> allItems = em.createQuery("SELECT i FROM MuscleCar i").getResultList();
		return allItems;
	}
	
	public void deleteItem(MuscleCar toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MuscleCar> typedQuery = em.createQuery("select mc from"
+ " MuscleCar mc where mc.make = :selectedMake and mc.model = :selectedModel and"
+ " mc.year = :selectedYear and mc.zeroToSixtyTime = :selectedZeroToSixtyTime and"
+ " mc.exteriorColor = :selectedExteriorColor", MuscleCar.class);
		
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		typedQuery.setParameter("selectedExteriorColor", toDelete.getExteriorColor());
		typedQuery.setParameter("selectedZeroToSixtyTime", toDelete.getZeroToSixtyTime());
		
		typedQuery.setMaxResults(1);
		
		MuscleCar result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public MuscleCar searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		MuscleCar found = em.find(MuscleCar.class, idToEdit);
		return found;
	}
	
	public void updateItem(MuscleCar toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<MuscleCar> searchForCarByMake(String carMake) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MuscleCar> typedQuery = em.createQuery("select mc from MuscleCar mc where "
				+ "mc.make = :selectedMake", MuscleCar.class);
		typedQuery.setParameter("selectedMake", carMake);
		
		List<MuscleCar> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<MuscleCar> searchForCarByModel(String carModel) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MuscleCar> typedQuery = em.createQuery("select mc from MuscleCar mc where "
				+ "mc.model = :selectedModel", MuscleCar.class);
		typedQuery.setParameter("selectedModel", carModel);
		
		List<MuscleCar> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<MuscleCar> searchForCarByYear(int carYear) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MuscleCar> typedQuery = em.createQuery("select mc from MuscleCar mc where "
				+ "mc.year = :selectedYear", MuscleCar.class);
		typedQuery.setParameter("selectedYear", carYear);
		
		List<MuscleCar> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<MuscleCar> searchForCarByColor(String carColor) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MuscleCar> typedQuery = em.createQuery("select mc from MuscleCar mc where "
				+ "mc.color = :selectedColor", MuscleCar.class);
		typedQuery.setParameter("selectedColor", carColor);
		
		List<MuscleCar> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<MuscleCar> searchForCarByZeroToSixtyTime(double carZeroToSixtyTime) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MuscleCar> typedQuery = em.createQuery("select mc from MuscleCar mc where "
				+ "mc.zeroToSixtyTime = :selectedZeroToSixtyTime", MuscleCar.class);
		typedQuery.setParameter("selectedZeroToSixtyTime", carZeroToSixtyTime);
		
		List<MuscleCar> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
