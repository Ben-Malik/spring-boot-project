package com.notlarim.notlarimltd.controller;

import java.util.List;

import com.notlarim.notlarimltd.model.Note;
import com.notlarim.notlarimltd.service.NoteManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
