package com.project.dictionary.dao;

import com.project.dictionary.model.Phrase;
import lombok.NonNull;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public interface DictionaryDAO {

    List<Phrase> getAllPhrases();

    void addPhrase(@NonNull Phrase phrase);

    void addPhrases(Collection<Phrase> phrases);

    Predicate<Collection<Phrase>> addPhrases();

    boolean removePhrase(@NonNull String id);
}
