const getCompanies = function(onSuccess){
    $.ajax({
            type: "GET",
            url: "http://localhost:8080/companies",
            success: function(retVal){
                onSuccess(retVal);
            },
            contentType: "application/json"
        });
}
export {getCompanies};