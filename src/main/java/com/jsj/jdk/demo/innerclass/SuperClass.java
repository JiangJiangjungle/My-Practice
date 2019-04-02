package com.jsj.jdk.demo.innerclass;

import com.jsj.jdk.demo.constractor.Member;

public class SuperClass {
    private Member member = new Member("成员变量");
    private static Member staticMember = new Member("静态成员");

    private Runnable runnable;

    public SuperClass(Runnable runnable) {
        this.runnable = runnable;
    }

    /**
     * 成员内部类
     */
    class MemberInnerClass {
        /**
         * 不允许静态变量，但是静态常量是允许的
         */
        static final int x = 0;
        int y = 2;
        final int z = 3;

        public MemberInnerClass() {
            System.out.println(member.toString());
            System.out.println(staticMember.toString());
        }
    }

    /**
     * 静态内部类
     */
    static class StaticInnerClass {
        int x = 0;
        static int i = 0;

        public StaticInnerClass() {
            System.out.println(staticMember.toString());
        }
    }

    public static void test() {
        int x = 0;
        final int y = 3;
        /**
         * 局部内部类
         */
        class LocalInnerClass {
            /**
             * 局部内部类只能访问局部常量
             */
            int num2 = y;
            /**
             * 编译优化后，值不改变的局部变量也可以被局部内部类访问
             */
            int num = x;
        }
        LocalInnerClass localInnerClass = new LocalInnerClass();
        System.out.println(localInnerClass.num);
        System.out.println(localInnerClass.num2);
    }

    public static void main(String[] args) {
        int x = 0;
        final int y = 3;
        /**
         * 匿名内部类
         */
        SuperClass superClass = new SuperClass(new Runnable() {
            @Override
            public void run() {
                System.out.println(y);
            }
        });
        test();
    }
}
