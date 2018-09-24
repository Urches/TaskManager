package com.project.dictionary.dao;

import com.project.dictionary.model.Phrase;
import lombok.NonNull;

import java.util.Collection;
import java.util.List;

public class DictionaryDatabaseDAO implements DictionaryDAO {
    @Override
    public List<Phrase> getAllPhrases() {
        return null;
    }

    @Override
    public void addPhrase(@NonNull Phrase phrase) {

    }

    @Override
    public void addPhrases(Collection<Phrase> phrases) {

    }

    @Override
    public boolean removePhrase(String id) {
        return false;
    }
}
