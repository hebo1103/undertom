package com.example.demo.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author HB
 * @data 2020/10/9 10:30
 * @Description: 控制层
 */
@Aspect
@Component
@Lazy(false)
public class LoggerAspect {
    @Pointcut("@annotation(com.example.demo.common.aop.MyAnnotation)")
    private void cutMethod() {
        System.out.println("==@Before== lingyejun blog logger : begin");
    }

    /**
     * 前置通知：在目标方法执行前调用
     */
    @Before("cutMethod()")
    public void begin() {
        System.out.println("==@Before== lingyejun blog logger : begin");
    }

    /**
     * 后置通知：在目标方法执行后调用，若目标方法出现异常，则不执行
     */
    @AfterReturning("cutMethod()")
    public void afterReturning() {
        System.out.println("==@AfterReturning== lingyejun blog logger : after returning");
    }

    /**
     * 后置/最终通知：无论目标方法在执行过程中出现一场都会在它之后调用
     */
    @After("cutMethod()")
    public void after() {
        System.out.println("==@After== lingyejun blog logger : finally returning");
    }

    /**
     * 异常通知：目标方法抛出异常时执行
     */
    @AfterThrowing("cutMethod()")
    public void afterThrowing() {
        System.out.println("==@AfterThrowing== lingyejun blog logger : after throwing");
    }

    /**
     * 环绕通知：灵活自由的在目标方法中切入代码
     */
    @Around("cutMethod()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取目标方法的名称
        String methodName = joinPoint.getSignature().getName();
        // 获取方法传入参数
        Object[] params = joinPoint.getArgs();
        MyAnnotation lingyejun = getDeclaredAnnotation(joinPoint);
        System.out.println("==@Around== lingyejun blog logger --》 method name " + methodName + " args " + params[0]);
        // 执行源方法
        Object object = joinPoint.proceed();
        // 模拟进行验证
        if (params != null && params.length > 0 && params[0].equals("Blog Home")) {
            System.out.println("==@Around== lingyejun blog logger --》 " + lingyejun.module() + " auth success");
        } else {
            System.out.println("==@Around== lingyejun blog logger --》 " + lingyejun.module() + " auth failed");
        }
        //打印入参和反参
        System.out.println("注解上面的参数为：" + lingyejun.module());
        return object;
    }

    /**
     * 获取方法中声明的注解
     *
     * @param joinPoint
     * @return
     * @throws NoSuchMethodException
     */
    public MyAnnotation getDeclaredAnnotation(ProceedingJoinPoint joinPoint) throws NoSuchMethodException {
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 反射获取目标类
        Class<?> targetClass = joinPoint.getTarget().getClass();
        // 拿到方法对应的参数类型
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
        // 根据类、方法、参数类型（重载）获取到方法的具体信息
        Method objMethod = targetClass.getMethod(methodName, parameterTypes);
        // 拿到方法定义的注解信息
        MyAnnotation annotation = objMethod.getDeclaredAnnotation(MyAnnotation.class);
        MyAnnotation ann = AnnotationUtils.findAnnotation(objMethod,
                MyAnnotation.class);
        // 返回
        return ann;
    }
}
