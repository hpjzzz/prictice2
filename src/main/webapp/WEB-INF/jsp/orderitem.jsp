<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%@include file="/WEB-INF/jsp/head.jsp" %>
    <!-- 编辑框支持 -->
    <script src="/easyui/plugin/cellEdit/jeasyui.extensions.datagrid.getColumnInfo.js"></script>
    <script src="/easyui/plugin/cellEdit/jeasyui.extensions.datagrid.editors.js"></script>
    <script src="/easyui/plugin/cellEdit/jeasyui.extensions.datagrid.edit.cellEdit.js"></script>
    <script src="/js/model/orderitem.js"></script>
</head>
<body>
<table id="purchasebillGrid" class="easyui-datagrid" data-options="fit:true,fixed:true,fitColumns:true,toolbar:'#tb',singleSelect:true "
       url="/purchasebill/page"
       iconCls="icon-save"
       enableHeaderClickMenu="true"
       rownumbers="true" pagination="true"
>
    <thead>
    <tr>
        <th width="20"  field="vdate" sortable="true">交易时间</th>
        <th width="20"  field="totalamount" sortable="true">总金额</th>
        <th width="20"  field="totalnum" sortable="true">总数量</th>
        <%--<th width="20"  field="inputtime" sortable="true">录入时间</th>--%>
        <th width="20"  field="auditortime" sortable="true">审核时间</th>
        <th width="20"  field="status" data-options="formatter:formaterStatus" sortable="true">状态</th>
        <th width="20"  field="supplier" sortable="true" data-options="formatter:formaterSupplier">供货商</th>
        <th width="20"  field="auditor" sortable="true" data-options="formatter:formaterObj">审核人</th>
        <th width="20"  field="inputUser" sortable="true" data-options="formatter:formaterObj">录入人</th>
        <th width="20"  field="buyer" sortable="true" data-options="formatter:formaterObj">采购人</th>
    </tr>
    </thead>
</table>
<div id="cc" class="easyui-calendar"></div>
<div id="tb" style="padding:5px;height:auto">
    <!-- 这部分是加上增删改的按键:现在没有功能，我们先不管它 -->
    <div style="margin-bottom:5px">
        <a href="#"  data-method="add" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="#"  data-method="edit" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="#"  data-method="del" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
    <!-- 这部门是查询的功能 -->
    <div>
        <form id="searchForm" action="/purchasebill/download" method="post">
            <!-- 按照时间查询 范围查询 开始时间 结束时间 选择时间-->
            日期: <input  name="beginTime"  type="text" class="easyui-datebox" sharedCalendar="#cc"> </input>-
            <input  name="endTime"  type="text" class="easyui-datebox" > </input>
            状态:<select name="status" class="easyui-combobox" data-options="panelHeight:'auto'"  style="width:100px;">
            <option value="">--请选择--</option>
            <option value="0">待审</option>
            <option value="1">已审</option>
            <option value="-1">作废</option>
        </select>

            <a data-method="search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
        </form>
    </div>
</div>

<!-- 弹出相应的功能框 -->
<div id="purchasebillDialog" class="easyui-dialog" title="数据操作" data-options="closed:true,modal:true"  style="width:800px;padding:10px">
    <form id="purchasebillForm" method="post">
        <input id="purchasebillId" type="hidden" name="id">
        <table cellpadding="5">
            <tr>
                <td>交易时间:</td>
                <td><input class="easyui-datebox" type="text" name="vdate"></input></td>
            </tr>
            <tr>
                <td>供应商:</td>
                <td><input  class="easyui-combobox" name="supplier.id"
                            data-options="valueField:'id',textField:'name',panelHeight:'auto',url:'/util/findSupplier'"></td>
            </tr>
            <tr>
                <td>采购员:</td>
                <td><input  class="easyui-combobox" name="buyer.id"
                            data-options="valueField:'id',textField:'username',panelHeight:'auto',url:'/util/getBuyer'"></td>
            </tr>

        </table>
        <!-- 采购子单 -->
        <table id="gridItems" title="编辑明细" style="width:100%;height:300px"></table>
        <!-- 采购单明细的按钮准备 -->
        <div id="itemBtns">
            <a href="javascript:;" id="btnInsert" class="easyui-linkbutton"
               data-options="iconCls:'icon-add',plain:true">添加</a>
            <a href="javascript:;" id="btnRemove" class="easyui-linkbutton"
               data-options="iconCls:'icon-remove',plain:true">删除</a>
        </div>
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" data-method="save">提交</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#purchasebillDialog').dialog('close')">取消</a>
        </div>
    </form>
</div>


<div id="gridMenu" class="easyui-menu" style="width:120px;">
    <div data-options="iconCls:'icon-add'"  data-method="add" >添加</div>
    <div data-options="iconCls:'icon-edit'"  data-method="edit">修改</div>
    <div data-options="iconCls:'icon-remove'" data-method="del">删除</div>
</div>


</body>
</html>
