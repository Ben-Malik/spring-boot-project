package com.bao.baoltd.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bao.baoltd.model.FileEntity;

/**
 * The service interface for file operations, to be used to communicate with the 
 * data access layer.
 * 
 * @author ben-maliktchamalam
 * 
 *
 */
public interface FileManager {
	
	/**
	 * Grabs all files from the database.
	 * @return a list of files.
	 */
	List<FileEntity> getAllFiles();
	
	/**
	 * Finds a file with the given id if exists.
	 * @param id The id whose file is sought.
	 * @return a {@link FileEntity} if found and null otherwise.
	 */
	FileEntity getById(Long id);
	
	/**
	 * Finds a file with the given name
	 * @param name The name of the file looked for.
	 * @return a {@link FileEntity} if found and null otherwise.
	 */
	FileEntity getByName(String name);
	
	/**
	 * Creates and saves the given file to the database.
	 * @param fileEntity The file to be saved
	 * @return The newly saved file entity.
	 */
	FileEntity create(FileEntity fileEntity);
	
	/**
	 * Saves a given multipartFile file to 
	 * @param file The file to be saved.
	 * @return An entity of file the saved.
	 */
	FileEntity store(MultipartFile file) throws IOException;

}
