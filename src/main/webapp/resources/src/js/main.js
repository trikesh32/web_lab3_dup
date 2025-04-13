var actual_r = null;
var actual_data = null;

function graphSetup(r) {
    if (r !== undefined) {
        if (actual_r === r) {
            actual_r = null;
            r = "R"
        } else {
            actual_r = r;
        }
    } else {
        r = actual_r == null ? "R":actual_r;
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

    if (actual_data != null){
        for (let result of actual_data){
            if (result["r"] === actual_r){
                let x = result["x"] * 100 / result["r"];
                let y = -(result["y"] * 100 / result["r"]);
                let radius = 5;
                ctx.beginPath(); // Начинаем новый путь
                ctx.arc(x, y, radius, 0, Math.PI * 2); // Параметры: x, y, радиус, начальный угол, конечный угол
                ctx.fillStyle = result["isHit"]?"green":"red"; // Цвет заливки
                ctx.fill(); // Заливаем кружок цветом
                ctx.closePath();
            }
        }
    }
    ctx.translate(-canvas.width / 2, -canvas.height / 2);
}

function sendCanvasCoordinates(x, y) {
    // Вызов remoteCommand с передачей параметров
    sendCoordinates([{name: 'x', value: x}, {name: 'y', value: y}]);
}

function handleCanvasClick(event) {
    const canvas = document.getElementById("graph");
    const dim = canvas.getBoundingClientRect();

    // Получаем координаты клика
    const x = event.clientX - dim.left - 150;
    const y = -(event.clientY - dim.top - 150);
    console.log(x, y)

    // Передаём координаты через remoteCommand
    sendCanvasCoordinates(x, y);
}

function coveringRedrow(event) {
    if (event.status === "success" && actual_r != null) {
        redraw();
    }
}

function redraw() {
    updateGraph();
}

function drawDots(data) {
    actual_data = data;
    graphSetup();
};

