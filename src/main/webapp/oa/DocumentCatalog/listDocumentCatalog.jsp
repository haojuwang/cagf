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
        <div class="filter">
            <form action="product.php" method="post">
                <select name="cat_id">
                    <option value="0">未分类</option>

                </select>
                <input name="keyword" type="text" class="inpMain" value="" size="20"/>
                <input name="submit" class="btnGray" type="submit" value="筛选"/>
            </form>

        </div>

        <div id="list">
            <form name="action" method="post" action="product.php?rec=action">
                <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
                    <tr>
                        <th width="22" align="center"><input name='chkall' type='checkbox' id='chkall'
                                                             onclick='selectcheckbox(this.form)' value='check'></th>
                        <th width="40" align="center">编号</th>
                        <th width="80" align="center">name</th>

                        <th width="80" align="center">date</th>

                        <th width="80" align="center">flag</th>

                        <th width="80" align="center">authorId</th>

                        <th width="80" align="center">authorName</th>

                        <th width="80" align="center">type</th>

                        <th width="80" align="center">content</th>

                        <th width="80" align="center">order</th>

                        <th width="80" align="center">address</th>

                        <th width="80" align="center">children</th>

                        <th width="80" align="center">items</th>

                        <th width="80" align="center">parent</th>


                        <th width="80" align="center">操作</th>
                    </tr>

                    <c:forEach items="${list}" var="bean" varStatus="vs">
                        <tr>
                            <td align="center"><input type="checkbox" name="checkbox[]" value="${document.id}"/></td>
                            <td align="center">${vs.index}</td>
                             <td align="center">{bean.name}</td>

                            <td align="center">{bean.date}</td>

                            <td align="center">{bean.flag}</td>

                            <td align="center">{bean.authorId}</td>

                            <td align="center">{bean.authorName}</td>

                            <td align="center">{bean.type}</td>

                            <td align="center">{bean.content}</td>

                            <td align="center">{bean.order}</td>

                            <td align="center">{bean.address}</td>

                            <td align="center">{bean.children}</td>

                            <td align="center">{bean.items}</td>

                            <td align="center">{bean.parent}</td>


                            <td align="center">
                                <a href="${pageContext.request.contextPath}/oa/DocumentCatalog/updatepDocumentCatalog?id=${bean.id}">编辑</a> |
                                <a href="${pageContext.request.contextPath}/oa/DocumentCatalog/deleteDocumentCatalog?id=${bean.id}">删除</a>
                            </td>

                        </tr>


                    </c:forEach>

                </table>
                <div class="action">
                    <select name="action" onchange="douAction()">
                        <option value="0">请选择...</option>
                        <option value="1">删除</option>
                        <option value="category_move">移动分类至</option>
                    </select>
                    <select name="new_cat_id" style="display:none">
                        <option value="0">未分类</option>
                        <option value="1"> 电子数码</option>
                        <option value="4">- 智能手机</option>
                        <option value="5">- 平板电脑</option>
                        <option value="2"> 家居百货</option>
                        <option value="3"> 母婴用品</option>
                    </select>
                    <input name="submit" class="btn" type="submit" value="执行"/>
                </div>
            </form>

        </div>

        <div class="clear"></div>
        <div class="pager">总计 15 个记录，共 1 页，当前第 1 页 | <a href="product.php?page=1">第一页</a> 上一页 下一页 <a
                href="product.php?page=1">最末页</a></div>

    </div>



</div>
<jsp:include page="/footer.jsp"></jsp:include>