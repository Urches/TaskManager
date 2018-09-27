package com.project.function;

import com.project.utils.AssertionException;
import lombok.experimental.UtilityClass;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

@UtilityClass
public class CollectionMapperUtils {

    public<T, C extends Collection<T>> C hasSize(C collection, int size){
        return Optional.of(collection)
                .filter(ts -> ts.size() == size)
                .get();
    }

    public<T, C extends Collection<T>> C  sizeLess(C collection, int size){
        return Optional.of(collection)
                .filter(ts -> ts.size() < size)
                .get();
    }


    public<T, C extends Collection<T>> C sizeNotLess(C collection, int size){
        return Optional.of(collection)
                .filter(ts -> ts.size() >= size)
                .get();
    }

    public <T, C extends Collection<T>> C sizeNotMore(C collection, int size){
        return Optional.of(collection)
                .filter(ts -> ts.size() <= size)
                .get();
    }

    public <T, C extends Collection<T>> C isNotEmpty(C collection) {
        return Optional.of(collection)
                .filter((collect) -> !collect.isEmpty())
                .get();
    }
}
