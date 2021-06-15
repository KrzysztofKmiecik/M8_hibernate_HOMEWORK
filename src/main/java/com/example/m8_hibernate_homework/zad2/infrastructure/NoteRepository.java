package com.example.m8_hibernate_homework.zad2.infrastructure;

import com.example.m8_hibernate_homework.zad2.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {
}
