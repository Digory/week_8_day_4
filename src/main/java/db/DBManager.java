package db;

import models.Administrator;
import models.Department;
import models.Employee;
import models.Manager;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBManager {
    private static Session session;

    public static List<Administrator> getAdministratorsForManager(Manager manager){
        List<Administrator> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Administrator.class);
            cr.add(Restrictions.eq("manager", manager));
            results = cr.list();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static Department getDepartmentForManager(Manager manager){
        Department result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Department.class);
            cr.add(Restrictions.eq("manager", manager));
            result = (Department) cr.uniqueResult();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } finally{
            session.close();
        }
        return result;
    }



}
