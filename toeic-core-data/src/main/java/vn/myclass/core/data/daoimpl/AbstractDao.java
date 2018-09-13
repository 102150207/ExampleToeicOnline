package vn.myclass.core.data.daoimpl;



import org.hibernate.*;
import vn.myclass.core.common.constant.CoreConstant;
import vn.myclass.core.common.utils.HibernateUtil;
import vn.myclass.core.data.dao.GenericDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;


public class AbstractDao<ID extends Serializable,  T  > implements GenericDao<ID,T> {

    private Class<T> persistenceClass;


    public String getPersistenceClass() {
        return persistenceClass.getSimpleName();
    }

    public AbstractDao() {
        this.persistenceClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        // ID tương ứng là vị trí 0
        // getActualTypeArguments()[1] :Tức là lấy tham số tại vị trí 1 tức là T
    }

//    protected Session getSession(){
//        return HibernateUtil.getSessionFactory().openSession();
//    }

    public List<T> findAll() {
        List<T> list = new ArrayList<T>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder hql = new StringBuilder("from ");
            hql.append(this.getPersistenceClass());
            Query query = session.createQuery(hql.toString());
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return list;
    }

    public T update(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        T result = null;
        try {
            Object object =  session.merge(entity);
            result = (T) object;
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return result;
    }

    public void save(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(entity);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }

    }

    public Integer Delete(List<ID> ids) {
        Integer count = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
         try {
                for(ID item : ids){
                    T t = (T) session.get(persistenceClass,item);
                    session.delete(t);
                    count++;
                }
                transaction.commit();
         }catch (HibernateException e){
             transaction.rollback();
                throw e;

         }finally {
            session.close();
         }
        return  count;
    }

    public T findById(ID id) {
        T result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();

        try {
            result = (T) session.get(persistenceClass,id);
            if(result == null){
                throw new ObjectNotFoundException("NOT FIND "+id,null);
            }
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return result;
    }

    public Object[] findByProperty(String property, Object value, String sortExpression, String sortDirection) {
        List<T> list = new ArrayList<T>();
        Object totalSize = 0;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder("from ");
            sql.append(this.getPersistenceClass());
            if(property != null && value != null){
                sql.append(" where ").append(property).append(" = :value");
            }
            if(sortDirection != null && sortDirection != null){
                sql.append(" order by ").append(sortExpression);
                sql.append(" "+(sortDirection.equals(CoreConstant.SORT_ASC)?"acs":"desc"));
            }
            Query query1 = session.createQuery(sql.toString());
            if(value != null){
                query1.setParameter("value",value);
            }
            list = query1.list();
            /* query2 la lay kich thuoc cua list*/
            StringBuilder sql2 = new StringBuilder("select count(*) from ");
            sql2.append(getPersistenceClass());
            if(property != null && value != null) {
                sql2.append(" where ").append(property).append("= :value");
            }
            Query query2 = session.createQuery(sql2.toString());
            if(value != null){
                query2.setParameter("value",value);
            }
            totalSize = query2.list().get(0);

            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }

        return new Object[]{totalSize,list};
    }
}
