package com.xtremelabs.robolectric;

import javassist.CtClass;

public interface ClassHandler {
    void instrument(CtClass ctClass);

    void beforeTest();

    void afterTest();

    Object methodInvoked(Class clazz, String methodName, Object instance, String[] paramTypes, Object[] params);
}
