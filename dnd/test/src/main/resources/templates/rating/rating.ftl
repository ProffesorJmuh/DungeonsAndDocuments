<#import "../base.ftl" as base>

<@base.body "${title}">
    <#list userList as userRating>
        ${userRating.user.firstName} - ${userRating.result}
    </#list>
    <br/>
    <hr/>

</@base.body>