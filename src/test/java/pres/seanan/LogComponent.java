package pres.seanan;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogComponent {

    @Pointcut("execution(public * pres.seanan.page.*.*(..))")
    public void myMethod() {
    }

    @After("myMethod()")
    public void after() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

