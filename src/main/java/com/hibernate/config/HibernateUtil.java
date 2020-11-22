package com.hibernate.config;
import java.util.List;
import java.util.Properties;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import com.hibernate.entity.Books;

public class HibernateUtil
{
    public static void main(String[] args)
    {
        Configuration configuration=new Configuration();
//        Properties properties=new Properties();
//        properties.put(AvailableSettings.URL,"jdbc:mysql://localhost:3306/orange?useSSL=false&serverTimezone=Asia/Shanghai");
//        properties.put(AvailableSettings.USER,"root");
//        properties.put(AvailableSettings.PASS,"00000000");
//        properties.put(AvailableSettings.DIALECT,MySQL5InnoDBDialect.class.getCanonicalName());
//        properties.put(AvailableSettings.SHOW_SQL,true);
//        properties.put(AvailableSettings.USE_SQL_COMMENTS,true);
//        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Books.class);
        configuration.configure();
        try (SessionFactory sessionFactory=configuration.buildSessionFactory(); Session session=sessionFactory.openSession())
        {
            System.out.println(sessionFactory);
            SQLQuery query=session.createSQLQuery("select null isbn,title from books");
//            query.setResultTransformer(new AliasToBeanResultTransformer(Books.class));
            query.addEntity(Books.class);
            List<Books> list=query.setMaxResults(5).setFirstResult(5).list();
            System.out.println(list.size());
            System.out.println(list.get(0).getClass());
            System.out.println(list.get(0).getIsbn());
            System.out.println(list.get(0).getTitle());
        }
    }
}