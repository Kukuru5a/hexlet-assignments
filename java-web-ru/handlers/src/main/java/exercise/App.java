package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var creation = Javalin.create(config -> {config.plugins.enableDevLogging();});
        creation.get("/phones", ctx -> ctx.json(Data.getPhones()));
        creation.get("/domains", ctx -> ctx.json(Data.getDomains()));
        return creation;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
