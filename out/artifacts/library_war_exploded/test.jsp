<%--
  Created by IntelliJ IDEA.
  User: chens
  Date: 2022/9/27
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<div>
    <button id="select">查询</button>
    <div id="adddata">
        <label for="">书名：</label><input type="text" id="bookName"/>
        <label for="">作者：</label
        ><input type="text" id="author"/> <label for="">价格：</label
    ><input type="text" id="price"/><label for="">出版日期：</label
    ><input type="text" id="publicationDate"/>
        <button id="add">添加</button>
    </div>
</div>
<table width="70%">
    <thead>
    <tr>
        <td>书名</td>
        <td>作者</td>
        <td>价格</td>
        <td>出版日期</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody id="tbd"></tbody>
</table>
</body>
</html>
