package com.rhk.TaskManagement.API.Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rhk.TaskManagement.API.Entity.Tasks;

@Repository
public class tasksRepository {
	@Autowired
	SessionFactory factory;
	
	public String saveTask(Tasks tasks) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(tasks);
			tx.commit();
			msg = "Task saved successfully";
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return msg;
	}
	
	public String updateTask(Tasks tasks, long id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Tasks record = session.get(Tasks.class, id);
			record.setTitle(tasks.getTitle());
			record.setDescription(tasks.getDescription());
			record.setCompleted(tasks.isCompleted());
			session.merge(record);
			tx.commit();
			msg = "Task updated successfully";
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return msg;
	}
	
	public String deleteTask(long id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Tasks record = session.get(Tasks.class, id);
			record.getId();
			session.remove(record);
			tx.commit();
			msg = "Task deleted successfully";
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return msg;
	}
	
	public Tasks fetchTaskById(long id) {
		Session session = null;
		Transaction tx = null;
		Tasks tsk = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Tasks where id=:id";
			Query<Tasks> query = session.createQuery(hqlQuery, Tasks.class);
			query.setParameter("id", id);
			tsk = query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return tsk;
	}
	
	public List<Tasks> fetchAllTasks() {
		Session session = null;
		Transaction tx = null;
		List<Tasks> list = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Tasks";
			Query<Tasks> query = session.createQuery(hqlQuery, Tasks.class);
			list = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return list;
	}
}
