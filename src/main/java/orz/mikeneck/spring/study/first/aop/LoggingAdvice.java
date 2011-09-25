package orz.mikeneck.spring.study.first.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/10
 * Time: 16:07
 * To change this template use File | Settings | File Templates.
 */
public class LoggingAdvice implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String method = invocation.getMethod().getName();
        StopWatch stopWatch = new StopWatch();

        stopWatch.start(method);

        System.out.println("Start : " + method);
        Object object = invocation.proceed();

        stopWatch.stop();

        System.out.println("Finished : " + method);
        System.out.println("Time : " + (stopWatch.getTotalTimeMillis() / 1000) + " sec.");

        return object;
    }
}
