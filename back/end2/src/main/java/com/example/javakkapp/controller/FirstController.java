package com.example.javakkapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/end2")
public class FirstController {
	@GetMapping("/message")
	public String test() {
		return "Hello from endpoint 2";
	}
}