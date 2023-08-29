package exercise;

// BEGIN
import io.javalin.Javalin;

// END

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var creator = Javalin.create(config -> {config.plugins.enableDevLogging();});
        creator.get("/welcome", ctx -> ctx.result("Welcome to Hexlet!"));
        return creator;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
