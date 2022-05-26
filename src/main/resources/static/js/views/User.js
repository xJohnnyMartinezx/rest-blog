import createView from "../createView.js";

const BASE_URL = "http://localhost:8080/api/users"

export default function User(props) {
    // console.log(props.user);

    // language=HTML
    return `

        <!DOCTYPE html>
        <html lang="em">
        <head>
            <meta charset="UTF-8"/>
            <title>Hello, ${props.user.username}</title>
        </head>
        <body>
        <h1>Your Information</h1>

        <div id="user-container">
            <form id="user-info-form"></form>
            <label for="username">Username</label>
            <p id="username">${props.user.username}</p>
            <label for="email">Email Address</label>
            <p id="email-${props.user.id}">${props.user.email}</p>

            <label for="new-password">New Password</label>
            <input id="new-password" name="new-password" type="password" value=""/>
            <button type="submit" id="change-pw-btn" class="btn btn-primary edit-button" data-id="${props.user.id}">
                Submit Password Change
            </button>
            </form>
        </body>
        </html>
    `
}

export function UserEvent() {
    addUpdatePasswordListener();
    updateUserProfileListener();
}

function addUpdatePasswordListener() {
    $(document).on("click", "#change-pw-btn", function (e) {
        e.preventDefault();

        const id = $(this).data("id");
        const newPassword = $("#new-password").val();

        const request = {
            method: "PUT",
            headers: {
                'Content-Type': 'application/json'
            }
        }

        fetch(`${BASE_URL}/${id}/updatePassword?newPassword=${newPassword}`, request)
            .then(res => {
                console.log(res.status);
            }).catch(error => {
            console.log(error);
        }).finally(() => {
            createView("/user")
        })


    })
}

function updateUserProfileListener() {
    const request = {
        method: "PATCH",
        headers: {
            "Content-Type": "application/json"
        }
    }
    fetch(`http://localhost:8080/api/users/${id}`, request)
        .then(res => {
            console.log(res.status);
        }).catch(error => {
        console.log(error);
    }).finally(() => {
        createView("/user")
    })
}
