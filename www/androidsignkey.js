
module.exports = {
    getSignatureHashCode: function (callback) {
        cordova.exec(callback, function(err){
			alert(err);
		}, "AndroidSignKey", "getSignatureHashCode", []);
    }
}
