package com.jcj.interview.desginpattern.decorator;

import com.jcj.interview.desginpattern.Shape;

/**
 * 实现了 ShapeDecorator 的实体类
 * 在原有 Shape 基础上，增加了红色边框，进行包装
 */
public class RedShapeDecorator extends AbstractShapeDecorator{
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
