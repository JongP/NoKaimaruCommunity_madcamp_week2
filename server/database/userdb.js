//Test용 DB

const UserModel = require("../src/models/userModel");
const RestModel = require("../src/models/restModel");

function add(id,name, callback) {

    UserModel.findOne({id:id},(error,result)=>{
        if(result) callback;
        else if(error) callback;
        else{
            const newItem = new UserModel({
                id: id,
                name: name,
            });
            newItem.save((error, result) => {
                callback(result);
            });
        }
    })


}

function getAll(callback) {
    
    UserModel.find({}, (error,result) => {
        console.log(result);
        callback(result);
    });

}
function deleteAll(callback) {
    UserModel.deleteMany({}, (error)=> {
    });
}

function addFavorite(id,res,callback){
    UserModel.findOne({ id : id}, (error,result) => {
        if(result!=null){//maybe should be changed
            
            const found = result.favorite.find((item)=>{
                return String(item)===res})
            if(found){
                callback(201)
            }
            else{
                const arr = result.favorite.concat([res]);
                const set = new Set(arr);
                const test = [...set]

                UserModel.updateOne({id:id},{favorite:test},()=>{})
                callback(200)
            }
        }else{
            console.log("id not found");
            callback(400)
        }
    });
}

function getFavorites(id,callback){
    UserModel.findOne({id:id}).populate('favorite').exec((err,data)=>{
        console.log(data.favorite);
        callback(data.favorite);

    })
}


module.exports = {
    add,
    getAll,
    addFavorite,
    getFavorites,
    deleteAll
  };