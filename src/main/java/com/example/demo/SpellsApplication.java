package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class SpellsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpellsApplication.class, args);
	}

	@Bean
	CommandLineRunner init(SpellRepository spellRepository){
		return args -> {
			Spell spell = new Spell("Tasha's Hideous Laughter", 30, "A creature of your choice finds everything as hilariously funny. That creature is incapacitated for a turn.");
			spellRepository.save(spell);
			Spell spell2 = new Spell("Eldritch Blast", 60, "Ranged spell attack that deals 1d10 damage on hit");
			spellRepository.save(spell2);
			Spell spell3 = new Spell("Detect Spell", 30, "You detect magic around you, duh");
			spellRepository.save(spell3);
			Spell spell4 = new Spell("Acid Splash", 60, "A target or two that are 5 feet within each other take 1d6 damage on a failed Dexterity saving throw");
			spellRepository.save(spell4);
			spellRepository.findAll().forEach(System.out::println);
		};
	}
}
