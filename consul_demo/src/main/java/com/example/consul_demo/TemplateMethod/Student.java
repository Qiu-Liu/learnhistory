package com.example.consul_demo.TemplateMethod;

public class Student extends AbstractPerson {
    @Override
    protected void dressUp() {
        System.out.println("student,dressUp");
    }

    @Override
    protected void eatBreakfast() {
        System.out.println("student,eatBreakfast");
    }

    @Override
    protected void takeThings() {
        System.out.println("student,eatBreakfast");
    }
}
