package com.notlarim.notlarimltd.repository;

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
    
}
