$(function () {
    $('#grid').datagrid({
        columns: [[
            {field: 'id', title: 'id', width: 100},
            {field: 'productNum', title: '商品编码', width: 100},
            {field: 'productName', title: '商品名称', width: 100},
            {field: 'productPrice', title: '价格', width: 100,editor:'numberbox'},
            {field: 'gmtCreat', title: '导入时间', width: 100}
        ]],
        singleSelect: true,
        rownumbers:true,
        toolbar: [{
            text:'新增',
            iconCls: 'icon-add',
            handler: function () {
                //增加一行
                $('#grid').datagrid('appendRow',{productNum:0,productPrice:0});
                var rows = $('#grid').datagrid('getRows');
                //开启最后一行的编辑,必须先在每列添加一个编辑器
                $('#grid').datagrid('beginEdit',rows.length-1);
            }
        }, '-', {
            text:'提交',
            iconCls: 'icon-save',
            handler: function () {

            }
        }]

    })
});