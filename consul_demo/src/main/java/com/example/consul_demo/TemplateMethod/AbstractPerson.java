package com.example.consul_demo.TemplateMethod;

/**
 * 模版方法
 * 优点：
 * 提高代码复用性
 * 将相同部分的代码放在抽象的父类中
 * 提高了拓展性
 * 将不同的代码放入不同的子类中，通过对子类的扩展增加新的行为
 * 实现了反向控制
 * 通过一个父类调用其子类的操作，通过对子类的扩展增加新的行为，实现了反向控制 & 符合“开闭原则”
 * 缺点：
 * 引入了抽象类，每一个不同的实现都需要一个子类来实现，导致类的个数增加，从而增加了系统实现的复杂度。
 */
public abstract class AbstractPerson {
    //抽象类定义整个流程骨架
    public void prepareGotoSchool(){
        dressUp();
        eatBreakfast();
        takeThings();
    }
    //以下是不同子类根据自身特性完成的具体步骤
    protected abstract void dressUp();
    protected abstract void eatBreakfast();
    protected abstract void takeThings();

}
