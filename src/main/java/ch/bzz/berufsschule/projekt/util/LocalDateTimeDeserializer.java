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

    /**
     * Constructor of the LocalDateTimeDeserializer that calls the super constructor
     */
    public LocalDateTimeDeserializer() {
        super(LocalDateTime.class);
    }

    /**
     * Deserializes the given string into a LocalDateTime object
     * @param parser
     * @param context
     * @return The LocalDateTime object containing the given date
     * @throws IOException: throws IOException if the string cannot be parsed to LocalDateTime
     */
    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        return LocalDateTime.parse(parser.readValueAs(String.class), DateTimeFormatter.ofPattern(DATETIMEFORMAT));
    }
}
