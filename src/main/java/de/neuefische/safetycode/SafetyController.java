package de.neuefische.safetycode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/adminmessage")
public class SafetyController {

    @GetMapping
    public String messageAdmin () {
        return "'Cause your friends don't dance and if they don't dance, well they're no friends of mine";
    }
}
