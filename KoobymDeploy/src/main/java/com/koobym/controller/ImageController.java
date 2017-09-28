package com.koobym.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.koobym.model.User;
import com.koobym.service.UserService;

@RestController
@RequestMapping(value = "/image")
public class ImageController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("file") MultipartFile file) {
		String filename = "";
		
		try {

			System.out.println("inside upload");
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();

			Random rand = new Random();
			String pre1 = Long.toString(rand.nextLong());
			String pre2 = Long.toString(rand.nextLong());
			
			// save file in server - you may need an another scenario
			filename = pre1+ pre2+ Long.toString(new Date().getTime())+ file.getOriginalFilename();

			Path path = Paths.get("/home/resty_artiaga/Koobym/images/" + filename);
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// redirect to an another url end point
		return filename;
	}

	@RequestMapping(value = "/{filename:.+}", headers = "Accept=image/jpeg, image/jpg, image/png, image/gif", method = RequestMethod.GET, produces = {"image/jpg", "image/jpeg", "image/png"})
	public @ResponseBody byte[] getFile(@PathVariable String filename) {
		byte[] flag = null;
		try {
			// Retrieve image from the classpath.
			File f = new File("/home/resty_artiaga/Koobym/images/" + filename);
			InputStream is = new FileInputStream(f);

			// Prepare buffered image.
			BufferedImage img = ImageIO.read(is);

			// Create a byte array output stream.
			ByteArrayOutputStream bao = new ByteArrayOutputStream();

			System.out.println("Extension = " + extension(filename));
			// Write to output stream
			ImageIO.write(img, extension(filename), bao);			

			flag = bao.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	private String extension(String filename){
		StringTokenizer tokenize = new StringTokenizer(filename , ".");
		String flag = "";

		while(tokenize.hasMoreTokens()){
			flag = tokenize.nextToken();
		}
		
		return flag;
	}

}