<%--
  Created by IntelliJ IDEA.
  User: yuecy
  Date: 2020/5/31
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="/js/jquery.min.js"></script>

<script>
    $(function () {
        // 查询所有resume
        $.ajax({
            url: '/resume/findAll',
            type: 'GET',
            contentType: 'application/json;charset=utf-8',
            dataType: 'json',
            success: function (data) {
                $.each(data, function (index, item) {
                    var tr;
                    tr = '<td>' + item.id + '</td>'
                        + '<td contenteditable="true">' + item.address + '</td>'
                        + '<td contenteditable="true">' + item.name + '</td>'
                        + '<td contenteditable="true">' + item.phone + '</td>'
                        + '<td onclick="edit(this)">edit</td>'
                        + '<td onclick="del(this)">del</td>';
                    $("#tableResume").append('<tr>' + tr + '</tr>')
                })
            }
        })
    })

    function edit(td) {
        var tr = td.closest('tr');//获取当前edit的td所在的tr
        var resume = {
            "id": tr.children[0].innerHTML,
            "address": tr.children[1].innerHTML,
            "name": tr.children[2].innerHTML,
            "phone": tr.children[3].innerHTML
        }
        $.ajax({
            url: '/resume/edit',
            type: 'POST',
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(resume),
            dataType: 'json',
            success: function (data) {
                window.location.reload()  //刷新页面
            }
        })
    }

    function del(td) {
        var tr = td.closest('tr');//获取当前del的td所在的tr
        var id = tr.children[0].innerHTML;//要删除的resume id
        var resume = {
            "id": id
        }
        $.ajax({
            url: '/resume/deleteById',
            type: 'POST',
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(resume),
            dataType: 'json',
            success: function (data) {
                window.location.reload()  //刷新页面
            }
        })
    }

</script>

<body>
<a href="/add">add</a>
<table id='tableResume'>
    <tr>
        <th>id</th>
        <th>address</th>
        <th>name</th>
        <th>phone</th>
    </tr>
</table>
</body>
</html>
