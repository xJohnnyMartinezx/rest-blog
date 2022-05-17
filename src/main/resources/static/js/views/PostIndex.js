import createView from "../createView";

// const postUrl = "http//localhost:8080/posts"

export default function PostIndex(props) {
    //language=HTML
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
            <div id="posts-container">
                ${props.posts.map(post => `
                    <h3>${post.title}</h3>
                    <p>${post.contents}</p>
                `).join('')}   
            </div>
            <div id="post-form">
                <div class="mb-3">
                 <label for="exampleFormControlInput1" class="form-label">Post Title</label>
                    <input type="text" class="form-control" id="post-title" placeholder="Ente title here.">
                </div>
                <div class="mb-3">
                  <label for="exampleFormControlTextarea1" class="form-label">Enter new post content below.</label>
                  <textarea class="form-control" id="post-content" rows="3"></textarea>
                </div>
            </div>
            <button id="create-post-sub-butt" btn="btn-secondary">Submit New Post</button>
        </main>
    `;
}


// window.addEventListener("click", "create-post-sub-butt", submitNewPost())
// document.getElementById("create-post-sub-butt").addEventListener("click", submitNewPost)
export function PostsEvent() {
    return addNewPost()
}


//********** ADD NEW POST FUNCTION *************


// ************ POST EVENT FUNCTION ***************


function addNewPost() {
    $(document).on("click", "#create-post-sub-butt", function (){
        console.log("button click test");
    })
//     let postTitle = document.getElementById("post-title").value
//     let postContent = document.getElementById("post-content").value
//
//     let post = {title: postTitle, contents: postContent};
//     let request = {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json',
//         },
//         body: JSON.stringify(post)
//     };
//     fetch("http:localhost:8080/posts", request)
//         .then(res => {
//             console.log(res.status);
//             createView("/posts")
//         }).catch(error => {
//         console.log(error);
//         createView("/posts");
//     });
// }

    const post = {
        title: $("post-title").val(),
        contents: $("post-content").val()
    }

    const request = {
        method: "POST",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(post)
    };
        fetch("http:localhost:8080/api/posts", request)
        .then(res => {
            console.log(res.status);
            createView("/posts")
        }).catch(error => {
        console.log(error);
        createView("/posts");
    });




}