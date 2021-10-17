package com.bao.baoltd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bao.baoltd.model.FileEntity;
import com.bao.baoltd.repository.FileRepository;

/**
 * An implementation of the {@link FileManager} interface.
 * 
 * @author ben-maliktchamalam
 *
 */
@Service
@Transactional(readOnly = true)
public class FileManagerImpl implements FileManager {

	@Autowired
	private FileRepository fileRepository;
	
	@Override
	public List<FileEntity> getAllFiles() {
		return fileRepository.findAll();
	}

	@Override
	public FileEntity getById(Long id) {
		return fileRepository.getById(id);
	}

	@Override
	public FileEntity getByName(String name) {
		return fileRepository.findByName(name);
	}

	@Override
	@Transactional(readOnly = false)
	public FileEntity create(FileEntity fileEntity) {
		return fileRepository.save(fileEntity);
	}

}
