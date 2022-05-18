import createView from "../createView.js";

const postUrl = "http://localhost:8080/api/posts";
let requestMethod = "POST";
let postId = "";

export default function PostIndex(props) {
    //language=HTML
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
            <div id="posts-container">
                ${props.posts.map(post =>
                        `
                                <h3 id="title-${post.id}">${post.title}</h3>
                                <p id="content-${post.id}">${post.content}</p>
<button type="submit" class="btn btn-primary edit-button" data-id="${post.id}">Edit</button>
<button type="submit" class="btn btn-danger delete-button" data-id="${post.id}">Delete</button>`)
                        .join('')}
            </div>
            <div id="post-form">
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Post Title</label>
                    <input type="text" class="form-control" id="post-title" placeholder="Enter title here.">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">Enter new post content below.</label>
                    <textarea class="form-control" id="post-content" rows="3"></textarea>
                </div>
            </div>
            <div>
                <button id="create-post-sub-butt" class="btn btn-secondary">Submit New Post</button>
            </div>
        </main>
    `;

}


// ************ POST EVENT FUNCTION ***************
export function PostsEvent() {
    addNewPost();
    createEditPostListener();
    deletePost();
}


//********** ADD NEW POST FUNCTION *************
function addNewPost() {
    $(document).on('click', '#create-post-sub-butt', function (e) {
        e.preventDefault();
        console.log("submit button has been clicked")

        let newPost = {
            title: $("#post-title").val(),
            content: $("#post-content").val()
        }

        let request = {
            method: requestMethod,
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(newPost)
        }

        let requestUrl = "";

        if (postId !== "") {
            requestUrl = `${postUrl}/${postId}`;
        } else {
            requestUrl = `${postUrl}`;
        }


        fetch(requestUrl, request)
            .then(res => {
                console.log(res.status);
                // createView("/posts")
            }).catch(error => {
            console.log(error);
            // createView("/posts");
        }).finally(() => {
            postId = "";
            requestMethod = "POST";
            createView("/posts")
        });
    })
}

//********** EDIT POST FUNCTION *************
function createEditPostListener() {
    $(document).on("click", ".edit-button", function (e) {
        e.preventDefault();
        console.log("edit button has been clicked")
        postId = $(this).data("id");
        requestMethod = "PUT"

        const postTitle = $(`#title-${postId}`).text();
        const postContent = $(`#content-${postId}`).text();

        $("#add-post-title").val(postTitle);
        $("#add-post-content").val(postContent);

        console.log(postId);
        console.log(requestMethod);


    })
}

//********** DELETE POST FUNCTION *************
    function deletePost(){
        $(document).on("click", ".delete-button", function (e) {
            e.preventDefault();
            console.log("delete button has been clicked")

            const id = $(this).data("id");

            const request = {
                method: "DELETE"
            }

            fetch(`${postUrl}/${id}`, request)
                .then(res => {
                    console.log(res.status);
                    // createView("/posts")
                }).catch(error => {
                console.log(error);
                // createView("/posts");
            }).finally(() => {
                createView("/posts")
            })
        })
    }
