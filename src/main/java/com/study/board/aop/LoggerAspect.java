package com.study.board.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

@Slf4j
@Aspect
@Component
public class LoggerAspect {
    // 보드의 모든 하위 패키지 중 파라미터가 0 개 이상인 모든 메서드를 의미
    @Around("execution(* com.study.board..*Controller.*(..)) "
        + "|| execution(* com.study.board..*Service.*(..)) "
        + "|| execution(* com.study.board..*Mapper.*(..))")
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {
        String name = joinPoint.getSignature().getDeclaringTypeName();
        String type =
            StringUtils.contains(name, "Controller") ? "Controller ===> " :
                StringUtils.contains(name, "Service") ? "Service ===> " :
                    StringUtils.contains(name, "Mapper") ? "Mapper ===> " :
                        "";
        log.debug(type + name + ", " + joinPoint.getSignature().getName() + "()");
        return joinPoint.proceed();
    }
}
