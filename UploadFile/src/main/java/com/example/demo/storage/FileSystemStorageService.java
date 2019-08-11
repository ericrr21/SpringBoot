package com.example.demo.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;
import org.springframework.util.StringUtils;

@Service
public class FileSystemStorageService {
	@Value("${staticresourceloader.fileLocation.path}")
	private Path uploadLocation;
	
	@PostConstruct
	public void init() {
		try {
			 Files.createDirectories(uploadLocation);
		}catch (IOException e) {
			 throw new RuntimeException("No puede almacenar la informacion",  e);
		}
	}
	
	
	
	public String store(MultipartFile file, String idIps) {
		 // Crea un archivo correspondiente a un IPS, en caso de que no
        // exista el archivo
        crearArchivo(idIps);
        String filename = StringUtils.cleanPath(idIps + "/"
                + file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("Fallo, al parecer el archivo"
                        + " esta vacio" + filename);
            }
            // checkeo de seguridad
            if (filename.contains("..")) {
                throw new RuntimeException("Fallo, no se pueden " 
                        + "cargar archivos que puedan salirse de "
                        + "la carpeta de guardado" + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, uploadLocation.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);
                return uploadLocation + "/" + file.getName();
            }
        }catch (IOException e) {
            throw new RuntimeException("Fallo, al guardar el archivo " 
                    + filename, e);
        }
		
	}
	
	
	 public void crearArchivo(String documento){
	        try {
	            File directorio = new File(uploadLocation + "/" + documento);
	            directorio.mkdirs();
	        }catch(Exception e) {
	            throw new RuntimeException("Fallo, al crear el archivo: "
	                    + documento, e);
	        }
	    }

}
