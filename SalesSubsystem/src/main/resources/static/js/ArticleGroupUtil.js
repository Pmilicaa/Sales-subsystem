const getArticleGroups = function(onSuccess){
    $.ajax({
            type: "GET",
            url: "http://localhost:8080/articleGroups",
            success: function(retVal){
                onSuccess(retVal);
            },
            contentType: "application/json"
        });
}
export {getArticleGroups};