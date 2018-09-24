package com.project.utils;

import com.project.dictionary.model.Phrase;
import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class CollectionUtils {

    public <T, R> Optional<Collection<R>> doIf(Collection<T> collection, Predicate<Collection<T>> predicate, Function<Void, Collection<R>> function){
        return Optional.ofNullable(predicate.test(collection) ? function.apply(null) : null);
    }

    public<T, R> Optional<Collection<R>> ifNotEmpty(Collection<T> collection, Function<Void, Collection<R>> function){
       return doIf(collection, isNotEmpty(), function);
    }

    public <T> boolean isEmpty(Collection<T> collection){
        return collection.isEmpty();
    }

    public <T> boolean isNotEmpty(Collection<T> collection){
        return !collection.isEmpty();
    }

    public <T> Predicate<Collection<T>> isNotEmpty(){
        return (collect) -> !collect.isEmpty();
    }

    public <T> Optional<T> getFirst(List<T> collection) {
       return Optional.ofNullable(isNotEmpty(collection) && collection.size() >= 1 ? collection.get(0) : null);
    }

    public <T> Collector<T, ?, T> toSingleton() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    Assertion.hasSize(list, 1);
                    return list.get(0);
                }
        );
    }
}
