package com.niit.onlineShopping.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineShopping.DAO.CartLineDao;
import com.niit.onlineShopping.model.Cart;
import com.niit.onlineShopping.model.CartLine;
import com.niit.onlineShopping.model.OrderDetail;

@Repository("cartLineDao")
@Transactional
public class CartLineDaoImpl implements CartLineDao {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		String query = "FROM CartLine WHERE cartId = :cartId AND product.prodId = :productId";
		try {
			
			return sessionfactory.getCurrentSession()
									.createQuery(query,CartLine.class)
										.setParameter("cartId", cartId)
										.setParameter("productId", productId)
											.getSingleResult();
			
		}catch(Exception ex) {
			return null;	
		}
		
	}

	@Override
	public boolean add(CartLine cartLine) {
		try {
			sessionfactory.getCurrentSession().persist(cartLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(CartLine cartLine) {
		try {
			sessionfactory.getCurrentSession().update(cartLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(CartLine cartLine) {	
		try {			
			sessionfactory.getCurrentSession().delete(cartLine);
			return true;
		}catch(Exception ex) {
			return false;
		}		
	}


	@Override
	public List<CartLine> list(int cartId) {
		
		String query = "FROM CartLine WHERE cartId = :cartId";
		return sessionfactory.getCurrentSession()
								.createQuery(query, CartLine.class)
									.setParameter("cartId", cartId)
										.getResultList();
	}

	@Override
	public CartLine get(int id) {		
		return (CartLine) sessionfactory.getCurrentSession().get(CartLine.class, Integer.valueOf(id));
	}
	
	@Override
	public boolean addCart(Cart cart) {
		try {			
			sessionfactory.getCurrentSession().saveOrUpdate(cart);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {			
			sessionfactory.getCurrentSession().update(cart);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
		String query = "FROM CartLine WHERE cartId = :cartId AND available = :available";
		return sessionfactory.getCurrentSession()
								.createQuery(query, CartLine.class)
									.setParameter("cartId", cartId)
									.setParameter("available", true)
										.getResultList();
	}

	@Override
	public boolean addOrderDetail(OrderDetail orderDetail) {
		try {			
			sessionfactory.getCurrentSession().persist(orderDetail);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
}