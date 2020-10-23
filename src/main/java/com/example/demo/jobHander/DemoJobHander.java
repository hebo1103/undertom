package com.example.demo.jobHander;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author HB
 * @data 2020/9/17 19:46
 * @Description: 控制层
 */
@Component
public class DemoJobHander {

    private static Logger logger = LoggerFactory.getLogger(DemoJobHander.class);

//    /**
//     * 1、简单任务示例（Bean模式）
//     */
//    @XxlJob("demoJobHandler")
//    public ReturnT<String> demoJobHandler(String param) throws Exception {
//        XxlJobLogger.log("XXL-JOB, Hello World.");
//        logger.info("111111111111111简单任务实例执行开始==================");
//        for (int i = 0; i < 5; i++) {
//            XxlJobLogger.log("beat at:" + i);
////            TimeUnit.SECONDS.sleep(2);
//        }
//        logger.info("22222222222222简单任务实例执行结束==================");
//        XxlJobLogger.log("XXL-JOB, IS OVER.");
//        return ReturnT.SUCCESS;
//    }

}
