<html lang="zh-CN">
<head>
    <meta charset="UTF-8"/>
    <title>学生表</title>
    <style>
        table {
            width: 50%;
            font-size: .938em;
            border-collapse: collapse; /*边框合并*/
        }

        th {
            text-align: left;
            padding: .5em .5em;
            font-weight: bold;
            background: #66677c;
            color: #fff;
        }

        td {
            padding: .5em .5em;
            border-bottom: solid 1px #ccc;
        }

        table, table tr th, table tr td {
            border: 1px solid #0094ff;
        }

        /*设置边框*/
    </style>
</head>
<body>

<table>
    <tr>
        <th>姓名</th>
        <th>学号</th>
        <th>性别</th>
        <th>民族</th>
        <th>政治面貌</th>
        <th>主要工作</th>
        <th>学校名称</th>
        <#--        <th>birthday</th>-->
        <#--        <th>entranceTime</th>-->
    </tr>
<#--    <#list studentById as student>-->
        <tr>
            <td>${student.studName}</td>
            <td>${student.stuNo}</td>
            <td>${student.sex}</td>
            <td>${student.nation}</td>
            <td>${student.political}</td>
            <td>${student.major}</td>
            <td>${student.school}</td>
            <#--            <td>${student.birthday}</td>-->
            <#--            <td>${student.entranceTime}</td>-->
        </tr>
<#--    </#list>-->
</table>
</body>
</html>