package tobyspring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobyspring.hellospring.api.ApiTemplate;
import tobyspring.hellospring.api.ErApiExRateExtractor;
import tobyspring.hellospring.api.SimpleApiExecutor;
import tobyspring.hellospring.exrate.CachedExRateProviderImpl;
import tobyspring.hellospring.pament.ExRateProvider;
import tobyspring.hellospring.exrate.WebApiExRateProviderImpl;
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
        return new WebApiExRateProviderImpl(apiTemplate());
    }
    @Bean
    ApiTemplate apiTemplate(){return new ApiTemplate(new SimpleApiExecutor(), new ErApiExRateExtractor());}
    @Bean
    public Clock clock(){
        return Clock.systemDefaultZone();
    }
    @Bean
    public CachedExRateProviderImpl cachedExRateProvider(){
        return new CachedExRateProviderImpl(exRateProvider());
    }

}
