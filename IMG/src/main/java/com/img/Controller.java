package com.img;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get")
public class Controller {
	@Autowired
	private ResourceLoader resourceLoader;
	
	@RequestMapping(value = "/sid", method = RequestMethod.GET,  produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE})
    public ResponseEntity<byte[]> getImage() throws IOException {
    	ClassPathResource imgFile = new ClassPathResource("static/image/sid.png");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
        //return bytes;
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
    }
    
    @GetMapping("/text")
    public @ResponseBody String getText() {
        return "Hello world";
    }
}