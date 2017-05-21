package com.hibernate.config;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import com.hibernate.entity.Department;

public class HibernateUtil
{
	private static final SessionFactory sessionFactory;
	private static Configuration configuration;
	static
	{
		try
		{
			configuration=new Configuration().configure();
			ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		}
		catch (Throwable e)
		{
			throw new ExceptionInInitializerError(e);
		}
	}
	private HibernateUtil()
	{}
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	public static void main(String[] args)
	{
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Department.class);
		List<Department> list=criteria.list();
		System.out.println(list.get(0).getCode());
		session.close();
		sessionFactory.close();
	}
}