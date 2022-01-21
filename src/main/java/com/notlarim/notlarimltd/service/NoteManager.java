package com.notlarim.notlarimltd.service;

import java.util.List;

import com.notlarim.notlarimltd.enums.Category;
import com.notlarim.notlarimltd.model.Note;

/**
 * An interface indicating doable operations on the Note entity.
 * 
 * @author ben-malik
 */
public interface NoteManager {
    
    /**
     * Gets the note having the given id.
     * @param id The id of the Note looked for.
     * @return
     */
    Note getById(Long id);
    
    List<Note> getByCategory(Category category);

    List<Note> getAllNotes();

    Note createNote(Note newNote);

    Note deleteNote(Long id);

}
