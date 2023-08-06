package poly.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import poly.util.JpaUtil;

public class AbstractDao<T> {
	public static final EntityManager entityManager = JpaUtil.getEntityManager();

	@SuppressWarnings("removal")
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}

	public T findById(Class<T> clazz, int id) {
		return entityManager.find(clazz, id);
	}

	public List<T> findAll(Class<T> clazz, boolean existIsActive) {
		// 1.bien exist xac dinh xem co ton` tai isactive ko, neu true thi` cau dk kem`
		// theo 2
		// 2.select o FROM entity Where isActive = 1;
		String entityname = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();

		// apend entity name: neu user thi` truyen vao user, history thi` truyen vao
		// history
		sql.append("SELECT o FROM ").append(entityname).append(" o");

		// kiem tra neu isactive true thi truyen vao them append
		if (existIsActive == true) {
			sql.append(" WHERE isActive = 1");
		}
		TypedQuery<T> query = entityManager.createQuery(sql.toString(), clazz);
		return query.getResultList();
	}

	public List<T> findAll(Class<T> clazz, boolean existIsActive, int pageNumber, int pageSize) {

		String entityname = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT o FROM ").append(entityname).append(" o");

		if (existIsActive == true) {
			sql.append(" WHERE isActive = 1");
		}
		TypedQuery<T> query = entityManager.createQuery(sql.toString(), clazz);
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();

		/*
		 * index ko danh' tu` 1 ma` danh tu` 0 => ng dung` chi biet trang 1 2 3 , ko
		 * biet [0]
		 * 
		 * 5 phan tu 1 trang chua 2 phan tu tong so trang : 3 trang 1: 2pt [0] [1] trang
		 * 2: 2pt [2] [3] trang 3: 1pt[4]
		 * 
		 * muon lay cac pt trang 2 => pagenumber = 2, pagesize = 2 1 * 2 = 2 --> bat dau
		 * lay tu pt thu 2 , lay 2 pt
		 * 
		 */
	}
	

	// select o from user o where o.username = ? and o.password = ?;
	// findOne: tìm 1 cái gì đó mà chỉ trả vể 1 giá trị 
	public T findOne(Class<T> clazz, String sql, Object... params) {
		// object ... params: tham so' co do dai` bien' doi ( trong cau lenh co the de
		// rat nhieu dk where)
		//findOne(User.class,sql,"duynt","111")
		
		TypedQuery<T> query = entityManager.createQuery(sql, clazz);
		for( int i = 0; i <params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<T> result = query.getResultList();
		if(result.isEmpty()) {
			return null;
			
		// kiem tra neu database ko tra ve phan tu nao 
		}
		return result.get(0);
	}
	
	public List<T> findMany(Class<T> clazz, String sql, Object... params) {
		TypedQuery<T> query = entityManager.createQuery(sql, clazz);
		for( int i = 0; i <params.length; i++) {
			query.setParameter(i, params[i]);
	}
		return query.getResultList();

	}
	
	
	//nativequery: ko truyen` class, tra ve list<T> , ma` tra ve list Object va` tu map vs nhau
	@SuppressWarnings("unchecked")
	public List<Object[]> findManyByNativeQuery(String sql, Object... params) {
		Query query = entityManager.createNativeQuery(sql);
		for( int i = 0; i <params.length; i++) {
			query.setParameter(i, params[i]);
	}
		return query.getResultList();
		
	}
	
	
	//INSERT, CREATE
	public T create(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			System.out.println("==> Create thanh` cong !");
			
			return entity;
		} catch (Exception e) {
		entityManager.getTransaction().rollback();
		// roll back neu bi loi~

		System.out.println("==> Khong the insert entity" + entity.getClass().getSimpleName() + "to DB");
		throw new RuntimeException(e);
		}
	}
	
	// UPDATE
	public T update(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			System.out.println("==> Update thanh` cong !");
			
			return entity;
		} catch (Exception e) {
		entityManager.getTransaction().rollback();
		// roll back neu bi loi~

		System.out.println("==> Khong the update entity" + entity.getClass().getSimpleName() + "to DB");
		throw new RuntimeException(e);
		}
	}
	
	// DELETE
	public T delete(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			System.out.println("==> Delete thanh` cong !");
			
			return entity;
		} catch (Exception e) {
		entityManager.getTransaction().rollback();
		// roll back neu bi loi~

		System.out.println("==> Khong the delete entity" + entity.getClass().getSimpleName() + "to DB");
		throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> callStored(String namedStored, Map<String, Object> params) {
			StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery(namedStored);
			params.forEach((key, value) -> query.setParameter(key, value));
			return (List<T>) query.getResultList();
	}
}
