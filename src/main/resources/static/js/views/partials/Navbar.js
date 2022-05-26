export default function Navbar(props) {
    return `
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Rest Blog</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/" data-link>Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/posts" data-link>Posts</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/about" data-link>About</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            User
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <li><a class="dropdown-item" href="/user" data-link>User</a></li>
            <li><a class="dropdown-item" href="/login" data-link>Login</a></li>
            <li><a class="dropdown-item" href="/register" data-link>Register</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
        
<!--        <nav>-->
<!--            <a href="/" data-link>Home</a>-->
<!--            <a href="/posts" data-link>Posts</a>-->
<!--            <a href="/about" data-link>About</a>-->
<!--            <a href="/login" data-link>Login</a>-->
<!--            <a href="/register" data-link>Register</a>-->
<!--            <a href="/user" data-link>User</a>-->
<!--        </nav>-->
    `;
}