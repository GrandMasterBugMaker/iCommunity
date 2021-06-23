package com.bailingnan.icommunity;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author bailingnan
 * @date 2021/3/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=ICommunityApplication.class)
@Slf4j
public class LoggerTests {
    @Test
    public void testLogger(){
        log.debug("debug log");
        log.info("info log");
        log.warn("warn log");
        log.error("error log");
    }
}
