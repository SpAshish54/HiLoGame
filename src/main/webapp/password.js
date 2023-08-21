
let password = document.querySelector('.password');
let confirmPassword = document.querySelector('.confirm-password')
let match = document.querySelector('.match')
let form = document.querySelector('.form')

function compare() {
    if (confirmPassword.value) {
    if (password.value != confirmPassword.value) {
       match.style.visibility = 'visible'
       match.innerHTML = 'Not Matching'
       return false
       

    } else {
        match.style.visibility = 'visible'
        match.innerHTML = 'Matching'
    }
} else {
    match.style.visibility = 'hidden'
}
}
confirmPassword.addEventListener('keyup' , () => {
    compare()
})

password.addEventListener('keyup' , () => {
    compare()
})