import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreatePostServlet extends HttpServlet {
    private List<BlogPost> blogPostList;

    public CreatePostServlet() {
        blogPostList = new ArrayList<>();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        // Kiểm tra xem người dùng đã đăng nhập
        if (username != null) {
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            // Tạo bài viết mới
            BlogPost post = new BlogPost();
            post.setTitle(title);
            post.setContent(content);
            post.setAuthor(username);

            // Thêm bài viết vào danh sách
            blogPostList.add(post);

            // Chuyển hướng đến trang danh sách bài viết
            response.sendRedirect("post-list.jsp");
        } else {
            // Chưa đăng nhập, chuyển hướng đến trang đăng nhập
            response.sendRedirect("login.jsp");
        }
    }
}
