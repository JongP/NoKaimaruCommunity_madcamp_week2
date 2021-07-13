/*Test API의 라우터와 요청을 처리하는 로직 */
const mongoose = require("mongoose");
const UserModel = require("./userModel");

const PostSchema = new mongoose.Schema({
    title: {
        type: String,
        default: ""
    },
    content: {
        type: String,
        default: ""
    },
    rate: {
        type: Number,
        default: 0
    },
    writer: {
        type: String,
        required: "true"
    },
    writerName:{
        type: String,
        default: "default name"
    },
    rest: {
        type: String,
        required: "true"
    },
    restName: {
        type: String,
        required: "true"
    },
    postImg: {
        type: String
    },
    likeNum:{
        type: Number,
        default:0
    },
    likes: [{
        type: String,
        ref: "test"//or user
    }]
});

const PostModel = mongoose.model("post", PostSchema);
module.exports = PostModel;