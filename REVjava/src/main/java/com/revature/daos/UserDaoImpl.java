package com.revature.daos;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
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

	public User getUser(Integer userId) {
		return (User) getCurrentSession().get(User.class, userId);
	}

	public Integer getUserId(Credentials cred) {

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

	}

	public UserDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;

	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = (Transaction) currentSession.beginTransaction();
		return currentSession;

	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	ArrayList<User> db = new ArrayList<User>();
	{
		db.add(new User("Bob", "The_builder", 1,"bob@revature.com","secret", "tampa", "florida", "rev", 1, "trainee"));
		db.add(new User("Bill","Smith", 2, "bill@revature.com", "secret2", "tampa", "florida", "rev", 1, "trainee"));
	}

}