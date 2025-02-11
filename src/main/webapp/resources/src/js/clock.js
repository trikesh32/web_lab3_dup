const canvas = document.getElementById("clock");
const ctx = canvas.getContext("2d");
const radius = (canvas.height / 2) * 0.9
const center_x = (canvas.height / 2)
const center_y = canvas.height /2;
drawClock();
setInterval(drawClock, 6000);

function drawClock(){
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx.fillStyle = "white";
    ctx.strokeStyle = "black";
    ctx.lineWidth = 10;
    ctx.beginPath();
    ctx.arc(center_x, center_y, radius, 0, 2 * Math.PI);
    ctx.stroke();
    ctx.fill();


    ctx.translate(center_x, center_y);
    ctx.lineWidth = 5;
    for (let i=0;i<12;++i){
        let angle = (Math.PI / 6) * i;
        ctx.beginPath();
        ctx.moveTo(Math.cos(angle) * radius * 0.87, Math.sin(angle) * radius * 0.87);
        ctx.lineTo(Math.cos(angle) * radius * 0.97, Math.sin(angle) * radius * 0.97);
        ctx.closePath();
        ctx.stroke();
    }

    const now = new Date()
    let hours = now.getHours() % 12;
    let minutes = now.getMinutes();
    let seconds = now.getSeconds();
    let secondsAngle = (seconds * Math.PI / 30) - Math.PI / 2;
    let minutesAngle =  (minutes * Math.PI / 30) + (seconds * Math.PI / (30 * 60)) - Math.PI / 2;
    let hoursAngle =  ((hours * Math.PI / 6) + (minutes * Math.PI / (6 * 60)) + (seconds * Math.PI / (360 * 60))) - Math.PI / 2;

    ctx.lineWidth = 15;
    ctx.beginPath();
    ctx.moveTo(0,0);
    ctx.lineTo(Math.cos(hoursAngle) * radius * 0.5, Math.sin(hoursAngle) * radius * 0.5);
    ctx.closePath();
    ctx.stroke();

    ctx.lineWidth = 10;
    ctx.beginPath();
    ctx.moveTo(0,0);
    ctx.lineTo(Math.cos(minutesAngle) * radius * 0.7, Math.sin(minutesAngle) * radius * 0.7);
    ctx.closePath();
    ctx.stroke();

    ctx.lineWidth = 5;
    ctx.beginPath();
    ctx.moveTo(0,0);
    ctx.lineTo(Math.cos(secondsAngle) * radius * 0.9, Math.sin(secondsAngle) * radius * 0.9);
    ctx.closePath();
    ctx.stroke();

    ctx.fillStyle = "black";
    ctx.beginPath();
    ctx.arc(0, 0, radius*0.05, 0, 2 * Math.PI);
    ctx.fill();

    ctx.translate(-center_x, -center_y);
}