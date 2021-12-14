package com.example.aspect.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger= LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * called by any packages under the com.example.aspect
     * .* any class
     * .* any methods
     *  .*(..) n no. of arguments
     */
    @Pointcut(value = "execution(* com.example.aspect.*.*.*(..) )")
    public void myPointCut(){}

    /**
     * called before invoke controller method
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
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
}
