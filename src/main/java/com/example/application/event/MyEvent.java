package com.example.application.event;

public class MyEvent { // extends ApplicationEvent { 4.2 부터는 상속을 안받아도 됨

    private int data;
    private Object source;

    public MyEvent(Object source, int data) {
//        super(source);
        this.source = source;
        this.data = data;
    }

    public int getData() {
        return data;
    }
}
