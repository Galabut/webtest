package hw8.taxi.dao;

import hw8.taxi.domain.Operator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Galabut on 23.01.2015.
 */
@Repository ("OperatorDaoImpl")
@Transactional
public class OperatorDaoImpl implements OperatorDao {
    private static Logger log = Logger.getLogger(OperatorDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(Operator operator) {
        Long id = 0L;
        try {
            Session session = sessionFactory.getCurrentSession();
            //System.out.println(session.toString());
            id = (Long) session.save(operator);
        } catch (HibernateException e) {
            log.error("Session to Create Operator failed", e);
            e.printStackTrace();
        }
        return id;
    }

    @Override
    @Transactional (readOnly = true)
    public Operator read(Long id) {
        Operator operator = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            operator = (Operator) session.get(Operator.class, id);
        } catch (HibernateException e) {
            log.error("Session to Read Operator failed", e);
        }
        return operator;
    }

    @Override
    @Transactional
    public boolean update(Operator operator) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.update(operator);
        } catch (HibernateException e) {
            log.error("Session to Update Operator failed", e);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean delete(Operator operator) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.delete(operator);
        } catch (HibernateException e) {
            log.error("Session to Delete Operator failed", e);
        }
        return true;
    }

    @Override
    @Transactional (readOnly = true)
    public List<Operator> findAll() {
        List<Operator> operators = null;
        try {
            Session session = sessionFactory.getCurrentSession();

            operators = session.createCriteria(Operator.class).list();
        } catch (HibernateException e) {
            log.error("Session to FindAll Operator failed", e);
        }
        return operators;
    }
}
