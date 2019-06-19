<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/jsp/head.jsp" %>
    <script type="text/javascript" src="/js/model/fileupload.js"></script>
</head>
<body>
<form action="/" method="post">
<table id="tt" class="easyui-datagrid" style="width:600px;height:250px"
       title="Load Data" iconCls="icon-save"
       rownumbers="true" pagination="true">
</table>
    <input id="sub" type="submit" value="提交">
</form>
</body>
</html>
