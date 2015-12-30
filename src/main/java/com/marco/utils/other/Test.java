package com.marco.utils.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by marco on 15/12/29.
 */
public class Test {
    public static void main(String[] args) {
        List<String> arrayListObj = new ArrayList<String>();
        Object obj = new Object();
        //a是否是b的实例(a是否是从b派生来的)
        System.out.println(arrayListObj instanceof Object);
        System.out.println(arrayListObj instanceof List);
        System.out.println(arrayListObj instanceof ArrayList);
        System.out.println(arrayListObj instanceof Map);
        System.out.println(obj instanceof List);
        System.out.println("#####################################");
        //b是否是a的实例,与instanceof正好相反
        System.out.println(Object.class.isInstance(arrayListObj));
        System.out.println(List.class.isInstance(arrayListObj));
        System.out.println(ArrayList.class.isInstance(arrayListObj));
        System.out.println(Map.class.isInstance(arrayListObj));
        System.out.println(List.class.isInstance(obj));
        System.out.println("#####################################");
        System.out.println(arrayListObj.getClass().isInstance(obj));
        System.out.println(arrayListObj.getClass().isInstance(arrayListObj));
        System.out.println(arrayListObj.getClass().isInstance(arrayListObj));
        System.out.println(arrayListObj.getClass().isInstance(new HashMap()));
        System.out.println(obj.getClass().isInstance(arrayListObj));
        System.out.println("#####################################");
        //b是否是a的实例(b是否从a派生而来)与instanceof正好相反
        System.out.println(arrayListObj.getClass().isAssignableFrom(Object.class));
        System.out.println(arrayListObj.getClass().isAssignableFrom(List.class));
        System.out.println(arrayListObj.getClass().isAssignableFrom(ArrayList.class));
        System.out.println(arrayListObj.getClass().isAssignableFrom(Map.class));
        System.out.println(obj.getClass().isAssignableFrom(List.class));
        System.out.println("#####################################");
        //b是否是a的实例(b是否从a派生而来)与instanceof正好相反
        System.out.println(Object.class.isAssignableFrom(arrayListObj.getClass()));
        System.out.println(List.class.isAssignableFrom(arrayListObj.getClass()));
        System.out.println(ArrayList.class.isAssignableFrom(arrayListObj.getClass()));
        System.out.println(Map.class.isAssignableFrom(arrayListObj.getClass()));
        System.out.println(List.class.isAssignableFrom(obj.getClass()));
    }
}
