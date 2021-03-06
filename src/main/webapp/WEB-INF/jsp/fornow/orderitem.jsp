<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Easyui扩展库 Datagrid - 落阳 整理</title>
    <link href="http://www.easyui-extlib.com/Content/Site.css" rel="stylesheet" />
    <script src="http://www.easyui-extlib.com/Scripts/jquery/jquery-1.11.0.min.js"></script>
    <script src="http://www.easyui-extlib.com/Scripts/jquery-extensions/jquery.jdirk.js"></script>
    <link href="http://www.easyui-extlib.com/Scripts/jquery-easyui/jquery-easyui-1.4.3/themes/default/easyui.css" rel="stylesheet" />
    <link href="http://www.easyui-extlib.com/Scripts/jquery-easyui/jquery-easyui-1.4.3/themes/icon.css" rel="stylesheet" />
    <script src="http://www.easyui-extlib.com/Scripts/jquery-easyui/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
    <script src="http://www.easyui-extlib.com/Scripts/jquery-easyui/jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js"></script>

    <link href="http://www.easyui-extlib.com//Scripts/jquery-easyui-extensions/validatebox/jeasyui.extensions.validatebox.css" rel="stylesheet" />
    <script src="http://www.easyui-extlib.com//Scripts/jquery-easyui-extensions/validatebox/jeasyui.extensions.validatebox.js"></script>
    <script src="http://www.easyui-extlib.com//Scripts/jquery-easyui-extensions/datagrid/jeasyui.extensions.datagrid.getColumnInfo.js"></script>
    <script src="http://www.easyui-extlib.com//Scripts/jquery-easyui-extensions/datagrid/jeasyui.extensions.datagrid.editors.js"></script>
    <script src="http://www.easyui-extlib.com//Scripts/jquery-easyui-extensions/datagrid/jeasyui.extensions.datagrid.edit.cellEdit.js"></script>
    <script src="/js/model/orderitem.js"></script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',border:false" style="height:40px;overflow:hidden;">
        <div class="datagrid-toolbar" style="height:100%;padding:7px;">
            <a id="btnInsert" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增一行</a>
            <a id="btnSave" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">保存数据行(不交互后台)</a>
        </div>
    </div>
    <div data-options="region:'center',border:false">
        <div class="easyui-layout" data-options="fit:true">
            <div data-options="region:'north',border:false" style="height:100px;overflow:hidden;">
                <div style="font-size:22px;font-weight:bolder;width:100%;text-align:center;">
                    本demo演示datagrid中的单元格编辑的功能
                    <br />
                    新增一行后请双击某单元格
                    <br />
                    已开启双击数据行触发编辑效果的功能
                </div>
            </div>
            <div data-options="region:'center',border:false" style="border-top-width:1px;">
                <table id="dg1"></table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
