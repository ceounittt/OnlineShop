<div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control ${(productNameError??)?string('is-invalid', '')}"
                       value="<#if product??>${product.productName}</#if>" name="productName" placeholder="Enter name of product" />
                <#if textError??>
                    <div class="invalid-feedback">
                        ${productNameError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="number" class="form-control"
                       value="<#if product??>${product.cost}</#if>" name="cost" placeholder="Cost"/>
                <#if costError??>
                    <div class="invalid-feedback">
                        ${costError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control"
                       value="<#if product??>${product.description}</#if>" name="description" placeholder="Description" />
                <#if descriptionError??>
                    <div class="invalid-feedback">
                        ${descriptionError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file" id="customFile" />
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input type="hidden" name="id" value="<#if product??>${product.id}</#if>" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Save product</button>
            </div>
        </form>
    </div>
