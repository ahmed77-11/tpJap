package com.ahmed.test;

import com.ahmed.dao.MotoDao;
import com.ahmed.entities.Moto;

public class MotoTest {
	public static void main(String[] args) {
		//créer un objet client
		Moto m = new Moto();
		m.setNom("YAMAHA");
		m.setPrix(1500.5);
		//ajouter l'objet client à la BD
		MotoDao motoDao = new MotoDao();
		motoDao.ajouter(m);
		System.out.println("Appel de la méthode listerTous");
		for (Moto moto : motoDao.listerTous())
		System.out.println(moto.getCode()+" "+moto.getNom());
		System.out.println("Appel de la méthode listerParNom");
		for (Moto moto : motoDao.listerParNom("y"))

		System.out.println(moto.getCode()+" "+moto.getNom());
		//tester les autres méthodes de la classe ClientDao
		System.out.println("Appel de la méthode modifier");
		motoDao.modifier(m);
		System.out.println("Appel de la méthode listerTous apres modification");
		for (Moto moto : motoDao.listerTous())
			System.out.println(moto.getCode()+" "+moto.getNom());
		System.out.println("Appel de la méthode supprimer");
		motoDao.supprimer(m);
		System.out.println("Appel de la méthode listerTous apres supprission");
		for (Moto moto : motoDao.listerTous())
			System.out.println(moto.getCode()+" "+moto.getNom());
		
		
		
		}
		
}
