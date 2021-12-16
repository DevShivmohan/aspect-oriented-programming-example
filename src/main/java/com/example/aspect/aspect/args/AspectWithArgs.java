package com.example.aspect.aspect.args;

import com.example.aspect.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AspectWithArgs {

    /**
     * aspect using argument
     * @param proceedingJoinPoint
     * @param name
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.example.aspect.service.UserService.getUserName(java.lang.String)) && args(name)")
    public Object aroundAspect(ProceedingJoinPoint proceedingJoinPoint, String name) throws Throwable {
        log.info("Requested for name "+name);
        Object response= proceedingJoinPoint.proceed();
        log.info("After proceedingJoinPoint response: "+response);
        return response;
    }

    /**
     * before aspect using argument
     * @param joinPoint
     * @param name
     */
    @Before("execution(* com.example.aspect.service.UserService.getUserName(java.lang.String)) && args(name)")
    public void before(JoinPoint joinPoint,String name){
        log.info("Before service execute with arg: "+name);
        throw new UserNotFoundException("Sorry user not found by name "+name);
    }
}
