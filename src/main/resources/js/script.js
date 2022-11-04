const nav = document.querySelector('.navbar')
fetch('/src/main/resources/templates/navbar.html')
.then(res=>res.text())
.then(data=> {
    nav.innerHTML=data
})