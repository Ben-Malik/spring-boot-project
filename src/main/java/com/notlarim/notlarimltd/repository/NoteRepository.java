package com.notlarim.notlarimltd.repository;

import java.util.List;

import com.notlarim.notlarimltd.enums.Category;
import com.notlarim.notlarimltd.model.Note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * A repository interface for the {@linkplain Note} entity.
 * 
 * @author ben-malik
 */
@Repository("NoteRepository")
public interface NoteRepository extends JpaRepository<Note, Long>, JpaSpecificationExecutor<Note>{
    
    /**
     * Grabs all notes from the database having the given category.
     * @param category The category of the notes looked for.
     * @return a list of notes.
     */
    List<Note> getByCategory(Category category);
}
