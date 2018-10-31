package com.camavilca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.camavilca.model.FileModel;

@Transactional
public interface FileRepository extends JpaRepository<FileModel, Long>{
//	public FileModel 
//	public FileModel 
	public FileModel findByName(String name);
}
