<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><dec:title default="Admin Page" /></title>
    <link rel="stylesheet" href="<c:url value='/template/admin/css/bootstrap.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/admin/css/ace.min.css' />" class="ace-main-stylesheet" id="main-ace-style" />
    <script src="<c:url value='/template/admin/js/ace-extra.min.js' />"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="/code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="<c:url value='/template/admin/js/jquery.2.1.1.min.js' />"></script>
    <script type="text/javascript" src="<c:url value="/template/admin/js/global_admin_script.js"/>"></script>
    <script src="<c:url value='/template/admin/js/jquery.validate.min.js' />"></script>
    <%--ckeditor plugin--%>
    <%--<script type="text/javascript" src="<c:url value="/ckeditor/ckeditor.js"/>"></script>--%>
    <%--sweetalert--%>
    <%--<script type='text/javascript' src='<c:url value="/template/admin/sweetalert/sweetalert2.min.js"/>'></script>--%>
    <%--<link rel="stylesheet" href="<c:url value="/template/admin/sweetalert/sweetalert2.min.css"/>">--%>

    <%--datatable--%>
    <%--<link href="<c:url value="/template/data-table/media/css/dataTables.bootstrap4_v4.6.1.min.css"/>" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/template/data-table/data_table-1.0.0.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/template/data-table/data-table-bootstrap4-1.0.0.js"/>"></script>--%>
    <%--ckfinder--%>
    <%--<script type="text/javascript" src="<c:url value="/ckfinder/ckfinder.js"/>"></script>--%>
    <dec:head />
</head>
<body class="login-layout">
    <div class="main-container">
        <div class="main-content">
            <div class="row">
                <div class="col-sm-10 col-sm-offset-1">
                    <div class="login-container">
                        <%@ include file="/common/login/header.jsp" %>
                        <div class="position-relative">
                            <dec:body/>
                        </div>
                        <div class="navbar-fixed-top align-right">
                            <br />
                            &nbsp;
                            <a id="btn-login-dark" href="#">Dark</a>
                            &nbsp;
                            <span class="blue">/</span>
                            &nbsp;
                            <a id="btn-login-blur" href="#">Blur</a>
                            &nbsp;
                            <span class="blue">/</span>
                            &nbsp;
                            <a id="btn-login-light" href="#">Light</a>
                            &nbsp; &nbsp; &nbsp;
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="<c:url value='/template/admin/js/bootstrap.min.js' />"></script>
    <script src="<c:url value='/template/admin/js/jquery-ui.custom.min.js' />"></script>
    <script src="<c:url value='/template/admin/js/jquery.ui.touch-punch.min.js' />"></script>
    <script src="<c:url value='/template/admin/js/jquery.easypiechart.min.js' />"></script>
    <script src="<c:url value='/template/admin/js/jquery.sparkline.min.js' />"></script>
    <script src="<c:url value='/template/admin/js/jquery.flot.min.js' />"></script>
    <script src="<c:url value='/template/admin/js/jquery.flot.pie.min.js' />"></script>
    <script src="<c:url value='/template/admin/js/jquery.flot.resize.min.js' />"></script>
    <script src="<c:url value='/template/admin/js/ace-elements.min.js' />"></script>
    <script src="<c:url value='/template/admin/js/ace.min.js' />"></script>
    <script src="<c:url value='/template/admin/js/bootstrap.min.js'/>"></script>

    <!-- page specific plugin scripts -->
    <script src="<c:url value='/template/admin/js/jquery-ui.min.js'/>"></script>

    <script type="text/javascript">
        function showAlertBeforeDelete(callback) {
            swal({
                title: "Xác nhận xóa",
                text: "Bạn có chắc chắn xóa những dòng đã chọn",
                type: "warning",
                showCancelButton: true,
                confirmButtonText: "Xác nhận",
                cancelButtonText: "Hủy bỏ",
                confirmButtonClass: "btn btn-success",
                cancelButtonClass: "btn btn-danger"
            }).then(function (isConfirm) {
                if (isConfirm) {
                    callback();
                }
            });
        }
    </script>
    <%--setting color bacgroud--%>
    <script type="text/javascript">
        //you don't need this, just used for changing background
        jQuery(function($) {
            $('#btn-login-dark').on('click', function(e) {
                $('body').attr('class', 'login-layout');
                $('#id-text2').attr('class', 'white');
                $('#id-company-text').attr('class', 'blue');

                e.preventDefault();
            });
            $('#btn-login-light').on('click', function(e) {
                $('body').attr('class', 'login-layout light-login');
                $('#id-text2').attr('class', 'grey');
                $('#id-company-text').attr('class', 'blue');
                e.preventDefault();
            });
            $('#btn-login-blur').on('click', function(e) {
                $('body').attr('class', 'login-layout blur-login');
                $('#id-text2').attr('class', 'white');
                $('#id-company-text').attr('class', 'light-blue');

                e.preventDefault();
            });

        });
    </script>
</body>
</html>
