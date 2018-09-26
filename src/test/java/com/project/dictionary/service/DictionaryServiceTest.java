package com.project.dictionary.service;

import com.project.dictionary.dao.DictionaryDAO;
import com.project.dictionary.dao.DictionarySimpleDAO;
import com.project.dictionary.model.Phrase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class DictionaryServiceTest {

    DictionaryService service = null;

    @Before
    public void setup() {
        service = new DictionaryService();
        service.dictionaryDAO = new DictionarySimpleDAO();
    }

    @Test
    public void addPhrase() {
        Phrase phrase = new Phrase("5", Arrays.asList("eval"), Arrays.asList("зло"), LocalDateTime.now());
        int sizeBefore = service.getPhrases().size();

        service.addPhrase(phrase);
        assertEquals(sizeBefore + 1, service.getPhrases().size());
        assertEquals(phrase, service.getPhraseById("5"));
    }

    public void addPhraseNull() {
        int sizeBefore = service.getPhrases().size();

        service.addPhrase(null);
        assertEquals(sizeBefore, service.getPhrases().size());
    }


    @Test
    public void removePhraseExist() {
        String id = "100100";
        service.addPhrase(new Phrase(id, Arrays.asList("eval"), Arrays.asList("зло"), LocalDateTime.now()));

        assertTrue(service.removePhraseById(id));
        assertNull(service.getPhraseById(id));
    }

    @Test
    public void removePhraseNotExist() {
        assertFalse(service.removePhraseById("100100"));
    }

    @Test
    public void removePhraseByNullId() {
        int sizeBefore = service.getPhrases().size();
        service.addPhrase(new Phrase("100100", Arrays.asList("eval"), Arrays.asList("зло"), LocalDateTime.now()));

        assertFalse(service.removePhraseById(null));
        assertEquals(sizeBefore, service.getPhrases().size() - 1);
    }

    @Test
    public void removePhraseNull() {
        service.addPhrase(new Phrase("100100", Arrays.asList("eval"), Arrays.asList("зло"), LocalDateTime.now()));
        assertFalse(service.removePhraseById(null));
    }

    @Test
    public void getPhrasesByCreationTime() {
        List<Phrase> expected = new ArrayList<>(Arrays.asList(new Phrase("10000", Arrays.asList("eval"), Arrays.asList("зло"), LocalDateTime.parse("2018-12-03T10:15:30"))));
        service.addPhrases(expected);

        assertEquals(expected, service.getPhrasesByCreationDate(LocalDateTime.parse("2018-12-03T10:13:30"), LocalDateTime.parse("2018-12-03T10:16:30")));
        assertEquals(expected, service.getPhrasesByCreationDate(LocalDateTime.parse("2018-12-03T10:15:29"), LocalDateTime.parse("2018-12-03T10:15:31")));
        assertEquals(expected, service.getPhrasesByCreationDate(LocalDateTime.parse("2017-12-02T10:15:30"), LocalDateTime.parse("2018-12-04T10:15:30")));
    }

    @Test
    public void getPhrasesByCreationTimeBorderValues() {
        List<Phrase> expected = new ArrayList<>(Arrays.asList(new Phrase("10000", Arrays.asList("eval"), Arrays.asList("зло"), LocalDateTime.parse("2018-12-03T10:15:30"))));
        service.addPhrases(expected);

        assertEquals(expected, service.getPhrasesByCreationDate(LocalDateTime.parse("2018-12-03T10:15:30"), LocalDateTime.parse("2018-12-03T10:15:30")));
        assertEquals(expected, service.getPhrasesByCreationDate(LocalDateTime.parse("2018-12-03T10:15:30"), LocalDateTime.parse("2018-12-03T10:15:31")));
        assertEquals(expected, service.getPhrasesByCreationDate(LocalDateTime.parse("2017-12-03T10:15:29"), LocalDateTime.parse("2018-12-03T10:15:30")));
    }

    @Test
    public void getPhrasesByCreationTimeTwoRecords() {
        List<Phrase> expected = new ArrayList<>((Arrays.asList(
                new Phrase("10000", Arrays.asList("eval"), Arrays.asList("зло"), LocalDateTime.parse("2018-12-03T10:15:31")),
                new Phrase("10000",  Arrays.asList("eval"), Arrays.asList("зло"), LocalDateTime.parse("2018-12-03T10:15:32")))));

        service.addPhrases(expected);

        assertEquals(expected, service.getPhrasesByCreationDate(LocalDateTime.parse("2018-12-03T10:13:30"), LocalDateTime.parse("2018-12-03T10:16:30")));
        assertEquals(expected, service.getPhrasesByCreationDate(LocalDateTime.parse("2018-12-03T10:15:20"), LocalDateTime.parse("2018-12-03T10:15:33")));
        assertEquals(expected, service.getPhrasesByCreationDate(LocalDateTime.parse("2017-12-02T10:15:30"), LocalDateTime.parse("2018-12-04T10:15:30")));
    }

    @Test
    public void getPhrasesByCreationTimeNull() {
        List<Phrase> expected = new ArrayList<>(Arrays.asList(new Phrase("10000", Arrays.asList("eval"), Arrays.asList("зло"), LocalDateTime.parse("2018-12-03T10:13:30"))));
        service.addPhrases(expected);

        assertTrue(service.getPhrasesByCreationDate(null, LocalDateTime.parse("2018-12-03T10:16:30")).isEmpty());
        assertTrue(service.getPhrasesByCreationDate(LocalDateTime.parse("2018-12-03T10:15:29"), null).isEmpty());
        assertTrue(service.getPhrasesByCreationDate(null, null).isEmpty());
    }


    @Test
    public void getPhrasesByContent() {

    }
}