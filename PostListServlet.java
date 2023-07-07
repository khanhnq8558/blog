import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        // Kiểm tra xem người dùng đã đăng nhập chưa
        if (username != null) {
            // Lấy danh sách bài viết từ servlet khác hoặc cơ sở dữ liệu
            List<BlogPost> blogPostList = getBlogPostList();

            // Gửi danh sách bài viết đến trang JSP để hiển thị
            request.setAttribute("blogPostList", blogPostList);
            request.getRequestDispatcher("post-list.jsp").forward(request, response);
        } else {
            // Chưa đăng nhập, chuyển hướng đến trang đăng nhập
            response.sendRedirect("login.jsp");
        }
    }

    private List<BlogPost> getBlogPostList() {
        // Lấy danh sách bài viết từ cơ sở dữ liệu hoặc servlet khác
        // Return danh sách bài viết
    }
}
