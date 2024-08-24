package tobyspring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobyspring.hellospring.exrate.CachedExRateProviderImpl;
import tobyspring.hellospring.pament.ExRateProvider;
import tobyspring.hellospring.exrate.WebExRateProviderImpl;
import tobyspring.hellospring.pament.PaymentService;

import java.time.Clock;

@Configuration
public class PaymentConfig {
    @Bean
    public PaymentService paymentService(){
        return new PaymentService(exRateProvider(), clock());
    }
    @Bean
    public ExRateProvider exRateProvider(){
        return new WebExRateProviderImpl();
    }
    @Bean
    public Clock clock(){
        return Clock.systemDefaultZone();
    }
    @Bean
    public CachedExRateProviderImpl cachedExRateProvider(){
        return new CachedExRateProviderImpl(exRateProvider());
    }

}
