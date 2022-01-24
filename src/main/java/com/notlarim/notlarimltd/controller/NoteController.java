package com.notlarim.notlarimltd.controller;

import java.util.List;

import com.notlarim.notlarimltd.model.Note;
import com.notlarim.notlarimltd.service.NoteManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The controller class for the Note.
 * 
 * @author ben-malik
 */
@Controller
public class NoteController {

    @Autowired
    private NoteManager noteManager;
    
    @GetMapping({ "/all", "/"})
    public String showAllNotes(Model model) {

        List<Note> allNotes = noteManager.getAllNotes();
        model.addAttribute("allNotes", allNotes);

        return "index";
    }

    @DeleteMapping("/delete")
    public String deleteNote(Model model, Note note) {

        noteManager.deleteNote(note);

        return "index";
    }

    @GetMapping("note/add")
    public String addNote(Model model, Note note) {

        return "note/add";
    }

    @PostMapping("/note/add")
    public String saveNote(Model model, Note note) {

        return "index";
    }
}
