package com.example.atipera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class Git_hub_Controllers {

        private final githubServices githubServices;

        @Autowired
        public Git_hub_Controllers(githubServices gitHubService) {
            this.githubServices = gitHubService;
        }

        @GetMapping("/repositories/{username}")
        @ResponseBody
        public ResponseEntity<?> getUserRepositoriesWithBranches(@PathVariable String username,  @RequestHeader(value = "Accept") String header) {

            if( header.contains("application/json")){
                List<Repository_Branch> repositories = githubServices.getUserRepositoriesWithBranches(username);

                if (repositories == null) {
                    Map<String, Object> response = new HashMap<>();
                    response.put("Message", "Not found - the resource you requested does not exist.");
                    response.put("status", HttpStatus.NOT_FOUND.value());

                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
                }
                return ResponseEntity.ok(repositories);

            }else {
                System.out.println(header);
                Map<String, Object> response = new HashMap<>();
                response.put("Message", "Bad Header, pls use Accept:  " + MediaType.APPLICATION_JSON_VALUE);
                response.put("status",406);

                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                        .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                        .body(response);
            }





        }



}
