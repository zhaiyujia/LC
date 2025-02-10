package com.design.patterns;

public class TemplateDemo {

    static abstract class AbstractActon{
        public void tempMethod(){
            System.out.println("模版方法的算法骨架被执行");
            beforeAction();
            action();
            afterAction();
        }


        private void beforeAction(){
            System.out.println("beforeAction 被执行");
        }

        public void afterAction(){
            System.out.println("afterAction 被执行");
        }

        public abstract void action();
    }

    static class ActionA extends AbstractActon{
        @Override
        public void action() {
            System.out.println("ActionA 执行action 方法");
        }
    }

    static class ActionB extends AbstractActon{
        @Override
        public void action() {
            System.out.println("ActionB 执行action 方法");
        }
    }

    public static void main(String[] args) {
        AbstractActon acton = null;
        acton = new ActionA();
        acton.tempMethod();

        acton = new ActionB();
        acton.tempMethod();
    }

}
