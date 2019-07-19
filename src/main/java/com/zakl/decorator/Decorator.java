package com.zakl.decorator;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-05 09:52
 **/

//装饰器模式
public class Decorator implements Component {
    private Component component;

    Decorator(Component component) {
        this.component = component;
    }
    @Override
    public void doSomeThing() {
        component.doSomeThing();
    }
}
