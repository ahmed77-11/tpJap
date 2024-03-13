package com.ahmed.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.ahmed.entities.Moto;
import com.ahmed.util.JPAutil;

//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)
public class MotoDao {
	private EntityManager entityManager = JPAutil.getEntityManager("MonProjetJPA");

//méthode ajouter d'une entité à la bd
	public void ajouter(Moto m) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(m);
		tx.commit();
	}

//méthode modifier d'une entité à partir de la bd
	public void modifier(Moto m) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(m);
		tx.commit();
	}

//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Moto m) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		m = entityManager.merge(m); // important
		entityManager.remove(m);
		tx.commit();
	}

//méthode Consulter d'une entité à partir de la bd
	public Moto consulter(Moto m, Object id) {
		return entityManager.find(m.getClass(), id);
	}

//méthode pour lister tous les objets à partir de la bd
	public List<Moto> listerTous() {
		List<Moto> motos = entityManager.createQuery("select m from Moto m").getResultList();

		return motos;
	}

//méthode pour lister tous les client dont le nom contient un
//texte donné en paramètre (pnom)
	public List<Moto> listerParNom(String nom) {
		List<Moto> motos = entityManager.createQuery("select m from Moto m where m.nom like :pnom").setParameter("pnom", "%" + nom + "%").getResultList();

		return motos;
	}
}