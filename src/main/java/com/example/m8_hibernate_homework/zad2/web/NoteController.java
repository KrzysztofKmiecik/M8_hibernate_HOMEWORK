package com.example.m8_hibernate_homework.zad2.web;

import com.example.m8_hibernate_homework.zad2.application.port.NoteService;
import com.example.m8_hibernate_homework.zad2.domain.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class NoteController {
    private final NoteService service;

    @Autowired
    public NoteController(NoteService service) {
        this.service = service;
    }

    //mainNoteView
    //*******************************************************
    @GetMapping("/notepad")
    public String getAllNotes(Model model) {
        List<Note> allNotes = service.findAllNotes();
        model.addAttribute("notes", allNotes);
        model.addAttribute("newNote", new Note());
        return "mainNoteView";
    }
    //******************************************************


    //add-noteButton
    //*******************************************************
    //obsluga przycisku add z mainView
    @PostMapping("/add-noteButton")
    public String addNoteButton() {
        return "redirect:/addNote";
    }

    //wywolanie strony addNoteView
    @GetMapping("/addNote")
    public String addNoteGET(Model model) {
        model.addAttribute("newNote", new Note());
        return "addNoteView";
    }

    //obsługa przycisku z addNoteView i powrót do mainView
    @PostMapping("/addNote")
    public String addNotePOST(Note note) {
        note.setTimeStamp(new Date().toString());
        service.saveNote(note);
        return "redirect:/notepad";
    }
    //********************************************************


    //edit-noteButton
    //********************************************************
    //obsluga przycisku edit z mainView
    @PostMapping("/edit-noteButton")
    public String EditNoteButton(@RequestParam String id) {
        return "redirect:/editNote?id=" + id;
    }

    @GetMapping("/editNote")
    public String editNoteGET(Model model, @RequestParam String id) {
        Optional<Note> noteById = service.findNoteById(Long.valueOf(id));
        Note note = noteById.orElse(new Note());
        model.addAttribute("note", note);
        return "editNoteView";
    }

    @PostMapping("/editNote")
    public String editNotePOST(@ModelAttribute Note note) {
        note.setTimeStamp(new Date().toString());
        service.saveNote(note);
        return "redirect:/notepad";
    }
    //*********************************************************

    //delete-noteButton
    @PostMapping("/delete-noteButton")
    public String DeleteNoteButton(@RequestParam String id) {
        service.deleteNoteById(Long.valueOf(id));
        return "redirect:/notepad";
    }

}
