package org.msx.software.edu.system.business.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.msx.software.edu.system.controller.util.IgnoreLogging;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class LoggingAdvice {

    @Pointcut(value = "execution(* org.msx.software.edu.system.model.entity.Category(..))")
    public void myPointcut() {
    }

    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        IgnoreLogging ignoreAnnotation = method.getAnnotation(IgnoreLogging.class);
        if (ignoreAnnotation == null) {
            String methodName = method.getName();
            String className = pjp.getTarget().getClass().getCanonicalName();
            Object[] args = pjp.getArgs();
            ObjectMapper mapper = new ObjectMapper();
            log.info(
                    "--- before call --- " + className + "." +
                            methodName + "() : args : " + mapper.writeValueAsString(args));
            long startTime = System.currentTimeMillis();
            Object proceed = pjp.proceed();
            long endTime = System.currentTimeMillis();
            log.info(
                    "--- after call --- " + className + "." +
                            methodName + "() : response : " + mapper.writeValueAsString(proceed));
            log.info(
                    "--- execution time --- " + className + "." +
                            methodName + "() : time millis : " + (endTime - startTime));
            return proceed;
        } else {
            return pjp.proceed();
        }
    }
}