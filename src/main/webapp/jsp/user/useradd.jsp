<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
</head>
<body>
<form name="frmUser" action="#" method="post">
    <table cellpadding="8" border="1" align="center" style="border-collapse:
collapse">
        <tr>
            <td>用户注册</td>
        </tr>
        <tr>
            <td>
                <table cellpadding="8" border="1" style="border-collapse: collapse">
                    <tr>
                        <td align="right">姓名：</td>
                        <td colspan="3">
                            <input name="userName"
                                   type="text"size="20"
                                   mixlength="4" maxlength="50"
                                   placeholder="请输入姓名"
                                   value="">
                        </td>
                    </tr>
                    <tr>
                        <td align="right" >性别：</td>
                        <td>
                            <input name="sex" type="radio" value="0">男 &nbsp;&nbsp;
                            <input name="sex" type="radio" value="1" checked>女
                        </td>
                        <td align="right" >籍贯：</td>
                        <td >
                            <select name="birthPlace">
                                <option value="安徽">安徽</option>
                                <option value="北京">北京</option>
                                <option value="河北" selected>河北</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" >班级：</td>
                        <td colspan="3">
                            <input name="clazz"
                                   type="text" size="20"
                                   mixlength="4" maxlength="20"
                                   placeholder="请输入班级"
                                   value="">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">学号：</td>
                        <td colspan="3">
                            <input name="userNo"
                                   type="text" size="20"
                                   mixlength="4" maxlength="20"
                                   placeholder="请输入学号"
                                   value="">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">家庭地址：</td>
                        <td colspan="3">
                            <input name="address"
                                   type="text" size="50"
                                   mixlength="4" maxlength="100"
                                   placeholder="请输入家庭地址"
                                   value="">
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td align="center">
                <input name="bthAdd" type="button" value="保存" onclick="useradd()">
                <input name="bthReset" type="reset" value="重置" onclick="">
                <input name="bthCancel" type="button" value="取消" onclick="cancel()">
            </td>
        </tr>
    </table>
</form>
<script language="JavaScript">
    function useradd() {
        document.frmUser.action="/UserAddServlet";
        document.frmUser.submit();
    }
    function cancel() {
        document.location.replace("/UserListServlet");
    }
</script>
</body>
</html>
