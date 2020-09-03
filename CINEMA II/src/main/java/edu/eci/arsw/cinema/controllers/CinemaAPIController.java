/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.controllers;

import edu.eci.arsw.cinema.services.CinemaServices;
import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.*;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 *
 * @author cristian
 */
@RestController
@RequestMapping("/cinemas")
public class CinemaAPIController {

@Autowired
CinemaServices cinemaServices;

    
@RequestMapping(method = RequestMethod.GET)
public ResponseEntity<?> manejadorGetRecursoCinema(){
    try {
        //obtener datos que se enviarán a través del API
        String data = new Gson().toJson(cinemaServices.getAllCinemas());
        return new ResponseEntity<>(data,HttpStatus.ACCEPTED);
    } catch (Exception ex) {
        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        return new ResponseEntity<>("Recurso no encontrado",HttpStatus.NOT_FOUND);
    }        
}

@GetMapping("/{name}")
public ResponseEntity<?> getFunctions(@PathVariable String name) throws CinemaException{
    try {
        String data = new Gson().toJson((ArrayList<CinemaFunction>) cinemaServices.getCinemaByName(name).getFunctions());
        return new ResponseEntity<>(data,HttpStatus.ACCEPTED);
    } catch (CinemaPersistenceException ex) {
        Logger.getLogger(CinemaAPIController.class.getName()).log(Level.SEVERE, null, ex);
        return new ResponseEntity<>("Recurso no encontrado",HttpStatus.NOT_FOUND);
    }
}

}
