function doSearch() {
    $('#tt').datagrid('load',{
        productNum:$('#productNum').val(),
        productName:$('#productName').val()
    });
}