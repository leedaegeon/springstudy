package tobyspring.hellospring.exrate;

import tobyspring.hellospring.api.*;
import tobyspring.hellospring.pament.ExRateProvider;

import java.math.BigDecimal;

public class WebApiExRateProviderImpl implements ExRateProvider {
    ApiTemplate apiTemplate = new ApiTemplate();

    @Override
    public BigDecimal getExRate(String currency) {

        String url = "https://open.er-api.com/v6/latest/" + currency;
//        return runApiForExRate(url, new SimpleApiExecutor(), response -> {
//            ObjectMapper mapper = new ObjectMapper();
//            ExRateDate data = mapper.readValue(response, ExRateDate.class);
//            return data.rates().get("KRW");
//        });
        return apiTemplate.getExRate(url, new SimpleApiExecutor(), new ErApiExRateExtractor());
    }

}
