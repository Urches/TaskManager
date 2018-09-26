package com.project.utils;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

@UtilityClass
public class Assertion {

    public Collection hasSize(Collection collection, int size, String message){
        if (collection.size() != size)
            throw new AssertionException(message);
        return collection;
    }

    public Collection hasSize(Collection collection, int size){
       return hasSize(collection, size, MessageFormat.format("Collection size assume: {0} but was founded: {1}", size, collection.size()));
    }

    public Collection sizeLess(Collection collection, int size, String message){
        if (collection.size() > size)
            throw new AssertionException(message);
        return collection;
}

    public Collection sizeNotLess(Collection collection, int size){
        return sizeLess(collection, size, MessageFormat.format("Collection size assume no less then: {0} but was founded: {1}", size, collection.size()));
    }

    public Collection sizeNotLess(Collection collection, int size, String message){
        if (collection.size() > size)
            throw new AssertionException(message);
        return collection;
    }

    public <T, C extends Collection<T>> C sizeNotMore(C collection, int size){
        return sizeNotMore(collection, size, MessageFormat.format("Collection size assume no more then: {0} but was founded: {1}", size, collection.size()));
    }

    public <T, C extends Collection<T>> C sizeNotMore(C collection, int size, String message){
        if (collection.size() < size)
            throw new AssertionException(message);
        return collection;
    }

    public Collection sizeLess(Collection collection, int size){
       return sizeLess(collection, size, MessageFormat.format("Collection size assume less then: {0} but was founded: {1}", size, collection.size()));
    }

    public <R, V> R check(V target, Predicate<V> predicate, R result){
        return predicate.test(target) ? result : null;
    }
}
