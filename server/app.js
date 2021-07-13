// Express 기본 모듈 불러오기
const express = require('express');
const http = require('http');
const path = require("path");
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const userRouter = require('./src/routes/user');
const restRouter = require('./src/routes/rest');
const postRouter = require('./src/routes/post')

const dbURL = 'mongodb://localhost:27018'
// 익스프레스 객체 생성
var app = express();

//mongodb 연결 및 설정
mongoose.connect(dbURL, {
  useNewUrlParser: true,
  useUnifiedTopology: true
});
const db = mongoose.connection;
db.on('error', function(){
    console.log('Connection Failed!');
});
db.once('open', function() {
    console.log('DB Connected!');
});

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
  extended: true
}));


// 기본 포트를 app 객체에 속성으로 설정
app.set('port', process.env.PORT || 80);

app.get('/', (req, res) => {
    res.status(418).send("MadCamp 2nd Project");
});

//router 연결
app.use('/user', userRouter);
app.use('/rest', restRouter);
app.use('/post', postRouter);

// Express 서버 시작
http.createServer(app).listen(app.get('port'), function(){
    console.log(app.get('port') + "에서 express 실행 중");
});