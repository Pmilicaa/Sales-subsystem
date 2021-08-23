const getUnitOfMeasures = function(onSuccess){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/unitOfMeasures",
        success: function(retVal){
        onSuccess(retVal);
        },
        contentType: "application/json"
    });
}
export {getUnitOfMeasures};