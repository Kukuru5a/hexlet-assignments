package exercise;

import java.net.URI;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> index(@RequestParam(defaultValue = "10") Integer limit) {
        posts.stream().limit(limit).toList();
        return ResponseEntity.ok().header("X-Total-Count", String.valueOf(posts.size())).build();
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> show(@PathVariable String id) {
        var res = posts.stream().filter(p->p.getId().equals(id)).findFirst();

        if (res.isPresent()) {
        return ResponseEntity.of(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> create(@RequestBody Post post) {
        var res = posts.add(post);
        return ResponseEntity.status(201).body(post);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> update(@PathVariable String id, @RequestBody Post data) {
        var pseudoPage = posts.stream().filter(p->p.getId().equals(id)).findFirst();
        if(pseudoPage.isPresent()) {
            var pg = pseudoPage.get();
            pg.setId(data.getId());
            pg.setTitle(data.getTitle());
            pg.setBody(data.getBody());
            return ResponseEntity.ok().body(data);
        }
        return ResponseEntity.noContent().build();
    }
    // END

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
}
