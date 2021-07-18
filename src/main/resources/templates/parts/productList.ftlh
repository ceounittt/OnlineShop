<#include "security.ftlh">
<#import "pager.ftlh" as p>

<@p.pager page url />

<div class="card-columns" id="message-list">
    <#list page.content as product>
        <div class="card my-3" data-id="${product.id}">
            <#if product.imageName??>
                <img src="/img/${product.imageName}" class="card-img-top" />
            </#if>
            <div class="m-2">
                <span>${product.productName}</span><br/>
                <span>${product.cost}$</span><br/>
                <i>${product.description}</i>
            </div>
            <div class="card-footer text-muted container">
                <div class="row">
                    <#if isAdmin??>
                        <a class="col btn btn-primary" href="/products/edit/${product.id}">
                            Edit
                        </a>
                    </#if>
                </div>
            </div>
        </div>
    <#else>
        No message
    </#list>
</div>

<@p.pager page url />
