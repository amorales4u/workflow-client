package dev.c20.workflow.process.usuarios;

import dev.c20.workflow.commons.CommonsConfig;
import dev.c20.workflow.commons.wrapper.RemoteStorageService;
import dev.c20.workflow.commons.wrapper.RemoteTaskService;
import dev.c20.workflow.commons.wrapper.entities.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping(
        path = "/workflow",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class WorkflowServiceRest {

    @Autowired
    RemoteTaskService remoteTaskService;

    @Autowired
    RemoteStorageService remoteStorageService;

    @GetMapping
    ResponseEntity<?> get(HttpServletRequest request) throws Exception {

        remoteTaskService.init("http://localhost:8089",
                "/workflow", request.getHeader(CommonsConfig.HEADER_AUTHORIZATION));

        return ResponseEntity.ok(remoteTaskService.getAll());
    }
    @PutMapping
    ResponseEntity<?> create(@RequestBody Map<String,Object> data, HttpServletRequest request) throws Exception {

        remoteTaskService.init("http://localhost:8089",
                "/workflow", request.getHeader(CommonsConfig.HEADER_AUTHORIZATION));

        remoteTaskService.start((String)data.get("workflow"),data);
        return ResponseEntity.ok(remoteTaskService.getAll());
    }

    @PutMapping("/tree/")
    ResponseEntity<?> create(Storage storageDefinition, HttpServletRequest request) throws Exception {

        remoteStorageService.init("http://localhost:8089",
                "/workflow", request.getHeader(CommonsConfig.HEADER_AUTHORIZATION));

        return ResponseEntity.ok(
                remoteStorageService.createTree(
                        "/Catálogos/Usuarios/Externos/amorales@c20.dev"
                        ,storageDefinition)
        );
    }


}
