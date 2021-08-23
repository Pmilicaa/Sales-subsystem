const getAllPriceLists= function(onSuccess){
    $.ajax({
                type: "GET",
                url: "http://localhost:8080/priceLists",
                success: function(retVal){
                    onSuccess(retVal);
                },
                contentType: "application/json"
            });
}
export {getAllPriceLists};