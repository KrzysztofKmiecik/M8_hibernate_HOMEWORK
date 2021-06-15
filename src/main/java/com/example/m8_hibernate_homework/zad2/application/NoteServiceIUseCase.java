package com.example.m8_hibernate_homework.zad2.application;

import com.example.m8_hibernate_homework.zad2.application.port.NoteService;
import com.example.m8_hibernate_homework.zad2.domain.Note;
import com.example.m8_hibernate_homework.zad2.infrastructure.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceIUseCase implements NoteService {

    private final NoteRepository repository;

    @Autowired
    public NoteServiceIUseCase(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Note> findAllNotes(){
        return repository.findAll();
    }

    @Override
    public Optional<Note> findNoteById(Long id){
        return repository.findById(id);
    }


    @Override
    public void saveNote(Note note){
        repository.save(note);
    }


}
