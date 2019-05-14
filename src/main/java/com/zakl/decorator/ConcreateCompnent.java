package com.zakl.decorator;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-05 09:50
 **/

//具体构建角色
public class ConcreateCompnent implements Component {
    @Override
    public void doSomeThing() {
        System.out.println("A功能");
    }
}
