<!doctype html>
<head>
    <title>Freemarke Example</title>
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
    <h2>User CRUD operation with Freemarker Template</h2>
    <a href="/create" class="btn btn-primary" role="button">Create New User</a>
    <table class="table">
        <thead >
        <tr>
            <th scope="col">Id</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Email</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
        <tr>
            <th scope="row">${user.id}</th>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td><a href="/update/${user.id}" class="btn btn-warning" role="button">
                Update</a></td>
            <td><a href="/delete/${user.id}" class="btn btn-danger" role="button">
                Delete</a></td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>