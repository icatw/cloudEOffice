package cn.icatw.yeb.server.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 日期转换
 *
 * @author icatw
 * @date 2022/05/13
 */
@Component
public class DateConverter implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(String source) {
        try {
            return LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MMdd"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
