package com.project.dictionary.service;

import com.project.dictionary.dao.DictionaryDAO;
import com.project.dictionary.model.Phrase;
import com.project.dictionary.service.search.DictionarySearchContext;
import com.project.utils.Assertion;
import com.project.utils.CollectionUtils;
import com.project.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        return Optional.of(translate)
                .map(StringUtils::isNotBlank)
                .map(getPhrases(phrase -> phrase.getTranslation().contains(translate)))
                .orElse(Collections.emptyList());
    }

    public List<Phrase> getPhrasesByDefinition(String definition){
        return Optional.of(definition)
                .map(StringUtils::isNotBlank)
                .map(getPhrases(phrase -> phrase.getDefinition().contains(definition)))
                .orElse(Collections.emptyList());
    }



    public Phrase getPhraseById(String id){
        //TODO Change to invoke appropriate dao method
        Function<List<Phrase>, List<Phrase>> hasOnePhrase = (list) -> {
            Assertion.hasSize(list, 1);
            return list;
        };

        return Optional.of(id)
                .map(StringUtils::isNotBlank)
                .map(getPhrases(p -> Objects.equals(p.getId(), id)))
                .map(hasOnePhrase)
                .map(CollectionUtils::getFirst).get();
    }

    public List<Phrase> getPhrases() {
        return dictionaryDAO.getAllPhrases();
    }

    private  Function<Object, List<Phrase>> getPhrases(Predicate<Phrase> predicate){
        return (Object) -> getPhrases().stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
