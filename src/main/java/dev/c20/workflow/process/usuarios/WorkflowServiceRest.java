package dev.c20.workflow.process.usuarios;

import dev.c20.workflow.commons.CommonsConfig;
import dev.c20.workflow.commons.wrapper.RemoteTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    ResponseEntity<?> get(HttpServletRequest request) throws Exception {

        remoteTaskService.init("http://localhost:8089", "/workflow", request.getHeader(CommonsConfig.HEADER_AUTHORIZATION));

        return null;
    }

}
