function login()
{
    const username=document.getElementById('loginUsername').value.trim();
    const password=document.getElementById('loginPassword').value.trim();
    console.log(`Login clicked. Username: ${username}, Password: ${password}`);

}
function register() {
    const name = document.getElementById('registerName').value.trim();
    const email = document.getElementById('registerEmail').value.trim();
    const username = document.getElementById('registerUsername').value.trim();
    const password = document.getElementById('registerPassword').value;

    console.log(`Register clicked. Name: ${name}, Email: ${email}, Username: ${username}, Password: ${password}`);

    
}
if(typeof module!=='undefined' && module.exports )
{
    module.exports={login,register};
}
