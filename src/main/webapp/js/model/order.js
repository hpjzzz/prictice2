function doSearch() {
    $('#tt').datagrid('load',{
        orderNum:$('#orderNum').val(),
        consignorNum:$('#consignorNum').val(),
        providerNum:$('#providerNum').val(),
        gmtCreat:$('#gmtCreat').val(),
        deliveryDate:$('#deliveryDate').val(),
    });
};
$(function () {
    $('#tt').datagrid({
        columns: [[
            {field: 'id', title: 'id', width: 100},
            {field: 'orderNum', title: '采购单号', width: 100},
            {field: 'consignorNum', title: '货主编号', width: 100},
            {field: 'consignorName', title: '货主名字', width: 100},
            {field: 'providerNum', title: '供应商编号', width: 100},
            {field: 'providerName', title: '供应商名字', width: 100},
            {field: 'totalNum', title: '总数', width: 100, editor: 'numberbox'},
            {field: 'totalPrice', title: '总价', width: 100},
            {field: 'gmtCreat', title: '提交时间', width: 100},
            {field: 'deliveryDate', title: '预计到货日期', width: 100,}
        ]],
        url: '/order/search',
        singleSelect: true
    });
});