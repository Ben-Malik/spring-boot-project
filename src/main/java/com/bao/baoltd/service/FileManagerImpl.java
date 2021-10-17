package com.bao.baoltd.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

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

	@Override
	public FileEntity store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    FileEntity fileEntity = new FileEntity();
	    fileEntity.setName(fileName);
	    fileEntity.setSize(file.getSize());
	    fileEntity.setContent(file.getBytes());
	    fileEntity.setType(file.getContentType());
	    
	    return fileRepository.save(fileEntity);
	}

}
