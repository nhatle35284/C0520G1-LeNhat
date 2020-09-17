<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Product </title>
    <link rel="stylesheet" href="../lib/bootstrap413/css/bootstrap.min.css"/>

</head>
<body style="background-image: url('https://photo2.tinhte.vn/data/attachment-files/2019/07/4722533_Cover_Picture_33.jpg')">
<div align="center">
    <form method="post">
        <div class="menu">
            <div class="row">
                <div class="col-12">
                    <div class="col-12" style="margin-top: 28px">
                        <table class="table table-striped">
                                <h2>Thêm mới mặt bằng</h2>

                            <tr>
                                <th>Mã :</th>

                                <td>
                                    <input type="text" name="ma" id="ma" class="input-group-text" size="100px"/>
                                </td>
                            </tr>
                            <tr>
                                <th>Diện Tích:</th>
                                <td>
                                    <input type="text" name="dien_tich" id="dien_tich" class="input-group-text" size="100px"/>
                                </td>
                            </tr>
                            <tr>
                                <th>Trạng Thái:</th>
                                <td>
                                    <select name="trang_thai" class="input-group-text">
                                        <option>Trống</option>
                                        <option>Cho thuê</option>
                                    </select>
<%--                                    <input type="text" name="trang_thai" id="trang_thai" class="input-group-text" size="100px"/>--%>
                                </td>
                            </tr>
                            <tr>
                                <th>tầng</th>
                                <td>
                                    <select name="tang" class="input-group-text">
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                    </select>
<%--                                    <input type="text" name="tang" id="tang" class="input-group-text"--%>
<%--                                           size="100px"/>--%>
                                </td>
                            </tr>
                            <tr>
                                <th>Loại Văn Phòng:</th>
                                <td>
                                    <select name="loai_van_phong" class="input-group-text">
                                        <option>van phong</option>
                                        <option>Văn Phòng Chia Sẻ</option>
                                        <option>Văn Phòng trọn gói</option>
                                    </select>
<%--                                    <input type="text" name="loai_van_phong" id="color" class="input-group-text" size="100px"/>--%>
                                </td>
                            </tr>
                            <tr>
                                <th> Giá:</th>
                                <td>
                                    <input type="text" name="gia" id="gia" class="input-group-text"
                                           size="100px"/>
                                </td>
                            </tr>
                            <tr>
                                <th>Ngày Bắt Dầu:</th>
                                <td>
                                    <input type="date" name="ngay_bat_dau" id="ngay_bat_dau" class="input-group-text"
                                           size="100px"/>
                                </td>
                            </tr>
                            <tr>
                                <th>Ngày Kết Thúc:</th>
                                <td>
                                    <input type="date" name="ngay_ket_thuc" id="ngay_ket_thuc" class="input-group-text"
                                           size="100px"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <input type="submit" value="Save" class="btn btn-primary"/>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <button class="btn btn-primary"><a href="/homePage" style="color: white">Go Home</a></button>
    </form>
</div>
<script src="../lib/jquery/jquery-3.5.1.min.js"></script>
<script src="../lib/bootstrap413/js/bootstrap.min.js"></script>
</body>
</html>
