package com.jcj.interview.desginpattern;

import com.jcj.interview.desginpattern.decorator.AbstractShapeDecorator;
import com.jcj.interview.desginpattern.decorator.RedShapeDecorator;

public class DesignPatternDemo {
    public static void main(String[] args) {
        decoratorPattern();
    }

    /**
     * 装饰器模式
     * 允许向一个现有的对象添加新的功能，同时又不改变其结构。
     * 创建了一个装饰类，用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能。
     */
    private static void decoratorPattern() {
        Shape circle = new Circle();
        AbstractShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        AbstractShapeDecorator redRectangle = new RedShapeDecorator(new Retangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
