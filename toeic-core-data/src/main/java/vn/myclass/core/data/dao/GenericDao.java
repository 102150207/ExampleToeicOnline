package vn.myclass.core.data.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<ID extends Serializable,T> {
        List<T> findAll();
        T update(T entity);
        void save(T entity);
        Integer Delete(List<ID> ids);
        T findById(ID id);
        // findByProperty la tim kiem the truong property co gia tri la value
        // sap xep theo truong nao trong cai bang CSDL va sap xep tang dan or giam dan
        Object [] findByProperty(String property,
                                 Object value,
                                 String sortExpression,
                                 String sortDirection);


}
