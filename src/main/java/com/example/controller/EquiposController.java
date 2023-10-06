package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.models.Equipo;
import com.example.models.Jugador;

/**
 * Controlador que nos ayuda con el mapeo de la aplicacion
 */
@Controller
public class EquiposController{

    @Autowired
    RestTemplate template;
    String urlEquipos = "http://localhost:8800/";
    String urlJugadores = "http://localhost:8888/";

    @GetMapping("/")
    public String inicio(Model model){
        List<Equipo> equipos = Arrays.asList(template.getForObject(urlEquipos+"equipos", Equipo[].class));
        model.addAttribute("equipos", equipos);
        return "Clasificacion";
    }

    @GetMapping("/goles")
    public String goles(Model model){
        List<Equipo> equipos = Arrays.asList(template.getForObject(urlEquipos+"equipos/Goles", Equipo[].class));
        model.addAttribute("equipos", equipos);
        return "Clasificacion";
    }

    @GetMapping("/victorias")
    public String victorias(Model model){
        List<Equipo> equipos = Arrays.asList(template.getForObject(urlEquipos+"equipos/Victorias", Equipo[].class));
        model.addAttribute("equipos", equipos);
        return "Clasificacion";
    }

    @GetMapping("/empates")
    public String empates(Model model){
        List<Equipo> equipos = Arrays.asList(template.getForObject(urlEquipos+"equipos/Empates", Equipo[].class));
        model.addAttribute("equipos", equipos);
        return "Clasificacion";
    }

    @GetMapping("/derrotas")
    public String derrotas(Model model){
        List<Equipo> equipos = Arrays.asList(template.getForObject(urlEquipos+"equipos/Derrotas", Equipo[].class));
        model.addAttribute("equipos", equipos);
        return "Clasificacion";
    }

    @GetMapping("/jugadores")
    public String listajugadores(@RequestParam(name="nombre") String nombre, Model model){
        List<Jugador> jugadores = Arrays.asList(template.getForObject(urlJugadores+"jugador/equipo/"+nombre, Jugador[].class));
        model.addAttribute("jugadores", jugadores);
        return "jugadores";
    }

}
