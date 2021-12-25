<!DOCTYPE html>

<html lang="en">

<body>
<#list studentList as student>

    请说出你的大名：${student.studName}! <br>
    是否团员 <br>
    我:${student.political}!

</#list>
</body>

</html>