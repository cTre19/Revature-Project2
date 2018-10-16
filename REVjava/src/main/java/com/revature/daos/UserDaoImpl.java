package com.revature.daos;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.beans.Credentials;
import com.revature.beans.User;
import com.revature.util.SessionUtil;

@Repository
public class UserDaoImpl {

	private Session currentSession;
	private Transaction currentTransaction;

	public Session getCurrentSession() {
		return SessionUtil.getSession();
	}

	public User getUser(Credentials cred) {
		return (User) getCurrentSession().get(User.class, cred.getEmail());
	}
	
	@Transactional
	public String createUser(User user){
		Session sess = SessionUtil.getSession();
		Transaction tx = null;
		String email = "";
		try {
			tx = sess.beginTransaction();
			email = (String) sess.save(user);
			tx.commit();
		 }
		 catch (HibernateException e) {
		     if (tx!=null) tx.rollback();
		     e.printStackTrace();
		 }
		 finally {
		     sess.close();
		 }
		return email;
	}
	
	public void deleteUser(String email) {
		Session sess = SessionUtil.getSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			User user = getUser(new Credentials(email,""));
			sess.delete(user);
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
	
	public void updateUser(User user) {
		Session sess = SessionUtil.getSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.update(user);
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

/*	public Integer getUserId(Credentials cred) {

		Session sess = SessionUtil.getSession();
		String hql = "FROM User WHERE email = :em and password = :pw";
		Query query = sess.createQuery(hql);
		query.setParameter("em", cred.getEmail());
		query.setParameter("pw", cred.getPass());

		try {
			User u = (User) query.list().get(0);
			return u.getId();
		} catch(NullPointerException e) {
			return 0;
		}

	}*/

	public UserDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
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