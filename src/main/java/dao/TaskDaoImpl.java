package dao;


import models.Task;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class TaskDaoImpl implements Dao<Task> {

    public Task findById(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Task.class, id);
    }

    public int save(Task task) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction trn = session.beginTransaction();
        Integer id = (Integer) session.save(task);
        trn.commit();
        session.close();
        return id;
    }

    public void update(Task task, int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction trn = session.beginTransaction();

        task.setId(id);
        session.replicate(task, ReplicationMode.OVERWRITE);
        trn.commit();
        session.close();
    }

    public void delete(Task task) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction trn = session.beginTransaction();
        session.delete(task);
        trn.commit();
        session.close();
    }

    public List<Task> findAll() {
        List<Task> taskList = HibernateSessionFactory.getSessionFactory().openSession()
                .createQuery("FROM models.Task AS T ORDER BY T.priority desc").list();
        return taskList;
    }
}
