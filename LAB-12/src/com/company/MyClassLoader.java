package com.company;


import org.junit.Test;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MyClassLoader extends ClassLoader {
    public Class<?> defineClass(String name, byte[] classBytes) {
        return defineClass(name, classBytes, 0, classBytes.length);
    }

    public  static void main(String []args) throws  Exception
    {
        Path path = Paths.get("/home/iulian/Documents/Test/out/production/Test/com/company/Main.class");
        MyClassLoader loader = new MyClassLoader();
        Class cls = loader.defineClass("com.company.Main", Files.readAllBytes(path));
        loader.loadClass("com.company.Main");
        System.out.println("Package :" + cls.getPackageName());

        int passed = 0 , failed = 0;
        System.out.println("Canonical name : " + cls.getCanonicalName());
        System.out.println("Name :" + cls.getName());
        for(Method m : cls.getMethods())
        {
            System.out.println("Method : " + m.getName());
            if (m.isAnnotationPresent(Test.class))
            {
                try {m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);

        path = Paths.get("/home/iulian/Public/Facultate/Programare-avansata/LAB-12/src/com/company/CustomClass.class");
        loader = new MyClassLoader();
         cls = loader.defineClass("com.company.CustomClass", Files.readAllBytes(path));
        loader.loadClass("com.company.CustomClass");
        System.out.println("Package :" + cls.getPackageName());

        passed = 0;
        failed = 0;
        System.out.println("Canonical name :   " +  cls.getCanonicalName());
        System.out.println("Name :  " + cls.getName());
        for(Method a :   cls.getMethods()) {
            System.out.println("Method : " + a.getName());
            if (a.isAnnotationPresent(Test.class)) {
                try {
                    a.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n", a, ex.getCause());
                    failed++;
                }
            }
        }
    }
}
