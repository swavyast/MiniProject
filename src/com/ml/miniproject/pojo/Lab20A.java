package com.ml.miniproject.pojo;

import java.util.*;
import org.hibernate.*;

import com.ml.miniproject.config.HibernateUtil1;

public class Lab20A {
	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil1.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

			Book b1 = new Book(" Angular-11.", 500, 1, 1.1f, 2023, "Available");
			session.save(b1);

			Book b2 = new Book(" Spring-5.4123", 800, 1, 1.1f, 2024, "Available");

			session.save(b2);

			Book b3 = new Book(" Spring Boot-3", 600, 1, 1.1f, 2025, "Available");

			session.save(b3);

			Set<String> skills = new HashSet<>();
			skills.add("Hibernate51");
			skills.add("Angular81");
			skills.add("Spring51");

			List<String> quals = new ArrayList<>();
			quals.add("B.Tech");
			quals.add("M.Tech");
			quals.add("P.hd");

			Map<String, Integer> exps = new HashMap<>();
			exps.put("Google", 5);
			exps.put("Oracle", 5);

			Author a1 = new Author("Som", "som@jtc", 12345, skills, quals, exps);
			session.save(a1);

			Author a2 = new Author("rai", "rai@jtc", 111, skills, quals, exps);
			session.save(a2);
			Author a3 = new Author("sp", "sp@jtc", 999, skills, quals, exps);
			session.save(a3);
			Set<Author> authors = new HashSet<>();
			authors.add(a1);
			b1.setMyAuthors(authors);
			authors = new HashSet<>();
			authors.add(a1);
			authors.add(a2);
			b2.setMyAuthors(authors);
			authors = new HashSet<>();
			authors.add(a1);
			authors.add(a2);
			authors.add(a3);
			b3.setMyAuthors(authors);
			tx.commit();
			
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}
}


