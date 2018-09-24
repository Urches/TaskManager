package com.project.dictionary.service;

import com.project.dictionary.dao.DictionaryDAO;
import com.project.dictionary.model.Phrase;
import com.project.dictionary.service.search.DictionarySearchContext;
import com.project.utils.Assertion;
import com.project.utils.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Service
public class DictionaryService {

    //TODO temp for testing suitability
    public DictionaryDAO dictionaryDAO;

    public void addPhrase(Phrase phrase){
        if (phrase != null) {
            dictionaryDAO.addPhrase(phrase);
        }
    }

    public void addPhrases(Collection<Phrase> phrases){
        if (CollectionUtils.isNotEmpty(phrases)) {
            dictionaryDAO.addPhrases(phrases);
        }
    }

    //only for admin
    public boolean removePhraseById(String id){
        return !StringUtils.isEmpty(id) && dictionaryDAO.removePhrase(id);
    }

    public List<Phrase> findPhrases(DictionarySearchContext dsc){
        return null;
    }

    public List<Phrase> getPhrasesByCreationDate(LocalDateTime from, LocalDateTime to) {
        List<Phrase> phrases = dictionaryDAO.getAllPhrases();
        return phrases.stream()
                .filter(phrase -> phrase.getCreationDateTime().isAfter(from) && phrase.getCreationDateTime().isBefore(to))
                .collect(toList());
    }

    public List<Phrase> getPhrasesByTranslate(String translate){
        //TODO Change to invoke appropriate dao method
        return Optional.of(translate).map( (v) ->
                dictionaryDAO.getAllPhrases().stream()
                        .filter(phrase -> phrase.getTranslation().contains(translate))
                        .collect(toList()))
                .orElse(Collections.emptyList());
    }

    public List<Phrase> getPhrasesByDefinition(String definition){
        return null;
    }



    public Phrase getPhrasesById(String id){
        //TODO Change to invoke appropriate dao method
        List<Phrase> phrases = dictionaryDAO.getAllPhrases().stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .collect(Collectors.toList());

        Assertion.sizeNotMore(phrases, 1);
        return CollectionUtils.getFirst(phrases).get();
    }

    public List<Phrase> getPhrases() {
        return dictionaryDAO.getAllPhrases();
    }
}
