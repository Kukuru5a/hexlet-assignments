package exercise.controller.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    private List<Post> posts = Data.getPosts();

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/users/{userId}/posts")
    public Post create(@PathVariable Integer userId, @RequestBody Post post) {
        post.setUserId(userId);
        posts.add(post);
        return post;
    }

    @GetMapping("/users/{userId}/posts")
    public List<Post> show(@PathVariable Integer userId) {
        return posts.stream()
                .filter(p -> p.getUserId() == userId).toList();
    }



//    @GetMapping("/users/{id}/posts")
//    public ResponseEntity<List<Post>> index(@RequestParam(defaultValue = "10") int id) {
//        List<Post> postList = Data.getPosts().stream().filter(post -> post.getUserId() == id).collect(Collectors.toList());
//        System.out.println(postList);
//        System.out.println(id);
//        return ResponseEntity.ok(postList);
//}
//

}
// END
