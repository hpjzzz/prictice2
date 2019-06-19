//数据转换
function formaterStatus(data){
    // 0  待审 1 已审 -1作废
    var obj = {
        0:"<div style='color:red'>待审</div>",
        1:"<div style='color:green'>已审</div>",
        '-1':"<div><s>作废</s></div>"
    }

    return obj[data];

}

function formaterObj(data){
    if(data){
        return data.username;
    }
}
//供货商
function formaterSupplier(data){
    if(data){
        return data.name;
    }
}


$(function () {

    //这里我们把很多会常用到的元素进行一个抽取
    var searchForm = $("#searchForm");
    var purchasebillGrid = $("#purchasebillGrid");
    var purchasebillDialog = $("#purchasebillDialog");
    var purchasebillForm = $("#purchasebillForm");

    //只要a标签中有data-method属性，咱们就给它添加事件
    //  执行对应的itsource中的事件
    $("*[data-method]").on("click",function () {
        itsource[$(this).data("method")]();
    })

    window.itsource={
        search:function () {
            //需要先引入 jquery.jdirk.js 才可以使用这个方法
            var params = searchForm.serializeObject();
            //purchasebill/page
            console.debug(params);
            purchasebillGrid.datagrid('load',params);
        },
        add:function () {
            //隐藏有data-save属性的元素
            $("*[data-save]").show();
            //禁用有data-save属性的input元素的验证功能
            $("*[data-save] input").validatebox("enableValidation");
            //弹出表单窗口
            purchasebillForm.form("clear");//清除数据
            //清空明细表格
            $("#gridItems").datagrid("loadData", []);
            purchasebillDialog.dialog("center").dialog("open");
        },
        edit:function () {
            //弹出表单窗口
            //选中了某一条数据才删除
            var row = purchasebillGrid.datagrid("getSelected");
            if(row) {
                //隐藏有data-save属性的元素
                $("*[data-save]").hide();
                //禁用有data-save属性的input元素的验证功能
                $("*[data-save] input").validatebox("disableValidation");

                purchasebillForm.form("clear");//清除数据

                //回显购货商和采购员
                if(row.buyer){
                    row["buyer.id"] = row.buyer.id;
                }

                if(row.supplier){
                    row["supplier.id"] = row.supplier.id;
                }

                //回显明细表格
                purchasebillDialog.dialog("center").dialog("open");
                //取到明细数据 拷贝一个副本
                var items = $.extend([], row.items);
                $("#gridItems").datagrid("loadData", items);



                //为form加载数据
                $("#purchasebillForm").form("load",row);
            }else{
                $.messager.alert('提示信息','请选择一行再进行修改!','info');
            }
        },
        del:function () {
            //拿到选中的这条数据
            var row = purchasebillGrid.datagrid("getSelected");
            if(row){
                $.messager.confirm('确认框', '确定要狠心删除我么?', function(r){
                    if (r){
                        //进行删除
                        $.get("/purchasebill/delete",{id:row.id},function (result) {
                            if(result.success){
                                $('#purchasebillGrid').datagrid('reload');
                            }else{
                                //alert("删除失败");
                                $.messager.alert('提示信息','删除失败!，原因:'+result.msg,"error");
                            }
                        })
                    }
                });

            }else{
                $.messager.alert('提示信息','请选择一行再进行删除!','info');
            }
        },
        save:function () {
            var url  = "/purchasebill/save";
            var id = $("#purchasebillId").val();
            if(id){
                url = "/purchasebill/update?cmd=update";
            }
            purchasebillForm.form('submit', {
                url:url,
                onSubmit: function(params){
                    //做验证 额外参数
                    //提交所有的明细表数据
                    var rows = $("#gridItems").datagrid("getRows");
                    //遍历数据
                    for(var i=0;i<rows.length;i++){
                        var row = rows[i];
                        params["items["+i+"].product.id"] = row.product.id;
                        params["items["+i+"].price"] = row.price;
                        params["items["+i+"].num"] = row.num;
                        params["items["+i+"].descs"] = row.descs;

                    }

                    return $("#purchasebillForm").form("validate");

                },
                success:function(data){
                    var result = JSON.parse(data);//转成相应的json数据
                    if(result.success) {
                        $('#purchasebillGrid').datagrid('reload');
                    }else{
                        $.messager.alert('提示信息','操作失败!，原因:'+result.msg,"error");
                    }
                    purchasebillDialog.dialog('close');
                }
            })
        }
    }
});
//明细编辑表格
$(function () {

    var dg = $("#gridItems"),
        //默认行
        defaultRow = { product: "", productNum: "", productName: "", totalNum: 0, productPirce: 0, totalPrice: 0 },
        //插入位置
        insertPosition = "bottom";
    //初始化表格
    var dgInit = function () {
        //列的设置
        var getColumns = function () {
            var result = [];
            //列信息的设置
            var normal = [
                {
                    field: 'product', title: '产品', width: 180,
                    editor: {
                        type: "combobox",
                        options: {
                            valueField:'id',
                            textField:'productName',panelHeight:'auto',
                            url:'/product/getAll',
                            required: true
                        }

                    },formatter:function(value,row){
                        //当前行数据
                        if(row){
                            return row.product.productName;
                        }
                    }
                },
                {
                    field: 'productNum', title: '编码', width: 180,
                    editor: {
                        options: {
                            required: false,
                            readonly: true
                        }
                    },
                    formatter:function(value,row){
                        //当前行数据
                        if(row && row.product){
                            return row.product.productNum;
                        }
                    }
                },
                {
                    field: 'totalNum', title: '数量', width: 100,
                    editor: {
                        type: "numberbox",
                        options: {
                            required: true
                        }
                    }
                },
                {
                    field: 'productPrice', title: '价格', width: 100,
                    editor: {
                        type: "numberbox",
                        options: {
                            required: false,
                            readOnly: true
                        }
                    },formatter:function(value,row){
                        //当前行数据
                        if(row && row.product){
                            return row.product.productPrice;
                        }
                    }
                },
                {
                    field: 'totalPrice', title: '小计', width: 100,
                    editor: {
                        type: "text",
                        options: {
                            required: false,
                            readonly: true
                        }
                    },formatter:function(value,row){
                        if(row && row.product.productPrice && row.totalNum){
                            return (row.product.productPrice*row.totalNum).toFixed(2);
                        }
                    }
                }
            ];
            result.push(normal);

            return result;
        };
        //选项属性设置
        var options = {
            idField: "product",
            rownumbers: true,
            fitColumns: true,
            fit: true,
            border: false,
            toolbar:"#itemBtns",
            singleSelect: true,
            columns: getColumns(),
            //表示开启单元格编辑功能
            enableCellEdit: true
        };
        //创建表格
        dg.datagrid(options);

    };
    //插入位置
    var getInsertRowIndex = function () {
        return insertPosition == "top" ? 0 : dg.datagrid("getRows").length;
    }
    //按钮的绑定时间
    var buttonBindEvent = function () {
        //插入一行数据
        $("#btnInsert").click(function () {
            //得到插入行的索引
            var targetIndex = getInsertRowIndex(), targetRow = $.extend({}, defaultRow, { ID: $.util.guid() });
            dg.datagrid("insertRow", { index: targetIndex, row: targetRow });
            //插入的时候,选中product编辑
            dg.datagrid("editCell", { index: targetIndex, field: "product" });
        });
        //保存数据
        /*$("#btnSave").click(function () {
            var rows = dg.datagrid("getRows"), len = rows.length;
            for (var i = 0; i < len; i++) {
                dg.datagrid("endEdit", i);
            }
        });*/

        //删除数据btnRemove
        $("#btnRemove").click(function(){
            //获取选中的行数
            var row =  $("#gridItems").datagrid('getSelected');
            //获取行索引
            var index = $("#gridItems").datagrid('getRowIndex',row);
            //通过索引删除行
            $("#gridItems").datagrid('deleteRow',index);

        });

    };

    //调用初始化方法
    dgInit();
    //按钮绑定事件
    buttonBindEvent();


});