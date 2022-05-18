import createView from "../createView.js";


export default function Register() {

    // language=HTML
    return `

<!DOCTYPE html>
<html lang="em">
<head>
    <meta charset="UTF-8"/>
    <title>Register</title>
</head>
<body>
<h1>Register Form</h1>

<form id="register-form">
    <label for="username">Username</label>
    <input id="username" name="username" type="text"/>
    <label for="email">Email</label>
    <input id="email" type="email">
    <label for="password">Password</label>
    <input id="password" name="password" type="password"/>
    <input id="register-btn" type="submit" value="Register"/>
</form>
</body>
</html>`;


}

export function RegisterEvent(){
    $(document).on("click", "#register-btn", function (e){
        e.preventDefault();
        console.log("Register button has been clicked")

        const newUser = {
            username: $("#username").val(),
            email: $("#email").val(),
            password: $("#password").val()
        }

        const options = {
            method: "POST",
            headers: {"Content-Type" : "application/json"},
            body: JSON.stringify(newUser)
        };
        fetch("http://localhost:8080/api/users", options)
            .then((response) => {
                console.log(response.status)
                createView("/");
            });
    })
}