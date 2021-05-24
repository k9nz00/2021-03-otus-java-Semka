package ru.otus.hw10;

import ru.otus.hw10.annotations.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class IocDemo {

    private static Set<String> methodsWithLogAnnotate = new HashSet<>();

    private IocDemo() {
    }

    static TestLoggingInterface createTestLoggingClass() {

        Method[] methods = TestLogging.class.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Log.class)) {
                methodsWithLogAnnotate.add(getMethodSignature(method));
            }
        }
        InvocationHandler handler = new DemoInvocationHandler(new TestLogging());

        return (TestLoggingInterface) Proxy.newProxyInstance(
                IocDemo.class.getClassLoader(),
                new Class<?>[]{TestLoggingInterface.class},
                handler);
    }

    private static String getMethodSignature(Method method) {
        return method.getName() + Arrays.asList(method.getParameterTypes()).toString();
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final TestLoggingInterface myClass;

        DemoInvocationHandler(TestLoggingInterface myClass) {
            this.myClass = myClass;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Выполнение метода: " + method.getName());

            if (methodsWithLogAnnotate.contains(getMethodSignature(method))) {
                System.out.println("Логирование параметров из " + method.getName() + " с параметрами " + Arrays.toString(method.getParameterTypes()));
                Arrays.stream(args).forEach(System.out::println);
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
