<#import "parts/common.ftlh" as c>
<@c.page>

    <#if isAdmin??>
        <#include "parts/productEdit.ftlh" />
    </#if>

    <#include "parts/productList.ftlh" />

</@c.page>