package dev.c20.workflow.process.usuarios;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(
        path = "/users",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class UsuariosRest {

    @GetMapping
    ResponseEntity<?> get(@RequestBody Map<String,Object> data) throws Exception {

        return null;
    }

    @PutMapping("/start")
    ResponseEntity<?> start(@RequestBody Map<String,Object> data) throws Exception {

        return null;
    }

    @PostMapping
    ResponseEntity<?> save(@RequestBody Map<String,Object> data) throws Exception {

        return null;
    }

    @DeleteMapping
    ResponseEntity<?> delete(@RequestBody Map<String,Object> data) throws Exception {

        return null;
    }

    @PostMapping("/complete/{fromActivity}/")
    ResponseEntity<?> complete(@PathVariable("fromActivity") String fromActivity,
                               @RequestBody Map<String,Object> data) throws Exception {

        return null;
    }


}
