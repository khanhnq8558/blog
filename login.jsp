<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <% if (request.getParameter("error") != null) { %>
        <p>Invalid username or password.</p>
    <% } %>
    <form action="login" method="post">
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
    </form>
</body>
</html>
