package edu.sabanciuniv.it526.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.sabanciuniv.it526.domain.User;
import edu.sabanciuniv.it526.utils.IT526Utillty;

@Stateless
public class UserService {
	
	@PersistenceContext
	private EntityManager entityManager;

	public User checkUser(String username, String password) {
		
		password = IT526Utillty.hash(password);
		System.out.println("User Input password (from textbox) hashed --> "+password);
		System.out.println("Ahmet Demirelli");
		System.out.println("Ahmet Demirelli");
		 List<User> users = entityManager.createQuery("select u from User u where u.username=?1 and u.password=?2",User.class)
				 .setParameter(1, username)
				 .setParameter(2, password)
				 .getResultList();	
		if (users.size()==1)
		{
			System.out.println("User password (from DB) hashed --> "+password);
			return users.get(0);
		}
		return null;
	}

//System.out.println("latest change");

}
