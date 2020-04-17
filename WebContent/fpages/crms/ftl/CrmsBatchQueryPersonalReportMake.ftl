<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html >
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>文件上传</title>
</head>
<style>
    body {
        font: normal 11px auto ,"Trebuchet MS", Verdana, Arial, Helvetica,sans-serif;
        color: #4f6b72;
    }

    #mytable {
        width: 100%;
        padding: 0;
        margin: 0;
    }

    td {
        padding: 0;
        margin: 0;
        height: 40px;
        border: 1px solid #ccc;
    }

    tr {
        padding: 0;
        margin: 0;
    }
</style>
<body id="body">
<%
String fileflag = request.getParameter("fileflag");
String reportid = request.getParameter("reportid");
String fileFormat = request.getParameter("fileFormat");
%>
<form
        action="<%=request.getContextPath()%>/fileupload/FileUploadServlet"
        enctype="multipart/form-data" name="inputform" id="inputform"
        method="post" accept-charset="UTF-8">
    <input type="hidden" name="fileflag" id="fileflag"
           value="<%=fileflag%>"/>
    <input type="hidden" name="reportid"
           id="reportid" value="<%=reportid%>"/>
    <input type="hidden" name="fileName"
           id="fileName" value=""/>

    <table id="mytable" cellspacing="0">
        <tr>
            <td id="uploadFile.title"
                style="width: 20%; text-align: right; height: 60px">文件名：
            </td>
            <td style="width: 60%; font-size: 12px; border: 1px solid lightgray"
                id="fileUpLoad"><input type="file" name="uploadFile"
                                       id="uploadFile" size="50" value=""/></td>
        </tr>
        <tr>
            <td style="width: 40%; text-align: center" colspan="2"><input
                    value="导入" class="btn_width1111" type="button"
                    onClick="return commonUploadFile();" name="upload1" id="upload1">
                <%--                <input class="btn_width1111" value="返回"
                                           onclick="javascript:parent.close()" type="button" id="back">--%>
                <br>&nbsp; <font id="msg" style="display: none" color="blue">正在导入,请等待......</font>
            </td>
        </tr>
    </table>
</form>
<script language="javascript">
    var fileFormat = "<%=fileFormat%>";
    var fileFormatArr = fileFormat.split("_");

    function checkEndWith(str, b) {
        var a = new RegExp(b + "$");
        return a.test(str);
    };

    function checkFileExtends(fileName) {
        var validFlag = false;
        for (var i = 0; i < fileFormatArr.length; i++) {
            if (fileFormatArr[i] == "XLS") {
                if (checkEndWith(fileName, ".xls") == true) {
                    return true;
                }
                else if (checkEndWith(fileName, ".xlsx") == true) {
                    return true;
                }
                else if (checkEndWith(fileName, ".XLS") == true) {
                    return true;
                }
                else if (checkEndWith(fileName, ".XLSX") == true) {
                    return true;
                }
            }
            else {
                var fileExtends = "." + fileFormatArr[i];
                if (checkEndWith(fileName, fileExtends.toLowerCase()) == true) {
                    return true;
                }
                else if (checkEndWith(fileName, fileExtends.toUpperCase()) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    function getFileName(o) {
        var pos = o.lastIndexOf("\\");
        return o.substring(pos + 1);
    }

    function commonUploadFile() {
        var uploadElement = document.getElementById("uploadFile");
        if (!uploadElement || uploadElement.value == "") {
            alert("请选择上传附件路径！");
            return false;
        }
        var uploadFileName = uploadElement.value.toLowerCase().toString();

        if (checkFileExtends(uploadFileName) == false) {
            alert("文件格式不正确，请上传正确的格式的文件！");
            return false;
        }

        var fileName = getFileName(uploadElement.value);

        if (confirm('确定导入文件[' + fileName + ']吗?')) {
            document.getElementById("fileName").value = fileName;
            document.getElementById("inputform").submit();
            document.getElementById("fileUpLoad").disabled = "none";
            document.getElementById("upload1").disabled = "none";
            document.getElementById("back").disabled = "none";
            document.getElementById("msg").style.display = "inline";
            return true;
        } else {
            return false;
        }
    }
</script>
</body>
</html>