package com.jcj.interview.desginpattern.decorator;

import com.jcj.interview.desginpattern.Shape;

/**
 * 实现了 Shape 接口的抽象装置类
 * 把 Shape 对象作为它的实例变量
 */
public abstract class AbstractShapeDecorator {

    protected Shape decoratedShape;

    public AbstractShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}
