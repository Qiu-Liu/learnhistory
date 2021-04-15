package com.example.consul_demo.TemplateMethod;

public class Teacher  extends AbstractPerson{
    @Override
    protected void dressUp() {
        System.out.println("teacher,dressUp");
    }

    @Override
    protected void eatBreakfast() {
        System.out.println("teacher,eatBreakfast");
    }

    @Override
    protected void takeThings() {
        System.out.println("teacher,eatBreakfast");
    }
}
