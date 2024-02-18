<%@ page import="java.util.List" %>
<%@ page import="kz.alabs.academy.entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
    <div>
<%--        <%--%>
<%--            List<Student> students = (List<Student>) request.getAttribute("students");--%>
<%--        %>--%>
<%--        <table class="table">--%>
<%--            <thead>--%>
<%--            <tr>--%>
<%--                <th scope="col">#</th>--%>
<%--                <th scope="col">name</th>--%>
<%--                <th scope="col">surname</th>--%>
<%--                <th scope="col">age</th>--%>
<%--            </tr>--%>
<%--            </thead>--%>
<%--            <%--%>
<%--                for(Student student : students) {--%>

<%--            %>--%>
<%--            <tbody>--%>
<%--            <tr>--%>
<%--                <th scope="row"><%=student.getId()%></th>--%>
<%--                <td><%=student.getName()%></td>--%>
<%--                <td><%=student.getSurname()%></td>--%>
<%--                <td><%=student.getAge()%></td>--%>
<%--            </tr>--%>
<%--            <%--%>
<%--                }--%>
<%--            %>--%>
<%--            </tbody>--%>
<%--        </table>--%>
        <form action="/addStudent" method="post">
            <div class="mb-3">
                <label class="form-label">Enter student`s name</label>
                <input class="form-control" placeholder="examples: Arman, Mark" name="studentName">
            </div>
            <div class="mb-3">
                <label class="form-label">Enter student`s surname</label>
                <input class="form-control" placeholder="examples: Hazaev, Mitenko" name="studentSurname">
            </div>
            <div class="mb-3">
                <label class="form-label">Enter student`s age</label>
                <input type="number" class="form-control" placeholder="examples: 10, 24, 69" name="studentAge">
            </div>
            <div class="mb-3">
                <label class="form-label">Enter student`s university</label>
                <input class="form-control" placeholder="examples: Harvard University" name="studentUniversity">
            </div>
            <button class="btn btn-primary">Add Student</button>
        </form>
<%--        <form action="students" method="get">--%>
<%--&lt;%&ndash;        <label for="fullName">Full Name:</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <input type="text" id="fullName" name="fullName" required><br><br>&ndash;%&gt;--%>

<%--&lt;%&ndash;        <label for="score">Exam evaluation:</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <input type="number" id="score" name="eval" required><br><br>&ndash;%&gt;--%>

<%--        <input type="submit" value="Submit">--%>
<%--        </form>--%>

    </div>
</body>
</html>
