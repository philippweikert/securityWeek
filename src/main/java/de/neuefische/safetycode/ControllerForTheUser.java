package de.neuefische.safetycode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/greetings")
public class ControllerForTheUser {

    @GetMapping
    public String messageTwo(){
        return "Moinsen, Geringverdiener!";
    }
}
