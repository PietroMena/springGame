package com.senai.pedro.prjGame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.pedro.prjGame.entities.Jogo;
import com.senai.pedro.prjGame.services.JogoService;


@RestController
@RequestMapping("/jogos")
public class JogoController {

	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}
	private final JogoService jogoService;
	
	@Autowired
	public JogoController (JogoService jogoService) {
		this.jogoService = jogoService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Jogo> getJogo(@PathVariable long id) {
		Jogo jogo = jogoService.getJogoById(id);
		if (jogo != null) {
			return ResponseEntity.ok(jogo);
		} else {
			return ResponseEntity.notFound().build();
		}
	
	}
	@PostMapping
	public Jogo creatProduct (@RequestBody Jogo jogo) {
		return jogoService.saveJogo(jogo);
	}

	@GetMapping
	public List<Jogo> getAllJogos(){
		return jogoService.getAllJogo();
	}
	
	@DeleteMapping("/{id}")
	public void deleteJogo(@PathVariable Long id) {
		jogoService.deleteJogo(id);
	}
	
}
