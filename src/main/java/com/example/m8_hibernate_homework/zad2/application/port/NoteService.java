package com.example.m8_hibernate_homework.zad2.application.port;

import com.example.m8_hibernate_homework.zad2.domain.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {


    List<Note> findAllNotes();

    Optional<Note> findNoteById(Long id);

    void saveNote(Note note);
}
