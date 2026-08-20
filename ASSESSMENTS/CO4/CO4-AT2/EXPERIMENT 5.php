<?php

$errors = [];

$name = "";
$email = "";
$password = "";
$confirmPassword = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {

    // Get input values
    $name = trim($_POST["name"] ?? "");
    $email = trim($_POST["email"] ?? "");
    $password = $_POST["password"] ?? "";
    $confirmPassword = $_POST["confirm_password"] ?? "";

    // Validate Name
    if ($name == "") {

        $errors[] = "Name is required.";

    } elseif (!preg_match("/^[a-zA-Z ]+$/", $name)) {

        $errors[] =
            "Name must contain only letters and spaces.";
    }

    // Validate Email
    if ($email == "") {

        $errors[] = "Email is required.";

    } elseif (!filter_var(
        $email,
        FILTER_VALIDATE_EMAIL
    )) {

        $errors[] =
            "Enter a valid email address.";
    }

    // Validate Password
    if ($password == "") {

        $errors[] =
            "Password is required.";

    } elseif (strlen($password) < 8) {

        $errors[] =
            "Password must contain at least 8 characters.";
    }

    // Validate Confirm Password
    if ($confirmPassword == "") {

        $errors[] =
            "Please confirm your password.";

    } elseif ($password !== $confirmPassword) {

        $errors[] =
            "Passwords do not match.";
    }

    // If no errors
    if (count($errors) == 0) {

        echo "<h3 style='color:green;'>
                Form submitted successfully!
              </h3>";

        echo "<p>Name: "
             . htmlspecialchars($name)
             . "</p>";

        echo "<p>Email: "
             . htmlspecialchars($email)
             . "</p>";

    } else {

        // Display errors
        echo "<div style='color:red;'>";

        foreach ($errors as $error) {

            echo "<p>" .
                 htmlspecialchars($error) .
                 "</p>";
        }

        echo "</div>";
    }
}
?>

<!DOCTYPE html>
<html>

<head>
    <title>PHP Validation</title>
</head>

<body>

<h2>User Registration Form</h2>

<form method="POST"
      action="">

    <label>Name:</label><br>

    <input type="text"
           name="name"
           value="<?php
           echo htmlspecialchars($name);
           ?>">

    <br><br>

    <label>Email:</label><br>

    <input type="text"
           name="email"
           value="<?php
           echo htmlspecialchars($email);
           ?>">

    <br><br>

    <label>Password:</label><br>

    <input type="password"
           name="password">

    <br><br>

    <label>Confirm Password:</label><br>

    <input type="password"
           name="confirm_password">

    <br><br>

    <input type="submit"
           value="Submit">

</form>

</body>
</html>