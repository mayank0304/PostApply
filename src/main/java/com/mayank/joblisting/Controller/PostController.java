package com.mayank.joblisting.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mayank.joblisting.Repository.JobApplicantRepository;
import com.mayank.joblisting.Repository.PostRepository;
import com.mayank.joblisting.Repository.SearchRepository;
import com.mayank.joblisting.model.JobApplication;
import com.mayank.joblisting.model.Post;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;

    @Autowired
    JobApplicantRepository jobrepo;

    @Hidden
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse  response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/allPosts")
    public List<Post> getAllPosts() {
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text) {
        return srepo.findByText(text);
    }

    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable String id){
        repo.deleteById(id);
        return "Post with ID " + id + " deleted";
    }

    @GetMapping("/posts/sorted")
    public List<Post> sortedList(@RequestParam String sortBy) {
        return repo.findAll(Sort.by( Sort.Direction.ASC,sortBy));

    }

    @PostMapping("/post")
    public Post addPost(@Valid @RequestBody Post post) {
        return repo.save(post);
    }
 
    @PostMapping("/post/applicant")
    public JobApplication apply(@Valid @RequestBody JobApplication job) {
        return jobrepo.save(job);
    }

    @GetMapping("/job/")
    public List<JobApplication> applications() {
        return jobrepo.findAll();
    }
}
