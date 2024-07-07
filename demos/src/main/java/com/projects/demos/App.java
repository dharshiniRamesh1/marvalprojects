package com.projects.demos;

import java.util.Iterator;
import java.util.List;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.sql.Select;

import com.projects.bean.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    AnnotationConfiguration cfg= new AnnotationConfiguration();
	cfg.configure("./Resource/herbinate.cfg.xml");
	SessionFactory sf=cfg.buildSessionFactory();
	Session session =sf.openSession();
	Transaction tnx=session.beginTransaction();
        
        
        Student student =new Student();
        student.setName("Ram");
        student.setSid(1);
        student.setAddress("Chennaia");
        
        session.save(student);
        tnx.commit();
        Query query = session.createQuery("from Student s");
        List l1 = query.list();
        //System.out.println(l1);
        
        Query q1 = session.createQuery("select s.name,s.Address from Student s");
        
        List SelectData = q1.list();
        
        Iterator it =SelectData.iterator();
        
        while(it.hasNext()) {
        	Object[]o=(Object[])it.next();
        	System.out.println(o[0] +" , " +o[1]);
        }
        
        Query q3=session.createQuery("select s.name,s.Address from Student s where sid=?");
        q3.setParameter(0, 3);
        
        List IdData = q3.list();
        IdData.stream().forEach(t -> System.out.println("data : "+t));
        Iterator itr =IdData.iterator();
        while(itr.hasNext()) {
        	Object obj1=(Object)itr.next();
            Student std=(Student) obj1;
        	System.out.println("Done");
        }
        
        
       // l1.stream().forEach(e -> System.out.println(e));
        //l1.stream().forEach(e -> System.out.println(e));
        
       /* ArrayList list = new ArrayList();
        list.add(10);
        list.add("adc");
        list.add("ch");
        
        System.out.println(list);
        Iterator it=list.iterator();
        while(it.hasNext()) {
        	System.out.println(it.next());
        }*/
        
         System.out.println("demo");
        
    }
}
