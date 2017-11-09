package com.project.lookify.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.project.lookify.models.Artist;
import com.project.lookify.models.Song;
import com.project.lookify.services.LookifyService;
import java.util.List;


@Controller
public class LookifyController{
	private LookifyService lookifyService;

	public LookifyController(LookifyService lookifyService){
		this.lookifyService = lookifyService;
	}
	
	@RequestMapping("")
	public String index(Model model){
		List<Song> songs = lookifyService.getAllSongs();
		model.addAttribute("songs", songs);
		return "index";
	}
	@RequestMapping("/new")
	public String newSong(@ModelAttribute("Song") Song song, @ModelAttribute("Artist") Artist artist){
		return "new";
	}
	@PostMapping("/create")
	public String create(@RequestParam("title") String title, @RequestParam("rating") int rating, @RequestParam("artist") String artist){
		if (lookifyService.getArtistByName(artist) != null){
			Artist artist2 = lookifyService.getArtistByName(artist);
			Song newSong = new Song(title, rating, artist2);
			// artist2.setSong(newSong);
			lookifyService.createSong(newSong);
			lookifyService.updateArtist(artist2);
			return "redirect:/";
		} else {
			Artist newArtist = new Artist(artist);
			newArtist = lookifyService.createArtist(newArtist);
			Song newSong = new Song(title, rating, newArtist);
			lookifyService.createSong(newSong);
			ArrayList<Song> newSong2 = new ArrayList();
			newSong2.add(newSong);
			System.out.println(newSong2);
			newArtist.setSong(newSong2);
			lookifyService.updateArtist(newArtist);

			return "redirect:/";
		}
	}
	@RequestMapping("/top10")
	public String top10(Model model){
		model.addAttribute("songs", lookifyService.getTop10());
		return "top10";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id){
		lookifyService.deleteSong(id);
		return "redirect:/";
	}
	@RequestMapping("/search")
	public String search(@RequestParam("artist") String search, Model model){
		model.addAttribute("songs", lookifyService.getArtistByName(search));
		return "search";
	}
}
