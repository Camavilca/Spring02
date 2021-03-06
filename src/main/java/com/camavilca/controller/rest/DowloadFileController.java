package com.camavilca.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import com.camavilca.model.View;
import com.camavilca.repository.FileRepository;
import com.fasterxml.jackson.annotation.JsonView;
import com.camavilca.model.FileModel;
import java.util.List;
import java.util.Optional;


@RestController
public class DowloadFileController {
	
	@Autowired
	FileRepository fileRepository;
	
	@JsonView(View.FileInfo.class)
	@GetMapping("/api/file/all")
	public List<FileModel> getListFiles(){
		return fileRepository.findAll();
	}
	@GetMapping("/api/file/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable Long id){
		Optional<FileModel> fileOptional = fileRepository.findById(id);
		if(fileOptional.isPresent()) {
			FileModel file = fileOptional.get();
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
					.body(file.getPic());	
		}
		return ResponseEntity.status(404).body(null);
	}
	
}
