package com.yoyo.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yoyo.entity.Player;
import com.yoyo.service.PlayerService;

@RestController
public class PlayerRestController {
	
	private PlayerService ps;
	
	@Autowired
	public PlayerRestController(PlayerService ps) {
		this.ps = ps;
	}

	@PostMapping(value="/post",
			consumes= {"application/json", "application/xml"})
	public ResponseEntity<String> add (@RequestBody Player p1){
		String msg = ps.upsert(p1);
		return new ResponseEntity<String> (msg, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/put",
			consumes= {"application/json", "application/xml"})
	public ResponseEntity<String> update (@RequestBody Player p1){
		String msg = ps.upsert(p1);
		return new ResponseEntity<String> (msg, HttpStatus.OK);
	}
	
	@GetMapping(value="get/{i1}",
			produces= {"application/json", "application/xml"})
	public ResponseEntity<Optional<Player>> getPlayer (@PathVariable("i1") Integer i1){
		Optional<Player> player = ps.getPlayer(i1);
		return new ResponseEntity<Optional<Player>> (player,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{i2}")
	public ResponseEntity<String> removePlayer (@PathVariable("i2") Integer i2){
		String mg = ps.removePlayer(i2);
		return new ResponseEntity<String> (mg, HttpStatus.OK);
	}
	
	@GetMapping ("/")
	public ResponseEntity<String> m1 (){
		String msg = "Hello";
		return new ResponseEntity<String> (msg, HttpStatus.OK);
	}
}
