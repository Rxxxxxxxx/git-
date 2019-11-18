<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <link href="${pageContext.servletContext.contextPath}/css/ff.css"
          type="text/css" rel="stylesheet">
</head>
<body>
<form name="frmUser" action="#" method="post">
    <div id="table1" name="table1" class="div_table">
        <div class="div_title">
            成员列表&nbsp;&nbsp;&nbsp;
            <input type="button" name="btnadd"
                   value="注册" onclick="useradd()">
            <input type="button" name="btnedit"
                   value="修改" onclick="useredit()">
            <input type="button" name="btndelete"
                   value="删除" onclick="userdel()">
        </div>
        <div class="div_content">
            <table class="table1">
                <tr class="th1">
                    <td class="td1">序号</td>
                    <td>姓名</td>
                    <td>班级</td>
                    <td>学号</td>
                </tr>
                <c:forEach var="user" items="${userlist}">
                    <c:if test="${(vstatus.index)%2 == 0}">
                        <tr class="tr0">
                            <td class="td1">
                                <input type="radio" name="userId" value="${user.userId}">${user.userId}
                            </td>
                            <td>${user.userName}</td>
                            <td>${user.clazz}</td>
                            <td>${user.userNo}</td>
                        </tr>
                    </c:if>
                    <c:if test="${(vstatus.index)%2 == 1}">
                        <tr class="tr1">
                            <td class="td2">
                                <input type="radio" name="userId" value="${user.userId}">
                            </td>
                            <td>${user.userName}</td>
                            <td>${user.clazz}</td>
                            <td>${user.userNo}</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </div>
</form>
<script language="JavaScript">
    function useradd() {
        window.location.replace("/UserToAddServlet");
    }
    function useredit() {
        var userids=document.getElementsByName("userId");
        var isSelected= false;
        //循环判断是否有选中的用户
        for(i=0;i<userids.length;i++){
            //如果有选中的用户，则 isSelected=true
            if(userids[i].checked){
                isSelected=true;
            }
        }
        if(isSelected){
            //如果选择了用户，则可以进行修改
            document.frmUser.action="/UserToEditServlet";
            document.frmUser.submit();
        }else{
            //否则进行提示
            alert("请先选择用户！");
        }
    }

    function userdel() {
        var userids=document.getElementsByName("userId");
        var isSelected= false;
        //循环判断是否有选中的用户
        for(i=0;i<userids.length;i++){
            //如果有选中的用户，则 isSelected=true
            if(userids[i].checked){
                isSelected=true;
            }
        }
        if(isSelected){
            //如果选择了用户
            if(confirm("确认删除选择的用户吗？")){
                //确认后，可以删除
                document.frmUser.action="/UserDeleteServlet";
                document.frmUser.submit();
            }
        }else{
            //否则进行提示
            alert("请先选择用户！");
        }
    }
</script>
</body>
</html>