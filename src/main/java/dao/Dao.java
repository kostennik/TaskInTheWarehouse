package dao;

import java.util.List;

public interface Dao<T> {
    public T findById (int id);

    public int save (T models);

    public void update(T model, int id);

    public void delete (T models);

    public List<T> findAll ();
}
