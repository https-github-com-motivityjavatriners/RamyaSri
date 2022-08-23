package com.employee;







import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainEmployee {

	public static void main(String[] args) {
		Configuration c = new Configuration();
		c.configure("hibernate.xml");
		SessionFactory sf= c.buildSessionFactory();
		
	Session	s=sf.openSession();
	Query q=s.createQuery("  from Employee e where e.empid=:input");
	q.setParameter("input", 59);

	List li = q.getResultList();
	Iterator i = li.iterator();
	
	while(i.hasNext()) {
		//int v = (Integer)i.next();
		//System.out.println(v);
		//Object []o=(Object [])i.next();
		//System.out.println(o[0]+" "+o[1]+" "+o[2]+" "+o[3]+" ");
		Employee e = (Employee)i.next();
	System.out.println(e.getEname()+" "+e.getEmpid()+" "+e.getDept()+" "+e.getSalary());
	}
	
	}

}
