<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>




<jsp:include page="/head.jsp"></jsp:include>

<jsp:include page="/left.jsp"></jsp:include>


<div id="dcMain">
    <!-- 当前位置 -->
    <div id="urHere">DouPHP 管理中心<b>></b><strong>添加分类</strong></div>
    <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3><a href="product_category.php" class="actionBtn">文档分类</a>添加分类</h3>
        <form action="${pageContext.request.contextPath}/oa/DocumentitemEntity/addDocumentitemEntity" method="post" id="forms">
            <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">



                <tr>
                    <td align="right">name</td>
                    <td>
                        <input type="text" name="name" size="50" class="inpMain">
                    </td>
                </tr>

                <tr>
                    <td align="right">authorId</td>
                    <td>
                        <input type="text" name="authorId" size="50" class="inpMain">
                    </td>
                </tr>

                <tr>
                    <td align="right">authorName</td>
                    <td>
                        <input type="text" name="authorName" size="50" class="inpMain">
                    </td>
                </tr>

                <tr>
                    <td align="right">date</td>
                    <td>
                        <input type="text" name="date" size="50" class="inpMain">
                    </td>
                </tr>

                <tr>
                    <td align="right">realSize</td>
                    <td>
                        <input type="text" name="realSize" size="50" class="inpMain">
                    </td>
                </tr>

                <tr>
                    <td align="right">size</td>
                    <td>
                        <input type="text" name="size" size="50" class="inpMain">
                    </td>
                </tr>

                <tr>
                    <td align="right">randomName</td>
                    <td>
                        <input type="text" name="randomName" size="50" class="inpMain">
                    </td>
                </tr>

                <tr>
                    <td align="right">type</td>
                    <td>
                        <input type="text" name="type" size="50" class="inpMain">
                    </td>
                </tr>

                <tr>
                    <td align="right">documentCatalog</td>
                    <td>
                        <input type="text" name="documentCatalog" size="50" class="inpMain">
                    </td>
                </tr>




                <tr>
                    <td></td>
                    <td>
                        <input name="submit" class="btn" type="submit" value="提交"/>
                    </td>
                </tr>

            </table>
        </form>
    </div>
</div>







<jsp:include page="/footer.jsp"></jsp:include>