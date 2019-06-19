$(function () {
    var dg = $("#dg1"),
        defaultRow = {productNum: "", productName: "", productPrice: "", totalNum: "0", totalPrice: "0"},
        insertPosition = "bottom";

    var dgInit = function () {

        var getColumns = function () {
            var result = [];

                var normal = [
                    {
                        field: 'product', title: '产品', width: 180,
                        editor: {
                            type: "combobox",
                            options: {
                                valueField: 'id',
                                textField: 'productName', panelHeight: 'auto',
                                url: '/product/getAll',
                                required: true
                            }

                        },
                        formatter: function (value, row) {
                            //当前行数据
                            alert(row.productNum);
                            if (row) {
                                return row.productName;
                            }
                        }
                    },
                    {
                        field: 'productName', title: '商品名称', width: 180,
                        editor: {
                            type: "validatebox",
                            options: {
                                required: false,
                                readonly: false
                            }

                        },
                        formatter: function (value, row) {
                            //当前行数据
                            if (row) {
                                return row.productName;
                            }
                        }
                    }
                ];
            result.push(normal);

            return result;
        }
            ;
            var options = {
                idField: "product",
                rownumbers: true,
                fitColumns: true,
                fit: true,
                border: false,
                singleSelect: true,
                columns: getColumns(),
                //表示开启单元格编辑功能
                enableCellEdit: true
            };

            dg.datagrid(options);

        }
            ;

            var getInsertRowIndex = function () {
                return insertPosition == "top" ? 0 : dg.datagrid("getRows").length;
            }

            var buttonBindEvent = function () {

                $("#btnInsert").click(function () {
                    var targetIndex = getInsertRowIndex(), targetRow = $.extend({}, defaultRow, {ID: $.util.guid()});
                    dg.datagrid("insertRow", {index: targetIndex, row: targetRow});
                    dg.datagrid("editCell", {index: 0, field: "Code"});
                });

                $("#btnSave").click(function () {
                    var rows = dg.datagrid("getRows"), len = rows.length;
                    for (var i = 0; i < len; i++) {
                        dg.datagrid("endEdit", i);
                    }
                });
            };


            dgInit();
            buttonBindEvent();


        }
    );