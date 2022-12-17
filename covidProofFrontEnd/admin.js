// opening and closing the form
function openCloseform(x){
    document.getElementById(x).classList.toggle('formCnt');
    document.querySelector('body').classList.toggle('stopScroll');
}