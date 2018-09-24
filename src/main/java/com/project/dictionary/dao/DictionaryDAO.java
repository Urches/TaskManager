package com.project.dictionary.dao;

import com.project.dictionary.model.Phrase;
import lombok.NonNull;

import java.util.Collection;
import java.util.List;

public interface DictionaryDAO {

    List<Phrase> getAllPhrases();

    void addPhrase(@NonNull Phrase phrase);

    void addPhrases(Collection<Phrase> phrases);

    boolean removePhrase(@NonNull String id);
}
