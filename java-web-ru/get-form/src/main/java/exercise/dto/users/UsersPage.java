package exercise.dto.users;

import exercise.model.User;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@Getter
@Setter
@AllArgsConstructor
public class UsersPage {
    private List<User> firstName;
    private String term;
}
// END
