<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav id="sidebarMenu" class="sidebar d-md-block bg-primary text-white collapse" data-simplebar>
    <div class="sidebar-inner px-4 pt-3">
        <div class="user-card d-flex d-md-none align-items-center justify-content-between justify-content-md-center pb-4">
            <div class="d-flex align-items-center">
                <div class="d-block">
                    <h2 class="h6">Hi, UserName</h2>
                    <a href="#" class="btn btn-secondary text-dark btn-xs"><span class="mr-2"><span
                            class="fas fa-sign-out-alt"></span></span>Sign Out</a>
                </div>
            </div>
            <div class="collapse-close d-md-none">
                <a href="#sidebarMenu" class="fas fa-times" data-toggle="collapse"
                   data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="true"
                   aria-label="Toggle navigation"></a>
            </div>
        </div>
        <ul class="nav flex-column">
            <li class="nav-item  active ">
                <a href="" class="nav-link">
                    <span class="sidebar-icon"><span class="fas fa-home"></span></span>
                    <span>Trang Chủ</span>
                </a>
            </li>
            <li class="nav-item">
                                <span class="nav-link  collapsed  d-flex justify-content-between align-items-center"
                                      data-toggle="collapse" data-target="#submenu-app">
                                    <span>
                                        <span class="sidebar-icon"><span class="fas fa-truck"></span></span>
                                        Đơn Hàng
                                    </span>
                                    <span class="link-arrow"><span class="fas fa-chevron-right"></span></span>
                                </span>
                <div class="multi-level collapse " role="list" id="submenu-app" aria-expanded="false">
                    <ul class="flex-column nav">
                        <li class="nav-item ">
                            <a class="nav-link" href="#">
                                                <span>
                                                    <span class="sidebar-icon"><span
                                                            class="fas fa-truck-loading"></span></span>
                                                    Đơn Đặt
                                                </span>
                            </a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="#">
                                                <span>
                                                    <span class="sidebar-icon"><span
                                                            class="fas fa-shipping-fast"></span></span>
                                                    Đang Giao
                                                </span>
                            </a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="#">
                                                <span>
                                                    <span class="sidebar-icon"><span class="fas fa-check-square"></span></span>
                                                    Hoàn Thành
                                                </span>
                            </a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="nav-item ">
                <a href="#" class="nav-link">
                    <span class="sidebar-icon"><span class="fas fa-warehouse"></span></span>
                    <span>Kho</span>
                </a>
            </li>
            <li class="nav-item ">
                <a href="#" class="nav-link">
                    <span class="sidebar-icon"><span class="fas fa-life-ring"></span></span>
                    <span>Phản Hồi</span>
                </a>
            </li>
            <li class="nav-item">
                                <span class="nav-link  collapsed  d-flex justify-content-between align-items-center"
                                      data-toggle="collapse" data-target="#submenu-pages">
                                    <span>
                                        <span class="sidebar-icon"><span class="fas fa-database"></span></span>
                                        Dữ Liệu Hệ Thống
                                    </span>
                                    <span class="link-arrow"><span class="fas fa-chevron-right"></span></span>
                                </span>
                <div class="multi-level collapse " role="list" id="submenu-pages" aria-expanded="false">
                    <ul class="flex-column nav">
                        <li class="nav-item ">
                                            <span class="nav-link  collapsed  d-flex justify-content-between align-items-center"
                                                  data-toggle="collapse" data-target="#submenu-data">
                                                <span>
                                                    <span class="sidebar-icon"><span class="fas fa-user"></span></span>
                                                    Người Dùng
                                                </span>
                                                <span class="link-arrow"><span
                                                        class="fas fa-chevron-right"></span></span>
                                            </span>
                            <div class="multi-level collapse " role="list" id="submenu-data" aria-expanded="false">
                                <ul class="flex-column nav">
                                    <li class="nav-item "><a class="nav-link" href="<c:url value='/admin-useradmin'/>"><span>Quản Trị Viên</span></a>
                                    </li>
                                    <li class="nav-item "><a class="nav-link" href="<c:url value='/admin-user' />"><span>Thành Viên</span></a></li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="<c:url value='/admin-productcategory?type=list' />">
                                                <span>
                                                    <span class="sidebar-icon"><span class="fas fa-list"></span></span>
                                                    Danh Mục Sản Phẩm
                                                </span>
                            </a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="<c:url value='/admin-product?page=1&items=3' />">
                                                <span>
                                                    <span class="sidebar-icon"><span
                                                            class="fas fa-dolly-flatbed"></span></span>
                                                    Sản Phẩm
                                                </span>
                            </a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="<c:url value='/admin-newcategory?page=1&items=10' />">
                                                <span>
                                                    <span class="sidebar-icon"><span
                                                            class="fas fa-clipboard-list"></span></span>
                                                    Danh Mục Tin Tức
                                                </span>
                            </a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="<c:url value='/admin-new?page=1&items=3' />" >
                                                <span>
                                                    <span class="sidebar-icon"><span
                                                            class="fas fa-newspaper"></span></span>
                                                    Tin Tức
                                                </span>
                            </a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="nav-item">
                                <span class="nav-link  collapsed  d-flex justify-content-between align-items-center"
                                      data-toggle="collapse" data-target="#submenu-components">
                                    <span>
                                        <span class="sidebar-icon"><span class="fas fa-edit"></span></span>
                                        Tùy Chỉnh Giao Diện
                                    </span>
                                    <span class="link-arrow"><span class="fas fa-chevron-right"></span></span>
                                </span>
                <div class="multi-level collapse " role="list" id="submenu-components" aria-expanded="false">
                    <ul class="flex-column nav">
                        <li class="nav-item ">
                            <a class="nav-link" href="#">
                                                <span>
                                                    <span class="sidebar-icon"><span class="fas fa-bars"></span></span>
                                                    Menu Chính
                                                </span>
                            </a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="#">
                                                <span>
                                                    <span class="sidebar-icon"><span
                                                            class="fas fa-chart-bar"></span></span>
                                                    Menu Phụ
                                                </span>
                            </a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="#">
                                                <span>
                                                    <span class="sidebar-icon"><span
                                                            class="fas fa-sliders-h"></span></span>
                                                    Slide
                                                </span>
                            </a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="#">
                                                <span>
                                                    <span class="sidebar-icon"><span class="fas fa-phone"></span></span>
                                                    Liên Hệ
                                                </span>
                            </a>
                        </li>
                    </ul>
                </div>
            </li>
            <li role="separator" class="dropdown-divider mt-4 mb-3 border-black"></li>
        </ul>
    </div>
</nav>