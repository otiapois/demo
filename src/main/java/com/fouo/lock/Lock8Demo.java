package com.fouo.lock;

import java.util.concurrent.TimeUnit;

/**
 * 8锁问题
 * 1.标准访问有两个线程a b，先打印邮件还是先打印短信   ==>邮件
 * 2.sendEmail暂停4秒，问先打印邮件还是先打印短信  ==>邮件
 * 3.新增一个普通的hello方法，请问先打印邮件还是hello？ ==》hello
 * 4.新增一部手机，请问先打印邮件还是短信==>短信（在2的基础上）
 * 5.两个静态同步方法，同一部手机？==》邮件
 * 6.两个静态同步方法，两部手机？==》邮件
 * 7.一个静态同步方法，一个普通同步方法，一部手机 ==》短信
 * 8.一个静态同步方法，一个普通同步方法，两部手机 ==》短信
 * @author fouo
 * @date 2021/10/18 22:51
 */
class Phone {
    public static synchronized void sendEmail() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("------send Email");
    }

    public synchronized void sendEms() {
        System.out.println("------send Ems");
    }
    public void hello(){
        System.out.println("Hello！");
    }
}

public class Lock8Demo {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone newPhone = new Phone();
        new Thread(() -> {
            phone.sendEmail();
        },"a").start();

        TimeUnit.MILLISECONDS.sleep(200);

        new Thread(() -> {
            newPhone.sendEms();
        },"b").start();

//        new Thread(() -> {
//            newPhone.hello();
//        },"c").start();
    }
}
