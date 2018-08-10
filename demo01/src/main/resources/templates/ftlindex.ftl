大家好我的名字叫${name}。
<p>
    ---------------------
<p>
<#list list as name>
    <#if name="springboot">我的名字是</#if>
    <#if name="springmvc">我的哥哥是</#if>
    <#if name="springcloud">我的弟弟是</#if>
    ${name}<p>
</#list>