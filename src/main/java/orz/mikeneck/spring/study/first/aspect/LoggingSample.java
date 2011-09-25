package orz.mikeneck.spring.study.first.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/10
 * Time: 17:47
 * To change this template use File | Settings | File Templates.
 */
@Aspect
public class LoggingSample {

    @Around("execution(* say())")
    public Object logAround(ProceedingJoinPoint point) throws Throwable {
        String method = point.getSignature().getName();
        StopWatch stopWatch = new StopWatch();

        stopWatch.start(method);

        System.out.println("Start : " + method);
        Object object = point.proceed();
        
        stopWatch.stop();

        System.out.println("Finish : " + method);
        System.out.println("Time : " + (stopWatch.getTotalTimeMillis() / 1000) + " sec.");

        return object;

    }
}
