package tobyspring.hellospring.order;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import tobyspring.hellospring.data.JpaOrderRepositoryImpl;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
     Order createOrder(String no, BigDecimal total) ;
     List<Order> createOrders(List<OrderReq> reqs);
}
