const express = require("express");
const db = require("../../database/restdb");
const RestModel = require("../models/restModel");
const router = express.Router();
const path = require('path');
fs = require('fs');

//ex) http://172.10.18.179/test/add/id1?pwd=1234






router.get("/init",(req,res) => {
    db.addOne(()=> {
        res.status(200).send();
    });
});

router.get("/getall", (req,res) => {
    db.getAll((item) => {res.json(item)
    });
});

router.post("/getone", (req,res) => {
    db.getOne(req.body.id,(item) => {res.json(item)
    });
});

router.get("/delete", (req,res) => {
    db.deleteAll(() =>{
        console.log("deleted")
    });
});




//To initialize when the Category collection is empty
RestModel.findOne({},function(err,doc){
    if(!doc){
       //Collection is empty
       //build fomr file
       console.log("wow");

        const mypath = path.dirname(__filename)+'/restList.json'
        fs.readFile(mypath,'utf8',function(err,data){          
            if (err) {
                console.log("fs error");
                return
            }
            console.log("fs start");
            var datafromfile=JSON.parse(data);
            datafromfile.forEach(function(obj){
               var catOb=new RestModel(obj)
               catOb.save(()=>{
                   //console.log("saved");
               });
            })
        });

    }
});



module.exports = router;