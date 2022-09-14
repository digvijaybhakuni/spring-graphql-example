package com.example.graphql.config;

import graphql.language.StringValue;
import graphql.schema.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeParseException;
import java.util.Date;

@Configuration
public class DataTypeConfig {
    @Bean
    public GraphQLScalarType dateScalar() {
        System.out.println("date scalar");

        return GraphQLScalarType.newScalar()
                .name("Date")
                .description("Java 17 Date as scalar.")
                .coercing(new Coercing<Date, String>() {
                    @Override
                    public String serialize(final Object dataFetcherResult) {
                        if (dataFetcherResult instanceof Date) {
                            return dataFetcherResult.toString();
                        } else {
                            throw new CoercingSerializeException("Expected a LocalDate object.");
                        }
                    }

                    @Override
                    public Date parseValue(final Object input) {
                        try {
                            if (input instanceof String) {
                                return new Date((String) input);
                            } else {
                                throw new CoercingParseValueException("Expected a String");
                            }
                        } catch (Exception e) {
                            throw new CoercingParseValueException(String.format("Not a valid date: '%s'.", input), e
                            );
                        }
                    }

                    @Override
                    public Date parseLiteral(final Object input) {
                        if (input instanceof StringValue) {
                            try {
                                return new Date(((StringValue) input).getValue());
                            } catch (DateTimeParseException e) {
                                throw new CoercingParseLiteralException(e);
                            }
                        } else {
                            throw new CoercingParseLiteralException("Expected a StringValue.");
                        }
                    }
                }).build();
    }
}