package tobyspring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import tobyspring.hellospring.data.JpaOrderRepositoryImpl;
import tobyspring.hellospring.order.OrderRepository;
import tobyspring.hellospring.order.OrderService;

@Configuration
@Import(DataConfig.class)
public class OrderConfig {

    @Bean
    public OrderRepository orderRepository(){
        return new JpaOrderRepositoryImpl();
    }
    @Bean
    public OrderService orderService(JpaTransactionManager transactionManager){
        return new OrderService(orderRepository(), transactionManager);
    }

}
