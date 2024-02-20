package com.example.Arifutera.github;

import com.example.Arifutera.github.DTOs.GitHubResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Set;

@RestController
public class GitHubController {

    private final GitHubService gitHubService;

    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/user/{username}")
    ResponseEntity<Set<GitHubResponseDTO>> getRepositories(@PathVariable String username) {
        return ResponseEntity.ok(gitHubService.getRepositories(username));
    }

    @GetMapping("/user/reactive/{username}")
    ResponseEntity<Flux<GitHubResponseDTO>> getRepositoriesWebflux(@PathVariable String username) {
        return ResponseEntity.ok(gitHubService.getRepositoriesWebflux(username));

    }
}