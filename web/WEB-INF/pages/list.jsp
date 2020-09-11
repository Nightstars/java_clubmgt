<%--
  Created by IntelliJ IDEA.
  User: Chris
  Date: 10/9/2019
  Time: 5:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery_3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/my.js"></script>
    <title>俱乐部管理</title>
    <style>
        .center{
            text-align: center;
        }
        label {
            display: inline-block;
            width: 100px;
            text-align: right;
        }
        input,textarea{
            vertical-align: center;
            width: 500px;
        }
    </style>
</head>
<body onload="editClub()">
    <div style="width: 90%;text-align: left;margin: 12px auto 0;">
        <button class="btn btn-success" id="addClubBtn" style="width: 7%">新增</button>
        <table class="table table-striped table-hover" align="center" style="text-align: center">
            <thead>
            <tr>
                <td><b>俱乐部名称</b></td>
                <td><b>俱乐部负责人</b></td>
                <td><b>俱乐部类型</b></td>
                <td><b>创建时间</b></td>
                <td><b>活动次数</b></td>
                <td><b>会员数</b></td>
                <td><b>操作</b></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${clubList}" var="club">
                <tr>
                    <td>${club.name}</td>
                    <td>${club.manager}</td>
                    <td>${club.type}</td>
                    <td><fmt:formatDate value="${club.createTime}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
                    <td>${club.activityNum}</td>
                    <td>${club.members}</td>
                    <td>
                        <a href="toEditClub?id=${club.id}" >修改</a>
                        <a onclick="return window.confirm('这条记录将被删除且不可恢复，确认删除吗？')" href="deleteClub?id=${club.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <input type="hidden" value="${isEdit}" id="isEdit">
    <input type="hidden" value="${id}" id="editId">
    <input type="hidden" value="${result.result}" id="deleteResult">
    <div class="modal fade" id="loginModalId" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true" id="hiddenWindow">
                        ×
                    </button>
                    <h4 class="modal-title" id="myModalLabel">新增</h4>
                </div>
                <div class="modal-body">
                    <div class="form-inline" style="width: 100%;text-align: center;margin-top: 10px;">
                        <label for="name">俱乐部名称：<span id="nameSpan" style="color: red;font-weight: bold">*</span></label>
                        <input type="text" class="form-control" id="name" style="width: 65%;">
                    </div>
                    <div class="form-inline" style="width: 100%;text-align: center;margin-top: 10px;">
                        <label for="manager">负责人：<span id="managerSpan" style="color: red;font-weight: bold">*</span></label>
                        <input type="text" class="form-control" id="manager" style="width: 65%;">
                    </div>
                    <div class="form-inline" style="width: 100%;text-align: center;margin-top: 10px;">
                        <label for="createTime">创建时间：<span id="createTimeSpan" style="color: red;font-weight: bold">*</span></label>
                        <input type="date" class="form-control" id="createTime" style="width: 65%;">
                    </div>
                    <div class="form-inline" style="width: 100%;text-align: center;margin-top: 10px;">
                        <label for="type">俱乐部类型：<span id="typeSpan" style="color: red;font-weight: bold">*</span></label>
                        <select class="form-control" id="type" style="width: 65%;">
                        </select>
                    </div>
                    <div class="form-inline" style="width: 100%;text-align: center;margin-top: 10px;">
                        <label for="activityNum">活动次数：<span id="activityNumSpan" style="color: red;font-weight: bold">*</span></label>
                        <input type="text" class="form-control" id="activityNum" style="width: 65%;">
                    </div>
                    <div class="form-inline" style="width: 100%;text-align: center;margin-top: 10px;">
                        <label for="members">会员数量：<span id="membersSpan" style="color: red;font-weight: bold">*</span></label>
                        <input type="text" class="form-control" id="members" style="width: 65%;">
                    </div>
                    <div class="form-inline" style="width: 100%;text-align: center;margin-top: 10px;">
                        <label for="remark">备注：</label>
                        <textarea type="text" class="form-control" id="remark" style="width: 65%;" rows="3"></textarea>
                    </div>
                </div>
                <div class="modal-footer" style="text-align: center">
                    <button type="button" class="btn btn-default" data-dismiss="modal" id="cancelSave">取消</button>
                    <button type="button" class="btn btn-primary" id="saveModalYesId">保存</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
