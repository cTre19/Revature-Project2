package com.revature.daos;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;
import com.revature.util.SessionUtil;

@Repository
public class UserDaoImpl implements UserDao{

	private Session currentSession;
	private Transaction currentTransaction;

	public Session getCurrentSession() {
		return SessionUtil.getSession();
	}
	
	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}
	
	public void newSession() {
		if (currentSession == null) {
			currentSession = SessionUtil.getSession();
		}
	}

	public User getUser(String email) {
		newSession();
		User u = (User) currentSession.get(User.class, email);
		if(u != null)
			currentSession.refresh(u);
		currentSession.close();
		currentSession = null;
		return u;
	}
	
	@Transactional
	public String createUser(User user){
		newSession();
		Transaction tx = null;
		String email = "";
		try {
			tx = currentSession.beginTransaction();
			email = (String) currentSession.save(user);
			tx.commit();
		 }
		 catch (HibernateException e) {
		     if (tx!=null) tx.rollback();
		     e.printStackTrace();
		 }
		 finally {
		     currentSession.close();
		     currentSession = null;
		 }
		return email;
	}
	

	@Transactional
	public void deleteUser(String email) {
		newSession();
		Transaction tx = null;
		try {
			tx = currentSession.beginTransaction();
			User user = getUser(email);
			currentSession.delete(user);
			tx.commit();
		 }
		 catch (HibernateException e) {
		     if (tx!=null) tx.rollback();
		     e.printStackTrace();
		 }
		 finally {
		    // currentSession.close();
		 }
	}
	
	public void updateUser(User user) {
		Session sess = SessionUtil.getSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.saveOrUpdate(user);
			sess.flush();
			tx.commit();
		 }
		 catch (HibernateException e) {
		     if (tx!=null) tx.rollback();
		     e.printStackTrace();
		 }
		 finally {
		     sess.close();
		 }
	}

	public UserDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<User> getPending(){
		newSession();
		Query query = currentSession.createQuery("FROM User where approved=0");
		List<User> all = query.getResultList();
		currentSession.close();
		currentSession = null;
		return all;
	}

	public List<User> getUsers() {
		newSession();
		Query query = currentSession.createQuery("FROM User where approved=3");
		List<User> all = query.getResultList();
		currentSession.close();
		currentSession = null;
		return all;
	}
	
	public List<User> getUsersByLoc(User u) {
		newSession();
		String location = u.getCity();
		Query query = currentSession.createQuery("FROM User where approved=3 AND city='" + location+"'");
		List<User> all = query.getResultList();
		currentSession.close();
		currentSession = null;
		return all;
	}
	
/*
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}*/


}