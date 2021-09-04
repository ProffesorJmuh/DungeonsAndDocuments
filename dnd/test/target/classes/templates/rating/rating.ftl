<#import "../base.ftl" as base>

<@base.body "${title}">
    <#list userList as userRating>
        ${userRating.user.email} - ${userRating.result}<#sep><br></#sep>
    </#list>
    <br/>
    <hr/>

</@base.body>