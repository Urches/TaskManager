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

    public <T> void hasSize(Collection<T> collection, int size, Function ifStatement, Function elseStatement){
        if (collection.size() == size) {
            ifStatement.apply(collection);
        }
            else elseStatement.apply(collection);
    }

    public void hasSize(Collection collection, int size, String message){
        if (collection.size() != size)
            throw new AssertionException(message);
    }

    public void hasSize(Collection collection, int size){
        hasSize(collection, size, MessageFormat.format("Collection size assume: {0} but was founded: {1}", size, collection.size()));
    }

    public void sizeLess(Collection collection, int size, String message){
        if (collection.size() > size)
            throw new AssertionException(message);
}

    public void sizeNotLess(Collection collection, int size){
        sizeLess(collection, size, MessageFormat.format("Collection size assume no less then: {0} but was founded: {1}", size, collection.size()));
    }

    public void sizeNotLess(Collection collection, int size, String message){
        if (collection.size() > size)
            throw new AssertionException(message);
    }

    public <T, C extends Collection<T>> C sizeNotMore(C collection, int size){
        return sizeNotMore(collection, size, MessageFormat.format("Collection size assume no more then: {0} but was founded: {1}", size, collection.size()));
    }

    public <T, C extends Collection<T>> C sizeNotMore(C collection, int size, String message){
        if (collection.size() < size)
            throw new AssertionException(message);
        return collection;
    }

    public void sizeLess(Collection collection, int size){
        sizeLess(collection, size, MessageFormat.format("Collection size assume less then: {0} but was founded: {1}", size, collection.size()));
    }

    public void notEmpty(@NonNull Collection collection, String message){
        if (collection.isEmpty())throw new AssertionException(message);
    }

    public Exception notEmpty(Collection collection, Class clazz){
        Exception.class.isAssignableFrom(clazz);
        return null;
    }

    public <R, V> R check(V target, Predicate<V> predicate, R result){
        return predicate.test(target) ? result : null;
    }

    public <V> V checkAndThrow(V target, Predicate<V> predicate){
        if (!predicate.test(target)) throw new AssertionException("Temp");
        return target;
    }
}
