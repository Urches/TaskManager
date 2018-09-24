package com.project.dictionary.dao;

import com.project.dictionary.model.Phrase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DictionarySimpleDAO implements DictionaryDAO {

    private List<Phrase> phrases = new ArrayList<>();

    public List<Phrase> getAllPhrases() {
        return phrases;
    }

    @Override
    public void addPhrase(Phrase phrase) {
        phrases.add(phrase);
    }

    @Override
    public void addPhrases(Collection<Phrase> phrases) {
        phrases.addAll(phrases);
    }

    @Override
    public boolean removePhrase(String id) {
        return phrases.remove(id);
    }
}
