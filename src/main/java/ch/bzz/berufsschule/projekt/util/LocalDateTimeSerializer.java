package ch.bzz.berufsschule.projekt.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by lucienzimmermann on 28.06.18.
 * A Serializer class for LocalDateTime
 */

public class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {

    private final String DATETIMEFORMAT = "yyyy.MM.dd HH:mm:ss";

    /**
     * Constructor of the LocalDateTimeSerializer that calls the super constructor
     */
    public LocalDateTimeSerializer(){
        super(LocalDateTime.class);
    }

    /**
     * Serializes the given LocalDateTime object into a string
     * @param localDateTime
     * @param generator
     * @param serializerProvider
     * @throws IOException: Throws Exception if the LocalDateTime object cannot be parsed to string
     */
    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator generator, SerializerProvider serializerProvider) throws IOException {
        generator.writeString(localDateTime.format(DateTimeFormatter.ofPattern(DATETIMEFORMAT)));

    }
}
