export default function User(props) {

    // language=HTML
    return `

        <!DOCTYPE html>
        <html lang="em">
        <head>
            <meta charset="UTF-8"/>
            <title>User</title>
        </head>
        <body>
        <h1>User Information</h1>

        <div id="user-container">
            ${props.users.map(user =>
                    `
                                <p id="username-${user.id}">${user.username}</p>
                                <p id="email-${user.id}">${user.email}</p>
<button type="submit" class="btn btn-primary edit-button" data-id="${user.id}">Edit</button>
<button type="submit" class="btn btn-danger delete-button" data-id="${user.id}">Delete</button>`)
                    .join('')}

            <!--<form id="register-form">-->
            <!--    <label for="username">Username</label>-->
            <!--    <input id="username" name="username" type="text"/>-->
            <!--    <label for="email">Email</label>-->
            <!--    <input id="email" type="email">-->
            <!--    <label for="password">Password</label>-->
            <!--    <input id="password" name="password" type="password"/>-->
            <!--    <input id="register-btn" type="submit" value="Register"/>-->
            <!--</form>-->
        </body>
        </html>`;

}

export function UserEvent(){

}