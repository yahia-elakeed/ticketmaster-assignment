package com.ticketmaster.assignment.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/*@Aspect
@Component*/
// Disabled to avoid any delay in performance, to enable it needs the upper 2 lines to uncommented and update logging.level.com.ticketmaster.assignment property to DEBUG
@Slf4j
public class LoggingAspect {

    /**
     * Pointcut that matches all services and web REST endpoints.
     */
    @Pointcut("within(com.ticketmaster.assignment..*)")
    public void assignmentPointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advice.
    }


    /**
     * Advice that logs when a method is entered and exited.
     *
     * @param joinPoint join point for advice
     * @return result
     * @throws Throwable throws Exception
     */
    @Around("assignmentPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        if (!log.isDebugEnabled()) return joinPoint.proceed();

        log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        try {
            Object result = joinPoint.proceed();
            log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), result);

            return result;
        } catch (Exception e) {
            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
            throw e;
        }
    }
}
