package com.camavilca.controller.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.camavilca.model.FileModel;
import com.camavilca.repository.FileRepository;

@RestController
public class UploadFileController {

	@Autowired
	FileRepository fileRepository;
	@PostMapping("/api/file/upload")
	public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file) {
		try {
			FileModel filemode = new FileModel(file.getOriginalFilename(),file.getContentType(),file.getBytes());
			fileRepository.save(filemode);
			return "Archivo subido satisfactoriamente -> nombre:" + file.getOriginalFilename();
		}catch(Exception e) {
			return "No se pudo subir el archivo ....>500KB";
		}
	}
}
