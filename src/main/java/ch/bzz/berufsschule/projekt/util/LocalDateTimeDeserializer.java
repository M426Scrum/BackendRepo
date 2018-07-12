package ch.bzz.berufsschule.projekt.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by lucienzimmermann on 28.06.18.
 * A Deserializer class for LocalDateTime
 */
public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

    private final String DATETIMEFORMAT = "yyyy.MM.dd HH:mm:ss";

    public LocalDateTimeDeserializer() {
        super(LocalDateTime.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        return LocalDateTime.parse(parser.readValueAs(String.class), DateTimeFormatter.ofPattern(DATETIMEFORMAT));
    }
}
