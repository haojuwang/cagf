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
        <form action="${pageContext.request.contextPath}/oa/DocumentCatalog/updateDocumentCatalog" method="post" id="forms">
            <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">



                <tr>
                    <td align="right">name</td>
                    <td>
                        <input type="text" name="name" size="50" value="<s:property value='documentCatalog.name' />"
                               class="inpMain">
                    </td>
                <tr/>

                <tr>
                    <td align="right">date</td>
                    <td>
                        <input type="text" name="date" size="50" value="<s:property value='documentCatalog.date' />"
                               class="inpMain">
                    </td>
                <tr/>

                <tr>
                    <td align="right">flag</td>
                    <td>
                        <input type="text" name="flag" size="50" value="<s:property value='documentCatalog.flag' />"
                               class="inpMain">
                    </td>
                <tr/>

                <tr>
                    <td align="right">authorId</td>
                    <td>
                        <input type="text" name="authorId" size="50" value="<s:property value='documentCatalog.authorId' />"
                               class="inpMain">
                    </td>
                <tr/>

                <tr>
                    <td align="right">authorName</td>
                    <td>
                        <input type="text" name="authorName" size="50" value="<s:property value='documentCatalog.authorName' />"
                               class="inpMain">
                    </td>
                <tr/>

                <tr>
                    <td align="right">type</td>
                    <td>
                        <input type="text" name="type" size="50" value="<s:property value='documentCatalog.type' />"
                               class="inpMain">
                    </td>
                <tr/>

                <tr>
                    <td align="right">content</td>
                    <td>
                        <input type="text" name="content" size="50" value="<s:property value='documentCatalog.content' />"
                               class="inpMain">
                    </td>
                <tr/>

                <tr>
                    <td align="right">order</td>
                    <td>
                        <input type="text" name="order" size="50" value="<s:property value='documentCatalog.order' />"
                               class="inpMain">
                    </td>
                <tr/>

                <tr>
                    <td align="right">address</td>
                    <td>
                        <input type="text" name="address" size="50" value="<s:property value='documentCatalog.address' />"
                               class="inpMain">
                    </td>
                <tr/>

                <tr>
                    <td align="right">children</td>
                    <td>
                        <input type="text" name="children" size="50" value="<s:property value='documentCatalog.children' />"
                               class="inpMain">
                    </td>
                <tr/>

                <tr>
                    <td align="right">items</td>
                    <td>
                        <input type="text" name="items" size="50" value="<s:property value='documentCatalog.items' />"
                               class="inpMain">
                    </td>
                <tr/>

                <tr>
                    <td align="right">parent</td>
                    <td>
                        <input type="text" name="parent" size="50" value="<s:property value='documentCatalog.parent' />"
                               class="inpMain">
                    </td>
                <tr/>



                <input type="hidden" name="id" value="<s:property value='documentCatalog.id'/>">

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