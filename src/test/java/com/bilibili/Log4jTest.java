package com.bilibili;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class Log4jTest {
    @Test
    public void contextLoads(){
        log.trace("I am trace log.");
        log.debug("I am debug log.");
        log.warn("I am warn log.");
        log.error("I am error log.");
        log.error("写入文件");
    }
}
