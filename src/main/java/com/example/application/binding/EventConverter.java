package com.example.application.binding;

import org.springframework.core.convert.converter.Converter;

public class EventConverter {

    // 상태 정보가 없기 때문에 얼마든지 빈으로 등록이 가능하고, 등록은 ConverterRegistry를 이용한다.
    public static class StringToEventConverter implements Converter<String, Event> {

        @Override
        public Event convert(String source) {
            return new Event(Integer.parseInt(source));
        }
    }

    public static class EventToStringConverter implements Converter<Event, String> {

        @Override
        public String convert(Event source) {
            return source.getId().toString();
        }
    }
}
