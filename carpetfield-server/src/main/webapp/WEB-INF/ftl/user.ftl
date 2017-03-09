<#-- @ftlvariable name="user" type="com.carpetfield.server.domain.auth.User" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Carpet Field - User Info</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>User Details</h1>

<p>E-mail: ${user.email}</p>

<p>Role: ${user.role}</p>

</body>
</html>