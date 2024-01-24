package productcrudapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import productcrudapp.model.Product;

@Component
public class ProductDao {

	@Autowired
	private SessionFactory SessionFactory;

	public SessionFactory getSessionFactory() {
		return SessionFactory;
	}

	public void setSessionFactory(SessionFactory SessionFactory) {
		this.SessionFactory = SessionFactory;
	}

	public ProductDao(SessionFactory SessionFactory) {
		this.SessionFactory = SessionFactory;
	}

	// create
	@Transactional
	public void createProduct(Product product) {
		this.SessionFactory.getCurrentSession().saveOrUpdate(product);
	}

	// get all productd
	@Transactional
	public List<Product> getProducts() {

		String hql = "FROM Product";
		List<Product> products = SessionFactory.getCurrentSession().createQuery(hql, Product.class).list();

		return products;
	}

	// delete the single product
	@Transactional
	public void deleteProduct(int pid) {
		Product p = this.SessionFactory.getCurrentSession().load(Product.class, pid);
		this.SessionFactory.getCurrentSession().delete(p);
	}

	// get single product
	@Transactional
	public Product getProduct(int pid) {
		return this.SessionFactory.getCurrentSession().get(Product.class, pid);
	}

}
