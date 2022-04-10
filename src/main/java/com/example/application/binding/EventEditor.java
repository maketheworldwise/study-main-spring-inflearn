package com.example.application.binding;

import java.beans.PropertyEditorSupport;

// 스레드 세이프하지 않기 때문에 절대로 빈으로 등록해서는 안된다.
// 하나의 스레드에서만 유효하도록 Scope를 붙일 수 는 있으나, 권장하지 않음
public class EventEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        Event event = (Event) getValue();
        return event.getId().toString();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Event(Integer.parseInt(text)));
    }
}
