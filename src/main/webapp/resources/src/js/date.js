const date_label = document.querySelector("#date");
const date = new Date();
date_label.innerText = `${date.getDate()}.${date.getMonth() + 1}.${date.getFullYear()}`