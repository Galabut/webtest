package hw8.taxi.dao;

import hw8.taxi.domain.Operator;

import java.util.List;

/**
 * Created by Galabut on 23.01.2015.
 */
public interface OperatorDao {
    Long create(Operator operator);
    Operator read(Long id);
    boolean update(Operator operator);
    boolean delete(Operator operator);
    List<Operator> findAll();

}
