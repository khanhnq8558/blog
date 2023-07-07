import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginServlet extends HttpServlet {
    private List<User> userList;

    public loginServlet() {
        userList = new ArrayList<>();
        // Thêm người dùng mẫu
        userList.add(new User("admin", "password"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra xem người dùng có trong danh sách không
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                // Lưu thông tin người dùng vào session
                HttpSession session = request.getSession();
                session.setAttribute("username", username);

                // Chuyển hướng đến trang danh sách bài viết
                response.sendRedirect("post-list.jsp");
                return;
            }
        }

        // Đăng nhập không thành công, chuyển hướng đến trang đăng nhập lại
        response.sendRedirect("login.jsp?error=1");
    }
}
