package com.project.utils;

import com.project.function.CollectionMapperUtils;
import lombok.experimental.UtilityClass;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

@UtilityClass
public class Assertion {

    public <T> Collection<T> hasSize(Collection<T> collection, int size, String message) {
        return Optional.of(CollectionMapperUtils.hasSize(collection, size))
                .orElseThrow(() -> new AssertionException(message));
    }

    public <T> Collection<T> hasSize(Collection<T> collection, int size) {
        return hasSize(collection, size, MessageFormat.format("Collection size assume: {0} but was founded: {1}", size, collection.size()));
    }

    public <T> Collection<T> sizeLess(Collection<T> collection, int size, String message) {
        return Optional.of(CollectionMapperUtils.sizeLess(collection, size))
                .orElseThrow(() -> new AssertionException(message));
    }

    public <T> Collection<T> sizeLess(Collection<T> collection, int size) {
        return sizeLess(collection, size, MessageFormat.format("Collection size assume less then: {0} but was founded: {1}", size, collection.size()));
    }

    public <T> Collection<T> sizeNotLess(Collection<T> collection, int size, String message) {
        return Optional.of(CollectionMapperUtils.sizeNotLess(collection, size))
                .orElseThrow(() -> new AssertionException(message));
    }

    public <T> Collection<T> sizeNotLess(Collection<T> collection, int size) {
        return sizeNotLess(collection, size, MessageFormat.format("Collection size assume no less then: {0} but was founded: {1}", size, collection.size()));
    }

    public <T, C extends Collection<T>> C sizeNotMore(C collection, int size, String message) {
        return Optional.of(CollectionMapperUtils.sizeNotMore(collection, size))
                .orElseThrow(() -> new AssertionException(message));
    }

    public <T, C extends Collection<T>> C sizeNotMore(C collection, int size) {
        return sizeNotMore(collection, size, MessageFormat.format("Collection size assume no more then: {0} but was founded: {1}", size, collection.size()));
    }

    public void throwAssertException(String message) {
        throw new AssertionException(message);
    }
}
