const getArticles = function(onSuccess){
    $.ajax({
            type: "GET",
            url: "http://localhost:8080/articles",
            success: function(retVal){
                onSuccess(retVal);
            },
            contentType: "application/json"
        });
}
export {getArticles};