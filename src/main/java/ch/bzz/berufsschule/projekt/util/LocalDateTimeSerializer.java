package ch.bzz.berufsschule.projekt.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.datatype.joda.ser.LocalDateSerializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by lucienzimmermann on 28.06.18.
 */
public class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {

    private final String DATETIMEFORMAT = "yyyy.MM.dd HH:mm:ss";

    public LocalDateTimeSerializer(){
        super(LocalDateTime.class);
    }

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator generator, SerializerProvider serializerProvider) throws IOException {
        generator.writeString(localDateTime.format(DateTimeFormatter.ofPattern(DATETIMEFORMAT)));

    }
}
