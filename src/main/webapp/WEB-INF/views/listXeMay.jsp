<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sach xe may</title>
</head>
<body>
<h1>Danh sach xe may</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Mo ta</th>
        <th>Gia nhap</th>
        <th>Gia ban</th>
        <th>So luong</th>
        <th>Website</th>
        <th>id_lxm</th>
        <th>Trang thai</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="xeMay">
        <tr>
            <td>${xeMay.id}</td>
            <td>${xeMay.ma}</td>
            <td>${xeMay.ten}</td>
            <td>${xeMay.moTa}</td>
            <td>${xeMay.giaNhap}</td>
            <td>${xeMay.giaBan}</td>
            <td>${xeMay.soLuong}</td>
            <td>${xeMay.website}</td>
            <td>${xeMay.id_lxm}</td>
            <td>${xeMay.trangThai}</td>
            <td>
                <a href="">Edit</a> |
                <a href="${pageContext.request.contextPath}/motor-management/delete?id=${xeMay.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
