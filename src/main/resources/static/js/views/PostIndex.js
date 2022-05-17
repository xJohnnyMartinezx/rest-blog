export default function PostIndex(props) {
    //Language=HTML
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
                    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Ente title here.">
                </div>
                <div class="mb-3">
                  <label for="exampleFormControlTextarea1" class="form-label">Enter new post content below.</label>
                  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                </div>
            </div>
            <button id="create-post-sub-butt">Submit New Post</button>
        </main>
    `;
}


// window.addEventListener("click", "create-post-sub-butt", submitNewPost())
// document.getElementById("create-post-sub-butt").addEventListener("click", submitNewPost)

$(document).on("click", "#create-post-sub-butt", function (){
    console.log("button click test");
})

export function PostsEvent() {

}

