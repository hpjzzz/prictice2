,
{
    field: 'productName', title: '商品名称', width: 180,
    editor: {
    type: "validatebox",
        options: {
        required: false,
            readonly: false
    },
    formatter:function (value,row) {
        if(row){
            return row.product.productNum;
        }
    }
}
},
{
    field: 'productPrice', title: '价格', width: 100,
    editor: {
    type: "validatebox",
        options: {
        required: false,
            readonly: true
    },
    formatter: function (value, row) {
        if (row && row.productPrice) {
            return row.productPrice;
        }
    }
}
},
{
    field: 'totalNum', title: '采购数量', width: 100,
    editor: {
    type: "numberbox",
        options: {
        required: true
    }
}
},
{
    field: 'totalPrice', title: '总金额', width: 100,
    editor: {
    type: "text"
}
}