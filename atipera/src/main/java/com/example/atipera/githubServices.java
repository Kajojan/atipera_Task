package com.example.atipera;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service

public class githubServices {

        private final String GITHUB_API_BASE_URL = "https://api.github.com";
        private final RestTemplate restTemplate;

        public githubServices(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        public Repository[] getUserRepositories(String username) {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            HttpEntity<?> entity = new HttpEntity<>(headers);
            String apiUrl = GITHUB_API_BASE_URL + "/users/" + username + "/repos";

            try {
                return restTemplate.exchange(
                        apiUrl,
                        HttpMethod.GET,
                        entity,
                        Repository[].class
                ).getBody();


            } catch (HttpClientErrorException.NotFound notFoundException) {
                return null;
            }

        }
    public List<Branch> getBranchesFromGitHub(String branchesUrl) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<?> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<Branch[]> responseEntity = restTemplate.exchange(
                    branchesUrl,
                    HttpMethod.GET,
                    entity,
                    Branch[].class
            );

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return Arrays.asList(responseEntity.getBody());
            } else {
                throw new RuntimeException("Error fetching branches: " + responseEntity.getStatusCode());
            }
        } catch (HttpClientErrorException.NotFound notFoundException) {
            return Collections.emptyList();
        }
    }









}
