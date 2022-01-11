package fr.mines.ales.rest.hotel;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.ws.rs.Produces;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.text.SimpleDateFormat;

@Provider
@Produces("application/json")
public class JsonMapperConfigurator implements ContextResolver<ObjectMapper> {
    private final ObjectMapper mapper = new ObjectMapper();

    public JsonMapperConfigurator() {
        SerializationConfig serConfig = mapper.getSerializationConfig();
        serConfig.with(new SimpleDateFormat("dd/MM/yyyy - hh:mm"));
        DeserializationConfig deserializationConfig = mapper.getDeserializationConfig();
        deserializationConfig.with(new SimpleDateFormat("dd/MM/yyyy - hh:mm"));
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Override
    public ObjectMapper getContext(Class<?> aClass) {
        return mapper;
    }
}
