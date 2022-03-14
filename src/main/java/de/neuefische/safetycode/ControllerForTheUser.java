package de.neuefische.safetycode;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class ControllerForTheUser {

    private final UserService userService;

    @PostMapping
    public UserDocument createUser(@RequestBody UserDocument user) {
        return userService.createUser(user);
    }
}
