package com.nateshao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class NateshaoBoot05LogbackApplicationTests {


    @Test
    void contextLoads() {
        MDC.put("user_id", "1000");

        for (int i = 0; i < 10; i++) {
            log.info("info 级别日志文件输出");
        }
    }

}



































