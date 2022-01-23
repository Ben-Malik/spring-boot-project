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
     * Grabs all notes having the given category type.
     * @param category The category whose notes are sought.
     * @return a list of notes.
     */
    List<Note> getByCategory(Category category);

    /**
     * Grabs all notes available in the database.
     * @return a list of notes.
     */
    List<Note> getAllNotes();

    /**
     * Saves a new note to the database.
     * @param newNote The new note to be saved.
     * @return The newly saved note.
     */
    Note saveNote(Note newNote);

    /**
     * Deletes the note having the given id if one exists.
     * @param id The id of the note to be deleted.
     * @return The note just deleted.
     */
    Note deleteNote(Long id);

}
