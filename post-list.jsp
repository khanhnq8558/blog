<html>
<head>
    <title>Blog Post List</title>
</head>
<body>
    <h1>Welcome, <%= session.getAttribute("username") %></h1>

    <h2>Create a new blog post</h2>
    <form action="create-post" method="post">
        <input type="text" name="title" placeholder="Title" required>
        <textarea name="content" placeholder="Content" required></textarea>
        <button type="submit">Create Post</button>
    </form>

    <h2>Blog Post List</h2>
    <ul>
        <% for (BlogPost post : blogPostList) { %>
            <li>
                <h3><%= post.getTitle() %></h3>
                <p><%= post.getContent() %></p>
                <p>Author: <%= post.getAuthor() %></p>
            </li>
        <% } %>
    </ul>
</body>
</html>
