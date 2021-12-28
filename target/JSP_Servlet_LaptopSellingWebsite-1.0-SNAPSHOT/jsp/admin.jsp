<%--
  Created by IntelliJ IDEA.
  User: Thinh PC
  Date: 12/21/2021
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"/>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Metaverse Laptop</title>
    <link rel="icon" href="${root}image/logo-re.png">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${root}css/admin.css" class="css">
    <link href="fonts/themify-icons/themify-icons.css" rel="stylesheet">
    <link href="fonts/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="fonts/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link crossorigin="anonymous" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
          integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
          referrerpolicy="no-referrer" rel="stylesheet"/>
</head>
<body>
<div id="main">
    <h1 class="title"><strong>DASHBOARD</strong></h1>
    <button class="logout">LOGOUT <i class="fas fa-sign-out-alt"></i></button>
    <div class="container">
        <div class="tab">
            <button class="tablinks">DELL</button>
            <button class="tablinks">MSI</button>
            <button class="tablinks">ASUS</button>
        </div>
        <div id="dell" class="details-laptop">
            <a role="button" type="button" href="#table2">
                <div class="logo" style="background-image: url('${root}image/logo lap/dell.png')"></div>
            </a>
            <div class="details bg-blue">
                <div class="details-number">52</div>
                <div class="details-title">Tổng số lượng nhập</div>
            </div>
            <div class="details bg-green">
                <div class="details-number">52</div>
                <div class="details-title">Tổng số lượng xuất</div>
            </div>
            <div class="details bg-red">
                <div class="details-number">52</div>
                <div class="details-title">Tổng số lượng tồn kho</div>
            </div>
        </div>
        <div id="msi" class="details-laptop">
            <a role="button" type="button">
                <div class="logo" style="background-image: url('${root}image/logo lap/msi.png')"></div>
            </a>
            <div class="details bg-blue">
                <div class="details-number">52</div>
                <div class="details-title">Tổng số lượng nhập</div>
            </div>
            <div class="details bg-green">
                <div class="details-number">52</div>
                <div class="details-title">Tổng số lượng xuất</div>
            </div>
            <div class="details bg-red">
                <div class="details-number">52</div>
                <div class="details-title">Tổng số lượng tồn kho</div>
            </div>
        </div>
        <div id="asus" class="details-laptop">
            <a role="button" type="button">
                <div class="logo" style="background-image: url('${root}image/logo lap/asus.png')"></div>
            </a>
            <div class="details bg-blue">
                <div class="details-number">52</div>
                <div class="details-title">Tổng số lượng nhập</div>
            </div>
            <div class="details bg-green">
                <div class="details-number">52</div>
                <div class="details-title">Tổng số lượng xuất</div>
            </div>
            <div class="details bg-red">
                <div class="details-number">52</div>
                <div class="details-title">Tổng số lượng tồn kho</div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="table-responsive">
            <div class="table-wrapper" style="width: auto">
                <div class="table-title">
                    <div class="row">
                        <div class="col-xs-6">
                            <h2>Quản lý <b>Kho hàng</b></h2>
                        </div>
                        <div class="col-xs-6">
                            <a id="addRow2" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                                <span>Thêm hàng</span></a>
                        </div>
                    </div>
                </div>
                <table id="table3" class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>MÃ LAPTOP</th>
                        <th>SỐ LƯỢNG NHẬP</th>
                        <th>SỐ LƯỢNG XUẤT</th>
                        <th>TỒN KHO</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>V4R53500U001W</td>
                        <td>Laptop Dell Vostro 14 3405</td>
                        <td>Dell</td>
                        <td>16.190.000</td>
                    </tr>
                    </tbody>
                </table>
                <div class="clearfix">
                    <ul class="pagination">
                        <li class="page-item disabled"><a href="#">Previous</a></li>
                        <li class="page-item"><a href="#" class="page-link">1</a></li>
                        <li class="page-item"><a href="#" class="page-link">2</a></li>
                        <li class="page-item active"><a href="#" class="page-link">3</a></li>
                        <li class="page-item"><a href="#" class="page-link">4</a></li>
                        <li class="page-item"><a href="#" class="page-link">5</a></li>
                        <li class="page-item"><a href="#" class="page-link">Next</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="table-responsive">
            <div class="table-wrapper" style="width: auto">
                <div class="table-title">
                    <div class="row">
                        <div class="col-xs-6">
                            <h2>Quản lý <b>Khách hàng</b></h2>
                        </div>
                        <div class="col-xs-6">
                            <a id="addRow3" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                                <span>Thêm hàng</span></a>
                        </div>
                    </div>
                </div>
                <table id="table4" class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>KHÁCH HÀNG</th>
                        <th>TÊN KHÁCH HÀNG</th>
                        <th>ID</th>
                        <th>ĐỊA CHỈ</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>V4R53500U001W</td>
                        <td>Laptop Dell Vostro 14 3405</td>
                        <td>Dell</td>
                        <td>16.190.000</td>
                    </tr>
                    </tbody>
                </table>
                <div class="clearfix">
                    <ul class="pagination">
                        <li class="page-item disabled"><a href="#">Previous</a></li>
                        <li class="page-item"><a href="#" class="page-link">1</a></li>
                        <li class="page-item"><a href="#" class="page-link">2</a></li>
                        <li class="page-item active"><a href="#" class="page-link">3</a></li>
                        <li class="page-item"><a href="#" class="page-link">4</a></li>
                        <li class="page-item"><a href="#" class="page-link">5</a></li>
                        <li class="page-item"><a href="#" class="page-link">Next</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="table-responsive">
            <div class="table-wrapper" style="width: auto">
                <div class="table-title">
                    <div class="row">
                        <div class="col-xs-6">
                            <h2>Quản lý <b>Chi tiết giỏ hàng</b></h2>
                        </div>
                        <div class="col-xs-6">
                            <a id="addRow4" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                                <span>Thêm hàng</span></a>
                        </div>
                    </div>
                </div>
                <table id="table5" class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>MÃ GIỎ HÀNG</th>
                        <th>MÃ LAPTOP</th>
                        <th>SỐ LƯỢNG</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>V4R53500U001W</td>
                        <td>Laptop Dell Vostro 14 3405</td>
                        <td>Dell</td>
                    </tr>
                    </tbody>
                </table>
                <div class="clearfix">
                    <ul class="pagination">
                        <li class="page-item disabled"><a href="#">Previous</a></li>
                        <li class="page-item"><a href="#" class="page-link">1</a></li>
                        <li class="page-item"><a href="#" class="page-link">2</a></li>
                        <li class="page-item active"><a href="#" class="page-link">3</a></li>
                        <li class="page-item"><a href="#" class="page-link">4</a></li>
                        <li class="page-item"><a href="#" class="page-link">5</a></li>
                        <li class="page-item"><a href="#" class="page-link">Next</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="table-responsive">
            <div class="table-wrapper" style="width: auto">
                <div class="table-title">
                    <div class="row">
                        <div class="col-xs-6">
                            <h2>Quản lý <b>Tài khoản</b></h2>
                        </div>
                        <div class="col-xs-6">
                            <a id="addRow5" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                                <span>Thêm hàng</span></a>
                        </div>
                    </div>
                </div>
                <table id="table6" class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>USERNAME</th>
                        <th>PASSWORD</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>V4R53500U001W</td>
                        <td>Laptop Dell Vostro 14 3405</td>
                        <td>Dell</td>
                    </tr>
                    </tbody>
                </table>
                <div class="clearfix">
                    <ul class="pagination">
                        <li class="page-item disabled"><a href="#">Previous</a></li>
                        <li class="page-item"><a href="#" class="page-link">1</a></li>
                        <li class="page-item"><a href="#" class="page-link">2</a></li>
                        <li class="page-item active"><a href="#" class="page-link">3</a></li>
                        <li class="page-item"><a href="#" class="page-link">4</a></li>
                        <li class="page-item"><a href="#" class="page-link">5</a></li>
                        <li class="page-item"><a href="#" class="page-link">Next</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="table-responsive">
            <div class="table-wrapper" style="width: auto">
                <div class="table-title">
                    <div class="row">
                        <div class="col-xs-6">
                            <h2>Quản lý <b>Giỏ hàng</b></h2>
                        </div>
                        <div class="col-xs-6">
                            <a id="addRow6" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                                <span>Thêm hàng</span></a>
                        </div>
                    </div>
                </div>
                <table id="table7" class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>MÃ GIỎ HÀNG</th>
                        <th>MÃ KHÁCH HÀNG</th>
                        <th>NGÀY XUẤT</th>
                        <th>TRỊ GIÁ</th>
                        <th>MÃ KHUYẾN MÃI</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>V4R53500U001W</td>
                        <td>Laptop Dell Vostro 14 3405</td>
                        <td>Dell</td>
                        <td>16.190.000</td>
                        <td>Dell</td>
                    </tr>
                    </tbody>
                </table>
                <div class="clearfix">
                    <ul class="pagination">
                        <li class="page-item disabled"><a href="#">Previous</a></li>
                        <li class="page-item"><a href="#" class="page-link">1</a></li>
                        <li class="page-item"><a href="#" class="page-link">2</a></li>
                        <li class="page-item active"><a href="#" class="page-link">3</a></li>
                        <li class="page-item"><a href="#" class="page-link">4</a></li>
                        <li class="page-item"><a href="#" class="page-link">5</a></li>
                        <li class="page-item"><a href="#" class="page-link">Next</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="table-responsive">
            <div class="table-wrapper" style="width: auto">
                <div class="table-title">
                    <div class="row">
                        <div class="col-xs-6">
                            <h2>Quản lý <b>Khuyến mãi</b></h2>
                        </div>
                        <div class="col-xs-6">
                            <a id="addRow7" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                                <span>Thêm hàng</span></a>
                        </div>
                    </div>
                </div>
                <table id="table8" class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>MÃ KHUYẾN MÃI</th>
                        <th>TÊN KHUYẾN MÃI</th>
                        <th>MỨC KHUYẾN MÃI</th>
                        <th>NGÀY HẾT HẠN</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>V4R53500U001W</td>
                        <td>Laptop Dell Vostro 14 3405</td>
                        <td>Dell</td>
                        <td>16.190.000</td>
                    </tr>
                    </tbody>
                </table>
                <div class="clearfix">
                    <ul class="pagination">
                        <li class="page-item disabled"><a href="#">Previous</a></li>
                        <li class="page-item"><a href="#" class="page-link">1</a></li>
                        <li class="page-item"><a href="#" class="page-link">2</a></li>
                        <li class="page-item active"><a href="#" class="page-link">3</a></li>
                        <li class="page-item"><a href="#" class="page-link">4</a></li>
                        <li class="page-item"><a href="#" class="page-link">5</a></li>
                        <li class="page-item"><a href="#" class="page-link">Next</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <!--        <div class="tab">-->
        <!--            <button class="tablink active">DELL</button>-->
        <!--            <button class="tablink">MSI</button>-->
        <!--            <button class="tablink">ASUS</button>-->
        <!--        </div>-->
        <div id="table-dell" class="table-responsive table-tabs">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-xs-6">
                            <h2>Quản lý <b>Laptop Dell</b></h2>
                        </div>
                        <div class="col-xs-6">
                            <a id="addRow1" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                                <span>Thêm hàng</span></a>
                        </div>
                    </div>
                </div>
                <table id="table2" class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>MÃ LAPTOP</th>
                        <th>TÊN LAPTOP</th>
                        <th>HÃNG</th>
                        <th>GIÁ BÁN</th>
                        <th>SERIES</th>
                        <th>MÀU</th>
                        <th>CPU</th>
                        <th>GPU</th>
                        <th>RAM</th>
                        <th>MÀN HÌNH</th>
                        <th>Ổ CỨNG</th>
                        <th>BÀN PHÍM</th>
                        <th>PIN</th>
                        <th>KHỐI LƯỢNG</th>
                        <th>Hình 1</th>
                        <th>Hình 2</th>
                        <th>Hình 3</th>
                        <th>Hình 4</th>
                        <th>Hình 5</th>
                    </tr>
                    </thead>
                    <tbody>
                    <jsp:useBean id="productsDell" scope="request" type="java.util.List"/>
                    <c:forEach var="x" items="${productsDell}">
                        <tr>
                            <td>${x.maLapTop}</td>
                            <td>${x.tenLaptop}</td>
                            <td>${x.hangSX}</td>
                            <td>${x.giaBan}</td>
                            <td>${x.series}</td>
                            <td>${x.mau}</td>
                            <td>${x.cpu}</td>
                            <td>${x.vga}</td>
                            <td>${x.ram}</td>
                            <td>${x.kichThuocManHinh}</td>
                            <td>${x.oCung}</td>
                            <td>${x.banPhim}</td>
                            <td>${x.pin}</td>
                            <td>${x.khoiLuong}</td>
                            <td>${x.linkHinh1}</td>
                            <td>${x.linkHinh2}</td>
                            <td>${x.linkHinh3}</td>
                            <td>${x.linkHinh4}</td>
                            <td>${x.linkHinh5}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="clearfix">
                    <ul class="pagination">
                        <li class="page-item disabled"><a href="#">Previous</a></li>
                        <li class="page-item"><a href="#" class="page-link">1</a></li>
                        <li class="page-item"><a href="#" class="page-link">2</a></li>
                        <li class="page-item active"><a href="#" class="page-link">3</a></li>
                        <li class="page-item"><a href="#" class="page-link">4</a></li>
                        <li class="page-item"><a href="#" class="page-link">5</a></li>
                        <li class="page-item"><a href="#" class="page-link">Next</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="thongbao" style="z-index: 1000">
    <div class="register js-register-container">
        <form class="register-form">
            <div class="input-register">
                Bạn chắc chứ?
            </div>
            <div class="register-div">
                <button type="button" id="yes" class="btn-register" >Có</button>
                <button type="button" id="no" class="btn-register">Không</button>
            </div>
        </form>
    </div>
</div>
<!--Back to top-->
<%@include file="../layout/back-to-top.jsp" %>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha384-vk5WoKIaW/vJyUAd9n/wmopsmNhiy+L2Z+SBxGYnUkunIxVxAv/UtMOhba/xskxh"
        crossorigin="anonymous"></script>
<script src="${root}js/bstable.js"></script>
<script>
    var example1 = new BSTable("table1", {
        $addButton: $('#addRow'),
        advanced: {
            columnLabel: ''
        }
    });
    example1.init();
    var example2 = new BSTable("table2", {
        $addButton: $('#addRow1'),
        advanced: {
            columnLabel: ''
        }
    });
    example2.init();
    var example3 = new BSTable("table3", {
        $addButton: $('#addRow2'),
        advanced: {
            columnLabel: ''
        }
    });
    example3.init();
    var example4 = new BSTable("table4", {
        $addButton: $('#addRow3'),
        advanced: {
            columnLabel: ''
        }
    });
    example4.init();
    var example5 = new BSTable("table5", {
        $addButton: $('#addRow4'),
        advanced: {
            columnLabel: ''
        }
    });
    example5.init();
    var example6 = new BSTable("table6", {
        $addButton: $('#addRow5'),
        advanced: {
            columnLabel: ''
        }
    });
    example6.init();
    var example7 = new BSTable("table7", {
        $addButton: $('#addRow6'),
        advanced: {
            columnLabel: ''
        }
    });
    example7.init();
    var example8 = new BSTable("table8", {
        $addButton: $('#addRow7'),
        advanced: {
            columnLabel: ''
        }
    });
    example8.init();
</script>
<script src="${root}js/BackToTop.js"></script>
<script src="${root}js/tabs.js"></script>
<!--<script src="${root}js/tabs-table.js"></script>-->
</html>
