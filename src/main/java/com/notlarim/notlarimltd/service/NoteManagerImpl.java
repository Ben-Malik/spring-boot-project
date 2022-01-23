package com.notlarim.notlarimltd.service;

import java.util.List;

import com.notlarim.notlarimltd.enums.Category;
import com.notlarim.notlarimltd.model.Note;
import com.notlarim.notlarimltd.repository.NoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * An implementation to the {@linkplain NoteManager} interface.
 * 
 * @author ben-malik
 */
@Service
@Transactional(readOnly = true)
public class NoteManagerImpl implements NoteManager {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note getById(Long id) {
        return noteRepository.getById(id);
    }

    @Override
    public List<Note> getByCategory(Category category) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note saveNote(Note newNote) {
        return noteRepository.save(newNote);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteNote(Note note) {
        noteRepository.delete(note);
    }
    
}
