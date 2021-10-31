<!doctype html>
<head>
    <title>Freemarker Example</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js">
    </script>
</head>
<body>
<div class="container">
            <h2>
                <#if !isUpdate>Create</#if>
            <#if isUpdate>Update</#if>
        User
        </h2>
<div>
    <form action="<#if isUpdate>/update/${user.id}</#if><#if !isUpdate>/create</#if>"
          method="post" name="user">
        <table class="table">
            <tbody>
            <thead>
            <tr>
                <th>Field</th>
                <th>Value</th>
            </tr>
            </thead>
            <tbody>
            <#if isUpdate>
            <tr>
                <th>ID</th>
                <td>
                    <div name="id">${user.id}</div>
                </td>
            </tr>
            </#if>
            <tr>
                <th>First Name</th>
                <td><input name="firstName" type="text"
                           value="<#if user.firstName??>${user.firstName}</#if>"/>
                                                    </td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td><input name="lastName" type="text"
                           value="<#if user.lastName??>${user.lastName}</#if>"/></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><input name="email" type="text"
                           value="<#if user.email??>${user.email}</#if>"/></td>
            </tr>
            </tbody>
        </table>
        <button class="btn btn-primary" type="submit">Save</button>
    </form>
</div>
</div>
</body>
</html>