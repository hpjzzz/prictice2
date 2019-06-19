<%--
  Created by IntelliJ IDEA.
  User: shiki
  Date: 2019/6/8
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
    <script type="text/javascript" src="/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/easyui/jquery.serializejson.js"></script>
    <script type="text/javascript" src="/js/model/order.js"></script>
</head>
<body>
<div id="tb" style="padding:3px">
    <span>单号:</span>
    <input id="orderNum" style="line-height:26px;border:1px solid #ccc">
    <span>货主编码:</span>
    <input id="consignorNum" style="line-height:26px;border:1px solid #ccc">
    <span>供应商编码:</span>
    <input id="providerNum" style="line-height:26px;border:1px solid #ccc">
    <span>采购提交时间:</span>
    <input id="gmtCreat" type="date" style="line-height:26px;border:1px solid #ccc">
    <span>预计到货时间:</span>
    <input id="deliveryDate" type="date" style="line-height:26px;border:1px solid #ccc">
    <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
</div>
<table id="tt" class="easyui-datagrid" style="width:1200px;height:250px" toolbar="#tb"
       title="Load Data" iconCls="icon-save"
       rownumbers="true" pagination="true">
</table>
</body>
</html>
