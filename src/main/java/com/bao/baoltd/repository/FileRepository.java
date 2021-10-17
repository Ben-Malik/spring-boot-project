package com.bao.baoltd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bao.baoltd.model.FileEntity;

/**
 * An interface of the data access layer for the FileEntity model.
 * 
 * @author ben-maliktchamalam
 *
 */
@Repository("FileRepository")
public interface FileRepository extends JpaRepository<FileEntity, Long>, JpaSpecificationExecutor<FileEntity>{

	/**
	 * Finds a file with the given name.
	 * @param name The name of the file looked for.
	 * @return A {@link FileEntity} if found and null otherwise.
	 */
	FileEntity findByName(String name);
}
