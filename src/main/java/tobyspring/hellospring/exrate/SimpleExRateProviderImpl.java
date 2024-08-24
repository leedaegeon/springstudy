package tobyspring.hellospring.exrate;

import tobyspring.hellospring.pament.ExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;
public class SimpleExRateProviderImpl implements ExRateProvider {

    @Override
    public BigDecimal getExRate(String currency) throws IOException {
        if(currency.equals("USD")) return BigDecimal.valueOf(1000);

        throw new IllegalArgumentException("지원하지 않는 통화입니다.");
    }
}
