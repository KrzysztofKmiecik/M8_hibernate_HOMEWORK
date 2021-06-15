package com.example.m8_hibernate_homework.zad2.web;

import com.example.m8_hibernate_homework.zad2.application.port.NoteService;
import com.example.m8_hibernate_homework.zad2.domain.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/notepad")
public class NoteController {
    private final NoteService service;

    @Autowired
    public NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping
    public String getAllNotes(Model model){
        List<Note> allNotes = service.findAllNotes();
        model.addAttribute("notes",allNotes);
        model.addAttribute("newNote",new Note());
        return "notesView";
    }

    @PostMapping
    public String addNote (@ModelAttribute Note note){
        note.setTimeStamp(new Date().toString());
        service.saveNote(note);
        return "redirect:/notepad";
    }


}
