package com.zakl.decorator;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-05 09:55
 **/
public class TestClient {
    public static void main(String[] args) {
        Component component = new ConcratorDecorator2(new ConcratorDecorator1(new ConcreateCompnent()));
        component.doSomeThing();
    }

}
