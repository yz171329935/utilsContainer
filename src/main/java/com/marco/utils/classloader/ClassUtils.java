package com.marco.utils.classloader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by marco on 15/12/29.
 */
@SuppressWarnings("all")
public class ClassUtils {

    /**
     * 获取interface当前包内的实例class
     * @return List<Class>
     * */
    public static List<Class> getAllClassesByInterface(Class c) throws IOException, ClassNotFoundException {
        List<Class> returnClasses = new ArrayList<Class>();

        //if class is not interface, return immediately.
        if(!c.isInterface()){ return returnClasses; }

        String packageName = c.getPackage().getName();
        //acquire all classes under the package
        List<Class> allClasses = getClasses(packageName);

        for(Class clazz : allClasses){
            if(c.isAssignableFrom(clazz) && !c.equals(clazz)){
                returnClasses.add(clazz);
            }
        }
        return returnClasses;
    }

    private static List<Class> getClasses(String packageName) throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        List<File> dirs = new ArrayList<File>();
        Enumeration<URL> enumeration =  classLoader.getResources(path);
        while (enumeration.hasMoreElements()){
            URL resource = enumeration.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        List<Class> classes = new ArrayList<Class>();
        for(File dir : dirs){
            classes.addAll(findClasses(dir, packageName));
        }
        return classes;
    }

    private static List<Class> findClasses(File dir, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!dir.exists()) {
            return classes;
        }
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

}
