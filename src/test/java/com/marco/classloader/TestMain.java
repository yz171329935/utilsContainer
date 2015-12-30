package com.marco.classloader;

import com.marco.utils.classloader.ClassUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by marco on 15/12/30.
 */
public class TestMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Class> classList = ClassUtils.getAllClassesByInterface(Iface.class);
        System.out.println(classList);
    }
}
