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
     * @return the note having the give id if one exist. and null otherwise.
     */
    Note getById(Long id);
    
    /**
     * 
     * @param category
     * @return
     */
    List<Note> getByCategory(Category category);

    /**
     * 
     * @return
     */
    List<Note> getAllNotes();

    /**
     * 
     * @param newNote
     * @return
     */
    Note createNote(Note newNote);

    /**
     * 
     * @param id
     * @return
     */
    Note deleteNote(Long id);

}
