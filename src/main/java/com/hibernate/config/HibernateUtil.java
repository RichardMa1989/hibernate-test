package com.hibernate.config;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.entity.Books;

public class HibernateUtil
{
    public static void main(String[] args)
    {
        Configuration configuration=new Configuration().configure();
        try (SessionFactory sessionFactory=configuration.buildSessionFactory(); Session session=sessionFactory.openSession())
        {
            Criteria criteria=session.createCriteria(Books.class);
            List<Books> list=criteria.list();
            for(Books books:list)
            {
                System.out.println(books.getTitle());
            }
        }
    }
}