<%--
  Created by IntelliJ IDEA.
  User: Thinh PC
  Date: 12/21/2021
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Metaverse Laptop</title>
    <link href="../image/logo-re.png" rel="icon">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../fonts/themify-icons/themify-icons.css" rel="stylesheet">
    <link href="../fonts/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link crossorigin="anonymous" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
          integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
          referrerpolicy="no-referrer" rel="stylesheet"/>
    <!--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.min.css" integrity="sha512-17EgCFERpgZKcm0j0fEq1YCJuyAWdz9KUtv1EjVuaOz8pDnh/0nZxmU6BBXwaaxqoi9PQXnRWqlcDB027hgv9A==" crossorigin="anonymous" referrerpolicy="no-referrer" />-->
    <link crossorigin="anonymous" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css"
          integrity="sha512-yHknP1/AwR+yx26cB1y0cjvQUMvEa2PFzt1c9LlS4pRQ5NOTZFWbhBig+X9G9eYW/8m0/4OXNx8pxJ6z57x0dw=="
          referrerpolicy="no-referrer" rel="stylesheet"/>
    <link href="../css/responsiveIndex.css" rel="stylesheet">
</head>
<body>
<div id="main">
    <%@include file="../layout/header.jsp"%>
    <%@include file="../layout/cart-hover.jsp"%>
    <div id="content1">
        <div class="title-pro-all">
            <div class="logo-lap" style="background-image: url('../image/logo-laptop/msi.png')"></div>
            <!--        <h1 class="title-all-product-item">MSI</h1>-->
            <span>TRUE GAMING. SOME ARE PC, WE ARE GAMING</span>
        </div>
        <div class="filter-product">
            <div class="title-filter-product">
                <div style="border-left: 3px solid #111111;padding-left: 8px">Bộ lọc</div>
            </div>
            <div class="filter">
                <div class="title-filter">
                    Thương hiệu
                </div>
                <div class="filter-items">
                    <div class="filter-item">DELL
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">MSI
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">LENOVO
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">ACER
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">ASUS
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">HP
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                </div>
            </div>
            <div class="filter">
                <div class="title-filter">
                    Màu sắc
                </div>
                <div class="filter-items">
                    <div class="filter-item">Đen
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">Xám
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">Bạc
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">Vàng hồng
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                </div>
            </div>
            <div class="filter">
                <div class="title-filter">
                    Series CPU
                </div>
                <div class="filter-items">
                    <div class="filter-item">Core i5
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">Core i7
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">Ryzen 7
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">Core i3
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">Ryzen 5
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">Ryzen 9
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">Core i9
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>

                </div>
            </div>
            <div class="filter">
                <div class="title-filter">
                    Dung lượng RAM
                </div>
                <div class="filter-items">
                    <div class="filter-item">4GB
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">8GB
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">16GB
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">32GB
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                </div>
            </div>
            <div class="filter">
                <div class="title-filter">
                    Series CPU
                </div>
                <div class="filter-items">
                    <div class="filter-item">Vostro
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">Latitude
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">Inspiron
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                    <div class="filter-item">Gaming
                        <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                    </div>
                </div>
            </div>

        </div>
        <div class="filter-another">
            <div class="title-filter">
                Sắp xếp theo
            </div>
            <div class="filter-items">
                <div class="filter-item-another">Bán chạy
                    <div class="tick tick-another"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                </div>
                <div class="filter-item-another">Giá giảm dần
                    <div class="tick tick-another"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                </div>
                <div class="filter-item-another">Giá tăng dần
                    <div class="tick tick-another"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                </div>
                <div class="price-filter">
                    <div class="filter-item-another" style="cursor: auto">
                        <input class="input-filter-product" placeholder="Giá thấp nhất">
                    </div>
                    <span style="line-height: 2; text-align: center">-</span>
                    <div class="filter-item-another" style="cursor: auto">
                        <input class="input-filter-product" placeholder="Giá cao nhất">
                    </div>
                </div>
                <button class="btn-search-filter">Tìm</button>

            </div>
        </div>
        <div class="cover-all-product">
            <div class="all-product-cover">
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>
                <div class="hover-all-product">
                    <a class="all-product-item" href="product-page.jsp">
                        <div class="status-sale">-11%</div>
                        <div class="img-all-product-item"
                             style="background-image: url(../image/all-product/unnamed.jpg)">
                            <!--                        <img src="../image/all-product/unnamed.jpg" style="visibility: hidden;" />-->
                        </div>
                        <div class="status">HẾT HÀNG</div>
                        <div class="infor-all-product-item">
                            Laptop MSI Prestige 15 A10SC-222VN (15" FHD/i7-10710U/16GB/512GB SSD/GTX 1650/Win10/1.6 kg)
                        </div>
                        <div class="price-all-product-item">
                            30.390.000đ
                        </div>
                        <div class="sale-all-product-item">
                            <span class="origin-price">33.999.000đ</span> <span>11%</span>
                        </div>
                    </a>
                </div>

            </div>
        </div>
        <div class="dots-slick"></div>
    </div>
    <%@include file="../layout/footer.jsp"%>
</div>
<%@include file="../layout/login.jsp"%>
<%@include file="../layout/fogot.jsp"%>
<%@include file="../layout/register.jsp"%>
<!--Back to top-->
<%@include file="../layout/back-to-top.jsp"%>
</body>
<script src="../js/register.js"></script>
<script src="../js/register.js"></script>
<script crossorigin="anonymous" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script crossorigin="anonymous"
        integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
        referrerpolicy="no-referrer"
        src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
<script src="../js/nav-responsive.js"></script>
<script src="../js/BackToTop.js"></script>
<script src="../js/Scroll-Indicator.js"></script>
<script src="../js/visibleCart.js"></script>
<script src="../js/slick-all-product.js"></script>
<script src="../js/click-filter.js"></script>
</html>
