package spring.core.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private LoggingAspect() {
    }

    @Pointcut("execution(* *.logEvent(..))")
    private void allLogEventMethods() {
    }

    @Pointcut("execution(* *.get*(..))")
    private void getMethods() {
    }

    @Pointcut("execution(* *.set*(..))")
    private void setMethods() {
    }

    @Before("allLogEventMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("BEFORE: " + joinPoint.getTarget().getClass().getSimpleName() + " " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "allLogEventMethods()", returning = "returnedValue")
    public void logAfter(Object returnedValue) {
        System.out.println("Returned value: " + returnedValue);
    }

    @AfterThrowing(pointcut = "allLogEventMethods()", throwing = "ex")
    public void logAfterThrow(Throwable ex) {
        System.out.println("Thrown: " + ex);
    }

    @Before("setMethods()")
    public void setBefore(JoinPoint joinPoint) {
        System.out.println("BEFORE: " + joinPoint.getTarget().getClass().getSimpleName() + " " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "getMethods()", returning = "returnedValue")
    public void getAfter(JoinPoint joinPoint, Object returnedValue) {
        System.out.println("After: " + joinPoint.getTarget().getClass().getSimpleName() + " " + joinPoint.getSignature().getName());
        System.out.println("Returned value: " + returnedValue);
    }

//    @Around("allLogEventMethods()")
//    public Object advice(ProceedingJoinPoint pjp) throws Throwable {
//        return (String) pjp.proceed();
//    }
}
