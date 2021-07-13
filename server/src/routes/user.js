const express = require("express");
const db = require("../../database/userdb");
const router = express.Router();

//ex) http://172.10.18.179/test/add/id1?pwd=1234
router.post("/add", (req,res) =>{
    db.add(
        req.body.id, 
        req.body.name,
        ()=> {
        res.status(200).send();
    });
});

router.get("/delete", (req,res) => {
    db.deleteAll(
        ()=> {
            res.status(200).send();
    });
});
router.get("/all", (req, res) => {
    db.getAll((item) => {res.json(item)
    });

});


router.post("/addfavorite", (req, res) => {
    db.addFavorite(req.body.id,req.body.res,(code)=>{
        res.status(code).send("test done");
    })
});

router.post("/getfavorites",(req,res)=>{
    db.getFavorites(req.body.id,(item)=>{
        res.json(item);
    })
});


module.exports = router;