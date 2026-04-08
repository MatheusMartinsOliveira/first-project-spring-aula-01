/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aula01.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author farma
 */
@Controller
public class PortalController {
    
    @GetMapping("/portal")
    public String abrirPortal() {
        return "portal";
    }
    @GetMapping("/servicos")
    public String abrirServicos(){
        return "servicos";
}
    @GetMapping("/contato")
    public String abrirContato(){
        return "contato";
    }
}
    
