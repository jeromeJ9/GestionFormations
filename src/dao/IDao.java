
package dao;

import java.util.List;


public interface IDao<T> {
    
    public List<T> getAll() throws Exception;
    
}
