package com.lets.beerShop.controllers;

import com.lets.beerShop.dao.BeersDAO;
import com.lets.beerShop.models.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/beers"/*,produces = MediaType.APPLICATION_JSON_VALUE*/)
public class BeersController {

    @Autowired
    private BeersDAO beersDAO;

    public BeersController(BeersDAO beersDAO) {
        this.beersDAO = beersDAO;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("beers",beersDAO.index());
        return "beers/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("beer",beersDAO.show(id));
        return "beers/show";
    }
    @GetMapping("/new")
    public String newBeer(@ModelAttribute("beer") Beer beer){
        //model.addAttribute("beer", new Beer());
        return "beers/new";
    }
    @PostMapping()
    public String create( @ModelAttribute("beer") @Valid Beer beer, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "beers/new";

        beersDAO.save(beer);
        return "redirect:/beers";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("beer",beersDAO.show(id));
        return "beers/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("beer") @Valid Beer beer, BindingResult bindingResult, @PathVariable("id") int id) {
        Boolean result=bindingResult.hasErrors();
        result=false;
        if (result){
            return "beers/edit";
        }
        beersDAO.update(beer,id);
        return "redirect:/beers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        beersDAO.delete(id);
        return "redirect:/beers";
    }
}
