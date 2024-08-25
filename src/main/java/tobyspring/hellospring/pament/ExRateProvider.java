package tobyspring.hellospring.pament;

import java.io.IOException;
import java.math.BigDecimal;

public interface ExRateProvider {
    abstract BigDecimal getExRate(String currency);

}
