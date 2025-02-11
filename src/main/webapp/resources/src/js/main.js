var actual_r = null;

function graphSetup(r) {
    if (actual_r === r) {
        actual_r = null;
        r = "R"
    } else {
        actual_r = r;
    }
    const canvas = document.getElementById('graph');

    const ctx = canvas.getContext('2d');
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    const R = 100;

    ctx.translate(canvas.width / 2, canvas.height / 2);

    ctx.fillStyle = 'rgba(0, 102, 255, 0.5)';


    ctx.fillRect(-R, 0, R, -R / 2);

    ctx.beginPath();
    ctx.moveTo(0, 0);
    ctx.lineTo(-R / 2, 0);
    ctx.lineTo(0, R / 2);
    ctx.closePath();
    ctx.fill();

    ctx.beginPath();
    ctx.moveTo(0, 0);
    ctx.arc(0, 0, R / 2, 0, -Math.PI / 2, true);
    ctx.closePath();
    ctx.fill();

    ctx.strokeStyle = 'black';
    ctx.lineWidth = 1;

    ctx.beginPath();
    ctx.moveTo(-canvas.width / 2, 0);
    ctx.lineTo(canvas.width / 2, 0);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(0, -canvas.height / 2);
    ctx.lineTo(0, canvas.height / 2);
    ctx.stroke();


    ctx.font = "10px Arial";
    ctx.fillStyle = 'black';
    ctx.textAlign = 'center';
    ctx.textBaseline = 'middle';
    if (!isNaN(r)) {
        ctx.fillText((-r).toString(), -R, 15);
        ctx.fillText((-r / 2).toString(), -R / 2, 15);
        ctx.fillText((r / 2).toString(), R / 2, 15);
        ctx.fillText((r).toString(), R, 15);
        ctx.fillText((r).toString(), -15, -R);
        ctx.fillText((r / 2).toString(), -15, -R / 2);
        ctx.fillText((-r / 2).toString(), -15, R / 2);
        ctx.fillText((-r).toString(), -15, R);
    } else {
        ctx.fillText("-R", -R, 15);
        ctx.fillText("-R/2", -R / 2, 15);
        ctx.fillText("R/2", R / 2, 15);
        ctx.fillText("R", R, 15);
        ctx.fillText("R", -15, -R);
        ctx.fillText("R/2", -15, -R / 2);
        ctx.fillText("-R/2", -15, R / 2);
        ctx.fillText("-R", -15, R);
    }

    ctx.fillText("X", canvas.width / 2 - 10, 15);
    ctx.fillText("Y", -15, -canvas.height / 2 + 10);
    ctx.translate(-canvas.width / 2, -canvas.height / 2);
}


