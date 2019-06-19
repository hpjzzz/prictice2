<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/jsp/head.jsp" %>
    <script type="text/javascript" src="/js/model/product.js"></script>
</head>
<body>
<div id="tb" style="padding:3px">
    <span>商品编码:</span>
    <input id="productNum" style="line-height:26px;border:1px solid #ccc">
    <span>商品名称:</span>
    <input id="productName" style="line-height:26px;border:1px solid #ccc">
    <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
</div>
<table id="tt" class="easyui-datagrid" style="width:600px;height:250px"
       url="/product/search" toolbar="#tb"
       title="Load Data" iconCls="icon-save"
       rownumbers="true" pagination="true">
    <thead>
    <tr>
        <th field="id" width="80">商品id</th>
        <th field="productNum" width="80">商品编码</th>
        <th field="productName" width="80" align="right">商品名称</th>
        <th field="productPrice" width="80" align="right">价格</th>
        <th field="gmtCreat" width="150">导入时间</th>
    </tr>
    </thead>
</table>
</body>
</html>
