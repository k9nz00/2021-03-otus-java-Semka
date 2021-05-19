package ru.otus.hw10;

import ru.otus.hw10.annotations.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class IocDemo {

    private IocDemo() {
    }

    static TestLoggingInterface createTestLoggingClass() {
        InvocationHandler handler = new DemoInvocationHandler(new TestLogging());
        return (TestLoggingInterface) Proxy.newProxyInstance(
                IocDemo.class.getClassLoader(),
                new Class<?>[]{TestLoggingInterface.class},
                handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final TestLoggingInterface myClass;

        DemoInvocationHandler(TestLoggingInterface myClass) {
            this.myClass = myClass;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Выполнение метода: " + method.getName());
            if (method.isAnnotationPresent(Log.class)){
                System.out.println("Логирование параметров из Proxy-класса");
                for (Object param : args){
                    System.out.println(param);
                }
                System.out.println("Параметры методы были залогированы");
                System.out.println("------------------------------------");
                System.out.println();
            }
            return method.invoke(myClass, args);
        }

        @Override
        public String toString() {
            return "DemoInvocationHandler{" +
                    "myClass=" + myClass +
                    '}';
        }
    }
}
