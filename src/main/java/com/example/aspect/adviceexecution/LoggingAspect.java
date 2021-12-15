package com.example.aspect.adviceexecution;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    private Logger logger= LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * * any return type in given package com.example.aspect
     * called by any packages under the com.example.aspect
     * .* any class
     * .* any methods
     *  .*(..) n no. of arguments
     *//*
    @Pointcut(value = "execution(* com.example.aspect.*.*.*(..) )")
    public void myPointCut(){}*/

    /**
     * called before invoke controller method
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    /*
    @Around(value = "myPointCut()")
    public ResponseEntity<?> logger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper objectMapper=new ObjectMapper();
        String methodName=proceedingJoinPoint.getSignature().getName();
        String className=proceedingJoinPoint.getClass().toString();
        Object[] args=proceedingJoinPoint.getArgs();
        logger.info("method invoked: "+className+" : "+methodName+" : arguments: "+objectMapper.writeValueAsString(args));
        Object object=proceedingJoinPoint.proceed(); // response returned by controller
        logger.info(className+" : "+methodName+" : Response : "+objectMapper.writeValueAsString(object));
        return new ResponseEntity<>("Here are problem", HttpStatus.OK); // getting response to client
    }
    */


    /**
     * execute this method before executing methods inside this package com.example.aspect
     * @param joinPoint
     */
    /*
    @Before(value = "myPointCut()")
    public void before(JoinPoint joinPoint){
        log.info("Before method invoked :: "+joinPoint.getSignature());
    }
    */


    /**
     * this method is executed after when controller returned the response
     * @param joinPoint
     * @param list
     */
    /*
    @AfterReturning(value = "execution(* com.example.aspect.*.*.*(..) )",returning = "list")
    public void afterReturn(JoinPoint joinPoint, List<Integer> list){
        log.info("After returning : "+joinPoint.getSignature()+" response : "+list);
    }
    */

    /**
     * this method executed when throw any exception in controller classes
     * @param joinPoint
     * @param exception
     * @return
     */
    /*
    @AfterThrowing(value = "execution(* com.example.aspect.*.*.*(..) )",throwing = "exception")
    public ResponseEntity<?> afterThrowing(JoinPoint joinPoint, Exception exception){
        log.info( "After throwing message : "+exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }
    */

    /**
     * point cut apply only inside the com.example.aspect.controller package
     * point cut apply only this AspectController class
     */
//    @Pointcut(value = "within(com.example.aspect.controller.*)")
//    @Pointcut(value = "this(com.example.aspect.controller.AspectController)")
//    public void pointCut(){}

//    @Before(value = "pointCut()")
//    public void myPointCut(JoinPoint joinPoint){
//        log.info("executed "+joinPoint.getSignature());
//    }

    @Pointcut(value = "@annotation(com.example.aspect.annotation.CustomAnnotation)")
    public void pointCut1(){}

    @Before(value = "pointCut1()")
    public void before(JoinPoint joinPoint){
        log.info("Custom annotation before executed");
    }

    @After(value = "pointCut1()")
    public void after(JoinPoint joinPoint){
        log.info("Custom annotation after executed");
    }
}
