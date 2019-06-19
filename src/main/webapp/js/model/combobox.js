$(function () {
    $('#combobox1').combobox({
        url:'/order/getAll',
        valueField:'providerName',
        textField:'providerName'
    });
})