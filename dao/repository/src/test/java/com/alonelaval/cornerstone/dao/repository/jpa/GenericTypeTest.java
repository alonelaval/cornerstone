package com.alonelaval.cornerstone.dao.repository.jpa;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author huawei
 * @create 2018-07-29
 **/

public class GenericTypeTest {
    static class Test1 extends T<Person, Animal> {

    }

    static class Test2 implements I<Person, Animal>, I2<Fruit> {
    }

    public static void main(String[] args) {
        //获取类定义上的泛型类型
        Test1 test1 = new Test1();
        Type types = test1.getClass().getGenericSuperclass();

        Type[] genericType = ((ParameterizedType) types).getActualTypeArguments();
        for (Type t : genericType) {
            System.out.println(t.getTypeName());
        }
        System.out.println("===============================================");

        //获取接口定义上的泛型类型
        Test2 test2 = new Test2();
        //一个类可能实现多个接口,每个接口上定义的泛型类型都可取到
        Type[] interfacesTypes = test2.getClass().getGenericInterfaces();
        for (Type t : interfacesTypes) {
            Type[] genericType2 = ((ParameterizedType) t).getActualTypeArguments();
            for (Type t2 : genericType2) {
                System.out.println(t2.getTypeName());
            }
        }


    }
}

class T<T1, T2> {
    public void printT(T1 t1, T2 t2) {
        System.out.println(t1.getClass());
        System.out.println(t2.getClass());
    }
}

interface I<T1, T2> {
}

interface I2<K> {

}

class Person {
    @Override
    public String toString() {
        return "Person Type";
    }
}

class Animal {
    @Override
    public String toString() {
        return "Animal Type";
    }
}

class Fruit {
    @Override
    public String toString() {
        return "Fruit Type";
    }
}