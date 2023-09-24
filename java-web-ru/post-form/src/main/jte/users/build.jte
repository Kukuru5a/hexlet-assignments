<!-- BEGIN -->
<html>
    <head>
        <meta charset="UTF-8">
    </head>
    <body>
        <form action="/users" method="post">
            <div>
                <label>
                    Name
                </label>
                <input type="text" name="name" />
            </div>
            <div>
                <label>
                    Email
                </label>
                <input type="text" required name="email" />
            </div>
            <div>
                <label>
                    Password
                </label>
                <input type="password" required name="password"/>
            </div>
            <div>
                <label>
                    Confirm Password
                </label>
                <input type="password" required name="passwordConfirmation"/>
            </div>
            <input type="submit" name="Register" />
        </form>
    </body>
</html>
<!-- END -->
