package com.jcj.interview.aop;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalculatorProxy{

    /**
     * 为传入的参数对象创建一个动态代理对象
     * @param calculator 被代理对象
     * @return 代理对象
     */
    public static ICalculator getProxy(ICalculator calculator) {
        ClassLoader loader = calculator.getClass().getClassLoader();
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        InvocationHandler handler = (proxy, method, args) -> {
            before(method, args);
            // 利用反射执行被代理对象的目标方法
            Object result = method.invoke(calculator, args);
            after(method, result);
            return result;
        };
        // 创建动态代理实例
        Object proxyInstance = Proxy.newProxyInstance(loader, interfaces, handler);
        return (ICalculator) proxyInstance;
    }

    private static void before(Method method, Object[] args){
        System.out.println(String.format("[%s]开始执行，参数列表 = %s", method.getName(),Arrays.asList(args)));
    }

    private static void after(Method method, Object result) {
        System.out.println(String.format("[%s]执行完成，返回结果 = %s", method.getName(), result));
    }




}
