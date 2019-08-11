package com.example.demo;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.storage.FileSystemStorageService;

@RestController
@RequestMapping("/archivos")
public class ArchivosController {
	
	@Autowired
	private FileSystemStorageService fileSystemStorageService;
	
	
	@PostMapping("/save")
	public ResponseEntity guardararchivo(@RequestHeader("file") MultipartFile file,@RequestParam("documento") String documento) {
		String Direccion ="";
		Direccion = fileSystemStorageService.store(file, documento);
		return ResponseEntity.ok(Direccion);
		
	}

 
}
