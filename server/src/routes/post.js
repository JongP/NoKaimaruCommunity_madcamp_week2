const express = require("express");
const db = require("../../database/postdb");
const router = express.Router();
var multer = require('multer');
const PostModel = require("../models/postModel");
var upload = multer({dest: 'uploads/'})

//ex) http://172.10.18.179/test/add/id1?pwd=1234
router.post("/add", (req,res) =>{
    db.add(
        req.body.title,
        req.body.content, 
        req.body.rate,
        req.body.rest,
        req.body.user,
        ()=> {
        res.status(200).send();
    });
});

router.get("/delete", (req,res) =>{
    db.deleteAll(
        ()=> {
            res.status(200).send();
    });
});

router.post("/addtest",upload.single('postImg') ,(req,res) =>{
    console.log("addtest start");
    //console.log(req);
    console.log("single data")
    console.log(req.body);
    console.log(req.file);
    console.log(req.postImg);
    db.add(
        req.body.title,
        req.body.content, 
        req.body.rate,
        req.body.rest,
        req.body.user,
        req.file.path,
        ()=> {
        res.status(200).send();
    });
});

router.post("/getphoto", (req,res)=>{
    db.getPhoto(req.body.id,(item)=>{
        console.log("res end start")
        res.end(item)
    })
})

router.get("/getall", (req,res) => {
    db.getAll((item) => {res.json(item)
    });
});

router.post("/getbyrest", (req,res) => {
    db.getByRest(req.body.rest,(item) => {res.json(item)
    });
});

router.post("/getone",(req,res)=>{
    db.getByID(req.body.id,(item)=>{res.json(item)
    })
})

router.post("/addlike",(req,res)=>{
    db.addLike(req.body.post,req.body.user,(code)=>{
        res.status(code).send();
    })
})

module.exports = router;