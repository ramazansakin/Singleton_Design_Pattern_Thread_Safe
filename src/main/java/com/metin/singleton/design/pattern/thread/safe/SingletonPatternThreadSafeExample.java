package com.metin.singleton.design.pattern.thread.safe;

import java.io.Serializable;

public class SingletonPatternThreadSafeExample implements Serializable {

    private static volatile SingletonPatternThreadSafeExample instance;

    protected SingletonPatternThreadSafeExample() {
    }

    public static SingletonPatternThreadSafeExample getInstance() {
        SingletonPatternThreadSafeExample result = instance;
        if (result == null) {

            synchronized (SingletonPatternThreadSafeExample.class) {
                if (result == null) {
                    instance = result = new SingletonPatternThreadSafeExample();
                }
            }
        }
        return result;
    }

    public Object readResolve(){
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}


