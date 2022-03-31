package com.jcj.interview.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect {

    public static void main(String[] args) throws Exception {
        Class userClass = Class.forName(User.class.getName());
        User user = (User) userClass.newInstance();
        System.out.println(userClass.getName());
        Method sayHi = userClass.getDeclaredMethod("sayHi", String.class);
        Field usernameField = userClass.getDeclaredField("username");
        usernameField.setAccessible(true);
        usernameField.set(user, "JCJ");
        sayHi.invoke(user, "Hello,");

    }
}
