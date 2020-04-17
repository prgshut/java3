package HW7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MainStart {
    public static void main(String[] args) {
        start(TestClass.class);
    }

    private static void start(Object o) {
        Map<Integer, Set<Method>> mapMethod = new TreeMap<>();
        Class cla = (Class) o;
        int counterMethodBefore = 0;
        int counterMethodAfter = 0;
        Set<Method> methodSet;
        Method[] methods = cla.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                counterMethodBefore++;
                methodSet = new LinkedHashSet<Method>();
                methodSet.add(method);
                mapMethod.put(Integer.MIN_VALUE, methodSet);
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                counterMethodAfter++;
                methodSet = new LinkedHashSet<Method>();
                methodSet.add(method);
                mapMethod.put(Integer.MAX_VALUE, methodSet);
            }
        }
        if (counterMethodAfter > 1 || counterMethodBefore > 1) {
            throw new RuntimeException("Присутствует больше одной анатаци AfterSuite или BeforeSuite");
        }
        for (Method method : methods) {
            if (method.getAnnotation(BeforeSuite.class) == null && method.getAnnotation(AfterSuite.class) == null){
                if (mapMethod.containsKey(method.getAnnotation(Test.class).priority())){
                    methodSet=mapMethod.get(method.getAnnotation(Test.class).priority());
                    methodSet.add(method);
                    mapMethod.put(method.getAnnotation(Test.class).priority(),methodSet);
                }else {
                    methodSet= new LinkedHashSet<Method>();
                    methodSet.add(method);
                    mapMethod.put(method.getAnnotation(Test.class).priority(),methodSet);
                }
            }
        }
        for (Integer key : mapMethod.keySet()) {
            for(Method method:mapMethod.get(key)){
                try {
                    method.invoke(cla.newInstance());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
