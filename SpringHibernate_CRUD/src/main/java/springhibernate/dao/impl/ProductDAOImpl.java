package springhibernate.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springhibernate.dao.ProductDAO;
import springhibernate.entities.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getProducts() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Product order by price desc").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertProduct(Product p) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(p);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public Product getProductById(Integer proId) {
		Session session = sessionFactory.openSession();
		try {
			Product product = session.get(Product.class, proId);
			return product;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();			
		}finally {
			session.close();
		}		
		return null;
	}


	@Override
	public boolean updateProduct(Product p) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(p);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(Integer proId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(getProductById(proId));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();			
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Product> getProductsByName(String proName) {
		Session session = sessionFactory.openSession();
		try {
			if(proName==null || proName.length()==0)
				proName = "%";
			else
				proName = "%"+proName+"%";
			
			
			List list = session.createQuery("from Product where proName like :proName")
			.setParameter("proName", proName)
			.list();
			return  list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}
}
