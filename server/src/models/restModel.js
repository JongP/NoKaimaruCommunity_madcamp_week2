/*Test API의 라우터와 요청을 처리하는 로직 */
const mongoose = require("mongoose");
const RestSchema = new mongoose.Schema({
    name: String,
    contact: String,
    category: String,
    rate: {
        type: Number,
        default: 0
    },
    rateNum: {
        type: Number,
        default: 0
    },
    photoURL: String
});

const RestModel = mongoose.model("rest", RestSchema);
module.exports = RestModel;