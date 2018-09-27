package com.project.function;

import lombok.experimental.UtilityClass;

import java.util.Objects;
import java.util.Optional;

@UtilityClass
public class StringMapperUtils {

    private static final String EMPTY_STRING = "";

    public String isNotBlank(String str){
        return Optional.of(str)
                .filter(s -> !Objects.equals(s, EMPTY_STRING))
                .get();
    }

    public String isEmpty(String str) {
        return Optional.of(str)
                .filter(s -> Objects.equals(s, EMPTY_STRING))
                .get();
    }
}
