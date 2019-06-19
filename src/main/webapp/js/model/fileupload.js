$(function () {
    $('#tt').datagrid({
        columns: [[
            {field: 'productNum', title: '采购单号', width: 100},
            {field: 'productName', title: '货主编号', width: 100},
            {field: 'productPrice', title: '货主名字', width: 100},
        ]],
        url: '/file/getFile',
        singleSelect: true
    });
});