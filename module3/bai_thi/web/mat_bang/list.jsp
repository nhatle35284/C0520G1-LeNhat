<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="../lib/bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../lib/datatables/css/dataTables.bootstrap4.min.css"/>
</head>
<body style="background-image: url('https://photo2.tinhte.vn/data/attachment-files/2019/07/4722533_Cover_Picture_33.jpg')">
<%@include file="../common/header.jsp" %>

<div class="menu">

    <div class="row">
        <div class="col-12">
            <div class="col-12" style="margin-top: 28px">
                <h2 style="color: darkcyan ;text-align: center">Danh sách Mặt Bằng </h2>

                <a class="btn btn-primary" style="margin: 3px"
                   href="/homePage?action=create"><span>Thêm mới mặt bằng</span></a>

                <form class="form-inline my-2 my-lg-0" action="/homePage?action=search" method="post"
                      style="float: right">
                    <input type="hidden" name="action" value="search">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                           name="loai_van_phong">
<%--                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"--%>
<%--                           name="tang">--%>
<%--                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"--%>
<%--                           name="ngay_bat_dau">--%>
<%--                    <select name="loai_van_phong" aria-label="Search" type="search">--%>
<%--                        <option>Trống</option>--%>
<%--                        <option>Cho Thuê</option>--%>
<%--                    </select>--%>
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>

                <table class="table table-striped" id="tableStudent">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">Mã</th>
                        <th scope="col">Diện Tich</th>
                        <th scope="col">Trạng Thai</th>
                        <th scope="col">Tầng</th>
                        <th scope="col">Loại Văn Phòng</th>
                        <th scope="col">Giá</th>
                        <th scope="col">Ngày Bắt Dau</th>
                        <th scope="col">Ngày Kết Thúc</th>
                        <th scope="col">action</th>
                    </tr>

                    </thead>
                    <tbody style="background-color: #f7f5f2">
                    <c:forEach var="matBang" items="${listMatBang}">
                        <tr>
                            <td><c:out value="${matBang.ma}"/></td>
                            <td><c:out value="${matBang.dienTich}"/></td>
                            <td><c:out value="${matBang.trangThai}"/></td>
                            <td><c:out value="${matBang.tang}"/></td>
                            <td><c:out value="${matBang.loaiVanPhong}"/></td>
                            <td><c:out value="${matBang.gia}"/></td>
                            <td><c:out value="${matBang.ngayBatDau}"/></td>
                            <td><c:out value="${matBang.ngayKetThuc}"/></td>
                            <td>
                                <button type="button" class="btn btn-primary" data-toggle="modal"
                                        data-target="#a${matBang.ma}">
                                    Delete
                                </button>
<%--                                <button class="btn btn-primary"><a href="/homePage?action=delete&id=${product.id}"--%>
<%--                                                                   style="color: white">Delete</a></button>--%>
                                <div class="modal fade" id="a${matBang.ma}" tabindex="-1" role="dialog"
                                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">Do you want delete?</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                Mặt bằng có mã : ${matBang.ma}
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                                                </button>
                                                <button type="button" class="btn btn-primary"><a
                                                        href="/homePage?action=delete&id=${matBang.ma}" style="color: black">Delete</a>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


    <%@include file="../common/footer.jsp" %>

    <script src="../lib/jquery/jquery-3.5.1.min.js"></script>
    <script src="../lib/datatables/js/jquery.dataTables.min.js"></script>
    <script src="../lib/datatables/js/dataTables.bootstrap4.min.js"></script>
    <script src="../lib/bootstrap413/js/bootstrap.min.js"></script>
</body>
</html>
