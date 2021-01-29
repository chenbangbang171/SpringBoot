<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table border="1" width=600>
    <tr>
        <th>index</th>
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th>address</th>
    </tr>
    <#list students as student>
        <#if student_index % 2 == 0>
            <tr bgcolor="red">
        <#else>
            <tr bgcolor="yellow">
        </#if>
        <td>${student_index}</td>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.age}</td>
        <td>${student.address}</td>
        </tr>
    </#list>
</table>
</body>
</html>