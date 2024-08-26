package tobyspring.hellospring.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import tobyspring.hellospring.order.Order;
import tobyspring.hellospring.order.OrderRepository;

import javax.sql.DataSource;

public class JpaOrderRepositoryImpl implements OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public JpaOrderRepositoryImpl(DataSource dataSource) {
    }

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }
}
