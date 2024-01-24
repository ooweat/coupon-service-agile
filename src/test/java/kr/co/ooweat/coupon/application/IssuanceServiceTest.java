package kr.co.ooweat.coupon.application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class IssuanceServiceTest {
    
    @Test
    void datePlus(){
        log.info("now: {}",
            LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd")));
    
        log.info("datePlus: {}",
            LocalDate.now().plusDays(60
            ).format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd")));
    }
    
}
