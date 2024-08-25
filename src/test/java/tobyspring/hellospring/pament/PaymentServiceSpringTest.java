package tobyspring.hellospring.pament;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tobyspring.hellospring.TestPaymentConfig;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestPaymentConfig.class)
class PaymentServiceSpringTest {

    @Autowired
    PaymentService paymentService;
    @Autowired
    ExRateProviderStub exRateProviderStub;
    @Autowired
    Clock clock;

    @Test
    @DisplayName("prepare 메소드가 요구사항 3가지를 잘 충족했는지 검증")
    void convertedAmount()  {
//      exRate: 1000
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);
//        환율 가져왔니?
        Assertions.assertThat(payment.getExRate()).isEqualByComparingTo(BigDecimal.valueOf(1_000));
        Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo(BigDecimal.valueOf(10_000));

//        exRate: 500
        exRateProviderStub.setExRate(BigDecimal.valueOf(500));
        Payment payment2 = paymentService.prepare(1L, "USD", BigDecimal.TEN);
//        환율 가져왔니?
        Assertions.assertThat(payment2.getExRate()).isEqualByComparingTo(BigDecimal.valueOf(500));
        Assertions.assertThat(payment2.getConvertedAmount()).isEqualByComparingTo(BigDecimal.valueOf(5_000));

//        원화 환산금액 유효시간
//        Assertions.assertThat(payment.getValidUntil().isAfter(LocalDateTime.now()));
//        Assertions.assertThat(payment.getValidUntil().isBefore(LocalDateTime.now().plusMinutes(30)));

    }
    @Test
    void validUntil() {
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        LocalDateTime now = LocalDateTime.now(this.clock);
        LocalDateTime expectedValidUntil = now.plusMinutes(30);

        Assertions.assertThat(payment.getValidUntil()).isEqualTo(expectedValidUntil);
    }

}