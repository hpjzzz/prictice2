<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
    <script type="text/javascript" src="/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/easyui/jquery.serializejson.js"></script>
    <script type="text/javascript" src="/js/model/product2.js"></script>
</head>
<body>
<form id="ff" method="post">
    <table id="grid"></table>
    <input type="submit" value="Submit"></input>
</form>

<div style="padding:3px 2px;border-bottom:1px solid #ccc">Ajax Form</div>
<form id="ff2" method="post">
    <table>
        <tr>
            <td>id:</td>
            <td><input name="id" type="text"></input></td>
        </tr>
        <tr>
            <td>num:</td>
            <td><input name="productNum" type="text"></input></td>
        </tr>
        <tr>
            <td>name:</td>
            <td><input name="productName" type="text"></input></td>
        </tr>
        <tr>
            <td>price</td>
            <td><input name="productPrice" type="text"></input></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"></input></td>
        </tr>
    </table>
</form>
</body>
</html>
