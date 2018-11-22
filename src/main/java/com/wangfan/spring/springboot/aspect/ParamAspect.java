package com.wangfan.spring.springboot.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Parameter;

/**
 * @Author : wangfan
 * @Description :
 * @Date : 2018/9/29 12:23
 */
@Slf4j
@Order(-9000)
@Aspect
@Component
public class ParamAspect {

    @Around("execution(* com.wangfan.spring.springboot..*Controller.*(..))")
    public Object pathVariableNullAssert(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
//        request.startAsync();
        String pathInfo = request.getPathInfo();
        String timestamp = pathInfo.substring(pathInfo.lastIndexOf("/") + 1);
        Signature signature = joinPoint.getSignature();
        MethodSignature ms = (MethodSignature) signature;
        Parameter[] parameters = ms.getMethod().getParameters();
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i].isAnnotationPresent(PathVariable.class)) {
                if (ObjectUtils.isEmpty(args[i])) {
                    log.info("[{}] : [{}] : [{}] 参数不能为空", joinPoint.getTarget().getClass().getName(), ms.getMethod().getName(), parameters[i].getName());
                }
            }
        }
        log.info("[{}] 请求url : [{}], 请求参数 : {}, timestamp : [{}]", joinPoint.getTarget().getClass().getName() + "." + ms.getMethod().getName(), request.getPathInfo(), JSON.toJSONString(args), timestamp);
        return joinPoint.proceed(args);
    }
}
