package com.wipro.shopping;

public class LoggingAspect {

    // Before advice
    public void logBefore() {
        System.out.println("[LOG] Method execution started...");
    }

    // After Returning advice
    public void logAfterReturning() {
        System.out.println("[LOG] Method executed successfully.");
    }

    // After Throwing advice
    public void logAfterThrowing(Exception ex) {
        System.out.println("[LOG] Exception occurred: " + ex.getMessage());
    }

    // Around advice (optional - measure execution time)
    public Object logAround(org.aspectj.lang.ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        System.out.println("[LOG] Execution time: " + (end - start) + " ms");
        return result;
    }
}
