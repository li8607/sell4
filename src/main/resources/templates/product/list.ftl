<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>商品id</th>
                            <th>名称</th>
                            <th>图片</th>
                            <th>单价</th>
                            <th>库存</th>
                            <th>描述</th>
                            <th>类目</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list productInfoPage.getContent() as productInfo>
                            <tr>
                                <td>${productInfo.getProductId()}</td>
                                <td>${productInfo.getProductName()}</td>
                                <td><img width="100" height="100" src="${productInfo.getProductIcon()}"></td>
                                <td>${productInfo.getProductPrice()}</td>
                                <td>${productInfo.getProductStock()}</td>
                                <td>${productInfo.getProductDescription()}</td>
                                <td>${productInfo.getCategoryType()}</td>
                                <td>${productInfo.getCreateTime()}</td>
                                <td>${productInfo.getUpdateTime()}</td>
                                <td><a href="/sell/seller/product/index?productId=${productInfo.getProductId()}">修改</a></td>
                                <td>
                                    <#if productInfo.getProductStatusEnum().getMessage() == "在架">
                                        <a href="/sell/seller/product/off_sale?productId=${productInfo.getProductId()}">下架</a>
                                    <#else >
                                        <a href="/sell/seller/product/on_sale?productId=${productInfo.getProductId()}">上架</a>
                                    </#if>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                            <#if currentPage lte 1>
                                <li class="disabled"><a href="">上一页</a></li>
                            <#else>
                                <li><a href="/sell/seller/product/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                            </#if>

                            <#list 1..productInfoPage.getTotalPages() as index>
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/sell/seller/product/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>
                            <#if currentPage gte productInfoPage.getTotalPages()>
                                <li class="disabled"><a href="">下一页</a></li>
                            <#else>
                                <li><a href="/sell/seller/product/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                            </#if>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>